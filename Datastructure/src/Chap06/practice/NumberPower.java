package Chap06.practice;

public class NumberPower {
	
	
	public long calculate(int x,int y){
		if(y == 1){
			return x;
		}
		long value = 1;
		int tmp = x;
		x = x*x;
		if(y % 2 == 0){
			y /= 2;
			value = calculate(x,y);
		}else{
			y /= 2;
			value = calculate(x,y) * tmp;
		}
		return value;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberPower np = new NumberPower();
		long m = np.calculate(3, 5);
		System.out.println(m);
	}

}
