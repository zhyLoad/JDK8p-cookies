/**
 * 
 */
package com.test.security.cert;



import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;

import org.apache.commons.codec.binary.Base64;


/**
 * @author 10007610
 *  ����ǩ����RSA֤��ʵ��ǩ����ǩ
 * 
 * 
 * ��JDK��keytool���ɹ�˽Կ�ԣ� 
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -genkeypair -alias svkeystore -keyalg RSA -keysize 2048 -keypass 111111 -sigalg SHA256withRSA -dname "CN=testsv,OU=ott,O=startimes,l=beijing,st=beijing,C=cn" -validity 365 -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storetype JKS -storepass 111111
 *
 * ��JDK��keytool����������˽Կ�ԵĹ�Կ֤�飺
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -export -alias svkeystore -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storepass 111111 -file C:\Users\10007610\Desktop\temp\svPubKey.cer
 *
 * ��JDK��keytool��ѯ������˽Կ��֤�������
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -list -v -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storepass 111111
 */
public class GenKeyStoreTest {
	public static String KEYSTORD_FILE = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\cert\\svkeystore.keystore";//֤����ļ�
    public static String PUB_CER_FILE = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\cert\\svPubKey.cer";//��Կ֤��
    public static String KEYSTORD_PASSWORD = "111111";//֤�������
    public static String PRIKEY_PASSWORD = "111111";//˽Կ����
    public static String KEYSTORD_ALIAS = "svkeystore";//֤���������ж������ʱ�����ò���ָ���������
    public static String CONTENT = "����asdfasldfasdfasdfasdfasfdasdf<head><request><content>dkadkkdkdkdkdkdkdkdkdkdk</content></request></head>";
    
    public static String SIGALG_MD5WITHRSA ="MD5withRSA"; //sigalg��ǩ���㷨����MD5withRSA
    public static String SIGALG_SHA1WITHRSA ="SHA1withRSA"; //sigalg��ǩ���㷨����SHA1withRSA
    public static String SIGALG_SHA256WITHRSA ="SHA256withRSA"; //sigalg��ǩ���㷨����SHA256withRSA
    public static String SIGALG_SHA384WITHRSA ="SHA384withRSA"; //sigalg��ǩ���㷨����SHA384withRSA
    public static String SIGALG_SHA512WITHRSA ="SHA512withRSA"; //sigalg��ǩ���㷨����SHA256withRSA
    
