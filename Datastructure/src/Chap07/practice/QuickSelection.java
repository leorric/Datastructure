package Chap07.practice;

public class QuickSelection {
	
	int[] a;
	int k;
	
	public QuickSelection(int[] a,int kth){
		this.a = a;
		this.k = kth;
	}
	
	public int select(){
		if(k > a.length-1){
			return -1;
		}
		return select(0,a.length-1);
	}
	
	public int select(int left,int right){
	
		int pivot = a[right];
		int par = partition(left,right,pivot);
		if(par == k) {
			return a[k];
		}else if(par < k){
			return select(par+1,right);
		}else{
			return select(left,par-1);
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
		//int[] a = new int[]{99,77,88,44,22};
		int[] a = new int[]{99,22};
		int kth = 1;
		QuickSelection qs = new QuickSelection(a,kth);
		int i = qs.select();
		System.out.println("the "+(kth+1)+"th biggest num is:"+i);
	}

}
