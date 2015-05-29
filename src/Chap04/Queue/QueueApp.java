// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
package Chap04.Queue;
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
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
   
   //wrong
//   public void display2(){
//	   if(nItems == 0){
//		   System.out.println("queue is empty");
//		   return;
//	   }
//	   if(front == rear){
//		   System.out.println(queArray[front]);
//		   return;
//	   }
//	   String s = ""+queArray[front]+" ";
//	   int cur = front+1;
//	   System.out.println(front);
//	   while(cur != front){
//		   if(cur == maxSize)
//			   cur = 0;
//		   //System.out.println(cur);
//		   s += queArray[cur] + " ";
//		   cur++;
//	   }
//	   //s += queArray[rear] + " ";
//	   System.out.println(s);
//   }
   
}  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();
      //theQueue.remove();
      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      
      theQueue.remove();  
//      
//      while( !theQueue.isEmpty() )    // remove and display
//         {                            //    all items
//         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
//         System.out.print(n);
//         System.out.print(" ");
//         }
//      System.out.println("");
      
 	 theQueue.display();
      }  
   
   // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
