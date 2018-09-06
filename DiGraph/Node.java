package DiGraph_A5;


import java.util.HashMap;
import java.util.HashSet;

public class Node {

	int in_num;
	int out_num;
	HashSet<String> inEdges;
	HashSet<String> outEdges;
	long idNum;
	String label;

	public Node(long idNum, String label) {
		inEdges = new HashSet<String>();
		outEdges = new HashSet<String>();
		this.idNum = idNum;
		this.label = label;
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

