/**
 * 
 */
package com.test.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author 10007610
 *
 */
public class TimeTest {
	
	public static void testNow(){
		Date nowDate = new Date();
		System.out.println(nowDate);
		System.out.println(nowDate.toString());
		System.out.println(nowDate.toLocaleString());
		System.out.println(nowDate.toInstant());
		System.out.println(nowDate.toGMTString());
		
		System.out.println("---------------------------------------");
		
		Instant nowInstent = Instant.now();
		System.out.println(nowInstent);
		System.out.println(nowInstent.toString());
		System.out.println(nowInstent.toEpochMilli());
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		System.out.println(nowLocalDateTime);
		System.out.println(nowLocalDateTime.toString());
		
		System.out.println("******************************************");
		ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
		System.out.println(nowZonedDateTime);
		System.out.println(nowZonedDateTime.toString());
		System.out.println(nowZonedDateTime.toInstant());
		System.out.println(nowZonedDateTime.toLocalDateTime());
	}
	
    public static Instant transferDateStr2Instant(String dateStr){
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(dateStr).toInstant();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testNow();
		Instant in = transferDateStr2Instant("20191223131532");
		System.out.println(in.toString());
	}

}
