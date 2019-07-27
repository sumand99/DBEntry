package com.sumandutta.dbentry;

import java.security.SecureRandom;

public class ReadAndWriteData {

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();

	public ReadAndWriteData() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Dummy Method assuming that we are reading content from Source X
	 * @param index
	 * @return
	 */
	public static String readDataFromX(int index) {
		return generateRandomString();
		
	}
	
	
	/**
	 * Dummy Method assuming that we are writing content to Destination Y.
	 * @param str
	 */
	public static void writeDataToY(String str){
		//Do some string massaging
		System.out.println("Writing Data - " + str);
	}

	 public static String generateRandomString() {
	    
	        StringBuilder sb = new StringBuilder(10);
	        for (int i = 0; i < 10; i++) {

	            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
	            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

	            sb.append(rndChar);

	        }

	        return sb.toString();

	    }
	public static void main(String args[]){
		System.out.println(generateRandomString());
	}

}
