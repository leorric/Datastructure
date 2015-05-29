package Chap04.practice.app;

public class Customer {
	
	private String name;
	private int processTime;
	
	public Customer(String name,int processTime){
		this.name = name;
		this.processTime = processTime;
	}
	
	public int passTime(){
		return --processTime;
	}
	
	public String toString(){
		return name;
	}
}
