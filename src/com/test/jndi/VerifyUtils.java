package com.test.jndi;



import org.apache.commons.codec.digest.DigestUtils;

/**
 * 瀵嗙爜楠岃瘉宸ュ叿绫�
 * Created by 10007610 on 2019/8/28.
 */
public class VerifyUtils {

    public static final String ENCRYPT_TYPE_SHA1 = "SHA-1";
    public static final String ENCRYPT_TYPE_SHA256 = "SHA-256";
    public static final String ENCRYPT_TYPE_MD5 = "MD5";

    private VerifyUtils(){}


    /**
     * 鏍规嵁鍔犲瘑绫诲瀷楠岃瘉鏄庢枃鍜屽瘑鏂囨槸鍚﹀尮閰�
     * @param plaintext 鏄庢枃
     * @param ciphertext 瀵嗘枃
     * @param encryptType 鍔犲瘑绫诲瀷锛歁D5 銆� SHA-1 銆丼HA-256 绛�
     * @return
     */
    public static boolean verify(String plaintext,String ciphertext,String encryptType)throws Exception{
      String encryptValue = "";
      switch (encryptType){
          case ENCRYPT_TYPE_SHA1:
              encryptValue = DigestUtils.sha1Hex(plaintext);
              break;
          case ENCRYPT_TYPE_MD5:
              encryptValue = DigestUtils.md5Hex(plaintext);
              break;
          case ENCRYPT_TYPE_SHA256:
              encryptValue = DigestUtils.sha256Hex(plaintext);
              break;
          default:break;
      }
      return ciphertext.equalsIgnoreCase(encryptValue);
    }



    public static void main(String[] args){
        String a = "123456";
        String b = "7c4a8d09ca3762af61e59520943dc26494f8941b";
        String c = "e10adc3949ba59abbe56e057f20f883e";
        String d = "[B@3712b94";
    try {
//        System.out.println(verify(a,b,ENCRYPT_TYPE_SHA1));
//        System.out.println(verify(a,c,ENCRYPT_TYPE_MD5));
//        System.out.println(verifyLDAP(Base64.encode(a.getBytes()),d));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
