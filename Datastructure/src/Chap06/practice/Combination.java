package Chap06.practice;

public class Combination {
	static int n;
	
	public void doComb(String[] a,int num,int s) {
		if(num == 0 || a.length-s < num){
			return;
		}else if(a.length-s == num && num==1){
			System.out.print(a[s]);
			n++;
			if(n%3==0){
				System.out.print(",");
			}
			return;
		}
		doComb(a,num-1,s+1);
		System.out.print(a[s]);
		n++;
		if(n%3==0){
			System.out.print(",");
		}
		doComb(a,num,s+1);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Combination comb = new Combination();
		String[] a = new String[]{"A","B","C","D","E"};
		comb.doComb(a, 3, 0);
	}

}
