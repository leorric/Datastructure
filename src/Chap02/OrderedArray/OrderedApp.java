// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
package Chap02.OrderedArray;
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey) {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true){
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
      }  // end while
   }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j;
      for(j=0; j<nElems; j++)        // find where it goes
         if(a[j] > value)            // (linear search)
            break;
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   
   //using binary search for position to insert
   public void insert2(long value)    // put element into array
   {
   int k;
   int n = find(value);
   for(k=nElems-1; k>n; k--)    // move bigger ones up
      a[k] = a[k-1];
   a[k] = value;                  // insert it
   nElems++;                      // increment size
   }  // end insert()
   
   public void merge(int[] a,int[] b){
	   int len1 = a.length;
	   int len2 = b.length;
	   int i=0;
	   int j=0;
	   while(true){
		   if(a[i] > b[j]){
			   insert(b[j]);
			   j++;
		   }else{
			   insert(a[i]);
			   i++;
		   }
		   if(i == len1 ){
			  for(;j<len2;j++){
				  //System.out.println("size:"+size()+",cap:"+this.a.length);
				  insert(b[j]);
			  }
			  break;
		   }else if(j == len2){
			  for(;i<len1;i++){
				  insert(a[i]);
			  }
			  break;
		   }
	   }
	  
   }
   
   //remove duplidates
   public void noDups(){
	   int num = 0;
	   long temp = 0;
	   for(int i=1;i<nElems;i++){
		   temp = a[i];
		   for(int j=i-1;j>=0;j--){
			   if(temp == a[j]){
				   a[i] = -1;
				   num++;
			   }
		   }
	   }
	   for(int i=0;i<nElems;i++){
		   if(a[i] == -1){
			   for(int j=i;j<nElems-1;j++){
				   a[j] = a[j+1];
			   }
		   }
	   }
	   nElems -= num;
   }
   
}  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

//      arr.delete(00);                // delete 3 items
//      arr.delete(55);
//      arr.delete(99);
      arr.insert(58);
      arr.display();                 // display items again
      
      //merge
      int[] a = {1,3,5,8,10};
      int[] b = {2,4,5,13,13,50,52};
      arr = new OrdArray(a.length+b.length);
      arr.merge(a, b);
      arr.display();
      arr.noDups();
      arr.display();
      }  // end main()
   }  // end class OrderedApp
