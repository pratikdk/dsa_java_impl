public class P04_122_BuySellStockAllProfits {

    private static int find(int[] prob) {
        if (prob == null || prob.length == 0) {return 0;}
        int totalProfit = 0;

        int low = 0;
        int i;
        for (i = 1; i < prob.length; i++) {
            if (prob[i] < prob[i-1]) {
                totalProfit += prob[i-1] - prob[low];
                low = i;
            }
        }
        totalProfit += prob[i-1] - prob[low];

        return totalProfit;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {7,1,5,3,6,4},
            {1,2,3,4,5},
            {7,6,4,3,1},
            {7,1,5,0,3,6,2,8},
            {2, 4, 1},
            {5},
            {7,2,6,1,9,1,8},
            {}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
