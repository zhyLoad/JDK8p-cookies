/**
 * 
 */
package com.test.jndi;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * @author 10007610
 *
 */
public class SimpleMD5Example {
	
    /** 
     * ���ַ���md5����(Сд+��ĸ) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
    public static String getMD5(String str) {  
        try {  
            // ����һ��MD5���ܼ���ժҪ�����MD5Ҳ�ɻ���SHA��SHA-1  SHAҲ��һ�ֺ�MD5���Ƶĵ���ɢ�м����㷨
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // ����md5����  
            md.update(str.getBytes());  
            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�  
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
      
      
    /** 
     * ���ַ���md5����(��д+����) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
      
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // ���MD5ժҪ�㷨�� MessageDigest ����  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // ʹ��ָ�����ֽڸ���ժҪ  
            mdInst.update(btInput);  
            // �������  
            byte[] md = mdInst.digest();  
            // ������ת����ʮ�����Ƶ��ַ�����ʽ  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
	
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        Encoder encoder = Base64.getEncoder();
        String newstr =encoder.encodeToString(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    
    public static String getLdapPassword(String md5pass)
    {
    	Encoder encoder = Base64.getEncoder();
        byte[] baKeyword = new byte[md5pass.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(md5pass.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String newstr = encoder.encodeToString(baKeyword);        
        return newstr;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  try {
			/*
			    slappasswd -h {md5} -s "secret"
			    {MD5}Xr4ilOzQ4PCOq3aQ0qbuaQ==
			 */
			String password = "123456";
			String N_md5 = EncoderByMd5(password);
			System.out.println(N_md5);
			
            System.out.println(MD5(password));
		    String N_md5_LDAP = getLdapPassword(MD5(password));
		    System.out.println(N_md5_LDAP);
			/*
			slappasswd -h {md5} -s "dsideal4r5t6y7u"
			{MD5}yDL5JsEkVI9aVYfIW1pbPw==
			 */
			String passwordToHash = "dsideal4r5t6y7u";
			N_md5 = EncoderByMd5(passwordToHash);
			System.out.println(N_md5);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
