package Chap08.tree.practice.huffman;

class PriorityQ
{
// array in sorted order, from max at 0 to min at size-1
private int maxSize;
private BinaryTree[] queArray;
private int nItems;
//-------------------------------------------------------------
public PriorityQ(int s)          // constructor
   {
   maxSize = s;
   queArray = new BinaryTree[maxSize];
   nItems = 0;
   }
//-------------------------------------------------------------
public int size(){
	return nItems;
}

public void insert(BinaryTree item)    // insert item
   {
   int j;

   if(nItems==0)                         // if no items,
      queArray[nItems++] = item;         // insert at 0
   else                                // if items,
      {
      for(j=nItems-1; j>=0; j--)         // start at end,
         {
         if( item.root.frequence > queArray[j].root.frequence )      // if new item larger,
            queArray[j+1] = queArray[j]; // shift upward
         else                          // if smaller,
            break;                     // done shifting
         }  // end for
      queArray[j+1] = item;            // insert it
      nItems++;
      }  // end else (nItems > 0)
   }  // end insert()
//-------------------------------------------------------------
public BinaryTree remove()             // remove minimum item
   { return queArray[--nItems]; }
//-------------------------------------------------------------
public BinaryTree peekMin()            // peek at minimum item
   { return queArray[nItems-1]; }
//-------------------------------------------------------------
public boolean isEmpty()         // true if queue is empty
   { return (nItems==0); }
//-------------------------------------------------------------
public boolean isFull()          // true if queue is full
   { return (nItems == maxSize); }
//-------------------------------------------------------------

public void traverse(){
	for(int i=nItems-1; i >= 0; i--){
		BinaryTree bt = queArray[i];
		bt.traverse(1);
	}
}

}  // end class PriorityQ
////////////////////////////////////////////////////////////////
