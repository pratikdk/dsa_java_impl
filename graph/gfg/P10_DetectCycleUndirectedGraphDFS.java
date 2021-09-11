import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class P10_DetectCycleUndirectedGraphDFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private boolean isCyclic(Integer u, Set<Integer> visited, Integer parent) {
        visited.add(u);
        for (Integer v: graph.get(u)) {
            if (!visited.contains(v)) {
                if (isCyclic(v, visited, u)) {
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCycle() {
        Set<Integer> visited = new HashSet<>();
        for (Integer u: graph.keySet()) {
            if (!visited.contains(u)) {
                if (isCyclic(u, visited, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P10_DetectCycleUndirectedGraphDFS g = new P10_DetectCycleUndirectedGraphDFS();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);
        System.out.println(g.detectCycle());
    }
}
