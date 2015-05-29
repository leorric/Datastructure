package Chap06.practice;

public class BinaryTreeDrawer {

	private String[] a = null; //width*5+4
	private int width;
	
	//public BinaryTreeDrawer(int width)
	
	public void drawTree(int width) {
		this.width = width;
		int n=0;
		while(width !=0 ){
			width /= 2;
			n++;
		}
		a = new String[this.width * n];
		drawTree(0,this.width-1,0);
	}
	
	public void drawTree(int leftBound,int rightBound,int level){
		if(leftBound >= rightBound){
			drawRoot(leftBound,rightBound,level);
			return;
		}
		
		int mid = (leftBound+rightBound)/2;
		//System.out.println(leftBound+","+rightBound+","+mid+","+level);
		drawRoot(leftBound,rightBound,level);
		level++;
		drawTree(leftBound,mid,level);
		drawTree(mid+1,rightBound,level);
	}
	
	private void drawRoot(int leftBound,int rightBound,int level){
		int mid = (leftBound+rightBound)/2;
		int offset = level * width;
		int i=leftBound;
		for(; i<rightBound+1; i++ ){
			if(i == mid){
				a[i+offset] = "X";
			}else {
				a[i+offset] = "-";
			}
		}
		//a[i] = "\n";
	}
	
	public void display(){
		for(int i=0;i<a.length;i++){
			if(i!=0 && i % this.width == 0){
				System.out.println();
			}
			System.out.print(a[i]);
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeDrawer drawer = new BinaryTreeDrawer();
		drawer.drawTree(8);
		drawer.display();
	}

}
