import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P13_PrintLevelsGraphDfs {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(Integer u) {
        graph.put(u, new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        graph.get(u).add(v);
    }

    private void dfs(Integer u, Set<Integer> visited, List<List<Integer>> levels, Integer level) {
        if (u == null) {return;}
        visited.add(u);
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(u);
        for (Integer v: graph.get(u)) {
            if (!visited.contains(v)) {
                dfs(v, visited, levels, level+1);
            }
        }
    }

    public List<List<Integer>> createLevels() {
        // result lists
        List<List<Integer>> res = new ArrayList<>();
        // Indegree
        Map<Integer, Integer> indegree = new HashMap<>();
        graph.keySet().forEach(k -> indegree.put(k, 0));
        for (List<Integer> vList: graph.values()) {
            for (Integer v: vList) {
                indegree.put(v, indegree.get(v)+1);
            }
        }
        // Set
        Set<Integer> visited = new HashSet<>();
        
        while (visited.size() != graph.size()) {
            int min = Integer.MAX_VALUE;
            Integer startVertex = null;
            for (Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
                if (!visited.contains(entry.getKey())) {
                    if (entry.getValue() < min) {
                        min = entry.getValue();
                        startVertex = entry.getKey();
                    }
                }
            }
            List<List<Integer>> levels = new ArrayList<>();
            dfs(startVertex, visited, levels, 0);
            res.addAll(levels);
        }
        return res;
    }
    
    public static void main(String[] args) {
        P13_PrintLevelsGraphDfs g = new P13_PrintLevelsGraphDfs();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(0, 4);
        g.addEdge(4, 5);
        System.out.println(g.createLevels());
    }
}
