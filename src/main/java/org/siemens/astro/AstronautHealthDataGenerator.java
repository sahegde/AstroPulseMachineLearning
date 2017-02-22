package org.siemens.astro;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.siemens.foundation.AstronautHealthData;
import org.siemens.foundation.TimeInterval;
import org.siemens.foundation.TimeInterval_;
import org.siemens.foundation.TimeInterval__;

public class AstronautHealthDataGenerator {

	public static String dataGenerator() {

		List<String> attribs1 = new ArrayList<String>();
		List<String> attribs2 = new ArrayList<String>();
		List<String> attribs3 = new ArrayList<String>();
		Map<String, List<Object>> healthStatsMap1 = new LinkedHashMap<String, List<Object>>();
		Map<String, List<Object>> healthStatsMap2 = new LinkedHashMap<String, List<Object>>();
		Map<String, List<Object>> healthStatsMap3 = new LinkedHashMap<String, List<Object>>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			File file = new File("/Users/hsandeep/Documents/workspace/example/src/main/resources/sensorData.json");
			AstronautHealthData ast = (AstronautHealthData) mapper.readValue(file, AstronautHealthData.class);
			List<Object> data1 = ast.getSpaceShipSensorData().getAstronautHealthDataSet1().getSensorValues();
			List<Object> data2 = ast.getSpaceShipSensorData().getAstronautHealthDataSet2().getSensorValues();
			List<Object> data3 = ast.getSpaceShipSensorData().getAstronautHealthDataSet3().getSensorValues();

			TimeInterval timeInterval1 = ast.getSpaceShipSensorData().getAstronautHealthDataSet1().getTimeInterval();
			TimeInterval_ timeInterval2 = ast.getSpaceShipSensorData().getAstronautHealthDataSet2().getTimeInterval();
			TimeInterval__ timeInterval3 = ast.getSpaceShipSensorData().getAstronautHealthDataSet3().getTimeInterval();

			for (int i = 0; i < data1.size(); i++) {
				LinkedHashMap<String, String> v = (LinkedHashMap<String, String>) data1.get(i);
				List<Object> healthParams = new LinkedList<Object>();

				healthParams.add(v.get("healthAttribValue"));
				healthParams.add(v.get("healthAttribUnit"));
				healthParams.add(v.get("statistics"));
				healthParams.add(timeInterval1.getStartDateTime());
				healthParams.add(timeInterval1.getEndDateTime());

				healthStatsMap1.put(v.get("healthAttribName"), healthParams);
				attribs1.add(v.get("healthAttribName"));
			}
			for (int i = 0; i < data2.size(); i++) {
				LinkedHashMap<String, String> v = (LinkedHashMap<String, String>) data2.get(i);

				List<Object> healthParams = new LinkedList<Object>();

				healthParams.add(v.get("healthAttribValue"));
				healthParams.add(v.get("healthAttribUnit"));
				healthParams.add(v.get("statistics"));
				healthParams.add(timeInterval2.getStartDateTime());
				healthParams.add(timeInterval2.getEndDateTime());

				healthStatsMap2.put(v.get("healthAttribName"), healthParams);
				attribs2.add(v.get("healthAttribName"));
			}
			for (int i = 0; i < data3.size(); i++) {
				LinkedHashMap<String, String> v = (LinkedHashMap<String, String>) data3.get(i);

				List<Object> healthParams = new LinkedList<Object>();

				healthParams.add(v.get("healthAttribValue"));
				healthParams.add(v.get("healthAttribUnit"));
				healthParams.add(v.get("statistics"));
				healthParams.add(timeInterval3.getStartDateTime());
				healthParams.add(timeInterval3.getEndDateTime());

				healthStatsMap3.put(v.get("healthAttribName"), healthParams);
				attribs3.add(v.get("healthAttribName"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String key1 = attribs1.get((int) (Math.random() * (attribs1.size())));
		List<Object> value1 = healthStatsMap1.get(key1);
		//System.out.println(key1 + " ----->" + value1);
		// threadSleep();

		String key2 = attribs2.get((int) (Math.random() * (attribs2.size())));
		List<Object> value2 = healthStatsMap2.get(key2);
		//System.out.println(key2 + " ----->" + value2);
		// threadSleep();

		String key3 = attribs3.get((int) (Math.random() * (attribs3.size())));
		List<Object> value3 = healthStatsMap3.get(key3);
		//System.out.println(key3 + " ----->" + value3);
		// threadSleep();
		
		return key1+" "+value1;
	}
}