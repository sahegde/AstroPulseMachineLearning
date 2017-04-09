package org.siemens.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PulseSparkHandler{
	
	private static final Map<Integer,String> astronautDetails = new HashMap<>();
	
	private static final Map<Integer,String> astronautFileDetails = new HashMap<>();
	
	private static void writeHealthStatusReport(int healtPrediction, int astronautCount, long timeStamp) {
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(FileLocationHandler.healthStatusFile, true));
		    writer.write(astronautCount+" "+astronautDetails.get(astronautCount)+" "+timeStamp+" "+healtPrediction);
		    writer.newLine();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void writeHealthUploadReport(String healthData) {
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(FileLocationHandler.healthDataFile, true));
		    writer.write(healthData);
		    writer.newLine();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void writeAstronautHealthReport(int astronautCount,String healthData, String astronautName,
			String fileName, int prediction) {
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(fileName, true));
		    writer.write(astronautCount+" "+astronautName+" "+healthData+" "+prediction);
		    writer.newLine();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static void writeToAstronautFile(String generatedData,int count, int healthPrediction) {
    	writeAstronautHealthReport(count,generatedData,astronautDetails.get(count),astronautFileDetails.get(count), healthPrediction);
	}
	
	private static int[] parseDataForPrediction(String healthData) {
		String str[] = healthData.split(" ");
		int arr[] = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i].split(":")[1]);
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		
		String osType = System.getProperty("os.name");
		System.out.println("Operating system type: "+osType);
		int type = -1;
		if(osType.contains("Mac")) {
			type = 0;
		}else if(osType.contains("Windows")) {
			type = 1;
		}
		new FileLocationHandler(type);
		
		astronautDetails.put(1, "John Herrington");
		astronautDetails.put(2, "Leland Melvin");
		astronautDetails.put(3, "Sunitha Williams");
		astronautDetails.put(4, "La Estela");
		astronautDetails.put(5, "Nicole Stott");
		astronautDetails.put(6, "Randy Bresnik");
		astronautDetails.put(7, "Charlie Camarda");
		astronautDetails.put(8, "Daniel Burbank");
		astronautDetails.put(9, "KC Thomton");
		astronautDetails.put(10, "Steven Nagel");
		
		astronautFileDetails.put(1, FileLocationHandler.johnDataFile);
		astronautFileDetails.put(2, FileLocationHandler.lelandDataFile);
		astronautFileDetails.put(3, FileLocationHandler.sunithaDataFile);
		astronautFileDetails.put(4, FileLocationHandler.laDataFile);
		astronautFileDetails.put(5, FileLocationHandler.nicoleDataFile);
		astronautFileDetails.put(6, FileLocationHandler.randyDataFile);
		astronautFileDetails.put(7, FileLocationHandler.charlieDataFile);
		astronautFileDetails.put(8, FileLocationHandler.danielDataFile);
		astronautFileDetails.put(9, FileLocationHandler.kcDataFile);
		astronautFileDetails.put(10, FileLocationHandler.stevenDataFile);
		
		// Create the context with a 1 second batch size
		SparkConf sparkConf = new SparkConf().setAppName("PulseSparkHandler");
		SparkContext sc = new SparkContext(sparkConf);
        LogisticRegressionModel sameModel = LogisticRegressionModel.load(sc,FileLocationHandler.modelFileLocation);
		
        System.out.println("Model details :"+sameModel.toString());
        
        while(true) {
        	Date date = new Date();
        	for (int i = 10; i >= 1; i--) {
            	String generatedData = DataGenerator.generate();
            	int dataParams[] = parseDataForPrediction(generatedData);
            	
        		Vector dv = Vectors.dense(dataParams[0],dataParams[1],dataParams[2],dataParams[3],dataParams[3],
        				dataParams[5],dataParams[6],dataParams[7],dataParams[8],dataParams[9],dataParams[10],
        				dataParams[11],dataParams[12]);
        		
        		Double healtPrediction = sameModel.predict(dv);
        		writeHealthStatusReport(healtPrediction.intValue(),i,date.getTime());
        		writeHealthUploadReport(healtPrediction.intValue()+" "+generatedData);
        		writeToAstronautFile(generatedData,i,healtPrediction.intValue());
        		System.out.println("Prediction for "+astronautDetails.get(i)+": "+healtPrediction);
        		
			}
    		Thread.sleep(10000);
        }	
	}
}
