import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class P09_DetectCycleDirectedGraphDFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    private boolean isCyclic(Integer u, Set<Integer> visited, Set<Integer> traceback) {
        // mark u as visited
        visited.add(u);
        traceback.add(u);
        // iterate over adjacents
        for (Integer v: graph.get(u)) {
            if (!visited.contains(v)) {
                if (isCyclic(v, visited, traceback)) {
                    return true;
                }
            } else if (traceback.contains(v)) {
                return true;
            }
        }
        traceback.remove(u);
        return false;
    }

    public boolean detectCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> traceback = new HashSet<>();
        for (Integer u: graph.keySet()) {
            if (!visited.contains(u)) {
                if (isCyclic(u, visited, traceback)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P09_DetectCycleDirectedGraphDFS g = new P09_DetectCycleDirectedGraphDFS();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println(g.detectCycle());
    }

}
