import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class P02_GraphReprList {
    private int nVertices;
    private List<List<Integer>> graph;
    private Map<String, Integer> vertToIdx;
    private Map<Integer, String> idxToVert;
    private int c;

    public P02_GraphReprList(int nVertices) {
        this.nVertices = nVertices;
        this.graph = new ArrayList<>();
        for (int i = 0; i < this.nVertices; i++) {
            this.graph.add(new ArrayList<Integer>());
        }
        this.vertToIdx = new HashMap<>();
        this.idxToVert = new HashMap<>();
    }

    public void setVertex(String s) {
        vertToIdx.put(s, c);
        idxToVert.put(c, s);
        c++;
    }

    public void setEdge(String a, String b) {
        graph.get(vertToIdx.get(a)).add(vertToIdx.get(b));
    }

    public List<String> getVertices() {
        List<String> vertices = new ArrayList<>();
        vertices.addAll(vertToIdx.keySet());
        return vertices;
    }

    public List<List<String>> getEdges() {
        List<List<String>> edges = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (Integer j: graph.get(i)) {
                edges.add(new ArrayList<String>(Arrays.asList(idxToVert.get(i), idxToVert.get(j))));
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        P02_GraphReprList graph = new P02_GraphReprList(4);
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
