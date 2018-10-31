package com.test.longt;

/**
 * @author 10007610
 *
 */
public class LongValueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long test = 2322323;
		
		Long a = Long.valueOf(test);
		Long b = new Long(test);
		Long c = Long.valueOf(test);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println("1.a.value="+a.longValue()+",b.value="+b.longValue()+"c.value="+c.longValue());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
	}

}
