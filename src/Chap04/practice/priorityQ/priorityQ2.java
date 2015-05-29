package Chap04.practice.priorityQ;

public class priorityQ2 {
	
	  private int maxSize;
	  private long[] queArray;
	  private int nItems;
	  
	  public priorityQ2(int size){
		  this.maxSize = size;
		  queArray = new long[maxSize];
	  }
	  
	  public boolean isEmpty(){
		  return nItems == 0;
	  }
	  
	  public boolean isFull(){
		  return nItems == maxSize;
	  }
	  
	  public void insert(long item) throws Exception{
		  if(isFull()){
			  throw new Exception("queue is full");
		  }
		  queArray[nItems++] = item;	  
	  }
	  
	  //O(n)
	  public long peekMin() throws Exception{
		  if(isEmpty()){
			  throw new Exception("queue is empty");
		  }
		  int min = 0;
		  for(int i=1; i<nItems ;i++){
			  if(queArray[i] < queArray[min]){
				  min = i;
			  }
		  }
		  return queArray[min];
	  }
	  
	  //O(n)
	  public long remove() throws Exception{
		  if(isEmpty()){
			  throw new Exception("queue is empty");
		  }
		  int min = 0;
		  for(int i=1; i<nItems ;i++){
			  if(queArray[i] < queArray[min]){
				  min = i;
			  }
		  }
		  long value = queArray[min];
		  for(int j=min+1; j < nItems;j++){
			  queArray[j-1] = queArray[j];
		  }
		  nItems--;
		  return value;
	  }
	  
	  public void display(){
		  for(int i=0 ; i<nItems ; i++){
			  System.out.print(queArray[i]+" ");
		  }
	  }
	  
	  public static void main(String[] args) throws Exception{
		  priorityQ2 queue = new priorityQ2(5);
		  queue.insert(2);
		  queue.insert(1);
		  queue.insert(3);
		  long n = queue.peekMin();
		  System.out.println(n);
		  queue.remove();
		  queue.insert(8);
		  queue.insert(4);
		  System.out.println(queue.remove());
		  queue.display();
	  }
}
