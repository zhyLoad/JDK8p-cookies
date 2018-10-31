/**
 * 
 */
package com.test.guava;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author 10007610
 *
 */
public class TestCollectionsGuava {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Long> ids = Arrays.asList(1L,3L,4L,54L,23L,123L,32L,23L,32L,21L);
		
		List<List<Long>> splits = Lists.partition(ids, 10);
		
		for(List<Long> eachList : splits){
			System.out.println(eachList.size());
		}
        
	}

}
