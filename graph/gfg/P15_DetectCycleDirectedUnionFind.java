import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class P15_DetectCycleDirectedUnionFind {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    private void union(Map<Integer, Integer> mappings, Integer a, Integer b) {
        mappings.put(b, a);
    }

    private Integer find(Map<Integer, Integer> mappings, Integer k) {
        if (mappings.get(k) == null) {
            return k;
        }
        return find(mappings, mappings.get(k));
    }
    
    private boolean unionfindDfs(Integer u, Set<Integer> visited, Map<Integer, Integer> mappings, Integer parent) {
        visited.add(u);
        mappings.put(u, parent);
    }

    public boolean uFStarter() {
        Map<Integer, Integer> mappings = new HashMap<>();
        graph.keySet().forEach(k -> mappings.put(k, null));

        Map<Integer, Integer> indegree = new HashMap<>();
        graph.keySet().forEach(k -> indegree.put(k , 0));
        for (List<Integer> vList: graph.values()) {
            for (Integer v: vList) {
                indegree.put(v, indegree.get(v)+1);
            }
        }
        Set<Integer> visited = new HashSet<>();
        
        while (visited.size() != graph.size()) {
            int minIndegree = Integer.MAX_VALUE;
            Integer minVertex = null;
            for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
                if (entry.getValue() < minIndegree && (!visited.contains(entry.getKey()))) {
                    minIndegree = entry.getValue();
                    minVertex = entry.getKey();
                }
            }
            // delink
            for (Integer v: graph.get(minVertex)) {
                if (!visited.contains(v)) {
                    indegree.put(v, indegree.get(v)-1);
                }
            }
            if (unionfindDfs(minVertex, visited, mappings, null)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        P15_DetectCycleDirectedUnionFind g = new P15_DetectCycleDirectedUnionFind();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        System.out.println(g.uFStarter());
    }
}
