package Chap03.practice;

import java.util.Arrays;

public class BubbleSort {
	
	public void sort(int[] a){
		int tmp = 0;
		for(int i=a.length-1 ; i>0; i--){ // ��λ��0 -> i(i���ΪN-1�������һ��λ��) ���ҳ����ֵ
			for(int j=0 ; j < i ; j++){
				if(a[j] > a[j+1]){
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		BubbleSort bs = new BubbleSort();
		int[] a = {5,4,1,2,8,11,3};
		//int[] a = {5,4,1,2};
		bs.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
