import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class P12_DetectCycleUndirectedGraphBFS {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public boolean isCyclicBfs() { 
        // Initialize indegree
        Map<Integer, Integer> indegree = new HashMap<>();
        graph.keySet().forEach(k -> indegree.put(k, 0));
        for (List<Integer> vList: graph.values()) {
            for (Integer v: vList) {
                indegree.put(v, indegree.get(v)+1);
            }
        }
        List<Integer> queue = new ArrayList<>();
        int visitedCount = 0;

        // find vertex with 0 indegree(incoming edges)
        for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if (entry.getValue() == 1) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            // pop 
            Integer u = queue.remove(0);
            // delink adjacents
            for (Integer v: graph.get(u)) {
                indegree.put(v, indegree.get(v)-1);
                if (indegree.get(v) == 1) {
                    queue.add(v);
                }
            }
            visitedCount++;
        }

        if (visitedCount == graph.size()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        P12_DetectCycleUndirectedGraphBFS g = new P12_DetectCycleUndirectedGraphBFS();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);
        System.out.println(g.isCyclicBfs());
    }

}
