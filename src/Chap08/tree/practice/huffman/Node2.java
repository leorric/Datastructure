package Chap08.tree.practice.huffman;

public class Node2 {
	
	int frequence;
	String desc;
	public Node2 leftChild;
	public Node2 rightChild;
	
//	public Node2(int frequence,String desc){
//		this.frequence = frequence;
//		this.desc = desc;
//	}
	
	public String toString(){
		String desc = this.desc;
		if(" ".equals(desc)) {
			desc = "SP";
		}else if("\n".equals(desc)){
			desc = "LF";
		}
		
		return desc+"["+frequence+"]";
	}
	
}
