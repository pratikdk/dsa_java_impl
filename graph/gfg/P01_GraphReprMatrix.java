import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class P01_GraphReprMatrix {
    private int nVertices;
    private int[][] matrix;
    private Map<String, Integer> vertToIdx;
    private Map<Integer, String> idxToVert;
    private int c = 0;

    public P01_GraphReprMatrix(int nVertices) {
        this.nVertices = nVertices;
        this.matrix = new int[nVertices][nVertices];
        this.vertToIdx = new HashMap<>();
        this.idxToVert = new HashMap<>();
    }

    public void setVertex(String s) {
        vertToIdx.put(s, c);
        idxToVert.put(c, s);
        c++;
    }
    
    public void setEdge(String a, String b, int weight) {
        matrix[vertToIdx.get(a)][vertToIdx.get(b)] = weight;
    }

    public List<String> getVertices() {
        List<String> vertices = new ArrayList<>();
        vertices.addAll(vertToIdx.keySet());
        return vertices;
    }

    public List<List<String>> getEdges() {
        List<List<String>> edges = new ArrayList<>();
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
               if (matrix[i][j] != 0) {
                   edges.add(new ArrayList<String>(Arrays.asList(idxToVert.get(i), idxToVert.get(j))));
               } 
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        P01_GraphReprMatrix graph = new P01_GraphReprMatrix(4);
        graph.setVertex("a");
        graph.setVertex("b");
        graph.setVertex("c");
        graph.setVertex("d");

        graph.setEdge("a", "b", 1);
        graph.setEdge("a", "d", 1);
        graph.setEdge("b", "c", 1);

        System.out.println(graph.getVertices());
        System.out.println(graph.getEdges());

    }
}