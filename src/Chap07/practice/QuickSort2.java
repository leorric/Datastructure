package Chap07.practice;

import java.util.Arrays;

public class QuickSort2 {

	int[] a;
	
	public QuickSort2(int[] a){
		this.a = a;
	}
	
	
	// correct
	public int partition(int left,int right,int pivot){
		int leftPtr = left;
		int rightPtr = right - 1;
		while(true){
			while(a[++leftPtr] < pivot)
				;
			while(a[--rightPtr] > pivot)
				;
			
			if(leftPtr >= rightPtr){
				break;
			}else{
				swap(leftPtr,rightPtr);
			}
		}
		swap(leftPtr,right-1);
		return leftPtr;
	}
	
	private void swap(int i,int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	//correct
	private int medianOf3(int left,int right){
		int center = (left+right)/2;
		if(a[left] > a[center]){
			swap(left,center);
		}
		if(a[left] > a[right]){
			swap(left,right);
		}
		if(a[center] > a[right]){
			swap(center,right);
		}
		
		swap(center,right-1); //最后一个大于pivot，因此已经在正确的分区中了
		return a[right-1];
	}
	
	private void manualSort(int left,int right){
		int size = right - left + 1;
		if(size <= 1){
			return;
		}else if(size == 2){
			if(a[left] > a[right]){
				swap(left,right);
			}
		}else if(size == 3){
			if(a[left] > a[right-1]){
				swap(left,right-1);
			}
			if(a[left] > a[right]){
				swap(left,right);
			}
			if(a[right-1] > a[right]){
				swap(right-1,right);
			}
		}
	}
	
	public void quickSort() {
		quickSort(0,a.length-1);
	}
	
	public void quickSort(int left,int right){
		int size = right - left + 1;
		if(size <= 3){
			manualSort(left,right);
			return;
		}
		int pivot = medianOf3(left,right);
		int par = partition(left,right,pivot);
		quickSort(left,par-1);
		quickSort(par+1,right);
	}
	
	public static void main(String[] args){
		int[] a = {46,85,72,96,97,75,49,87,70,65,14,19,31,97,53,53};
		//int[] a = {33,12,59,29,34,51};
		QuickSort2 qs2 = new QuickSort2(a);
		qs2.quickSort();
		System.out.println(Arrays.toString(qs2.a));
	}

}
