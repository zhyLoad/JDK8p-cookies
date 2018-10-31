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
	 *  ����1
     * ���ܣ���ȡ�ַ������ȣ�һ�����ֵ��������ַ�
     * @param strParameter Ҫ��ȡ���ַ���
     * @return ����
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
 * ����2
 * ��ȡ�ַ����ĳ��ȣ���������ģ���ÿ�������ַ���Ϊ2λ
 * @param value ָ�����ַ���
 * @return �ַ����ĳ���
 */

public static int getLength(String value) {

    int valueLength = 0;

    String chinese = "[\u0391-\uFFE5]";

    /* ��ȡ�ֶ�ֵ�ĳ��ȣ�����������ַ�����ÿ�������ַ�����Ϊ2������Ϊ1 */

    for (int i = 0; i < value.length(); i++) {

        /* ��ȡһ���ַ� */

        String temp = value.substring(i, i + 1);

        /* �ж��Ƿ�Ϊ�����ַ� */

        if (temp.matches(chinese)) {

            /* �����ַ�����Ϊ2 */

            valueLength += 2;

        } else {

            /* �����ַ�����Ϊ1 */

            valueLength += 1;

        }

    }

    return valueLength;

}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String a = "1d����"; 
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
