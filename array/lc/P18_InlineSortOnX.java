import java.util.Arrays;

public class P18_InlineSortOnX {

    private static void sort(int[] prob, int x) {
        int left = 0;
        int i = 0;
        int j; // used only for internal loops
        int temp;
        while (i < prob.length) {
            if (prob[i] < x) {
                j = i;
                while (j > left) {
                    temp = prob[j-1];
                    prob[j-1] = prob[j];
                    prob[j] = temp;
                    j--;
                }
            }
            if (prob[left] < x) {
                left++;
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        int[][][] probs = {
            {{10, 4, 20, 18, 2, 1, 6, 0, 0, 2, 5, 9}, {5}},
            {{2, 8, 7, 10, 11, 28, 1, 0, 3, 4}, {4}}
        };
        for (int[][] prob: probs) {
            sort(prob[0], prob[1][0]);
            System.out.println(Arrays.toString(prob[0]));
        }
    }
}
