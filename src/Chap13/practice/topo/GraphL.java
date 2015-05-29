package Chap13.practice.topo;

import Chap13.practice.Queue;
import Chap13.practice.Stack;
import Chap13.practice.Vertex;

public class GraphL {
	
	private static final int MAX_VERTS = 20;
	static VertexL[] vertexList;
	private int nVerts;
	private char[] sortedArray;
	private Stack stack;
	
	 public GraphL()               // constructor
     {
	     vertexList = new VertexL[MAX_VERTS];
	     nVerts = 0;
	     sortedArray = new char[MAX_VERTS];
	     stack = new Stack(20);
     }  // end constructor
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new VertexL(lab);
	}
	
	public void addEdge(int start,int end) {
		vertexList[start].addAdjVertex(end);
	}
	
	public void topo() {
		int n = nVerts;
		while(n > 0) {
			int v = noSuccessors();
			sortedArray[n-1] = vertexList[v].label;
			//remove
			for(int i=0;i<n;i++) {
				if(vertexList[i] != null)
					vertexList[i].adjVertices.delete(v);
			}
			vertexList[v] = null;
			//
			n--;
			//System.out.println("c:"+nVerts);
		}
		for(int i=0;i<nVerts;i++) {
			System.out.print(sortedArray[i]+ " ");
		}
	}
	
	private int noSuccessors() {
		for(int i=0;i<nVerts;i++) {
			if(vertexList[i] != null && vertexList[i].adjVertices.size()==0)
				return i;
		}
		return -1; //cycle
	}
	
	public void depthfirstSearch() {
		vertexList[0].wasVisited = true;
		stack.push(0);
		int n = 0;
		displayNode(vertexList[0]);
		while(!stack.isEmpty()) {
			n = getNextAdjVertex(stack.peek());
			if(n != -1) {
				stack.push(n);
				vertexList[n].wasVisited = true;
				displayNode(vertexList[n]);
			}else {
				stack.pop();
			}
		}
	}
	
	private int getNextAdjVertex(int v) {
		VertexL vertex = vertexList[v];
		int n = vertex.adjVertices.findUnvisitedVertex();
		return n;
	}
	
	private void displayNode(VertexL vertex) {
		System.out.print(vertex.label + " ");
	}
}
