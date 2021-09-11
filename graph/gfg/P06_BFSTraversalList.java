import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P06_BFSTraversalList {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    public List<List<Integer>> bfsTraversal(Integer startVertex) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        List<Integer> queue = new ArrayList<>();
        queue.add(startVertex);
        visited.add(startVertex);

        Integer u;
        Integer t = 1;
        List<Integer> subList = new ArrayList<>();

        while (!queue.isEmpty()) {
            u = queue.remove(0);
            subList.add(u);
            t--;
            for (Integer v: graph.get(u)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
            if (t == 0) {
                res.add(subList);
                subList = new ArrayList<>();
                t = queue.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P06_BFSTraversalList g = new P06_BFSTraversalList();
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

        System.out.println(g.bfsTraversal(0));
    }
}