package Chap08.tree.practice.huffman;

import java.io.*;
import java.util.*;               // for Stack class

class BinaryTree
   {
   Node2 root;             // first Node2 of BinaryTree

// -------------------------------------------------------------
   public BinaryTree()                  // constructor
      { root = null; }            // no Node2s in BinaryTree yet
// -------------------------------------------------------------
   public Node2 find(int key)      // find Node2 with given key
      {                           // (assumes non-empty BinaryTree)
      Node2 current = root;               // start at root
      while(current.frequence != key)        // while no match,
         {
         if(key < current.frequence)         // go left?
            current = current.leftChild;
         else                            // or go right?
            current = current.rightChild;
         if(current == null)             // if no child,
            return null;                 // didn't find it
         }
      return current;                    // found it
      }  // end find()
// -------------------------------------------------------------
   public void insert(int id, String dd)
      {
      Node2 newNode2 = new Node2();    // make new Node2
      newNode2.frequence = id;           // insert data
      newNode2.desc = dd;
      if(root==null)                // no Node2 in root
         root = newNode2;
      else                          // root occupied
         {
         Node2 current = root;       // start at root
         Node2 parent;
         while(true)                // (exits internally)
            {
            parent = current;
            if(id < current.frequence)  // go left?
               {
               current = current.leftChild;
               if(current == null)  // if end of the line,
                  {                 // insert on left
                  parent.leftChild = newNode2;
                  return;
                  }
               }  // end if go left
            else                    // or go right?
               {
               current = current.rightChild;
               if(current == null)  // if end of the line
                  {                 // insert on right
                  parent.rightChild = newNode2;
                  return;
                  }
               }  // end else go right
            }  // end while
         }  // end else not root
      }  // end insert()
   
   
   public void insert(Node2 newNode)
   {
 
   if(root==null)                // no Node2 in root
      root = newNode;
   else                          // root occupied
      {
      Node2 current = root;       // start at root
      Node2 parent;
      while(true)                // (exits internally)
         {
         parent = current;
         if(newNode.frequence < current.frequence)  // go left?
            {
            current = current.leftChild;
            if(current == null)  // if end of the line,
               {                 // insert on left
               parent.leftChild = newNode;
               return;
               }
            }  // end if go left
         else                    // or go right?
            {
            current = current.rightChild;
            if(current == null)  // if end of the line
               {                 // insert on right
               parent.rightChild = newNode;
               return;
               }
            }  // end else go right
         }  // end while
      }  // end else not root
   }  // end insert()
   
   
// -------------------------------------------------------------
   public boolean delete(int key) // delete Node2 with given key
      {                           // (assumes non-empty list)
      Node2 current = root;
      Node2 parent = root;
      boolean isLeftChild = true;

      while(current.frequence != key)        // search for Node2
         {
         parent = current;
         if(key < current.frequence)         // go left?
            {
            isLeftChild = true;
            current = current.leftChild;
            }
         else                            // or go right?
            {
            isLeftChild = false;
            current = current.rightChild;
            }
         if(current == null)             // end of the line,
            return false;                // didn't find it
         }  // end while
      // found Node2 to delete

      // if no children, simply delete it
      if(current.leftChild==null &&
                                   current.rightChild==null)
         {
         if(current == root)             // if root,
            root = null;                 // BinaryTree is empty
         else if(isLeftChild)
            parent.leftChild = null;     // disconnect
         else                            // from parent
            parent.rightChild = null;
         }

      // if no right child, replace with left subBinaryTree
      else if(current.rightChild==null)
         if(current == root)
            root = current.leftChild;
         else if(isLeftChild)
            parent.leftChild = current.leftChild;
         else
            parent.rightChild = current.leftChild;

      // if no left child, replace with right subBinaryTree
      else if(current.leftChild==null)
         if(current == root)
            root = current.rightChild;
         else if(isLeftChild)
            parent.leftChild = current.rightChild;
         else
            parent.rightChild = current.rightChild;

      else  // two children, so replace with inorder successor
         {
         // get successor of Node2 to delete (current)
         Node2 successor = getSuccessor(current);

         // connect parent of current to successor instead
         if(current == root)
            root = successor;
         else if(isLeftChild)
            parent.leftChild = successor;
         else
            parent.rightChild = successor;

         // connect successor to current's left child
         successor.leftChild = current.leftChild;
         }  // end else two children
      // (successor cannot have a left child)
      return true;                                // success
      }  // end delete()
// -------------------------------------------------------------
   // returns Node2 with next-highest value after delNode2
   // goes to right child, then right child's left descendents
   private Node2 getSuccessor(Node2 delNode2)
      {
      Node2 successorParent = delNode2;
      Node2 successor = delNode2;
      Node2 current = delNode2.rightChild;   // go to right child
      while(current != null)               // until no more
         {                                 // left children,
         successorParent = successor;
         successor = current;
         current = current.leftChild;      // go to left child
         }
                                           // if successor not
      if(successor != delNode2.rightChild)  // right child,
         {                                 // make connections
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode2.rightChild;
         }
      return successor;
      }
// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node2 localRoot)
      {
      if(localRoot != null)
         {
         System.out.print(localRoot.toString() + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   public void inOrder(Node2 localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.desc + " ");
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node2 localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.frequence + " ");
         }
      }
// -------------------------------------------------------------
   public void displayBinaryTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node2 temp = (Node2)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.frequence);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayBinaryTree()
// -------------------------------------------------------------
   }  // end class BinaryTree
////////////////////////////////////////////////////////////////
