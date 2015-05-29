package Chap13.practice.topo;

public class TestGraphL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDepthfirstSearch();
	}
	
	public static void testTopo1() {
		GraphL g = new GraphL();
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
		g.addEdge(2, 5);
		g.topo();
		
	}
	
	public static void testTopo2() {
		GraphL g = new GraphL();
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
		g.topo();
		
	}
	
	public static void testDepthfirstSearch() {
		GraphL g = new GraphL();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.depthfirstSearch();
		
	}
}