    public static String STORE_TYPE_JKS  ="JKS";
    
    
    public static void main(String[] args) throws Exception {
        
        //====================֤����л�ȡ˽Կ����Կ����Կ֤���л�ȡ��Կ========================
        KeyStore keyStore = getKeyStore(KEYSTORD_FILE);
        Certificate certificate = keyStore.getCertificate(KEYSTORD_ALIAS);
        //˽Կ
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(KEYSTORD_ALIAS, PRIKEY_PASSWORD.toCharArray());
        //��Կ����֤����ļ��У�
        PublicKey publicKey = certificate.getPublicKey();
        //��Կ���ӹ�Կ֤���л�ȡ��
        PublicKey cerPublicKey = getPublicKeyFromPubCerFile(PUB_CER_FILE);
        
        
        //====================base64λ�����˽Կ========================
        base64PrintKey(privateKey.getEncoded(),"֤���","˽Կ");
        String base64KeystorePubKey = base64PrintKey(publicKey.getEncoded(),"֤���","��Կ");
        String base64CerPubKey = base64PrintKey(cerPublicKey.getEncoded(),"��Կ֤��","��Կ");
        System.out.println("֤����еĹ�Կ�͹�Կ֤���еĹ�Կ�Ƿ���ͬ��" + base64KeystorePubKey.equals(base64CerPubKey));
 
        //====================��˽Կ�����Ľ���ǩ��========================
        String md5Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_MD5WITHRSA,null);
        String sha1Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA1WITHRSA,null);
        String sha256Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA256WITHRSA,null);
        String sha384Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA384WITHRSA,null);
        String sha512Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA512WITHRSA,null);
        
        
        //====================��Կ��ǩ========================
        verify(CONTENT.getBytes(),Base64.decodeBase64(md5Sign), publicKey,SIGALG_MD5WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha1Sign), publicKey,SIGALG_SHA1WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha256Sign), publicKey,SIGALG_SHA256WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha384Sign), publicKey,SIGALG_SHA384WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha512Sign), publicKey,SIGALG_SHA512WITHRSA,null);
    }
    
    /**
     * base64�����˽Կ
     * @param keyEncoded
     * @param keyFile
     * @param keyType
     * @return
     */
    private static String base64PrintKey(byte[] keyEncoded,String keyFile,String keyType) {
        String base64Key = Base64.encodeBase64String(keyEncoded);
        System.out.println("base64���" + keyFile + "�е�"+ keyType + "��");
        System.out.println(base64Key);
        return base64Key;
    }
 
    
    /**
     * ��ȡ֤������
     * @param keystoreFile
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keystoreFile) throws Exception {
        FileInputStream keystoreIs = new FileInputStream(new File(KEYSTORD_FILE));
        KeyStore keyStore = KeyStore.getInstance(STORE_TYPE_JKS);
        keyStore.load(keystoreIs, KEYSTORD_PASSWORD.toCharArray());
        keystoreIs.close();
        return keyStore;
    }
 
    /**
     * ǩ����ʹ��˽Կ����ǩ��
     * @param message
     * @param privateKey
     * @param algorithm
     * @param provider
     * @return
     * @throws Exception
     */
    public static String sign(byte[] message, PrivateKey privateKey, String algorithm, String provider) throws Exception {
        Signature signature;
        if (null == provider || provider.length() == 0) {
            signature = Signature.getInstance(algorithm);
        } else {
            signature = Signature.getInstance(algorithm, provider);
        }
        signature.initSign(privateKey);
        signature.update(message);
        byte[] sign = signature.sign();
        return Base64.encodeBase64String(sign);
    }
    
    /**
     * ��ǩ:ʹ�ù�Կ������ǩ
     * @param message
     * @param signMessage
     * @param publicKey
     * @param algorithm
     * @param provider
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] message, byte[] signMessage, PublicKey publicKey, String algorithm,
                                 String provider) throws Exception {
        Signature signature;
        boolean verifyResult;
        if (null == provider || provider.length() == 0) {
            signature = Signature.getInstance(algorithm);
        } else {
            signature = Signature.getInstance(algorithm, provider);
        }
        signature.initVerify(publicKey);
        signature.update(message);
        verifyResult = signature.verify(signMessage);
        System.out.println(algorithm+ "��ǩ�����" + verifyResult);
        return verifyResult;
    }
    
    /**
     * �ӹ�Կ֤���л�ȡ��Կ
     * @param pubCerFile
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKeyFromPubCerFile(String pubCerFile) throws Exception{
        FileInputStream cerIs = new FileInputStream(new File(pubCerFile));
        CertificateFactory cer = CertificateFactory.getInstance("X.509");
        Certificate cerCertificate = cer.generateCertificate(cerIs);
        cerIs.close();
        PublicKey cerPublicKey = cerCertificate.getPublicKey();
        return cerPublicKey;
    }
    
    
    /**
     * ֤����ȡ������֤���ֻ��һ������ʱ���÷�����ȡ��Ĭ�ϱ������ж������ʱ���ᱻ���ǣ������ò���ָ���������
     * 
     * @param pubCerFile
     * @return
     * @throws Exception
     */
    public static String getAliasByKeystore(KeyStore keyStore) throws Exception{
      Enumeration aliasEnum = keyStore.aliases();
      String keystoreAlias=null;
      while (aliasEnum.hasMoreElements()) keystoreAlias = (String) aliasEnum.nextElement();
      return keystoreAlias;
    }
}
