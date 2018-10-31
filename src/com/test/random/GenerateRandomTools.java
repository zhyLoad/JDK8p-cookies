/**
 * 
 */
package com.test.random;

import java.util.Date;

/**
 * @author dell
 *
 */
public class GenerateRandomTools {
	
	
	  public static String getRandomNum1(){
       String randomNum = ""+Math.round(Math.random()*1000000);
       while(randomNum.length()<6){
    	   randomNum="0"+randomNum;
    	   }
       return randomNum;
      } 
	
	  public static String getRandomNum2(){
         String randomNum = ""+Math.floor(Math.random()*1000000);
         if(randomNum.length()<6){randomNum="0"+randomNum;}
         return randomNum;
      }   
	  
      public static String getRandomNum3(){
         String randomNum = ""+Math.ceil(Math.random()*1000000);;
         while(randomNum.length()<6){randomNum="0"+randomNum;}
         return randomNum;
      } 
      
      
      public static String getRandomNum4(){
         String randomNum = (Math.random()+"").substring(2,8);
         return randomNum;
      }
      
      public static String getRandomNum5(){
         String randomNum = "";
         for(int i=0;i<6;i++) 
         { 
          randomNum+=Math.floor(Math.random()*10); 
         } 
         return randomNum;
      }
      
      
      public static String getRandomNum6(){
         String randomNum = new Date().getTime()+"";
         randomNum = String.valueOf(Math.floor(Math.random() * 9) + 1)+randomNum.substring(randomNum.length()-5,randomNum.length());
         return randomNum;
      }
      
      public static String getRandomNum7() 
      {
         String randomNum = String.valueOf(Math.floor(Math.random()*900000 + 100000));
         return randomNum;
      }

      
}
