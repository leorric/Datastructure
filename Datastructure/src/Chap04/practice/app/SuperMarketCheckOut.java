package Chap04.practice.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuperMarketCheckOut {
	
	private Queue[] ques;
	private int size;
	
	public SuperMarketCheckOut(int size){
		this.size = size;
		ques = new Queue[size];
		for(int i=0;i<size;i++){
			ques[i] = new Queue(10);
		}
	}
	
	public void addCustomer(Customer c,int queNo){
		//need check full
//		Customer c = new Customer(name,processTime);
		ques[queNo].insert(c);
	}
	
	public Customer removeCustomer(int queNo){
		//need check empty
		Customer c = ques[queNo].remove();
		System.out.println("Remove "+c.toString()+" from line "+queNo);
		return c;
	}
	
	public void passTime(){
		int processTime = 0;
		for(int i=0; i<ques.length;i++) {
			if(!ques[i].isEmpty()){
				processTime = ques[i].peekFront().passTime();
				if(processTime == 0){
					removeCustomer(i);
				}
			}
		}
	}
	
	public void display(){
		for(int i=0;i<size;i++){
			System.out.print("Line "+i+":");
			ques[i].display();
		}
	}
	
	private static String getStringFromInput() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}
	
	public static void main(String[] args) throws Exception{
		SuperMarketCheckOut market = new SuperMarketCheckOut(3);
		System.out.println("please input:");
		while(true){
			String command = getStringFromInput();
			switch(command.charAt(0)){
				case 'a' :
					System.out.println("Add customer,please input customer name,process time and queue number,seperate by ' '");
					String customerInfo = getStringFromInput();
					String[] infos = customerInfo.split(" ");
					int processTime = Integer.parseInt(infos[1]);
					int queueNo =  Integer.parseInt(infos[2]);
					Customer cus = new Customer(infos[0],processTime);
					market.addCustomer(cus, queueNo);
					System.out.println("Customer "+cus.toString()+" has joined line "+queueNo);
					break;
				case 'p' :
					System.out.println("One minute passed..");
					market.passTime();
					break;
				case 'd' :
					market.display();
					break;
			}
		}
	}
}
