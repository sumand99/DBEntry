/**
 * 
 */
package com.sumandutta.dbentry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author suman.dutta
 *
 */
public class WriterThread implements Runnable {

	private String fileName = "";
	/**
	 * 
	 */
	public WriterThread(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		 String line = null;
		try {
            FileReader fileReader = 
                new FileReader(fileName);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
            	 ReadAndWriteData.writeDataToY(line);
             }   
            bufferedReader.close(); 
            File file = new File(fileName);
            file.delete();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
		
		
	}

}
