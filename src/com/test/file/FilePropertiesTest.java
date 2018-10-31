/**
 * 
 */
package com.test.file;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 10007610
 *
 */
public class FilePropertiesTest {

	/**
	 * 
	 */
	public FilePropertiesTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		File file = new File("D:\\temp\\upload\\rtes\\/ueditor/upload/image/20180932");
		System.out.println("absolutePath = "+file.getAbsolutePath());
		System.out.println("path = "+file.getPath());
		System.out.println("name = "+file.getName());
		String name = file.getName();
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyyMMdd");
        Date date = formatter.parse(name);
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        
		System.out.println("name transfer = "+localDate.toString());
	}

}
