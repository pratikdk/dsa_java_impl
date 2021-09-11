import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P08_DFSTraversalList {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    private void dfs(Integer u, Set<Integer> visited, List<Integer> output) {
        // mark vertex u as visited
        visited.add(u);
        // Pre print
        //System.out.println(u);
        // go deep, iterate and recurse
        for (Integer v: graph.get(u)) {
            if (!visited.contains(v)) {
                dfs(v, visited, output);
            }
        }
        // Post print
        // System.out.println(u);
        output.add(u);

    }

    public void dfsTraversal(Integer startVertex) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        dfs(startVertex, visited, output);
        System.out.println(output);
    }
    
    public static void main(String[] args) {
        P08_DFSTraversalList g = new P08_DFSTraversalList();
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

        g.dfsTraversal(0);
    }
}
