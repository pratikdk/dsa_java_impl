public class P10_11_ContainerMostWater {

    private static int find(int[] prob) {
        int maxArea = 0;

        int l = 0;
        int r = prob.length-1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(prob[l], prob[r])*(r-l));
            if (prob[l] <= prob[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,1},
            {1,8,6,2,5,4,8,3,7},
            {4,3,2,1,4},
            {1,2,1}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}
