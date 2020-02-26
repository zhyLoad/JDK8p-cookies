/**
 * 
 */
package com.test.security.openssl.cert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * pem�ļ����ɹ��̣�����-centos�� yum ��װopenssl
 * 
 * 1������˽Կ֤��
 * openssl genrsa -out rsa_private_key.pem 1024
 * 
 * 2����ʽת����ת��Ϊpkcs8��ʽ
 * openssl pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt > pkcs8_rsa_private_key.pem
 * 
 * 3�����ɹ�Կ֤��
 * openssl rsa -in pkcs8_rsa_private_key.pem -pubout -out pkcs8_rsa_public_key.pem
 * 
 * @author 10007610
 *
 */
public class RSASignAndVerifyBySHA1 {
	
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";

    /**
     * ��˽Կ����Ϣ��������ǩ��
     *
     * @param data �������ݣ�ԭ�ģ�
     * @param privateKey ˽Կ
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, PrivateKey privateKey) throws Exception {  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return new String(Base64.encodeBase64(signature.sign()));
    }

    
    
    /**
     * У������ǩ��
     *
     * @param data ��������(ԭ��)
     * @param publicKey ��Կ
     * @param sign ����ǩ��
     * @return У��ɹ�����true ʧ�ܷ���false
     * @throws Exception
     */
    public static boolean verify(byte[] data, PublicKey publicKey, String sign) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);
        byte[] willVerify = Base64.decodeBase64(sign);
        return signature.verify(willVerify);
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

    
    /**
     * ����.pem�ļ���·����ȡPem�ļ��е�˽Կ
     * @param pemFilePath
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPem(String pemFilePath) throws Exception {
        byte[] b = getBytesContentFromPemFile(pemFilePath);
        // ����˽��  
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(b);
        PrivateKey privateKey = kf.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * ����.pem�ļ���·����ȡPem�ļ��еĹ�Կ
     * @param pemFilePath
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromPem(String pemFilePath) throws Exception {
        byte[] b = getBytesContentFromPemFile(pemFilePath);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(b);
        PublicKey pubKey = kf.generatePublic(keySpec);
        return pubKey;
    }
    
    
    /**
     * ��ȡ��pem�ļ��е�����
     * @param pemFilePath
     * @return
     * @throws Exception
     */
    private static byte[] getBytesContentFromPemFile(String pemFilePath)throws Exception{
    	BufferedReader br = null;
    	try{
    		br = new BufferedReader(new FileReader(pemFilePath));
	        String s = br.readLine();
	        String str = "";
	        s = br.readLine();
	        while (s.charAt(0) != '-') {
	            str += s + "\r";
	            s = br.readLine();
	        }
	        return Base64.decodeBase64(str);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(br!=null){
    			br.close();
    		}
    	}
    	return null;
    }
    
    
    public static void main(String[] args){
    	String privateKeyPemPath = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\openssl\\cert\\pkcs8_rsa_private_key.pem";
    	String publicKeyPemPath = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\openssl\\cert\\pkcs8_rsa_public_key.pem";
    	String content="����asdfasldfasdfasdfasdfasfdasdf<head><request><content>dkadkkdkdkdkdkdkdkdkdkdk</content></request></head>";
    	try {
			PrivateKey privateKey = getPrivateKeyFromPem(privateKeyPemPath);
			System.out.println("the content will be sign is :\n"+content);
			String signResult = sign(content.getBytes(), privateKey);
			System.out.println("sign result is \n"+signResult);
			
			PublicKey publicKey = getPublicKeyFromPem(publicKeyPemPath);
			boolean verifyResult = verify(content.getBytes(), publicKey, signResult);
			System.out.println("verify result is \n"+verifyResult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
