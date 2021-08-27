import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P19_RemoveDuplicate {

    private static void remove(Integer[] prob) {
        int left = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        while (i < prob.length) {
            temp = prob[i];
            if (!map.containsKey(temp)) {
                // keep but shift
                prob[i] = null;
                prob[left] = temp;
                left++;
            } else {
                // remove
                prob[i] = null;
            }
            map.putIfAbsent(temp, 1);
            i++;
        }
    }

    public static void main(String[] args) {
        Integer[][] probs = {
            {0,0,1,1,1,2,2,3,3,4},
            {1,1,2},
            {1,3,2,3,2}
        };
        for (Integer[] prob: probs) {
            remove(prob);
            System.out.println(Arrays.toString(prob));
        }
    }
}
