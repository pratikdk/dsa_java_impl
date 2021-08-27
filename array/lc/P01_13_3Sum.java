import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01_13_3Sum {

    private static List<List<Integer>> find(int[] prob, int v) {
        List<List<Integer>> result = new ArrayList<>();

        int l, r;
        int sum;
        Arrays.sort(prob); 
        for (int i = 0; i < prob.length; i++) {
            if (i > 0 && prob[i] == prob[i-1]) {
                continue;
            }
            l = i+1;
            r = prob.length-1;
            while (l < r) {
                sum = prob[i]+prob[l]+prob[r];
                if (sum > v) {
                    r--;
                } else if (sum < v) {
                    l++;
                }
                else {
                    List<Integer> combo = new ArrayList<>();
                    combo.add(prob[i]);
                    combo.add(prob[l]);
                    combo.add(prob[r]);
                    result.add(combo);
                    l++;
                    // r--; // works
                    while (prob[l] == prob[l-1] && l < r) {
                        l++;
                    }
                    // while (prob[r] == prob[r+1] && l < r) {
                    //     r--;
                    // }
                }
                
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {-1,0,1,2,-1,-4},
            {2, -2, 0},
            {2, -2, 1},
            {},
            {0},
            {5,2,-2,-1, 4},
            {-1, 0, 1, 2, 3, 4}
        };

        for (int[] prob: probs) {
            System.out.println(find(prob, 0));
        }
    }
}