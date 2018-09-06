package A6_Dijkstra;

public class EntryPair implements EntryPair_Interface {
    public String value;
    public long priority;
    public boolean known;
    public EntryPair(String aValue, long edgeWeight) {
    	known = false;
        value = aValue;
        priority = edgeWeight;
    }

    public String getValue() {
        return value;
    }

    public long getPriority() {
        return priority;
    }

    public void setKnown(){
    	known = true;
    }
    public boolean getKnown(){
    	return known;
    }
    
}