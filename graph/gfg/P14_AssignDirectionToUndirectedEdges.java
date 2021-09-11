import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class P14_AssignDirectionToUndirectedEdges {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    public List<List<Integer>> getEdges() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.addAll(graph.values());
        return edges;
    }

    private List<Integer> topologicalSort() {
        Map<Integer, Integer> indegree = new HashMap<>(); 
        graph.keySet().forEach(k -> indegree.put(k, 0));
        for (List<Integer> vList: graph.values()){
            for (Integer v: vList) {
                indegree.put(v, indegree.get(v)+1);
            }
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> topOrder = new ArrayList<>();
        while (topOrder.size() < graph.size()) {
            int min = Integer.MAX_VALUE;
            Integer minVertex = null;
            for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    minVertex = entry.getKey();
                }
            }
            indegree.remove(minVertex);
            topOrder.add(minVertex);
            visited.add(minVertex);
            // delink
            for (Integer v: graph.get(minVertex)) {
                if (!visited.contains(v)) {
                    indegree.put(v, indegree.get(v)-1);
                }
            }
        } 
        return topOrder;
    }

    public void assignDirection() {
        List<Integer> topOrder = topologicalSort();
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            Integer u = entry.getKey();
            for (Integer v: entry.getValue()) {
                if (graph.get(v).contains(u)) {
                    if (topOrder.indexOf(u) < topOrder.indexOf(v)) {
                        graph.get(v).remove(u);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        P14_AssignDirectionToUndirectedEdges g = new P14_AssignDirectionToUndirectedEdges();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        System.out.println(g.getEdges());
        g.assignDirection();
        System.out.println(g.getEdges());
    }
}
