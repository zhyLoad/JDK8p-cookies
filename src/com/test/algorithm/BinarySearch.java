/**
 * 
 */
package com.test.algorithm;


/**
 * @author 10007610 ���η�ʵ��
 * ���ֲ��ң�ǰ���ǲ���һ���Ѿ�����õļ��ϣ�
 *
 */
public class BinarySearch {

	/**
	 * 
	 */
	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}
	
	public static int binarySearchIntList(int[] arr,int searchValue){
		int low = 0;
		int upper = arr.length-1;
		return doBinarySearch(arr,searchValue,low,upper);
	}
	
	private static int doBinarySearch(int[] arr,int searchValue,int low,int upper){
		int middle = (upper+low)/2;
		
		if(low>upper||arr[low]>searchValue||arr[upper]<searchValue){
			return -1;
		}

		if(searchValue == arr[middle]){
			return middle;
		}else if(searchValue<arr[middle]){
			upper = middle-1;
			return doBinarySearch(arr,searchValue,low,upper);
		}else{
			low = middle+1;
			return doBinarySearch(arr,searchValue,low,upper);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,123,232,245,276,321,433};
        System.out.println(binarySearchIntList(arr,321));
           

	}

}
