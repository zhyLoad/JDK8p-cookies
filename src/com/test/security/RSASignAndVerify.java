/**
 * 
 */
package com.test.security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
	
	
/**
 * @author 10007610
 *
 */
public class RSASignAndVerify {

private static String src = "i look";
	
	
	public static void MD5RSASign(){
		
		try {
			
			// ����һ����Կ
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");  //��ȡ��Կ������ʵ��
			keyPairGenerator.initialize(512);  // ��ʼ������
			KeyPair keyPair = keyPairGenerator.generateKeyPair();  
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();//���ɹ�Կ
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();  // ����˽Կ
			
			//��˽Կ����ǩ��
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());  //˽Կת����pkcs8��ʽ
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); // ��key������������˽Կ
			Signature signature = Signature.getInstance("MD5withRSA");  //  md5 RSAǩ������
			signature.initSign(privateKey);  //��ʼ��ǩ��
			signature.update(src.getBytes());
			byte[] result = signature.sign();  //����Ϣ����ǩ��
			System.out.println("ǩ�������"+result);
			
			
			//�ù�Կ������֤
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature.initVerify(publicKey);
			signature.update(src.getBytes());
			boolean verify = signature.verify(result);
			System.out.println("��֤���:"+verify);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MD5RSASign();

	}
	
	

}
