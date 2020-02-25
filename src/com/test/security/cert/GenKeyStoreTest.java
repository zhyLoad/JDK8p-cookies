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
 *  用自签名的RSA证书实现签名验签
 * 
 * 
 * 用JDK的keytool生成公私钥对： 
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -genkeypair -alias svkeystore -keyalg RSA -keysize 2048 -keypass 111111 -sigalg SHA256withRSA -dname "CN=testsv,OU=ott,O=startimes,l=beijing,st=beijing,C=cn" -validity 365 -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storetype JKS -storepass 111111
 *
 * 用JDK的keytool导出上述公私钥对的公钥证书：
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -export -alias svkeystore -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storepass 111111 -file C:\Users\10007610\Desktop\temp\svPubKey.cer
 *
 * 用JDK的keytool查询上述公私钥对证书情况：
 * C:\Program Files\Java\jdk1.8.0_131\bin>keytool -list -v -keystore C:\Users\10007610\Desktop\temp\svkeystore.keystore -storepass 111111
 */
public class GenKeyStoreTest {
	public static String KEYSTORD_FILE = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\cert\\svkeystore.keystore";//证书库文件
    public static String PUB_CER_FILE = "D:\\Git_local\\java\\JDK8p-cookies\\src\\com\\test\\security\\cert\\svPubKey.cer";//公钥证书
    public static String KEYSTORD_PASSWORD = "111111";//证书库密码
    public static String PRIKEY_PASSWORD = "111111";//私钥密码
    public static String KEYSTORD_ALIAS = "svkeystore";//证书库别名：有多个别名时，引用参数指定具体别名
    public static String CONTENT = "内容asdfasldfasdfasdfasdfasfdasdf<head><request><content>dkadkkdkdkdkdkdkdkdkdkdk</content></request></head>";
    
    public static String SIGALG_MD5WITHRSA ="MD5withRSA"; //sigalg（签名算法）：MD5withRSA
    public static String SIGALG_SHA1WITHRSA ="SHA1withRSA"; //sigalg（签名算法）：SHA1withRSA
    public static String SIGALG_SHA256WITHRSA ="SHA256withRSA"; //sigalg（签名算法）：SHA256withRSA
    public static String SIGALG_SHA384WITHRSA ="SHA384withRSA"; //sigalg（签名算法）：SHA384withRSA
    public static String SIGALG_SHA512WITHRSA ="SHA512withRSA"; //sigalg（签名算法）：SHA256withRSA
    
    public static String STORE_TYPE_JKS  ="JKS";
    
    
    public static void main(String[] args) throws Exception {
        
        //====================证书库中获取私钥、公钥，公钥证书中获取公钥========================
        KeyStore keyStore = getKeyStore(KEYSTORD_FILE);
        Certificate certificate = keyStore.getCertificate(KEYSTORD_ALIAS);
        //私钥
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(KEYSTORD_ALIAS, PRIKEY_PASSWORD.toCharArray());
        //公钥（从证书库文件中）
        PublicKey publicKey = certificate.getPublicKey();
        //公钥（从公钥证书中获取）
        PublicKey cerPublicKey = getPublicKeyFromPubCerFile(PUB_CER_FILE);
        
        
        //====================base64位输出公私钥========================
        base64PrintKey(privateKey.getEncoded(),"证书库","私钥");
        String base64KeystorePubKey = base64PrintKey(publicKey.getEncoded(),"证书库","公钥");
        String base64CerPubKey = base64PrintKey(cerPublicKey.getEncoded(),"公钥证书","公钥");
        System.out.println("证书库中的公钥和公钥证书中的公钥是否相同：" + base64KeystorePubKey.equals(base64CerPubKey));
 
        //====================用私钥对明文进行签名========================
        String md5Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_MD5WITHRSA,null);
        String sha1Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA1WITHRSA,null);
        String sha256Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA256WITHRSA,null);
        String sha384Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA384WITHRSA,null);
        String sha512Sign = sign(CONTENT.getBytes(),privateKey,SIGALG_SHA512WITHRSA,null);
        
        
        //====================公钥验签========================
        verify(CONTENT.getBytes(),Base64.decodeBase64(md5Sign), publicKey,SIGALG_MD5WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha1Sign), publicKey,SIGALG_SHA1WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha256Sign), publicKey,SIGALG_SHA256WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha384Sign), publicKey,SIGALG_SHA384WITHRSA,null);
        verify(CONTENT.getBytes(),Base64.decodeBase64(sha512Sign), publicKey,SIGALG_SHA512WITHRSA,null);
    }
    
    /**
     * base64输出公私钥
     * @param keyEncoded
     * @param keyFile
     * @param keyType
     * @return
     */
    private static String base64PrintKey(byte[] keyEncoded,String keyFile,String keyType) {
        String base64Key = Base64.encodeBase64String(keyEncoded);
        System.out.println("base64输出" + keyFile + "中的"+ keyType + "：");
        System.out.println(base64Key);
        return base64Key;
    }
 
    
    /**
     * 获取证书库对象
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
     * 签名：使用私钥进行签名
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
     * 验签:使用公钥进行验签
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
        System.out.println(algorithm+ "验签结果：" + verifyResult);
        return verifyResult;
    }
    
    /**
     * 从公钥证书中获取公钥
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
     * 证书库获取别名：证书库只有一个别名时，该方法能取到默认别名，有多个别名时，会被覆盖，需引用参数指定具体别名
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
