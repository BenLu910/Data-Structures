package A6_Dijkstra;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      /*
      d.addNode(1,"f");
      d. addNode(3, "s");
      d.delNode("f");

      d.addNode(1,"f");
      d.addNode(3, "s");
      d.delNode("x");


      d.delNode("f");
      d.addNode(1,"f");
      d.delNode("f");
      d.addNode(3,"f");
      d.delNode("f");
      */
      
      
      
      
      
      
//      d.addNode(0, "a");
//      d.addNode(1, "b");
//      d.addNode(2, "c");
//      d.addNode(3, "d");
//      d.addEdge(0, "a", "b", 1, null);
//      d.addEdge(1, "b", "c", 2, null);
//      d.addEdge(2, "c", "a", 3, null);
//      d.addEdge(3, "c", "d", 2, null);
//      d.addEdge(4, "d", "b", 1, null);
//      d.shortestPath("a");
      
      
      
      d.addNode(0, "0");
      d.addNode(1, "0");
      d.addNode(2, "2");
      d.addNode(3, "3");
      d.addNode(4, "4");
      d.addNode(5, "5");
      d.addNode(6, "6");
      d.addEdge(0, "4", "5", 2, null);
      d.addEdge(1, "0", "5", 3, null);
      d.addEdge(2, "3", "2", 6, null);
      d.addEdge(3, "6", "1", 4, null);
      d.addEdge(4, "4", "0", 1, null);
      for (ShortestPathInfo a: d.shortestPath("0")) {
			System.out.println(a.toString());
		}
      
      
      
      
      //d.topoSort();
      //d.addNode(1, "f");
//      System.out.print(d.addNode(2,"z"));
      
//      d.addNode(3, "s");
//      d.addNode(7, "t");
//      d.addNode(0, "fo");
//      d.addNode(4, "fi");
//      d.addNode(6, "si");
//      d.addEdge(0, "f", "s", 0, null);
//      d.addEdge(1, "f", "si", 0, null);
//      d.addEdge(2, "s", "t", 0, null);
//      d.addEdge(3, "fo", "fi", 0, null);
//      d.addEdge(4, "fi", "si", 0, null);
//      System.out.println("numEdges: "+d.numEdges());
//      System.out.println("numNodes: "+d.numNodes());
  //    printTOPO(d.topoSort());
      
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}
