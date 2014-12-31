package Chap08.tree.practice.letterTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TreeBuilder {
	
	private LetterTree[] arr = new LetterTree[50];
	private int nItems = 0;
	
	private static String getStringFromInput() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}
	
	public LetterTree build() {
		LetterTree lt1 = null;
		LetterTree lt2 = null;
		int i = 1;
		while(nItems > 1){
			lt1 = arr[0]; 
			lt2 = arr[i];
			arr[i] = null;
			i++;
			nItems--;
			
			LetterTree lt = new LetterTree();
			lt.root  = new Node("+");
			lt.root.leftChild = lt1.root;
			lt.root.rightChild = lt2.root;
			arr[0] = lt; //store the latest combined tree
			
		}
		return arr[0];
	}
	
	public LetterTree buildBlancedTree() {
		LetterTree lt1 = null;
		LetterTree lt2 = null;
		int i = 0;
		int last = nItems - 1;
		while(nItems > 1){
			System.out.println("remove "+i+" and "+ (i+1));
			lt1 = arr[i]; 
			lt2 = arr[i+1];
			arr[i] = null;
			arr[i+1] = null;
			i += 2;
			//build new tree
			System.out.println("add new tree to "+ (last+1));
			
			LetterTree lt = new LetterTree();
			lt.root = new Node("+");
			lt.root.leftChild = lt1.root;
			lt.root.rightChild = lt2.root;
			arr[last+1] = lt;
			last++;
			nItems--;
		}
		return arr[last];
	}
	
	public LetterTree buildOrderedFullTree() {
		LetterTree lt1 = null;
		int i = 0;
		int left = 0;
		int right = 0;
		while(true){
			lt1 = arr[i];
			left = 2*i+1;
			right = 2*i+2;
			if(left < nItems) {
				lt1.root.leftChild = arr[left].root; 
			}else {
				break;
			}
			if(right < nItems) {
				lt1.root.rightChild = arr[right].root; 
			}else {
				break;
			}
			i++;
		}
		return arr[0];
	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) throws Exception{
//		// TODO Auto-generated method stub
//		TreeBuilder builder = new TreeBuilder();
//		String input = "";
//		int i=0;
//		Node node = null;
//		while(true) {
//			input = getStringFromInput();
//			if("#".equals(input)){
//				System.out.println("input done");
//				break;
//			}
//			node = new Node(input);
//			LetterTree lt = new LetterTree();
//			lt.insert(node);
//			builder.arr[i] = lt; 
//			builder.nItems++;
//			i++;
//		}
//		LetterTree lt = builder.buildBlancedTree();
//		lt.displayLetterTree();
//	}
	
	//create full ordered tree
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		TreeBuilder builder = new TreeBuilder();
		String input = "";
		int i=0;
		Node node = null;
		char c = '0';
		int index = 0;
		
		input = getStringFromInput();
		while(i < input.length()) {
			c = input.charAt(i);
			node = new Node(String.valueOf(c));
			LetterTree lt = new LetterTree();
			lt.root = node;
			index = c - 'A';
			builder.arr[index] = lt; 
			builder.nItems++;
			i++;
		}
		
		LetterTree lt = builder.buildOrderedFullTree();
		lt.displayLetterTree();
	}

}
