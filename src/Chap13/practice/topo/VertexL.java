package Chap13.practice.topo;

public class VertexL
{
	public char label;        // label (e.g. 'A')
	public boolean wasVisited;
	
	LinkList adjVertices;
	//-------------------------------------------------------------
	public VertexL(char lab)   // constructor
	   {
	   label = lab;
	   wasVisited = false;
	   adjVertices = new LinkList();
	   }
	//-------------------------------------------------------------
	
	public void addAdjVertex(int v) {
		adjVertices.insertFirst(v, -1);
	}
	
	public void delAdjVertex(int v) {
		adjVertices.delete(v);
	}
	
	public int getAdjVerticesNum() {
		return adjVertices.size();
	}
}  // end class Vertex
