public class P21_152_MaxProductSubarray {

    private static int find(int[] prob) {
        int maxProduct = prob[0];
        int currentProd = 1;
        for (int i=0; i < prob.length; i++) {
            currentProd *= prob[i];
            maxProduct = Math.max(maxProduct, currentProd);
            if (currentProd <= 0) {
                currentProd = 1;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {2,3,-2,4},
            {0, 2},
            {-2,0,-1},
            {3,-1,4},
            {-3, -1, -1},
            {-2,3,-4},
            {-1,-2,-9,-6},
            {2, 1, 3, 2}
        };

        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
