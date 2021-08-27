import java.util.HashMap;
import java.util.Map;

public class P20_128_LongestConsecutiveSequence {

    private static int find(int[] prob) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: prob) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n-1, 0);
                int right = map.getOrDefault(n+1, 0);
                int len = left + right + 1;
                map.put(n, len);
                res = Math.max(res, len);
                map.put(n-left, len);
                map.put(n+right, len);
            } else {
                continue;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {100,4,200,1,3,2},
            {0,3,7,2,5,8,4,6,0,1}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
