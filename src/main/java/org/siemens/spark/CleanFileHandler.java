package org.siemens.spark;

import java.io.PrintWriter;

public class CleanFileHandler {
	
	private static final String healthStatusFile = "/Users/hsandeep/Desktop/gitRepos/"+
	"astroDataGen/astroDataGen/src/main/resources/healthStatusFile.txt";

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
	
	public static void main(String[] args) throws Exception {
		PrintWriter writer = new PrintWriter(healthStatusFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(healthStatusFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(healthDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(johnDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(lelandDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(sunithaDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(laDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(nicoleDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(randyDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(charlieDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(danielDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(kcDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(stevenDataFile);
		writer.print("");
		writer.close();
		
		System.out.println("Done cleaning all files");
	}
}
