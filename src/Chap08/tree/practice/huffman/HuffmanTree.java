package Chap08.tree.practice.huffman;

public class HuffmanTree {
	
	String text = "SUSIE SAYS IT IS EASY\n";
	
	PriorityQ queue = new PriorityQ(9);
	
	BinaryTree huffmanTree = null;
	
	//code for A,B,C,D ... Z sp lf
	String[] huffmanTable = new String[28];
	
	public void init() {
		BinaryTree a = new BinaryTree();
		a.insert(2,"A");
		BinaryTree e = new BinaryTree();
		e.insert(2,"E");
		BinaryTree i = new BinaryTree();
		i.insert(3,"I");
		BinaryTree s = new BinaryTree();
		s.insert(6,"S");
		BinaryTree t = new BinaryTree();
		t.insert(1,"T");
		BinaryTree u = new BinaryTree();
		u.insert(1,"U");
		BinaryTree y = new BinaryTree();
		y.insert(2,"Y");
		BinaryTree sp = new BinaryTree();
		sp.insert(4," ");
		BinaryTree lf = new BinaryTree();
		lf.insert(1,"\n");
		
		queue.insert(t);
		queue.insert(u);
		queue.insert(lf);
		queue.insert(a);
		queue.insert(e);
		queue.insert(y);
		queue.insert(i);
		queue.insert(sp);
		queue.insert(s);
		huffmanTree = buildHuffmanTree();
		buildHuffmanTable();
	}
	
	private int getIndex(char c){
		if(c == ' '){
			return 26;
		}
		if(c == '\n') {
			return 27;
		}
		int n = c - 'A';
		return n;
	}
	
	private String getCode(char c){
		int i = getIndex(c);
		return huffmanTable[i];
	}
	
	//is correct
	private BinaryTree buildHuffmanTree() {
		int freq = 0;
		while(queue.size() > 1){
			BinaryTree t1 = queue.remove();
			BinaryTree t2 = queue.remove();
			freq = t1.root.frequence + t2.root.frequence;
			//System.out.println("freq1:"+t1.root.toString()+",freq2:"+t2.root.toString());
			BinaryTree t0 = new BinaryTree();
			t0.insert(freq, "");
//			t0.insert(t1.root);
//			t0.insert(t2.root);
			t0.root.leftChild = t1.root;
			t0.root.rightChild = t2.root;
			queue.insert(t0);
			
			queue.traverse();
			System.out.println("=====");
		}
		return queue.remove();
	}
	
	private void buildHuffmanTable() {
		findPath(huffmanTree.root,"",0);
	}
	

	private void findPath(Node2 node,String path,int level) {
		if(node == null){
			return;
		}
		//test
		for(int i=0;i<level;i++)
			System.out.print(" ");
		//
		System.out.println(node.toString()+","+path+",level:"+level);
		if(!node.desc.equals("")){
			char c = node.desc.charAt(0);
			int i = getIndex(c);
			huffmanTable[i] = path;
		}
		findPath(node.leftChild,path+"0",++level);
		findPath(node.rightChild,path+"1",level);
	}	
	
	public String codeText(){
		char c = '0';
		String codedText = "";
		for(int i=0 ; i<text.length() ; i++){
			c = text.charAt(i);
			// find in table
			codedText += getCode(c);
		}
		return codedText;
	}
	
	public String decodeText(String codedText) {
		char c = '0';
		String text = "";
		Node2 current = huffmanTree.root;
		for(int i=0; i<codedText.length();i++){
			c = codedText.charAt(i);
			if(c - '0' == 0){
				current = current.leftChild;
			}else {
				current = current.rightChild;
			}
			if(current == null){
				System.out.println("current is null");
				return "";
			}
			if(!current.desc.equals("")) {
				text += current.desc;
				current = huffmanTree.root;
			}
		}
		return text;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanTree htree = new HuffmanTree();
		htree.init();
//		htree.huffmanTree.inOrder(htree.huffmanTree.root);
//		
//		System.out.println("----");
//		for(int i=0 ; i<htree.huffmanTable.length ; i++) {
//			System.out.print(htree.huffmanTable[i]+" ");
//		}
		String encodedMsg = htree.codeText();
		System.out.println("msg:"+encodedMsg);
		String originalMsg = htree.decodeText(encodedMsg);
		System.out.println("msg:"+originalMsg);
	}

}
