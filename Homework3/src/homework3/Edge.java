package homework3;

public class Edge {
     private final Node source;
     private final Node goal;
     private final int weight;

     public Edge(Node source, Node goal, int weight) {
            this.source = source;
            this.goal = goal;
            this.weight = weight;
     }

     public Node getGoal() {
            return goal;
     }

     public Node getSource() {
            return source;
     }
     public int getWeight() {
            return weight;
     }

     @Override
     public String toString() {
             return source + " " + goal;
     }
}
