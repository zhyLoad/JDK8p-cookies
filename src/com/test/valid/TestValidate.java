/**
 * 
 */
package com.test.valid;

import java.util.regex.Pattern;

/**
 * @author dell
 *
 */
public class TestValidate {

	 public static boolean validateInternationalPhoneNumberFormat(String phone) {
	     StringBuilder sb = new StringBuilder(200);

	     // Country code
	     sb.append("^(\\+{1}[\\d]{1,3})?");

	     // Area code, with or without parentheses
	     sb.append("([\\s])?(([\\(]{1}[\\d]{2,3}[\\)]{1}[\\s]?)|([\\d]{2,3}[\\s]?))?");

	     // Phone number separator can be "-", "." or " "

	     // Minimum of 5 digits (for fixed line phones in Solomon Islands)
	     sb.append("\\d[\\-\\.\\s]?\\d[\\-\\.\\s]?\\d[\\-\\.\\s]?\\d[\\-\\.\\s]?\\d[\\-\\.\\s]?");

	     // 4 more optional digits
	     sb.append("\\d?[\\-\\.\\s]?\\d?[\\-\\.\\s]?\\d?[\\-\\.\\s]?\\d?$");

	     return Pattern.compile(sb.toString()).matcher(phone).find();
	 }
	 
	 
	 public static String[] testGetDifference(int start,int end){
		 String[] result = null;
		 int difference = end-start;
		  result  = new String[difference+1];
		 if(difference==0){
			 result[0] = String.valueOf(start);
	        }else{
	            for(int i=0;i<=result.length-1;i++){
	            	result[i] = String.valueOf(start+i);
	            }
	        }
		 return result;
	 }
	 
	 
	 public static boolean check(Object a){
		 if(!a.getClass().getName().equals("java.lang.String")){
			 return false;
		 }
		 return true;
	 }



	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String testPhone = "+61-234-567-89-01";
//		System.out.println(validateInternationalPhoneNumberFormat(testPhone));
//		int start = 5;
//		int end = 8;
//		
//		String[] ttt = testGetDifference(start,end);
//		for(String a :ttt){
//			System.out.println("a="+a+"########");
//		}
		Integer i = 3;
		String s = "3";
		System.out.println(check(i));
		System.out.println(check(s));
	}

}
