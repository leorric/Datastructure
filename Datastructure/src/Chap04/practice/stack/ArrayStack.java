package Chap04.practice.stack;

import Chap04.practice.deque.Deque;

public class ArrayStack {
	
	private Deque deque;
	
	public ArrayStack(int maxSize){
		deque = new Deque(maxSize);
	}
	
	public boolean isEmpty(){
		return deque.isEmpty();
	}
	
	public boolean isFull(){
		return deque.isFull();
	}
	
	public void push(long a) throws Exception{
		deque.insertRight(a);
	}
	
	public long pop() throws Exception{
		return deque.removeRight();
	}
	
	public long peek() throws Exception{
		long n = deque.removeRight();
		deque.insertRight(n);
		return n;
	}
	
	public int size(){
		return deque.size();
	}
	
	public static void main(String[] args) throws Exception{
		ArrayStack stack = new ArrayStack(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		long n = stack.peek();
		System.out.println("top is:"+n);
		for(int i=0;i<2;i++){
			System.out.print(stack.pop()+",");
		}
	}
}
