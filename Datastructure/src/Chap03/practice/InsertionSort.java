package Chap03.practice;

import java.util.Arrays;

public class InsertionSort {

	public void sort(int[] a){
		int tmp = 0;
		for(int j=1,i=0 ; j<a.length; j++) {
			tmp = a[j];
			for(i=j-1; i>=0;i--){			
				if(tmp < a[i]){
					a[i+1] = a[i];
				}else{
					break;
				}
			}
			a[i+1] = tmp;
			//System.out.println(Arrays.toString(a)+","+tmp);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort is = new InsertionSort();
		int[] a = {5,4,1,2,8,11,3};
		//int[] a = {5,4,1,2};
		is.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
