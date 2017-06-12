package homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SmallGraph implements Graph {
	
	
	 static List<Node> nodess;
     static List<Edge> edgess;
     public static List<Integer> obs;
	SmallGraph(){
		//tem.add();
		nodess = new ArrayList<Node>();
        edgess = new ArrayList<Edge>();
        obs = new ArrayList<Integer>(); 
        for(int i=0;i<30;i++){
        	obs.add(i);
        }
        for(int i=0;i<30;i++){
        	obs.add(570+i);
        }
        for(int i=0;i<18;i++){
        	obs.add(30+i*30);
        }
        for(int i=0;i<18;i++){
        	obs.add(59+i*30);
        }
        for(int i=0;i<9;i++){
        	obs.add(43+i*30);
        }
        for(int i=0;i<9;i++){
        	obs.add(316+i*30);
        }
        for(int i=0;i<9;i++){
        	obs.add(271+i);
        }
        for(int i=0;i<8;i++){
        	obs.add(231+i);
        }
        for (int i = 0; i < 600; i++) {
            Node location = new Node(i, "Node_" + i,(int)Math.floor(i%30)*40,40*(int)Math.floor(i/30));
            nodess.add(location);
        }    	
        for(int i=0;i<600;i++){
    		
    		if(i>30&&!obs.contains(i-30)&&!obs.contains(i)){
    				addNewEdge(i,i-30,40);
    		}
    		if(i<570&&!obs.contains(i+30)&&!obs.contains(i)){
    				addNewEdge(i,i+30,40);
    		}
    		if(i%30>0&&!obs.contains(i-1)&&!obs.contains(i)){
    				addNewEdge(i,i-1,40);
    		}
    		if(i%30<29&&!obs.contains(i)&&!obs.contains(i+1)){
    				addNewEdge(i,i+1,40);
    		}
    	
        }
        
	}
	private static void addNewEdge(int sourceLocNo, int destLocNo,
            int cost) {
    Edge lane = new Edge(nodess.get(sourceLocNo), nodess.get(destLocNo), cost );
    edgess.add(lane);
	}
	public List<Node> getNodes() {
        return nodess;
	}
	public List<Edge> getEdges() {
        return edgess;
	}
	
}
