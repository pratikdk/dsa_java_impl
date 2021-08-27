import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P03_2SumUnSorted {

    public static List<List<Integer>> find(int[] prob, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < prob.length; i++) {
            int requiredValue = target-prob[i];
            map.put(prob[i], i);

            if (map.containsKey(requiredValue)) {
                List<Integer> combo = new ArrayList<>();
                combo.add(prob[i]);
                combo.add(requiredValue);
                result.add(combo);
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
