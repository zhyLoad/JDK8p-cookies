/**
 * 
 */
package com.test.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * @author dell
 *
 */
public class FileTypeTest {
	/**
	  * byte数组转换成16进制字符串
	  * @param src
	  * @return
	  */
	 public static String bytesToHexString(byte[] src){     
	        StringBuilder stringBuilder = new StringBuilder();     
	        if (src == null || src.length <= 0) {     
	            return null;     
	        }     
	        for (int i = 0; i < src.length; i++) {     
	            int v = src[i] & 0xFF;     
	            String hv = Integer.toHexString(v);     
	            if (hv.length() < 2) {     
	                stringBuilder.append(0);     
	            }     
	            stringBuilder.append(hv);     
	        }     
	        return stringBuilder.toString();     
	    }
	 
	 /**
	  * 根据文件流读取图片文件真实类型
	  * @param is
	  * @return
	  */
	 public static String getTypeByStream(FileInputStream is){
	     byte[] b = new byte[4];  
	          try {
			   is.read(b, 0, b.length);
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	        String type = bytesToHexString(b).toUpperCase();
	        if(type.contains("FFD8FF")){
	         return "jpg";
	        }else if(type.contains("89504E47")){
	         return "png";
	        }else if(type.contains("47494638")){
	         return "gif";
	        }else if(type.contains("49492A00")){
	         return "tif";
	        }else if(type.contains("424D")){
	         return "bmp";
	        }else if(type.contains("504B0304")){
	        	return "zip";
	        }else if(type.contains("52617221")){
	        	return "rar";
	        }
	        return type;
	 }

	 
	 /**
	  * 
	  * 常用文件的文件头如下：
JPEG (jpg)，文件头：FFD8FF
PNG (png)，文件头：89504E47
GIF (gif)，文件头：47494638
TIFF (tif)，文件头：49492A00 
Windows Bitmap (bmp)，文件头：424D
CAD (dwg)，文件头：41433130
Adobe Photoshop (psd)，文件头：38425053
Rich Text Format (rtf)，文件头：7B5C727466
XML (xml)，文件头：3C3F786D6C
HTML (html)，文件头：68746D6C3E
Email [thorough only] (eml)，文件头：44656C69766572792D646174653A
Outlook Express (dbx)，文件头：CFAD12FEC5FD746F 
Outlook (pst)，文件头：2142444E 
MS Word/Excel (xls.or.doc)，文件头：D0CF11E0
MS Access (mdb)，文件头：5374616E64617264204A
WordPerfect (wpd)，文件头：FF575043
Postscript. (eps.or.ps)，文件头：252150532D41646F6265
Adobe Acrobat (pdf)，文件头：255044462D312E
Quicken (qdf)，文件头：AC9EBD8F 
Windows Password (pwl)，文件头：E3828596 
ZIP Archive (zip)，文件头：504B0304 
RAR Archive (rar)，文件头：52617221 
Wave (wav)，文件头：57415645 
AVI (avi)，文件头：41564920 
Real Audio (ram)，文件头：2E7261FD 
Real Media (rm)，文件头：2E524D46 
MPEG (mpg)，文件头：000001BA 
MPEG (mpg)，文件头：000001B3
Quicktime (mov)，文件头：6D6F6F76 
Windows Media (asf)，文件头：3026B2758E66CF11 
MIDI (mid)，文件头：4D546864 
	  * 
	  * @param args
	  * @throws Exception
	  */
	public static void main(String[] args) throws Exception {
//	     String src = "D:/workspace//8129.jpg";
//	     String src = "D:/workspace//temp/1.gif";
	     String src = "D://temp//apks//2017-07-26//bb28894f-992c-4d4f-8de7-328bdf92adf6//MySwagger.txt";
	     FileInputStream is = new FileInputStream(src);  
//	        byte[] b = new byte[4];  
//	        is.read(b, 0, b.length);  
//	        System.out.println(bytesToHexString(b));
	       
//	        String type = getTypeByStream(is);
//	        System.out.println(type);
	  /*
	   * JPEG (jpg)，文件头：FFD8FF
	PNG (png)，文件头：89504E47
	GIF (gif)，文件头：47494638
	TIFF (tif)，文件头：49492A00 
	Windows Bitmap (bmp)，文件头：424D

	   */
	     
	     
	     
//	     byte[] readByte = new byte[4];
//	        try {
//	            is.read(readByte, 0, readByte.length);
//	            StringBuilder stringBuilder = new StringBuilder();
//	            for (int i = 0; i < readByte.length; i++) {
//	                int v = readByte[i] & 0xFF;
//	                String hv = Integer.toHexString(v);
//	                if (hv.length() < 2) {
//	                    stringBuilder.append(0);
//	                }
//	                stringBuilder.append(hv);
//	            }
//	            String fileHeadSubStr = stringBuilder.toString();
//	            if("504B0304".equals(fileHeadSubStr.toUpperCase())){
//	                System.out.println("HHHHHHHH");
//	            }else{
//	            	System.out.println("NNNNNNNNNNN");
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	     
//	     System.out.println(Integer.MAX_VALUE);
	     
//	     String a = "D:\\temp\\2017-08-21\\1ec3e0af-f04b-438d-b9e3-f28249a1163d\\Launcher2.apk";
//	     
//	     String b[] = {"天成","aaa","霸道","彩礼","dfdafdsaf","坎坎坷坷"};
//	     Arrays.sort(b);
//	     for(String i :b){
//	        System.out.println("---->"+i);
//	     }
//	     String a = "";
//	     String[] b = a.split("1");
//	     System.out.println(b[0]);
	     try {
			int val = 64;
			 System.out.println((val & -val) == val);  
		} catch(IllegalArgumentException ie){
			System.out.println("catched");
			ie.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("11111");
			e.printStackTrace();
		}
	     
	    }    
}
