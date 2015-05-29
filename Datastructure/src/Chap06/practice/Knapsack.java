package Chap06.practice;

public class Knapsack {

	String[] compo = new String[200];
	int n = 0;
	public static final String ADD="+";
	
	public void match(long weight,String[] items,int num){
		if(num == 1 ){
			compo[0] = items[num-1];
			check(weight,compo[0]);
			n++;
			return;
		}
		match(weight,items,num-1);
		String current = items[num-1];
		compo[n++] = current;
		check(weight,current);
		//n++;
		int tmp = n;
		for(int i=0; i<tmp-1 ; i++,n++){
			compo[tmp+i] = compo[i]+ADD+current;
			check(weight,compo[tmp+i]);
		}
	}
	
	//ÊÊÓÃÓÚ0-9
	private void check(long weight,String str){
		long n = 0;
		char c = 0;
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if( c < 48 || c > 57 ){
				continue;
			}
			n += c -'0';
		}
		if( n == weight){
			System.out.println(str);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack ks = new Knapsack();
		String[] items = new String[]{"1","3","7","5","6","9","2","4"};
		long weight = 31;
		ks.match(weight, items, items.length);
		
		//char a = '12';
	}

}
