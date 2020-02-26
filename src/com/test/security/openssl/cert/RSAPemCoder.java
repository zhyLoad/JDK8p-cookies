/**
 * 
 */
package com.test.security.openssl.cert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * @author 10007610
 *
 */
public class RSAPemCoder {
    public static final String KEY_SHA = "SHA";   
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * ��˽Կ����Ϣ��������ǩ��
     *
     * @param data ��������
     * @param privateKey ˽Կ
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, PrivateKey privateKey) throws Exception {  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    /**
     * У������ǩ��
     *
     * @param data ��������
     * @param publicKey ��Կ
     * @param sign ����ǩ��
     * @return У��ɹ�����true ʧ�ܷ���false
     * @throws Exception
     */
    public static boolean verify(byte[] data, PublicKey publicKey, String sign) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(decryptBASE64(sign));
    }

    /**
     * ˽Կ����
     *
     * @param data ����
     * @param PrivateKey ˽Կ
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * �ù�Կ����
     *
     * @param data ����
     * @param publicKey ��Կ 
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * �ù�Կ����
     *
     * @param data ����
     * @param PublicKey ��Կ
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * ��˽Կ����
     *
     * @param data ����
     * @param privateKey ˽Կ
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, PrivateKey privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static PrivateKey getPrivateKeyFromPem() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\openssl\\cert\\pkcs8_rsa_private_key.pem"));
        String s = br.readLine();
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != '-') {
            str += s + "\r";
            s = br.readLine();
        }
        byte[] b = Base64.decodeBase64(str);

        // ����˽��  
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(b);
        PrivateKey privateKey = kf.generatePrivate(keySpec);
        return privateKey;
    }

    public static PublicKey getPublicKeyFromPem() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\openssl\\cert\\pkcs8_rsa_public_key.pem"));
        String s = br.readLine();
        String str = "";
        s = br.readLine();
        while (s.charAt(0) != '-') {
            str += s + "\r";
            s = br.readLine();
        }
        byte[] b = Base64.decodeBase64(str);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(b);
        PublicKey pubKey = kf.generatePublic(keySpec);
        return pubKey;
    }
    
    public static byte[] decryptBASE64(String key) throws Exception {   
    	return Base64.decodeBase64(key);
    }   
  
    public static String encryptBASE64(byte[] key) throws Exception {   
    	return new String(Base64.encodeBase64(key));
    }   

    public static byte[] encryptMD5(byte[] data) throws Exception {   
  
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);   
        md5.update(data);   
  
        return md5.digest();   
  
    }   
  
    public static byte[] encryptSHA(byte[] data) throws Exception {   
  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);   
        sha.update(data);   
  
        return sha.digest();   
  
    }  
    
    
    public static void main(String[] args){
    	String content="����asdfasldfasdfasdfasdfasfdasdf<head><request><content>dkadkkdkdkdkdkdkdkdkdkdk</content></request></head>";
    	try {
			PrivateKey privateKey = getPrivateKeyFromPem();
			System.out.println("the content will be sign is :\n"+content);
			String signResult = sign(content.getBytes(), privateKey);
			System.out.println("sign result is \n"+signResult);
			
			PublicKey publicKey = getPublicKeyFromPem();
			boolean verifyResult = verify(content.getBytes(), publicKey, signResult);
			System.out.println("verify result is \n"+verifyResult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
