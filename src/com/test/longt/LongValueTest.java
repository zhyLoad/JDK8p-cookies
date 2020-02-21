package com.test.longt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10007610
 *
 */
public class LongValueTest {
	
	public static <T> List<List<T>> fixedGrouping2(List<T> source, int n) {

	    if (null == source || source.size() == 0 || n <= 0)
	        return null;
	    List<List<T>> result = new ArrayList<List<T>>();
	    int remainder = source.size() % n;
	    int size = (source.size() / n);
	    for (int i = 0; i < size; i++) {
	        List<T> subset = null;
	        subset = source.subList(i * n, (i + 1) * n);
	        result.add(subset);
	    }
	    if (remainder > 0) {
	        List<T> subset = null;
	        subset = source.subList(size * n, size * n + remainder);
	        result.add(subset);
	    }
	    return result;
	}
	
	
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
        
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        list.add(4L);
        List<List<Long>> result = fixedGrouping2(list, 2);
        System.out.println(result.size());
	}

}
