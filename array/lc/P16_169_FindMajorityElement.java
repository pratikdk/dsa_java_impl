import java.util.HashMap;
import java.util.Map;

public class P16_169_FindMajorityElement {

    private static int find(int[] prob) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = prob[0];
        int num;
        for (int i = 0; i < prob.length; i++) {
            num = prob[i];
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
            if (map.get(num) > map.get(res)) {
                res = num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {2,2,1,1,1,2,2},
            {3,4,3,4}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
