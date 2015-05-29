package Chap13.practice;


public class Graph {
	
	private static final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts;
	private Stack stack;
	private Queue queue;
	
	
	 public Graph()               // constructor
     {
	     vertexList = new Vertex[MAX_VERTS];
	                                         // adjacency matrix
	     adjMat = new int[MAX_VERTS][MAX_VERTS];
	     nVerts = 0;
	     for(int j=0; j<MAX_VERTS; j++)      // set adjacency
	        for(int k=0; k<MAX_VERTS; k++)   //    matrix to 0
	           adjMat[j][k] = 0;
	     
	     stack = new Stack(20);
	     queue = new Queue(20);
     }  // end constructor
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start,int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void depthFirstDisplay() {
		vertexList[0].wasVisited = true;
		stack.push(0);
		int seq = 0;
		System.out.print(vertexList[seq].label+" ");
		while(!stack.isEmpty()) {
			seq = getNextAdjVertex(stack.peek());
			if(seq != -1) {
				stack.push(seq);
				vertexList[seq].wasVisited = true;
				System.out.print(vertexList[seq].label+" ");
			}else{
				stack.pop();
			}
		}
		
		for(int i=0;i<nVerts;i++) {
			vertexList[i].wasVisited = false;
		}
		
	}
	
	public void breathFirstSearch() {
		vertexList[0].wasVisited = true;
		queue.insert(0);
		System.out.print(vertexList[0].label+" ");
		while(!queue.isEmpty()) {
			int v = queue.remove();
			visitAdjVertices(v);
		}
		
		for(int i=0;i<nVerts;i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	private void visitAdjVertices(int v) {
		for(int i=0;i<adjMat[0].length;i++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				vertexList[i].wasVisited = true;
				queue.insert(i);
				//System.out.print(vertexList[v].label);
				System.out.print(vertexList[i].label+ " ");
			}
		}
	}
	
	public void mstWithBreathFirst() {
		vertexList[0].wasVisited = true;
		queue.insert(0);
		System.out.print(vertexList[0].label+" ");
		while(!queue.isEmpty()) {
			int v = queue.remove();
			visitAdjVertices2(v);
		}
		
		for(int i=0;i<nVerts;i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	private void visitAdjVertices2(int v) {
		for(int i=0;i<adjMat[0].length;i++) {
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				vertexList[i].wasVisited = true;
				queue.insert(i);
				System.out.print(vertexList[v].label);
				System.out.print(vertexList[i].label+ " ");
			}
		}
	}
	
	private int getNextAdjVertex(int n) {
		for(int i=0;i<adjMat[0].length;i++) {
			if(adjMat[n][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
//	private void visit(Vertex vertex) {
//		System.out.print(vertex.label);
//		vertex.wasVisited = true;
//		stack.push(vertex);
//	}
//	
//	private int getNextVertex(int seq) {
//		boolean hasUnvisitedAdj = false;
//		int i=seq+1;
//		for( ; i<nVerts ; i++) {
//			if(adjMat[seq][i] == 1) {
//				Vertex adjVertex = vertexList[i];
//				adjVertex.seq = i;
//				if(adjVertex.wasVisited == false) {
//					visit(adjVertex);
//					hasUnvisitedAdj = true;
//					break;
//				}
//			}
//		}
//		if(!hasUnvisitedAdj) {
//			stack.pop();
//			if(stack.isEmpty()) {
//				return -1;
//			}
//			Vertex previous = stack.peek();
//			return previous.seq;
//		}
//		return i;
//	}
}
