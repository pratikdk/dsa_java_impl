import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Integer[] nums = {1, 2, 3, 4};
        // Node n1 = LLUtil.generateLList(nums);
        // LLUtil.printLlist(n1);

        Integer N = 5;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i+1, new ArrayList<>());
        }
        System.out.println(map);
        // for (Map.Entry<String, Integer> entry: map.entrySet()) {
            
        // }
    }
}
