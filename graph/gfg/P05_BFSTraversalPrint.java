import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class P05_BFSTraversalPrint {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    public void bfsTraversal(Integer startVertex) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> queue = new ArrayList<>();
        queue.add(startVertex);
        visited.add(startVertex);

        Integer u;
        while (!queue.isEmpty()) {
            u = queue.remove(0);
            // Print
            System.out.println(u);
            for (Integer v :graph.get(u)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        P05_BFSTraversalPrint g = new P05_BFSTraversalPrint();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 5);

        g.bfsTraversal(0);
    }
}
