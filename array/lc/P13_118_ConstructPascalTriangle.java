import java.util.ArrayList;
import java.util.List;

public class P13_118_ConstructPascalTriangle {

    private static List<List<Integer>> construct(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> rowZero = new ArrayList<>();
        rowZero.add(1);
        triangle.add(rowZero);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                int value = 0;
                if (j > 0) {
                    value += triangle.get(i-1).get(j-1);
                }
                if (j < i) {
                    value += triangle.get(i-1).get(j);
                }
                row.add(value);
            }
            triangle.add(row);
        }

        return triangle;
    }
    public static void main(String[] args) {
        int[] probs = {8};
        // for (List<Integer> row: construct(probs[0]) {
        //     System.out.println(row);
        // }
        System.out.println(construct(probs[0]));
    }
}
