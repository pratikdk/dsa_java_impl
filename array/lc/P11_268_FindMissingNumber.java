public class P11_268_FindMissingNumber {
    private static int find(int[] prob) {
        int n = prob.length;
        int sum = 0;
        for (int p: prob) {
            sum += p;
        }
        int gaussSum = (n*(n+1))/2;
        return gaussSum-sum;
    }
    // Use gauss's formula
    public static void main(String[] args) {
        int[][] probs = {
            {3,0,1},
            {9,6,4,2,3,5,7,0,1},
            {0,1},
            {0}
        };

        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
