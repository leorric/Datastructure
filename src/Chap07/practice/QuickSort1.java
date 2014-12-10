package Chap07.practice;

import java.util.Arrays;

public class QuickSort1 {	
	
	int[] a;
	
	public QuickSort1(int[] a){
		this.a = a;
	}

	public int partition(int left,int right,int pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true){
			while(a[++leftPtr] < pivot)
				;
			while(rightPtr > 0 && a[--rightPtr] > pivot)
				;
			
			if(leftPtr >= rightPtr){
				break;
			}else{
				swap(leftPtr,rightPtr);
			}
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	
	private void swap(int i,int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public void quickSort() {
		quickSort(0,a.length-1);
	}
	
	public void quickSort(int left,int right){
		if(left >= right){
			return;
		}
		int pivot = a[right];
		int par = partition(left,right,pivot);
		quickSort(left,par-1);
		quickSort(par+1,right);
	}
	
	public static void main(String[] args){
		//int[] a = {46,85,72,96,97,75,49,87,70,65,14,19,31,97,53,53};
		int[] a = {33,12,59,29,34,51};
		QuickSort1 qs = new QuickSort1(a);
		qs.quickSort();
		System.out.println(Arrays.toString(qs.a));
	}
}
