import java.util.ArrayList;
import java.util.List;

public class P04_GraphReprNodes {
    private static class Node {
        public String value;
        public List<Node> neighbors;
        public Node (String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }
        public void addNeighbor(Node v) {
            neighbors.add(v);
        }
        public List<Node> getNeighbors() {
            return neighbors;
        }
        public String toString() {
            return value;
        }
    }     

    public static void main(String[] args) {
        // Construct Graph
        // Create graph nodes
        Node n0 = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        // Add Connections/edges between nodes
        n0.addNeighbor(n1);
        n0.addNeighbor(n2);
        n1.addNeighbor(n3);
        n1.addNeighbor(n4);
        n2.addNeighbor(n5);

        System.out.println(n0.getNeighbors());
        System.out.println(n1.getNeighbors());
        System.out.println(n2.getNeighbors());
    }
}
