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
 * pem文件生成过程：环境-centos， yum 安装openssl
 * 
 * 1）生成私钥证书
 * openssl genrsa -out rsa_private_key.pem 1024
 * 
 * 2）格式转化：转化为pkcs8格式
 * openssl pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt > pkcs8_rsa_private_key.pem
 * 
 * 3）生成公钥证书
 * openssl rsa -in pkcs8_rsa_private_key.pem -pubout -out pkcs8_rsa_public_key.pem
 * 
 * @author 10007610
 *
 */
public class RSASignAndVerifyBySHA1 {
	
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data 加密数据（原文）
     * @param privateKey 私钥
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
     * 校验数字签名
     *
     * @param data 加密数据(原文)
     * @param publicKey 公钥
     * @param sign 数字签名
     * @return 校验成功返回true 失败返回false
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
     * 私钥解密
     *
     * @param data 密文
     * @param PrivateKey 私钥
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
     * 用公钥解密
     *
     * @param data 密文
     * @param publicKey 公钥 
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
     * 用公钥加密
     *
     * @param data 明文
     * @param PublicKey 公钥
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
     * 用私钥加密
     *
     * @param data 明文
     * @param privateKey 私钥
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
     * 根据.pem文件的路径读取Pem文件中的私钥
     * @param pemFilePath
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKeyFromPem(String pemFilePath) throws Exception {
        byte[] b = getBytesContentFromPemFile(pemFilePath);
        // 生成私匙  
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(b);
        PrivateKey privateKey = kf.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * 根据.pem文件的路径读取Pem文件中的公钥
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
     * 读取出pem文件中的内容
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
    	String content="内容asdfasldfasdfasdfasdfasfdasdf<head><request><content>dkadkkdkdkdkdkdkdkdkdkdk</content></request></head>";
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
