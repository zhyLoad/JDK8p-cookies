/**
 * 
 */
package com.test.security;


 import java.security.InvalidAlgorithmParameterException;
 import java.security.InvalidKeyException;
 import java.security.NoSuchAlgorithmException;

 import javax.crypto.BadPaddingException;
 import javax.crypto.Cipher;
 import javax.crypto.IllegalBlockSizeException;
 import javax.crypto.KeyGenerator;
 import javax.crypto.NoSuchPaddingException;
 import javax.crypto.SecretKey;
 import javax.crypto.spec.IvParameterSpec;
 import javax.crypto.spec.SecretKeySpec;

 import org.apache.commons.codec.binary.Base64;
 
 
/**
 * @author 10007610
 *
 */
public class AESSignAndVerify {

	 /**
	       * ע��key�ͼ����õ����ַ����ǲ�һ���� ���ܻ�Ҫָ�����ļ���ģʽ�����ģʽ AES��Կ������128����256������ģʽ����ECB, CBC��
	       * ECBģʽ�Ƿ����ģʽ��CBC�Ƿֿ���ܺ�ÿ����ǰһ��ļ��ܽ�������ټ��� ��һ����ܵ���������IV�����������
	       */
	      public static final String KEY_ALGORITHM = "AES";
	      public static final String ECB_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	      public static final String CBC_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	      public static final String PLAIN_TEXT = "MANUTD is the greatest club in the world";
	 
	      /**
	       * IV(Initialization Value)��һ����ʼֵ������CBCģʽ��˵�������������ѡȡ������Ҫ���ܵ�
	       * �������ĳ��Ⱥ����������ͬ(���磺����AES 128Ϊ128λ��������Ϊ16��byte��������)
	       *
	       */
	      public static final byte[] IVPARAMETERS = new byte[] { 1, 2, 3, 4, 5, 6, 7,
	              8, 9, 10, 11, 12, 13, 14, 15, 16 };
	 
	      public static void main(String[] arg) {
	          byte[] secretBytes = generateAESSecretKey();
	          SecretKey key = restoreSecretKey(secretBytes);
	          byte[] encodedText = AesEcbEncode(PLAIN_TEXT.getBytes(), key);
	 
	          System.out.println("AES ECB encoded with Base64: " + Base64.encodeBase64String(encodedText));
	          System.out.println("AES ECB decoded: "
	                  + AesEcbDecode(encodedText, key));
	 
	 
	 
	          encodedText = AesCbcEncode(PLAIN_TEXT.getBytes(), key, IVPARAMETERS);
	 
	 
	          System.out.println("AES CBC encoded with Base64: " + Base64.encodeBase64String(encodedText));
	          System.out.println("AES CBC decoded: "
	                  + AesCbcDecode(encodedText, key,
	                          IVPARAMETERS));
	      }
	 
	      /**
	       * ʹ��ECBģʽ���м��ܡ� ���ܹ��������ߣ� 1. �����㷨��ʵ����һ���ӽ����� 2. �������ģʽ����Կ����ʼ��һ�������� 3.
	       * ����doFinal��������
	       *
	       * @param plainText
	       * @return
	       */
	      public static byte[] AesEcbEncode(byte[] plainText, SecretKey key) {
	 
	          try {
	 
	              Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
	              cipher.init(Cipher.ENCRYPT_MODE, key);
	              return cipher.doFinal(plainText);
	          } catch (NoSuchAlgorithmException | NoSuchPaddingException
	                  | InvalidKeyException | IllegalBlockSizeException
	                  | BadPaddingException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	          }
	          return null;
	      }
	 
	      /**
	       * ʹ��ECB���ܣ������ߣ���˵��
	       *
	       * @param decodedText
	       * @param key
	       * @return
	       */
	      public static String AesEcbDecode(byte[] decodedText, SecretKey key) {
	          try {
	              Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
	              cipher.init(Cipher.DECRYPT_MODE, key);
	              return new String(cipher.doFinal(decodedText));
	          } catch (NoSuchAlgorithmException | NoSuchPaddingException
	                  | InvalidKeyException | IllegalBlockSizeException
	                  | BadPaddingException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	          }
	          return null;
	 
	      }
	
	     /**
	      * CBC���ܣ������ߣ�ֻ���ڳ�ʼ��ʱ����һ����ʼ����
	      *
	      * @param plainText
	      * @param key
	      * @param IVParameter
	      * @return
	      */
	     public static byte[] AesCbcEncode(byte[] plainText, SecretKey key,
	             byte[] IVParameter) {
	         try {
	             IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);
	
	             Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
	             cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
	             return cipher.doFinal(plainText);
	
	         } catch (NoSuchAlgorithmException | NoSuchPaddingException
	                 | InvalidKeyException | InvalidAlgorithmParameterException
	                 | IllegalBlockSizeException | BadPaddingException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
	         return null;
	     }
	
	     /**
	      * CBC ����
	      *
	      * @param decodedText
	      * @param key
	      * @param IVParameter
	      * @return
	      */
	     public static String AesCbcDecode(byte[] decodedText, SecretKey key,
	             byte[] IVParameter) {
	         IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);
	
	         try {
	             Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
	             cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
	             return new String(cipher.doFinal(decodedText));
	         } catch (NoSuchAlgorithmException | NoSuchPaddingException
	                 | InvalidKeyException | InvalidAlgorithmParameterException
	                 | IllegalBlockSizeException | BadPaddingException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
	
	         return null;
	
	     }
	
	     /**
	      * 1.����һ��KeyGenerator 2.����KeyGenerator.generateKey����
	      * ����ĳЩԭ������ֻ����128���������Ϊ256�ᱨ�쳣��ԭ������������˵��
	      *
	      * @return
	      */
	     public static byte[] generateAESSecretKey() {
	         KeyGenerator keyGenerator;
	         try {
	             keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
	             // keyGenerator.init(256);
	             return keyGenerator.generateKey().getEncoded();
	         } catch (NoSuchAlgorithmException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
	         return null;
	     }
	
	     /**
	      * ��ԭ��Կ
	      *
	      * @param secretBytes
	      * @return
	      */
	     public static SecretKey restoreSecretKey(byte[] secretBytes) {
	         SecretKey secretKey = new SecretKeySpec(secretBytes, KEY_ALGORITHM);
	         return secretKey;
	     }

}
