package Chap07.practice;

public class QuickMedianFinder {
	
	int[] a;
	
	public QuickMedianFinder(int[] a){
		this.a = a;
	}
	
	public int findMedian(){
		return findMedian(0,a.length-1);
	}
	
	public int findMedian(int left,int right){
	
		int pivot = a[right];
		int par = partition(left,right,pivot);
		int mid = (0+a.length-1)/2;
		if(par == mid) {
			return a[mid];
		}else if(par < mid){
			return findMedian(par+1,right);
		}else{
			return findMedian(left,par-1);
		}
		
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = new int[]{0,1,3,6,4,5,2};
		//int[] a = new int[]{0,1,2,6,4,5,3};
		//int[] a = new int[]{0,1,2,6,4,5,3,9,10,8,7};
		//int[] a = new int[]{99,77,88,44,22};
		//int[] a = new int[]{99,77,88};
		int[] a = new int[]{99,77};
		QuickMedianFinder finder = new QuickMedianFinder(a);
		int median = finder.findMedian();
		System.out.println("median val:"+median);
	}

}
