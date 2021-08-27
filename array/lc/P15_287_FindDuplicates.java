public class P15_287_FindDuplicates {
    private static int find(int[] prob) {
        // fast gets stuck in a cycle,
        // slow also enters the cycle and eventually they point to same position
        int slow = prob[0], fast = prob[0];
        while (true) {
            slow = prob[slow];
            fast = prob[prob[fast]];
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }

    public static void main (String[] args) {
        int[][] probs = {
            {1,3,4,2,2},
            {3,1,3,4,2},
            {1,1},
            {1,1,2},
            {1, 2, 3, 4, 5, 6, 5},
            {1,1,1,3,4,2}
        };

        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
