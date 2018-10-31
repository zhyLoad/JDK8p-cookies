/**
 * 
 */
package com.test.enums;

/**
 * @author dell
 *
 */
public class TestEnums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

      String model = "MODEL";
      
      System.out.println(ConfigKey.valueOf(model).getClass());
      System.out.println(ConfigKey.valueofByName(model).getClass());

	}

}
