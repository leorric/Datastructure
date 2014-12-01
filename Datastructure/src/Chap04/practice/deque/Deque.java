package Chap04.practice.deque;

public class Deque {
	
	private int maxSize;
	private int nItems;
	private int front;
	private int rear;
	private long[] que;
	
	public Deque(int size){
		this.maxSize = size;
		front = -1;
		rear = -1;
		que = new long[maxSize];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return maxSize == nItems;
	}
	
	public void insertLeft(long a) throws Exception {
		if(isFull()){
			throw new Exception("stack is full");
		}
		if(isEmpty()){
			front = 0;
			rear = 0;
			que[front] = a;
		}else{
			front--;
			if(front == -1)
				front = maxSize - 1;
			que[front] = a;
		}
		nItems++;
		
	}
	
	public void insertRight(long a) throws Exception {
		if(isFull()){
			throw new Exception("stack is full");
		}
		if(isEmpty()){
			front = 0;
			rear = 0;
			que[front] = a;
		}else{
			rear++;
			if(rear == maxSize)
				rear = 0;
			que[rear] = a;
		}
		nItems++;
	}
	
	public long removeRight() throws Exception {
		if(isEmpty()){
			throw new Exception("stack is empty");
		}
		
		long n = que[rear];
		rear--;
		if(rear == -1){
			rear = maxSize - 1;
		}
		nItems--;
		return n;
	}
	
	public long removeLeft() throws Exception {
		if(isEmpty()){
			throw new Exception("stack is empty");
		}
		long n = que[front];
		front++;
		if(front == maxSize){
			front = 0;
		}
		nItems--;
		return n;
	}
	
	public void display() {
		for(int i=0 ; i<nItems ;i++){
			System.out.print(que[front]+" ");
			front++;
			if(front == maxSize)
				front = 0;
		}
	}
	
	public int size(){
		return nItems;
	}
	
	public static void main(String[] args) throws Exception{
		Deque deq = new Deque(4);
		deq.insertLeft(3);
		deq.insertLeft(2);
		deq.insertRight(4);
		deq.removeLeft();
		deq.insertRight(5);
		deq.insertRight(6);
		deq.removeLeft();
		deq.insertRight(7);
		deq.display();
	}
}
