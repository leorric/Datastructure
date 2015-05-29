package Chap08.tree.practice.postfix;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Chap08.tree.practice.letterTree.*;
public class PostfixParser {
	
	
	private StackX stack = new StackX(50);
	
	public LetterTree parsePostFix2Tree(String exp) {
		char c = '0';
		String s = "";
		for(int i=0;i<exp.length();i++) {
			c = exp.charAt(i);
			s = String.valueOf(c);
			if(isOperator(s)){
				LetterTree lt1 = stack.pop();
				LetterTree lt2 = stack.pop();
				LetterTree lt = new LetterTree();
				Node node = new Node(s);
				lt.root = node;
				lt.root.leftChild = lt2.root;
				lt.root.rightChild = lt1.root;
				stack.push(lt);
			} else {
				LetterTree lt = new LetterTree();
				Node node = new Node(s);
				lt.root = node;
				stack.push(lt);
			}
		}
		return stack.pop();
	}
	
	private boolean isOperator(String s){
		if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
			return true;
		}
		return false;
	}
	
	private static String getStringFromInput() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String input = getStringFromInput();
		PostfixParser parser = new PostfixParser();
		LetterTree lt = parser.parsePostFix2Tree(input);
		lt.displayLetterTree();
		lt.traverse(1);
		lt.traverse(2);
		lt.traverse(3);
	}

}
