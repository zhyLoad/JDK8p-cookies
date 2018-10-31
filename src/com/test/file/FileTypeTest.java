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
	  * byte����ת����16�����ַ���
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
	  * �����ļ�����ȡͼƬ�ļ���ʵ����
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
	  * �����ļ����ļ�ͷ���£�
JPEG (jpg)���ļ�ͷ��FFD8FF
PNG (png)���ļ�ͷ��89504E47
GIF (gif)���ļ�ͷ��47494638
TIFF (tif)���ļ�ͷ��49492A00 
Windows Bitmap (bmp)���ļ�ͷ��424D
CAD (dwg)���ļ�ͷ��41433130
Adobe Photoshop (psd)���ļ�ͷ��38425053
Rich Text Format (rtf)���ļ�ͷ��7B5C727466
XML (xml)���ļ�ͷ��3C3F786D6C
HTML (html)���ļ�ͷ��68746D6C3E
Email [thorough only] (eml)���ļ�ͷ��44656C69766572792D646174653A
Outlook Express (dbx)���ļ�ͷ��CFAD12FEC5FD746F 
Outlook (pst)���ļ�ͷ��2142444E 
MS Word/Excel (xls.or.doc)���ļ�ͷ��D0CF11E0
MS Access (mdb)���ļ�ͷ��5374616E64617264204A
WordPerfect (wpd)���ļ�ͷ��FF575043
Postscript. (eps.or.ps)���ļ�ͷ��252150532D41646F6265
Adobe Acrobat (pdf)���ļ�ͷ��255044462D312E
Quicken (qdf)���ļ�ͷ��AC9EBD8F 
Windows Password (pwl)���ļ�ͷ��E3828596 
ZIP Archive (zip)���ļ�ͷ��504B0304 
RAR Archive (rar)���ļ�ͷ��52617221 
Wave (wav)���ļ�ͷ��57415645 
AVI (avi)���ļ�ͷ��41564920 
Real Audio (ram)���ļ�ͷ��2E7261FD 
Real Media (rm)���ļ�ͷ��2E524D46 
MPEG (mpg)���ļ�ͷ��000001BA 
MPEG (mpg)���ļ�ͷ��000001B3
Quicktime (mov)���ļ�ͷ��6D6F6F76 
Windows Media (asf)���ļ�ͷ��3026B2758E66CF11 
MIDI (mid)���ļ�ͷ��4D546864 
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
	   * JPEG (jpg)���ļ�ͷ��FFD8FF
	PNG (png)���ļ�ͷ��89504E47
	GIF (gif)���ļ�ͷ��47494638
	TIFF (tif)���ļ�ͷ��49492A00 
	Windows Bitmap (bmp)���ļ�ͷ��424D

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
//	     String b[] = {"���","aaa","�Ե�","����","dfdafdsaf","��������"};
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
