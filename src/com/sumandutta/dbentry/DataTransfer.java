package com.sumandutta.dbentry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DataTransfer {

	private static int indexCounter = 1;
	private static int lastIndex = 10;
	
	public static void main(String[] args) throws Exception {
			
		Thread t1 = null;
		Thread t2 = null;
		Thread t3 = null;
		Thread t4 = null;
		
		
		Thread t5 = null;
		Thread t6 = null;
		Thread t7 = null;
		Thread t8 = null;
        
		do{

			ReaderThread readerThread1 = new ReaderThread("T1");
			t1 = new Thread(readerThread1,"T1");
			readerThread1 = null;
			 
		    ReaderThread readerThread2 = new ReaderThread("T2");
			t2 = new Thread(readerThread2,"T2");
			readerThread2 = null;
			 			 
			ReaderThread readerThread3 = new ReaderThread("T3");
			t3 = new Thread(readerThread3,"T3");
			indexCounter = indexCounter + 5;
			readerThread3 = null;
			 			 
			ReaderThread readerThread4 = new ReaderThread("T4");
			t4 = new Thread(readerThread4,"T4");
			indexCounter = indexCounter + 5;
			readerThread4 = null;
			
			t1.start(); 
			t2.start();
			t3.start(); 
			t4.start(); 

			t1.join();
			t2.join();
			t3.join();
			t4.join();
				 	
			 WriterThread writerThread1 = new WriterThread("T1");
			 t5 = new Thread(writerThread1,"T1");
			 writerThread1 = null;
			 
	         WriterThread writerThread2 = new WriterThread("T2");
			 t6 = new Thread(writerThread2,"");
			 writerThread2 = null;
			 
			 
			 WriterThread writerThread3 = new WriterThread("T3");
			 t7 = new Thread(writerThread3,"");
			 writerThread3 = null;
			 
			 
			 WriterThread writerThread4 = new WriterThread("T4");
			 t8 = new Thread(writerThread4,"");
			 writerThread4 = null;
			
			 t5.start();
			 t6.start();
			 t7.start();
			 t8.start();

			
			FileReader fileReader;
			
			try {
				fileReader = new FileReader("indexCounter");
			
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            String line = "";
	            while((line = bufferedReader.readLine()) != null) {
	            	indexCounter = Integer.parseInt(line);
	            }   
	            bufferedReader.close();
		    } catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

		
		
	}while(indexCounter<lastIndex);
	
	}
	
}
