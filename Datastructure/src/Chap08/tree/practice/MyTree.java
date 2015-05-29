package Chap08.tree.practice;

public class MyTree {
	
	Node root;
	
	public MyTree(){
		root = null;
	}
	
	public Node find(int id){
		Node current = root;
		while(current != null){
			if(current.id > id){
				current = current.leftChild;
			}else if(current.id < id){
				current = current.rightChild;
			}else {
				return current;
			}
		}
		return current;
	}
	
	public void insert(int id,String desc){
		Node node = new Node(id,desc);
		Node current = root;
		Node parent = null;
		if(root == null){
			root = node;
			return;
		}
		while(true){
			parent = current;
			if(current.id > id){
				current = current.leftChild;
				if(current == null){
					parent.leftChild = node;
					break;
				}
			}else{
				current = current.rightChild;
				if(current == null){
					parent.rightChild = node;
					break;
				}
			}
		}
	}
	
	public void inorder(Node subRoot){
		if(subRoot == null){
			return;
		}
		inorder(subRoot.leftChild);
		System.out.print(subRoot.id+",");
		inorder(subRoot.rightChild);
	}
	
	public void delete(int id) {
		//find node
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		while(current.id != id) {
			parent = current;
			if(id < current.id){
				current = current.leftChild;
				isLeftChild = true;
			}else{
				current = current.rightChild;
				isLeftChild = false;
			}
			if(current == null){
				System.out.println("node not exist");
				return;
			}
		}	
		//get successor
	      // if no children, simply delete it
	      if(current.leftChild==null &&
	                                   current.rightChild==null){
	         if(current == root)             // if root,
	            root = null;                 // tree is empty
	         else if(isLeftChild)
	            parent.leftChild = null;     // disconnect
	         else                            // from parent
	            parent.rightChild = null;
	      }

	      // if no right child, replace with left subtree
	      else if(current.rightChild==null) {
	         if(current == root)
	            root = current.leftChild;
	         else if(isLeftChild)
	            parent.leftChild = current.leftChild;
	         else
	            parent.rightChild = current.leftChild;
	      }
	      // if no left child, replace with right subtree
	      else if(current.leftChild==null) {
	         if(current == root)
	            root = current.rightChild;
	         else if(isLeftChild)
	            parent.leftChild = current.rightChild;
	         else
	            parent.rightChild = current.rightChild;
	      }else {
			Node successor = getSuccessor(current);
			if(isLeftChild) {
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
	      }
	}
	
	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTree tree = new MyTree();
		tree.insert(50,"A");
		tree.insert(25,"B");
		tree.insert(15,"C");
		tree.insert(35,"D");
		tree.insert(5,"E");
		tree.insert(20,"F");
		tree.insert(30,"G");
		tree.insert(40,"H");
		//Node node = tree.find(20);
		//System.out.println(node.id+","+node.desc);
		tree.inorder(tree.root);
		System.out.println();
		tree.delete(25);
		tree.inorder(tree.root);
	}

}
