/**
 * 
 */
package com.test.file.codestype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author 10007610
 *
 */
public class CodeStypeTest {
	
	private static String filenameTemp;

	/**
	 * 
	 */
	public CodeStypeTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readFile2Str(FileReader fileReader){
		String str = null;
          try {
			StringBuffer buffer = new StringBuffer();
			  BufferedReader bf= new BufferedReader(fileReader);
			  String s = null;
			  while((s = bf.readLine())!=null){//使用readLine方法，一次读一行
			     buffer.append(s.trim());
			  }

			 str = buffer.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return str;
	}
		
		
		/**
		 * 创建文件
		 * 
		 * @throws IOException
		 */
		public static boolean creatTxtFile(String name) throws IOException {
			boolean flag = false;
			File filename = new File(name);
			if (!filename.exists()) {
				filename.createNewFile();
				flag = true;
			}
			return flag;
		}
	 
		/**
		 * 写文件
		 * 
		 * @param newStr
		 *            新内容
		 * @throws IOException
		 */
		public static boolean writeTxtFile(File file,String newStr) throws IOException {
			// 先读取原有文件内容，然后进行写入操作
			boolean flag = false;
			String filein = newStr + "\r\n";
			String temp = "";
	 
			FileInputStream fis = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
	 
			FileOutputStream fos = null;
			PrintWriter pw = null;
			try {
				// 将文件读入输入流
				fis = new FileInputStream(file);
				isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);
				StringBuffer buf = new StringBuffer();
	 
				// 保存该文件原有的内容
				for (int j = 1; (temp = br.readLine()) != null; j++) {
					buf = buf.append(temp);
					// System.getProperty("line.separator")
					// 行与行之间的分隔符 相当于“\n”
					buf = buf.append(System.getProperty("line.separator"));
				}
				buf.append(filein);
	 
				fos = new FileOutputStream(file);
				pw = new PrintWriter(fos);
				pw.write(buf.toString().toCharArray());
				pw.flush();
				flag = true;
			} catch (IOException e1) {
				// TODO 自动生成 catch 块
				throw e1;
			} finally {
				if (pw != null) {
					pw.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (fis != null) {
					fis.close();
				}
			}
			return flag;
		}

	public static String stripNonCharCodepoints(String input) {
		  StringBuilder retval = new StringBuilder();
		  char ch;
		 
		  for (int i = 0; i < input.length(); i++) {
		    ch = input.charAt(i);
		 
		    // Strip all non-characters http://unicode.org/cldr/utility/list-unicodeset.jsp?a=[:Noncharacter_Code_Point=True:]
		    // and non-printable control characters except tabulator, new line and carriage return
		    if (ch % 0x10000 != 0xffff && // 0xffff - 0x10ffff range step 0x10000
		        ch % 0x10000 != 0xfffe && // 0xfffe - 0x10fffe range
		        (ch <= 0xfdd0 || ch >= 0xfdef) && // 0xfdd0 - 0xfdef
		        (ch > 0x1F || ch == 0x9 || ch == 0xa || ch == 0xd)) {
		 
		      retval.append(ch);
		    }
		  }
		 
		  return retval.toString();
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader uuFile = new FileReader("D:\\ParseAPK\\testJars\\xf_g.text");
			String tempStr = readFile2Str(uuFile);
			String result = stripNonCharCodepoints(tempStr);
			System.out.println("result ***********************************************");
			System.out.println(result);
			if(creatTxtFile("D:\\ParseAPK\\testJars\\trans_xf_g.text")){
				writeTxtFile(new File("D:\\ParseAPK\\testJars\\trans_xf_g.text"),result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
