/**
 * 
 */
package com.test.length;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dell
 *
 */
public class TestValidateLength {
	
	/**
	 *  方法1
     * 功能：获取字符串长度，一个汉字等于两个字符
     * @param strParameter 要获取的字符串
     * @return 长度
     */
public static  int getStrLength(String strParameter )
{
     int temp_int=0;
     byte[] b=strParameter.getBytes();
  
     for(int i=0 ; i<b.length ; i++)
     {
      if(b[i]>=0)
      {
       temp_int=temp_int+1;
      }
      else
      {
       temp_int=temp_int+2;
       i++;
      }
     }
     return temp_int;
}


/**
 * 方法2
 * 获取字符串的长度，如果有中文，则每个中文字符计为2位
 * @param value 指定的字符串
 * @return 字符串的长度
 */

public static int getLength(String value) {

    int valueLength = 0;

    String chinese = "[\u0391-\uFFE5]";

    /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */

    for (int i = 0; i < value.length(); i++) {

        /* 获取一个字符 */

        String temp = value.substring(i, i + 1);

        /* 判断是否为中文字符 */

        if (temp.matches(chinese)) {

            /* 中文字符长度为2 */

            valueLength += 2;

        } else {

            /* 其他字符长度为1 */

            valueLength += 1;

        }

    }

    return valueLength;

}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String a = "1d汉字"; 
//		System.out.println(getStrLength(a));
//		System.out.println(getLength(a));
		
/*		double d = 2.9;
		
		System.out.println(d);
		
		BigDecimal b = new BigDecimal(1.01);
		
		System.out.println(b.toString());*/
		

		
		System.out.println(20000/2000);
		System.out.println(10002/2000);
		
		

		System.out.println(2000%2000);
		System.out.println(10002%2000);

		
	}

}
