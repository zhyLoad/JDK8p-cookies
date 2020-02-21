/**
 * 
 */
package com.test.security;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Map;

/**
 * @author 10007610
 *
 */
public class RSASignVerify {

    /** 数字签名算法。JDK只提供了MD2withRSA, MD5withRSA, SHA1withRSA，其他的算法需要第三方包才能支持 */
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    public static final String PLAIN_TEXT = "MANUTD is the greatest club in the world";
    public static void main(String[] args)
    {
        //建立两套公私钥对
        Map<String, byte[]> keyMap1 = RSAEncodeAndDecode.generateKeyBytes();
        PublicKey publicKey1 = RSAEncodeAndDecode.restorePublicKey(keyMap1.get(RSAEncodeAndDecode.PUBLIC_KEY));
        PrivateKey privateKey1 = RSAEncodeAndDecode.restorePrivateKey(keyMap1.get(RSAEncodeAndDecode.PRIVATE_KEY));

        Map<String, byte[]> keyMap2 = RSAEncodeAndDecode.generateKeyBytes();
        PublicKey publicKey2 =RSAEncodeAndDecode.restorePublicKey(keyMap2.get(RSAEncodeAndDecode.PUBLIC_KEY));
        PrivateKey privateKey2 =RSAEncodeAndDecode.restorePrivateKey(keyMap2.get(RSAEncodeAndDecode.PRIVATE_KEY));

        /** 假设现在A签名后向B发送消息
         * A用B的公钥进行加密
         * 用自己A的私钥进行签名
         */
        byte[] encodedText = RSAEncodeAndDecode.RSAEncode(publicKey2, PLAIN_TEXT.getBytes());
        byte[] signature = sign(privateKey1, PLAIN_TEXT.getBytes());

        /**
         * 现在B收到了A的消息，进行两步操作
         * 用B的私钥解密得到明文
         * 将明文和A的公钥进行验签操作
         */

        byte[] decodedText = RSAEncodeAndDecode.RSADecode(privateKey2, encodedText).getBytes();
        System.out.println("Decoded Text: " + new String(decodedText));

        System.out.println("Signature is " + verify(publicKey1, signature, decodedText));
    }

    /**
     * 签名，三步走
     * 1. 实例化，传入算法
     * 2. 初始化，传入私钥
     * 3. 签名
     * @param key
     * @param plainText
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, byte[] plainText)
    {
        try {
            //实例化
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

            //初始化，传入私钥
            signature.initSign(privateKey);

            //更新
            signature.update(plainText);

            //签名
            return signature.sign();

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 验签，三步走
     * 1. 实例化，传入算法
     * 2. 初始化，传入公钥
     * 3. 验签
     * @param publicKey
     * @param signatureVerify
     * @param plainText
     * @return
     */
    public static boolean verify(PublicKey publicKey, byte[] signatureVerify, byte[] plainText )
    {
        try {
            //实例化
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

            //初始化
            signature.initVerify(publicKey);

            //更新
            signature.update(plainText);

            //验签
            return signature.verify(signatureVerify);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

}
