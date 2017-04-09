package org.siemens.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;


/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

// $example on$
import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS;
import org.apache.spark.mllib.evaluation.MulticlassMetrics;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.mllib.recommendation.Rating;

/**
 * Example for LogisticRegressionWithLBFGS.
 */
public class LogisticRegressionWithLBFGSExample {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("LogisticRegressionWithLBFGSExample");
		SparkContext sc = new SparkContext(conf);
		
		Logger.getLogger("org").setLevel(Level.OFF);
		Logger.getLogger("akka").setLevel(Level.OFF);
		
		// $example on$
		//String path = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen/src/main/resources/healthHistoricalData.txt";
		//JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc, path).toJavaRDD();
		
		String path = "/Users/hsandeep/Desktop/gitRepos/astroDataGen/Jersey-Jetty-Mysql-REST/src/main/resources/historical_data.txt";
		JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc, path).toJavaRDD();
		
	    /*JavaRDD<Rating> training = data.map(s -> {
	        String[] sarray = s.split(",");
	        return new Rating(Integer.parseInt(sarray[0]),
	          Integer.parseInt(sarray[1]),
	          Double.parseDouble(sarray[2]));
	      });*/
		
			
		// Split initial RDD into two... [60% training data, 40% testing data].
		JavaRDD<LabeledPoint>[] splits = data.randomSplit(new double[] { 0.6, 0.4 }, 11L);
		
		//JavaRDD<List<String>> training = data.map(line -> Arrays.asList(line.split(" ")));
		
		JavaRDD<LabeledPoint> training = splits[0].cache();
		JavaRDD<LabeledPoint> test = splits[1];

		// Run training algorithm to build the model.
		LogisticRegressionModel model = new LogisticRegressionWithLBFGS().setNumClasses(3).run(training.rdd());

		// Compute raw scores on the test set.
		JavaPairRDD<Object, Object> predictionAndLabels = test
				.mapToPair(p -> new Tuple2<>(model.predict(p.features()), p.label()));

		// Get evaluation metrics.
		MulticlassMetrics metrics = new MulticlassMetrics(predictionAndLabels.rdd());
		double accuracy = metrics.precision();
		System.out.println("Accuracy = " + accuracy);

		// Save and load model
		model.save(sc, "/Users/hsandeep/Desktop/gitRepos/astroDataGen/astroDataGen/src/main/resources/javaLogisticRegressionWithLBFGSModel");
	
		// $example off$

		Vector dv = Vectors.dense(115,145,19,140,310,38.5,35,22,23,55,30,64,135);
		Double jdd = model.predict(dv);
		System.out.println("Sandeep1 "+jdd);
		
		/*dv = Vectors.dense(71,157,251,75,17,260);
		jdd = model.predict(dv);
		System.out.println("Sandeep2 "+jdd);*/
		
		/*dv = Vectors.dense(101,130,290,120,160,610);
		jdd = model.predict(dv);
		System.out.println("Sandeep3 "+jdd);*/
		
		/*Vector dv = Vectors.dense(0.888889,0.5,0.932203,0.75 );
		Double jdd = model.predict(dv);
		System.out.println("Sandeep1 "+jdd);
		
		dv = Vectors.dense(-0.611111,0.166667,-0.830508,-0.916667 );
		jdd = model.predict(dv);
		System.out.println("Sandeep2 "+jdd);
		
		dv = Vectors.dense(-0.0555556,-0.416667,0.38983,0.25 );
		jdd = model.predict(dv);
		System.out.println("Sandeep3 "+jdd);*/
		
		sc.stop();
	}
}
