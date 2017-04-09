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
	
	private static final String healthStatusFile = "/Users/hsandeep/Desktop/gitRepos/"+
	"astroDataGen/astroDataGen/src/main/resources/healthStatusFile.txt";
	private static final String dataModelFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/javaLogisticRegressionWithLBFGSModel";
	private static final String healthDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/healthDataFile.txt";
	
	private static final String johnDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/john.txt";
	
	private static final String lelandDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/leland.txt";
	
	private static final String sunithaDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/sunitha.txt";
	
	private static final String laDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/la.txt";
	
	private static final String nicoleDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/nicole.txt";
	
	private static final String randyDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/randy.txt";
	
	private static final String charlieDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/charlie.txt";
	
	private static final String danielDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/daniel.txt";
	
	private static final String kcDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/kc.txt";
	
	private static final String stevenDataFile = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen"+
	"/src/main/resources/steven.txt";
	
	private static final Map<Integer,String> astronautDetails = new HashMap<>();
	
	private static final Map<Integer,String> astronautFileDetails = new HashMap<>();
	
	private static void writeHealthStatusReport(int healtPrediction, int astronautCount, long timeStamp) {
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(healthStatusFile, true));
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
		    writer = new BufferedWriter(new FileWriter(healthDataFile, true));
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
		
		astronautFileDetails.put(1, johnDataFile);
		astronautFileDetails.put(2, lelandDataFile);
		astronautFileDetails.put(3, sunithaDataFile);
		astronautFileDetails.put(4, laDataFile);
		astronautFileDetails.put(5, nicoleDataFile);
		astronautFileDetails.put(6, randyDataFile);
		astronautFileDetails.put(7, charlieDataFile);
		astronautFileDetails.put(8, danielDataFile);
		astronautFileDetails.put(9, kcDataFile);
		astronautFileDetails.put(10, stevenDataFile);
		
		// Create the context with a 1 second batch size
		SparkConf sparkConf = new SparkConf().setAppName("PulseSparkHandler");
		SparkContext sc = new SparkContext(sparkConf);
        LogisticRegressionModel sameModel = LogisticRegressionModel.load(sc,dataModelFile);
		
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
