package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
  // and the topo sort operation
	HashMap<String, Node> nodes;
	HashMap<Long, Edge> edges;
	HashSet<Long> vertIDs;
	
	int n_num;
	int e_num;


  public DiGraph ( ) { 
	  	nodes = new HashMap<String, Node>();
		edges = new HashMap<Long, Edge>();
		vertIDs = new HashSet<Long>();
		
		n_num = 0;
		e_num = 0;
	// default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }

@Override
public boolean addNode(long idNum, String label) {
	//Check if vertID has been used before, if not add it. If yes return false.
	//Also check if the num is less than 0
	//Also check if label is not unique
	
	if(vertIDs.contains(idNum)){
		return false;
	}else if(idNum < 0){
		return false;
	}else if(nodes.containsKey(label)){
		return false;
	}else if(label == null){
		return false;
	}
	vertIDs.add(idNum);
	//If it is successfully added return true 
	Node newNode = new Node(idNum,label);
	nodes.put(label,newNode);
	n_num++;
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	
	if(edges.containsKey(idNum) == true){
		return false;
	}else if(idNum<0){
		return false;
	}else if(nodes.containsKey(sLabel) == false){
		return false;
	}else if(nodes.containsKey(dLabel) == false){
		return false;
	}else if(nodes.get(sLabel).outEdges.contains(dLabel)){
		return false;
	}
	
	nodes.get(sLabel).outEdges.add(dLabel);
	nodes.get(sLabel).out_num++;
	nodes.get(dLabel).inEdges.add(sLabel);
	nodes.get(dLabel).in_num++;
	Edge newEdge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
	edges.put(idNum, newEdge);
	
	e_num++;
	return true;
}

@Override
public boolean delNode(String label) { //make sure you delete edges associated with node you are deleting
	if(!nodes.containsKey(label)){
		return false;
	}
	nodes.get(label).inEdges = null;
	nodes.get(label).in_num = 0;
	nodes.get(label).outEdges = null;
	nodes.get(label).out_num = 0;
	
	long id = nodes.get(label).idNum;
	vertIDs.remove(id);
	
	nodes.remove(label);
	
	n_num --;
	return true;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	if(nodes.containsKey(sLabel) == false || nodes.containsKey(dLabel) == false){
		return false;
	}
	if(nodes.get(sLabel).outEdges.contains(dLabel) == false){
		return false;
	}
	nodes.get(sLabel).outEdges.remove(dLabel);
	nodes.get(sLabel).out_num--;
	nodes.get(dLabel).outEdges.remove(sLabel);
	nodes.get(dLabel).in_num--;
	for(Long currentKey : edges.keySet()){
		if(edges.get(currentKey).sLabel == sLabel && edges.get(currentKey).dLabel == dLabel){
			edges.remove(currentKey);
			e_num -- ;
			break;
		}
	}
	return true;
}

@Override
public long numNodes() {
	return n_num;
}

@Override
public long numEdges() {
	return e_num;
}

@Override
public String[] topoSort() {
	HashMap<String, Node> nodes = this.nodes;
	Queue<Node> inNumZero = new LinkedList<Node>();

	for (Node node : nodes.values()) {
		if (node.in_num == 0) {
			inNumZero.add(node); 
		}
	}

	if (inNumZero.isEmpty()) {
		return null; 
	}

	String[] topoSort = new String[n_num];
	int i = 0;
	while (!(inNumZero.isEmpty())) {
		Node sNode = inNumZero.poll();
		topoSort[i] = sNode.label;
		i++;

		for (Node dVertex : sNode.outEdgeVertexs(nodes)) {
			dVertex.in_num--;
			if (dVertex.in_num == 0) {
				inNumZero.add(dVertex);
			}
		}
	}
	if (i != n_num) {
		return null;
	}
	return topoSort;
}





}