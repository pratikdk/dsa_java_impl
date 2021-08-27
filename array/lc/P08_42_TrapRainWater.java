public class P08_42_TrapRainWater {

    private static int find(int[] prob) {
        int res = 0;

        int left = 0;
        int right = prob.length-1;

        int leftmax = 0, rightmax = 0;

        while (left < right) {
            if (prob[left] <= prob[right]) {
                leftmax = Math.max(leftmax, prob[left]);
                res += leftmax-prob[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, prob[right]);
                res += rightmax-prob[right];
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {4, 0, 3, 1, 2},
            {4,2,0,3,2,5},
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {5, 4, 1, 2},
            {4,9,4,5,3,2},
            {4, 3, 1, 2}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
