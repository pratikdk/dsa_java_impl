public class P05_121_BuySellStockMaxProfit {

    private static int find(int[] prob) {
        if (prob == null || prob.length == 0) {return 0;}
        int maxProfit = 0;

        int low = 0;
        for (int i = 1; i < prob.length; i++) {
            if (prob[i] <= prob[low]) {
                low = i;
            } else {
                maxProfit = Math.max(maxProfit, prob[i]-prob[low]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {7,2,6,1,9,1,8},
            {7,2,1,6,7,1,9,8},
            {1, 7, 1, 8, 2},
            {7,1,5,3,6,4},
            {7,6,4,3,1},
            {2, 3, 1, 4, 7},
            {1, 2, 2, 2, 11},
            {2, 3, 3, 11, 1}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
