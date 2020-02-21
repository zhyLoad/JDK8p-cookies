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

    /** ����ǩ���㷨��JDKֻ�ṩ��MD2withRSA, MD5withRSA, SHA1withRSA���������㷨��Ҫ������������֧�� */
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    public static final String PLAIN_TEXT = "MANUTD is the greatest club in the world";
    public static void main(String[] args)
    {
        //�������׹�˽Կ��
        Map<String, byte[]> keyMap1 = RSAEncodeAndDecode.generateKeyBytes();
        PublicKey publicKey1 = RSAEncodeAndDecode.restorePublicKey(keyMap1.get(RSAEncodeAndDecode.PUBLIC_KEY));
        PrivateKey privateKey1 = RSAEncodeAndDecode.restorePrivateKey(keyMap1.get(RSAEncodeAndDecode.PRIVATE_KEY));

        Map<String, byte[]> keyMap2 = RSAEncodeAndDecode.generateKeyBytes();
        PublicKey publicKey2 =RSAEncodeAndDecode.restorePublicKey(keyMap2.get(RSAEncodeAndDecode.PUBLIC_KEY));
        PrivateKey privateKey2 =RSAEncodeAndDecode.restorePrivateKey(keyMap2.get(RSAEncodeAndDecode.PRIVATE_KEY));

        /** ��������Aǩ������B������Ϣ
         * A��B�Ĺ�Կ���м���
         * ���Լ�A��˽Կ����ǩ��
         */
        byte[] encodedText = RSAEncodeAndDecode.RSAEncode(publicKey2, PLAIN_TEXT.getBytes());
        byte[] signature = sign(privateKey1, PLAIN_TEXT.getBytes());

        /**
         * ����B�յ���A����Ϣ��������������
         * ��B��˽Կ���ܵõ�����
         * �����ĺ�A�Ĺ�Կ������ǩ����
         */

        byte[] decodedText = RSAEncodeAndDecode.RSADecode(privateKey2, encodedText).getBytes();
        System.out.println("Decoded Text: " + new String(decodedText));

        System.out.println("Signature is " + verify(publicKey1, signature, decodedText));
    }

    /**
     * ǩ����������
     * 1. ʵ�����������㷨
     * 2. ��ʼ��������˽Կ
     * 3. ǩ��
     * @param key
     * @param plainText
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, byte[] plainText)
    {
        try {
            //ʵ����
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

            //��ʼ��������˽Կ
            signature.initSign(privateKey);

            //����
            signature.update(plainText);

            //ǩ��
            return signature.sign();

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ��ǩ��������
     * 1. ʵ�����������㷨
     * 2. ��ʼ�������빫Կ
     * 3. ��ǩ
     * @param publicKey
     * @param signatureVerify
     * @param plainText
     * @return
     */
    public static boolean verify(PublicKey publicKey, byte[] signatureVerify, byte[] plainText )
    {
        try {
            //ʵ����
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

            //��ʼ��
            signature.initVerify(publicKey);

            //����
            signature.update(plainText);

            //��ǩ
            return signature.verify(signatureVerify);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

}
