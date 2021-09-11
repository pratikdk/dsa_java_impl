import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class P03_GraphReprMap {
    private Map<String, List<String>> graph;

    public P03_GraphReprMap() {
        this.graph = new HashMap<>();
    }

    public void setVertex(String s) {
        this.graph.put(s, new ArrayList<String>());
    }

    public void setEdge(String a, String b) {
        this.graph.get(a).add(b);
    }

    public List<String> getVertices() {
        List<String> vertices = new ArrayList<>();
        vertices.addAll(this.graph.keySet());
        return vertices;
    }

    public List<List<String>> getEdges() {
        List<List<String>> edges = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: graph.entrySet()) {
            for (String b: entry.getValue()) {
                edges.add(new ArrayList<>(Arrays.asList(entry.getKey(), b)));
            }
        }
        return edges;
    }

    public Integer getSize() {
        return this.graph.size();
    }

    public static void main(String[] args) {
        P03_GraphReprMap graph = new P03_GraphReprMap();
        graph.setVertex("a");
        graph.setVertex("b");
        graph.setVertex("c");
        graph.setVertex("d");

        graph.setEdge("a", "b");
        graph.setEdge("a", "d");
        graph.setEdge("b", "c");

        System.out.println(graph.getVertices());
        System.out.println(graph.getEdges());
    }
}
