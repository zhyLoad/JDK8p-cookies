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
		
//		//1-1.lambda���ʽ�ڲ�����ֱ���޸��ⲿ������ֵ����---�����޸Ļ��������ֶε�ֵ
//		long  bNumber = 0;
//		List<Integer> a11List = Arrays.asList(1,3,23,4,23,54,34);
//		a11List.forEach((a)->{
//			System.out.println(a);
//			bNumber = 234;//Error before complier :bNumber must be final
//		});
		
//		//����취1-1 ��Ҫ�޸ĵ�ֵ��Ϊ��������Դ���
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

		
//		//1-2.lambda���ʽ�ڲ�����ֱ���޸��ⲿ������ֵ����---���ܸ�����ֵ
//		AAObject aObj = null;
//		List<Integer> a1List = Arrays.asList(1,3,23,4,23,54,34);
//		a1List.forEach((a)->{
//			System.out.println(a);
//			aObj = new AAObject(12,"����");//Error before complier :aObj must be final
//		});
		

		
		
//		//����취1-2 ��lambda���ʽ�ⲿ����һ������Ϊ1�Ķ�������,ͬ�����Ҫ�޸Ļ����������ͱ������û����������͵����鼴��
//		AAObject[] aObjArr = {null};
//		List<Integer> a1List = Arrays.asList(1,3,23,4,23,54,34);
//		a1List.forEach((a)->{
//			System.out.println(a);
//			aObjArr[0] = new AAObject(12,"����");
//		});
//		AAObject aObj = (AAObject)aObjArr[0];
//		System.out.println(aObj.getName());//print ����
		

	}

}
