/**
 * 
 */
package com.test.security;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author 10007610
 *
 */
public class CustomMessageDigest {

    public static final String PLAIN_TEXT = "i m a sample";
    public static final String MD_ALGORITHM = "MD5";
    public static final String SHA_ALGORITHM = "SHA-512";
    public static final String MAC_ALGORITHM = "HmacSHA512";

    /**
     * 1.��ϢժҪ�㷨��MD���壬��MD2 MD4 MD5������MD4 JDK��֧��
     *
     * @param plainText
     * @return
     */
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
     * 2.SHA Security Hash Algorithm ��ȫɢ���㷨���̶�����ժҪ��Ϣ SHA-1 SHA-2( SHA-224
     * SHA-256 SHA-384 SHA-512) ʹ�õ���Ȼ��MessageDigest�࣬JDK��֧��224
     *
     * @param plainText
     * @return
     */
    public static String SHA(byte[] plainText) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SHA_ALGORITHM);
            return Base64.encodeBase64String(messageDigest.digest(plainText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 3.MAC(Message Authentication Code) ��Ϣ��֤���㷨���Ǻ�����Կɢ�к����㷨��
     * ������MD��SHA�����ԡ�
     * ���ܹ��������ߣ������Ҫ���ܵĶԳƼ��ܺͷǶԳƼ��������Ƶ�
     * 1) �����㷨��ʵ����һ��������
     * 2) ������Կ����ʼ��������
     * 3) ����doFinal�������м���
     * @param plainText
     * @return
     */
    public static String MAC(byte[] plainText) {

        try {
            byte[] secretBytes = generatorMACSecretKey();
            SecretKey key = restoreMACSecretKey(secretBytes);
            Mac mac = Mac.getInstance(MAC_ALGORITHM);
            mac.init(key);
            return Base64.encodeBase64String(mac.doFinal(plainText));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    /**
     * MAC���������Կ ������ 1.����һ��KeyGenerator 2.����KeyGenerator.generateKey����
     *
     * @return
     */
    public static byte[] generatorMACSecretKey() {
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance(MAC_ALGORITHM);
            SecretKey key = keyGenerator.generateKey();
            return key.getEncoded();
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
    public static SecretKey restoreMACSecretKey(byte[] secretBytes) {
        SecretKey key = new SecretKeySpec(secretBytes, MAC_ALGORITHM);
        return key;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        System.out.println("MD5: " + MD5(PLAIN_TEXT.getBytes()));
        System.out.println("SHA-512: " + SHA(PLAIN_TEXT.getBytes()));
        System.out.println("HmacSHA512��" + MAC(PLAIN_TEXT.getBytes()));

	}

}
