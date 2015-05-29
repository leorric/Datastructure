package Chap06.practice;

public class Knapsack2 {
	
	public boolean match(long weight,int[] items,int i){
		if(i > items.length-1 || weight < 0){
			return false;
		}
		if( weight == items[i]){
			System.out.print(items[i]+ " ");
			return true;
		}
		boolean m = match(weight - items[i],items,i+1);
		if(m == true) {
			System.out.print(items[i]+ " ");
			return true;
		}
		return match(weight,items,i+1);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack2 ks = new Knapsack2();
		int[] items = new int[]{11,5,1,2,33};
		long weight = 45;
		boolean b = ks.match(weight, items, 0);
		System.out.print("total:"+weight+" "+b);
		//char a = '12';
	}
}
