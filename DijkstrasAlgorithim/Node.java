package A6_Dijkstra;


import java.util.HashMap;
import java.util.HashSet;

public class Node {

	int in_num;
	int out_num;
	HashMap<String, Long> outEdgeId;
	HashSet<String> inEdges;
	HashSet<String> outEdges;
	long idNum;
	String label;
	
	//a6 additions
	
	boolean known = false;
	
	
	public void setKnown(){
		known = true;
	}
	public boolean getKnown(){
		return known;
	}
	
	public Node(long idNum, String label) {
		inEdges = new HashSet<String>();
		outEdges = new HashSet<String>();
		this.idNum = idNum;
		this.label = label;
		this.outEdgeId = new HashMap<String, Long>();
		in_num = inEdges.size();
		out_num = outEdges.size();
	}
	
	public HashSet<Node> outEdgeVertexs(HashMap<String, Node> vertices) {
		HashSet<Node> outEdgeVertexs = new HashSet<Node>();
		
		for (String outEdge : outEdges) {
			Node temp = vertices.get(outEdge);
			outEdgeVertexs.add(temp);
		}
		
		return outEdgeVertexs;
	}

}

