package Chap03.practice;

import java.util.Arrays;

public class SelectionSort {
	
	public void sort(int[] a){
		int tmp = 0;
		int min = 0;
		for(int i=0; i<a.length-1;i++){
			min = i;
			for(int j=i+1 ; j<a.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort selectionSort = new SelectionSort();
		int[] a = {5,4,1,2,8,11,3};
		selectionSort.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
