package Chap13.practice;

import Chap13.practice.topo.GraphL;

public class TestGraph {
	
	public static void main(String[] args) {
//		testDisplay();
//		System.out.println();
//		testBfsDisplay();
//		System.out.println();
//		testBfsDisplay2();
		test();
	}
	
	public static void testDisplay() {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		
		g.depthFirstDisplay();
	}
	
	public static void testDisplay2() {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge(0, 1);
		
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.depthFirstDisplay();
	}
	
	public static void testBfsDisplay() {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		
		g.breathFirstSearch();
	}
	
	public static void testBfsDisplay2() {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge(0, 1);
		
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.breathFirstSearch();
	}
	
	public static void test() {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.depthFirstDisplay();
	}
}
