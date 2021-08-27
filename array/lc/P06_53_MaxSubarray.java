import java.util.ArrayList;
import java.util.List;

public class P06_53_MaxSubarray {
    
    private static int find(int[] prob) {
        int maxSum = prob[0];

        int currentSum = 0;

        for (int i = 0; i < prob.length; i++) {
            currentSum += prob[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum <= 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    private static int findBounds(int[] prob) {
        int[] idx = {0, 0};
        int maxSum = prob[0];
        int currentSum = 0;

        boolean bufferReset = false;

        for (int i = 0; i < prob.length; i++) {
            currentSum += prob[i];
            if (maxSum < currentSum) {
                if (bufferReset) {
                    idx[0] = i;
                    idx[1] = i;
                } else {
                    idx[1] = i;
                }
            }
            bufferReset = false;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum <= 0) {
                currentSum = 0;
                bufferReset = true;
            }
        }
        //Print
        List<Integer> subSlice = new ArrayList<>();
        for (int i = idx[0]; i < idx[1]+1; i++) {
            subSlice.add(prob[i]);
        }
        System.out.println(subSlice);
        //System.out.println("\n" + idx[0] + " " + idx[1]);
        return maxSum;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {4,-1,2,1},
            {-2,1,-3,4,-1,2,1,-5,4},
            {-1},
            {5,-5,-1,7,8},
            {-2,-1},
            {2, 5}
        };

        
        for (int[] prob: probs) {
            //System.out.println(find(prob));
            System.out.println(findBounds(prob));
        }
    }
}
