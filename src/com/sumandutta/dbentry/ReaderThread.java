/**
 * 
 */
package com.sumandutta.dbentry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sumandutta
 *
 */
public class ReaderThread implements Runnable {

	 private int indexCounter;
	 private String fileName = "";
	 private StringBuffer strbuffer = new StringBuffer();
	 int MaxLimit = 10;
	 
	/**
	 * 
	 */
	public ReaderThread(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		File file = new File(fileName);
		FileWriter writer =null;
		FileWriter indexWriter=null;
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileReader fileReader;
		
		try {
			fileReader = new FileReader("indexCounter");
		
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
            	indexCounter = Integer.parseInt(line.trim());
            }   
            bufferedReader.close();
            
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(indexCounter < MaxLimit){
			for(int i=0;i<5;i++){
				strbuffer.append(indexCounter+"--"+ReadAndWriteData.readDataFromX(indexCounter)).append("\n"); ;
				indexCounter++;
				
				try {
					indexWriter = new FileWriter("indexCounter");
					indexWriter.write(String.valueOf(indexCounter));
					indexWriter.flush();
					indexWriter.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
		}

		
		

		
		try {
			if(strbuffer.length()>0){
				writer = new FileWriter(file);
				writer.write(strbuffer.toString());
				writer.flush();
				writer.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

/*

		
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strbuffer = new StringBuffer();
		for(int i = indexCounter;i<=indexCounter+5;i++){
			strbuffer.append(String.valueOf(i)+"--"+ReadData.readDataFromX(1)).append("\n");

		}
		System.out.println(strbuffer.toString());
		
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			writer.write(strbuffer.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
*/