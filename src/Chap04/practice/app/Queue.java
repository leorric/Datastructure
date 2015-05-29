package Chap04.practice.app;

public class Queue
{
	   private int maxSize;
	   private Customer[] queArray;
	   private int front;
	   private int rear;
	   private int nItems;
	//--------------------------------------------------------------
	   public Queue(int s)          // constructor
	      {
	      maxSize = s;
	      queArray = new Customer[maxSize];
	      front = 0;
	      rear = -1;
	      nItems = 0;
	      }
	//--------------------------------------------------------------
	   public void insert(Customer j)   // put item at rear of queue
	      {
	      if(rear == maxSize-1)         // deal with wraparound
	         rear = -1;
	      queArray[++rear] = j;         // increment rear and insert
	      nItems++;                     // one more item
	      }
	//--------------------------------------------------------------
	   public Customer remove()         // take item from front of queue
	      {
		   Customer temp = queArray[front++]; // get value and incr front
	      if(front == maxSize)           // deal with wraparound
	         front = 0;
	      nItems--;                      // one less item
	      return temp;
	      }
	//--------------------------------------------------------------
	   public Customer peekFront()      // peek at front of queue
	      {
	      return queArray[front];
	      }
	//--------------------------------------------------------------
	   public boolean isEmpty()    // true if queue is empty
	      {
	      return (nItems==0);
	      }
	//--------------------------------------------------------------
	   public boolean isFull()     // true if queue is full
	      {
	      return (nItems==maxSize);
	      }
	//--------------------------------------------------------------
	   public int size()           // number of items in queue
	      {
	      return nItems;
	      }
	//--------------------------------------------------------------
	   
	   //by yjj
	   public void display(){
		   if(nItems == 0){
			   System.out.println("queue is empty");
			   return;
		   }
		   String s = "";
		   for(int i=front,j=0;j<nItems;j++,i++){
			   if(i == maxSize)
				   i = 0;
			   s += queArray[i] + " ";
		   }
		   System.out.println(s);
	   }

}  // end class Queue
