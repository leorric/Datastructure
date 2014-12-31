package Chap07.practice;

import java.util.Arrays;

public class RadixSort {
	
	long[] a;
	DoublyLinkedList[] groups;
	
	public RadixSort(long[] a){
		this.a = a;
		groups = new DoublyLinkedList[10];
		for(int i=0;i<groups.length;i++){
			groups[i] = new DoublyLinkedList();
		}
	}
	
	public void sort(){
		int divide = 1;
		int num = 0;
		boolean compareHigherDigit = false;
		while(divide > 0){
			compareHigherDigit = false;
			// to linklist
			for(int i=0;i < a.length;i++){
				num = (int)a[i]/divide % 10;
				groups[num].insertLast(a[i]);
				if(num != 0){
					compareHigherDigit = true;
				}
			}
			if(!compareHigherDigit){
				System.out.println("done compare");
				return;
			}
			
			// copy back
			int k = 0;
			for(int i=0; i<groups.length;i++){
				while(!groups[i].isEmpty()) {
					a[k] = groups[i].deleteFirst().dData;
					k++;
				}
			}
			divide *= 10;
			System.out.println(divide);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] a = new long[]{360,451,352,789,11,45,1000,3,982};
		RadixSort rs = new RadixSort(a);
		rs.sort();
		System.out.println(Arrays.toString(a));
	}

}
