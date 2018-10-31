/**
 * 
 */
package com.test.time;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testNow();
	}

}
