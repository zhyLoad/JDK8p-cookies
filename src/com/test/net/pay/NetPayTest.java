/**
 * 
 */
package com.test.net.pay;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import CCBSign.RSASig;

/**
 * @author 10007610
 *
 */
public class NetPayTest {
	
    public static final String MD_ALGORITHM = "MD5";
	
    public static String MD5(byte[] plainText) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(MD_ALGORITHM);
            return Base64.encodeBase64String(messageDigest.digest(plainText));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String request = "{'user_name':'zhangsan','password':'sdfasdfasfd==','time_stamp':'1034324123','subssrvice_num':'123124124'}";
		
		
		RSASig rsaSig = new RSASig();
		rsaSig.generateKeys();
		
		String willSign = MD5(request.getBytes());
		System.out.println("the information we want to sign is : \n"+willSign);
		String signStr = rsaSig.generateSigature(willSign);
		System.out.println("after sign, the result is : \n"+signStr+"\n");
		
		
		String willVerifyCompare = MD5(request.getBytes());
		System.out.println("the information will be compared is : \n"+willVerifyCompare);
		System.out.println("the information will be verify is : \n"+signStr);
		boolean verifyResult = rsaSig.verifySigature(signStr, willVerifyCompare);
		System.out.println("the verify result is "+ verifyResult);

	}

}
