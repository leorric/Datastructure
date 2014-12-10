package Chap07.practice;

import java.util.Arrays;

public class ShellSort {
	
	public void sort(int[] a){
		int len = a.length;
		int h = 1;
		while(h < len/3){
			h = 3*h+1;
		}
		
		while(h > 0) {
			
			int j = h;
			//h-sort
			for(int i=h;i<len;i++) {
				int current = a[i];
				j = i;
				while(j-h >=0 && current < a[j-h]){
					a[j] = a[j-h];
					j -= h;
				}
				a[j] = current;
			}
			h = (h-1)/3;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{27,94,41,50,51,63,64,69,76,81,5,91 };
		//int[] a = new int[]{27,34,41,50,51 };
		ShellSort ss = new ShellSort();
		ss.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
