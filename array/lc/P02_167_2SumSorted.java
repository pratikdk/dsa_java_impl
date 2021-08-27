import java.util.ArrayList;
import java.util.List;

public class P02_167_2SumSorted {
    public static List<List<Integer>> find(int[] prob, int v) {
        List<List<Integer>> result = new ArrayList<>();

        int sum;
        int r;
        for (int l = 0; l < prob.length; l++) {
            r = prob.length-1;
            while (l < r) {
                sum = prob[l]+prob[r];
                if (sum == v) {
                    List<Integer> combo = new ArrayList<>();
                    combo.add(prob[l]);
                    combo.add(prob[r]);
                    result.add(combo);
                }
                r--;
                while (prob[r] == prob[r+1] && l < r) {
                    r--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {0, 2, 2, 3, 6, 4, 8},
            {2, 7, 11, 15},
            {3, 2, 4}
        };

        for (int[] prob: probs) {   
            System.out.println(find(prob, 6));
        }
    }
}
// 2 3 6 4 8