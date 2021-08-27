public class P22_152_FindMinimumInRotateArray {

    private static int find(int[] prob) {
        int res = prob[0];

        int left = 0;
        int right = prob.length-1;
        
        int mid;
        while (left < right) {
            mid = left + (right-left)/2;
            if (prob[mid-1] > prob[mid]) {
                res = prob[mid];
            }
            if (prob[mid] >= prob[left]) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] probs = {
            //{3,4,5,1,2},
            //{4,5,6,7,0,1,2},
            {11,13,15,17}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob));
        }
    }
}

// 2/2

// 1 1 1 
// 1 1
// 3