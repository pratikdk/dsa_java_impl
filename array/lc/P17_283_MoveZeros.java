import java.util.Arrays;

public class P17_283_MoveZeros {

    // private static void move(int[] prob) {
    //     int nonzeroIdx = 0;
    //     int zeroIdx = prob.length-1;
        
    //     int tmp;
    //     while (nonzeroIdx < zeroIdx) {
    //         if (prob[nonzeroIdx] == 0) {
    //             tmp = prob[zeroIdx];
    //             prob[zeroIdx] = prob[nonzeroIdx];
    //             prob[nonzeroIdx] = tmp;
    //             zeroIdx--;
    //         } else {
    //             nonzeroIdx++;
    //         }
    //     }
    // }

    private static void move(int[] prob) {
        int left = 0;
        int i = 0;
        int temp;
        while (i < prob.length) {
            if (prob[i] != 0) {
                temp = prob[i];
                prob[i] = prob[left];
                prob[left] = temp;
            }
            if (prob[left] != 0) {
                left++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[][] probs = {
            {0,1,0,0,0,3,12},
            {1,0,1},
            {0,1,0,3,12}
        };

        for (int[] prob: probs) {
            move(prob);
            System.out.println(Arrays.toString(prob));
        }
    }
}