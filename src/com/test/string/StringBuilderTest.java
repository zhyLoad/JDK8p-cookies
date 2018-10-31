/**
 * 
 */
package com.test.string;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author dell
 *
 */
public class StringBuilderTest {
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> list  = new ArrayList<Integer>();
//		list.add(23);
//		list.add(22);
//		list.add(11);
//		list.add(53);
	    StringBuilder stringBuilder = new StringBuilder();
	    if(list.size()>0){
	        stringBuilder.append("|");
	        list.forEach(deviceModelDTO -> {
	            stringBuilder.append(deviceModelDTO).append("|");
	        });
	    }

        System.out.println(stringBuilder.toString());
        
        System.out.println(StringUtils.isBlank(" "));
        
        
        String a = " ";
        System.out.println("111111111"+(a==null));
        System.out.println("222222222222222"+(a.length()<1));

	}

}
