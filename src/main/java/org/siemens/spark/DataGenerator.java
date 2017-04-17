package org.siemens.spark;

import java.util.Random;

/*
	1=[60-120][beats/min]
	2=[100-140][mmHg]
	3=[60-90][mmHg]
	4=[12-18][counts]
	5=[79-140][mg/dL]
	6=[50-300][steps]
	7=[36.5–37.5][deg.celcius]
	8=[20-30][%]
	9=[50-100][%]
	10=[60-100][%]
	11=[-60-60][deg.celcius]
	12=[40-100][%]
	13=[25-60][%]
*/

/*
	1=Heart Rate
	2=Blood Pressure (systolic)
	3=Blood Pressure (diastolic)
	4=Respiration Rate
	5=Blood Glucose
	6=Activity Count
	7=Body Temperature
	8=Body Fat Percentage
	9=Body Strength
	10=Body Oxygen Level
	11=Atmospheric Temperature
	12=Atmospheric Oxygen Level
	13=Atmospheric Humidity
*/

class Parameter {
	int minimum;
	int maximum;

	public Parameter(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}
}

public class DataGenerator {

	public static String generate() {

		Random rand = new Random();
		int choice = rand.nextInt(10) + 1;

		// Normal ranges
		Parameter heartRate = null;
		Parameter bloodPressureSystolic = null;
		Parameter respirationRate = null;
		Parameter bloodGlucose = null;
		Parameter activityCount = null;
		Parameter bodyTemperature = null;
		Parameter bodyFat = null;
		Parameter bodyStrength = null;
		Parameter bodyOxygen = null;
		Parameter temperature = null;
		Parameter oxygenLevel = null;
		Parameter humidity = null;
		Parameter bloodPressureDiastolic = null;
		int healthStatusActual = -1;

		if (choice <= 8) {

			// Normal ranges
			heartRate = new Parameter(60, 120);
			bloodPressureSystolic = new Parameter(100, 140);
			bloodPressureDiastolic = new Parameter(60, 90);
			respirationRate = new Parameter(12, 18);
			bloodGlucose = new Parameter(79, 140);
			activityCount = new Parameter(50, 300);
			bodyTemperature = new Parameter(36, 38);
			bodyFat = new Parameter(20, 30);
			bodyStrength = new Parameter(50, 100);
			bodyOxygen = new Parameter(60, 100);
			temperature = new Parameter(-60, 60);
			oxygenLevel = new Parameter(40, 100);
			humidity = new Parameter(25, 60);
			healthStatusActual = 0;

		} else if (choice == 9) {

			// Health Deteorating ranges
			heartRate = new Parameter(115, 130);
			bloodPressureSystolic = new Parameter(135, 150);
			bloodPressureDiastolic = new Parameter(90, 100);
			respirationRate = new Parameter(17, 20);
			bloodGlucose = new Parameter(135, 150);
			activityCount = new Parameter(270, 350);
			bodyTemperature = new Parameter(38, 40);
			bodyFat = new Parameter(30, 35);
			bodyStrength = new Parameter(100, 110);
			bodyOxygen = new Parameter(100, 110);
			temperature = new Parameter(60, 70);
			oxygenLevel = new Parameter(90, 110);
			humidity = new Parameter(60, 70);
			healthStatusActual = 2;

		} else if (choice == 10) {

			// Health not ok ranges
			heartRate = new Parameter(135, 150);
			bloodPressureSystolic = new Parameter(145, 170);
			bloodPressureDiastolic = new Parameter(100, 120);
			respirationRate = new Parameter(18, 25);
			bloodGlucose = new Parameter(150, 170);
			activityCount = new Parameter(355, 400);
			bodyTemperature = new Parameter(40, 45);
			bodyFat = new Parameter(36, 48);
			bodyStrength = new Parameter(110, 150);
			bodyOxygen = new Parameter(120, 150);
			temperature = new Parameter(70, 100);
			oxygenLevel = new Parameter(120, 140);
			humidity = new Parameter(70, 90);
			healthStatusActual = 1;
		}

		int heartRateRandom = rand.nextInt(heartRate.maximum - heartRate.minimum) + heartRate.minimum;
		int bloodPressureSystolicRandom = rand.nextInt(bloodPressureSystolic.maximum - bloodPressureSystolic.minimum)
				+ bloodPressureSystolic.minimum;
		int bloodPressureDiastolicRandom = rand.nextInt(bloodPressureDiastolic.maximum - bloodPressureDiastolic.minimum)
				+ bloodPressureDiastolic.minimum;
		int respirationRateRandom = rand.nextInt(respirationRate.maximum - respirationRate.minimum)
				+ respirationRate.minimum;
		int bloodGlucoseRandom = rand.nextInt(bloodGlucose.maximum - bloodGlucose.minimum) + bloodGlucose.minimum;
		int activityCountRandom = rand.nextInt(activityCount.maximum - activityCount.minimum) + activityCount.minimum;
		int bodyTemperatureRandom = rand.nextInt(bodyTemperature.maximum - bodyTemperature.minimum)
				+ bodyTemperature.minimum;
		int bodyFatRandom = rand.nextInt(bodyFat.maximum - bodyFat.minimum) + bodyFat.minimum;
		int bodyStrengthRandom = rand.nextInt(bodyStrength.maximum - bodyStrength.minimum) + bodyStrength.minimum;
		int bodyOxygenRandom = rand.nextInt(bodyOxygen.maximum - bodyOxygen.minimum) + bodyOxygen.minimum;
		int temperatureRandom = rand.nextInt(temperature.maximum - temperature.minimum) + temperature.minimum;
		int oxygenLevelRandom = rand.nextInt(oxygenLevel.maximum - oxygenLevel.minimum) + oxygenLevel.minimum;
		int humidityRandom = rand.nextInt(humidity.maximum - humidity.minimum) + humidity.minimum;

		System.out.println("ActualValue: " + healthStatusActual);

		return "1:" + heartRateRandom + " " + "2:" + bloodPressureSystolicRandom + " " + "3:" + bloodPressureDiastolicRandom +
				" 4:" + respirationRateRandom + " " + "5:" + bloodGlucoseRandom + " " + "6:" + activityCountRandom + " " + "7:"
				+ bodyTemperatureRandom + " " + "8:" + bodyFatRandom + " " + "9:" + bodyStrengthRandom + " " + "10:"
				+ bodyOxygenRandom + " " + "11:" + temperatureRandom + " " + "12:" + oxygenLevelRandom + " " + "13:"
				+ humidityRandom;

	}

	public static void main(String[] args) throws Exception {
		while (true) {
			String healthDataGenerated = generate();
			System.out.println(healthDataGenerated);
			Thread.sleep(1000);
		}
	}
}
