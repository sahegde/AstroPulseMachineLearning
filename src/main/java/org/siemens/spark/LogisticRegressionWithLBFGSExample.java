package org.siemens.spark;

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
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS;
import org.apache.spark.mllib.evaluation.MulticlassMetrics;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;

/**
 * Example for LogisticRegressionWithLBFGS.
 */
public class LogisticRegressionWithLBFGSExample {
	
	static FileLocationHandler fHandler = null;
	
	public static void main(String[] args) {
		
		String osType = System.getProperty("os.name");
		System.out.println("Operating system type: "+osType);
		int type = -1;
		if(osType.contains("Mac")) {
			type = 0;
		}else if(osType.contains("Windows")) {
			type = 1;
		}
		fHandler = new FileLocationHandler(type);
		
		SparkConf conf = new SparkConf().setAppName("LogisticRegressionWithLBFGSExample");
		SparkContext sc = new SparkContext(conf);
		
		Logger.getLogger("org").setLevel(Level.OFF);
		Logger.getLogger("akka").setLevel(Level.OFF);
		
		String path = FileLocationHandler.historicalFileStorePath;
		JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc, path).toJavaRDD();
				
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
		model.save(sc, FileLocationHandler.modelFileLocation);
	
		// $example off$
		
		sc.stop();
	}
}
