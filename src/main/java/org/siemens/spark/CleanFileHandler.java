package org.siemens.spark;

import java.io.PrintWriter;

public class CleanFileHandler {
	
	static FileLocationHandler fHandler = null;
	
	public static void main(String[] args) throws Exception {
		
		String osType = System.getProperty("os.name");
		System.out.println("Operating system type: "+osType);
		int type = -1;
		if(osType.contains("Mac")) {
			type = 0;
		}else if(osType.contains("Windows")) {
			type = 1;
		}
		fHandler = new FileLocationHandler(type);
		
		PrintWriter writer = new PrintWriter(FileLocationHandler.healthStatusFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.healthDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.paramFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.johnDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.lelandDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.sunithaDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.laDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.nicoleDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.randyDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.charlieDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.danielDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.kcDataFile);
		writer.print("");
		writer.close();
		
		writer = new PrintWriter(FileLocationHandler.stevenDataFile);
		writer.print("");
		writer.close();
		
		System.out.println("Done cleaning all files");
	}
}
