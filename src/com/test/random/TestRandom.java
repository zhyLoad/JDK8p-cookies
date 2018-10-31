/**
 * 
 */
package com.test.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author dell
 *  ���ɹ̶����ȵ�����������ڶ�����֤�롢ͼƬ��֤�����֤�볡��
 */
public class TestRandom {
	
    /**
     * ����ָ�����ȵ���֤��---����+��ĸ���
     * @author Q
     * @param verificationCodeLength
     * @return String
     * @since 2016-09-6
     */
    public static final String createVerificationCode(int verificationCodeLength) 
    {
        //    ���к�ѡ�����֤����ַ�������������
        String[] verificationCodeArrary={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
               "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
               "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
               };
        String verificationCode = "";
        Random random = new Random();
        //�˴���������֤��ĺ����ˣ�����һ����Χ�ڵ��������Ϊ��֤��������±꣬ѭ�����������Ҫ���ȵ���֤�룬��Ϊҳ��������֤���ʼ���������֤����֤����
        for(int i=0;i<verificationCodeLength;i++){
        	verificationCode += verificationCodeArrary[random.nextInt(verificationCodeArrary.length)];
        }
        return verificationCode;
    }
    
    /**
    * ����ָ������������ַ���
    * @param numberFlag �Ƿ�������
    * @param length
    * @return
    */
    public static String createRandom(boolean numberFlag, int length){
     String retStr = "";
     String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
     int len = strTable.length();
     boolean bDone = true;
     do {
      retStr = "";
      int count = 0;
      for (int i = 0; i < length; i++) {
      double dblR = Math.random() * len;
      int intR = (int) Math.floor(dblR);
      char c = strTable.charAt(intR);
      if (('0' <= c) && (c <= '9')) {
       count++;
      }
      retStr += strTable.charAt(intR);
      }
      if (count >= 2) {
      bDone = false;
      }
     } while (bDone);
     return retStr;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		System.out.println("test function createVerificationCode begin:");
//	    for(int i=0; i<10;i++)
//        {
//            System.out.println("��"+i+"��"+"      ��the verification code is��       "+createVerificationCode(6));
//        }
//	    System.out.println("test function createVerificationCode end!");
//	    
//	    System.out.println("test function createRandom:"+createRandom(true,6));
//		System.out.println(Math.random());
//		System.out.println(Math.random()*1000000);
//		System.out.println(Math.round(Math.random()*1000000));
//
//	    System.out.println("test GenerateRandomTools's function: "+GenerateRandomTools.getRandomNum1());
//	     
		
//		Map<String,List> map = new HashMap<String,List>();
//		for(int i=0;i<=3;i++){
//			List<String> list = map.get("1");
//			if(list==null){
//				list = new ArrayList<String>();
//			}else{
//				list.add("*(");
//			}
//			map.put("1", list);
//		}
//		
//		List<String> result = map.get("1");
//		System.out.println("List.size="+result.size());
//		for(String a : result){
//			System.out.println("ddddd="+a);
//		}
		
		String  aRount = "";
		Random random = new Random();
		for(int i=0;i<6;i++){
			String rand = String.valueOf(random.nextInt(10));
			aRount = aRount.concat(rand);
		}
		
		System.out.println(random.nextInt(10));
		System.out.println(aRount);
	
	}

}
