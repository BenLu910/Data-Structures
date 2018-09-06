package DiGraph_A5;

public class Edge {

	String sLabel;
	String dLabel;
	String eLabel;
	long weight;
	long idNum;

	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel){
		this.dLabel = dLabel;	
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.eLabel = eLabel;
		
		if(weight < 0){
			weight = 1;
		}else{
			this.weight= weight;
		}
	}
}
