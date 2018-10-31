/**
 * 
 */
package com.test.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author 10007610
 *
 */
public class TestLambda {

	/**
	 * 
	 */
	public TestLambda() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//1-1.lambda表达式内部不能直接修改外部变量的值问题---不能修改基础类型字段的值
//		long  bNumber = 0;
//		List<Integer> a11List = Arrays.asList(1,3,23,4,23,54,34);
//		a11List.forEach((a)->{
//			System.out.println(a);
//			bNumber = 234;//Error before complier :bNumber must be final
//		});
		
//		//解决办法1-1 将要修改的值作为对象的属性传入
//		long  bNumber = 0;
//		ParametersClass parametersClass = new ParametersClass();
//		parametersClass.setParam1(bNumber);
//		List<Integer> a11List = Arrays.asList(1,3,23,4,23,54,34);
//		a11List.forEach((a)->{
//			System.out.println(a);
//			long setBNumberValue = 234;
//			parametersClass.setParam1(setBNumberValue);
//		});
//		bNumber = parametersClass.getParam1();
//		System.out.println(bNumber); //print 234

		
//		//1-2.lambda表达式内部不能直接修改外部变量的值问题---不能给对象赋值
//		AAObject aObj = null;
//		List<Integer> a1List = Arrays.asList(1,3,23,4,23,54,34);
//		a1List.forEach((a)->{
//			System.out.println(a);
//			aObj = new AAObject(12,"张三");//Error before complier :aObj must be final
//		});
		

		
		
//		//解决办法1-2 从lambda表达式外部传入一个长度为1的对象数组,同理，如果要修改基础数据类型变量，用基础数据类型的数组即可
//		AAObject[] aObjArr = {null};
//		List<Integer> a1List = Arrays.asList(1,3,23,4,23,54,34);
//		a1List.forEach((a)->{
//			System.out.println(a);
//			aObjArr[0] = new AAObject(12,"张三");
//		});
//		AAObject aObj = (AAObject)aObjArr[0];
//		System.out.println(aObj.getName());//print 张三
		

	}

}
