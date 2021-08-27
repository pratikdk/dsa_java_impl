import java.util.Arrays;

public class P07_75_SortColors {

    private static void sort(int[] prob) {
        int red = 0, white = 0, blue = prob.length-1;
        
        int tmp;
        while (white <= blue) {
            if (prob[white] == 0) { // red
                tmp = prob[red];
                prob[red] = prob[white];
                prob[white] = tmp;
                red++;
                white++;
            } else if (prob[white] == 1) { // white
                white++;
            } else { // blue
                tmp = prob[blue];
                prob[blue] = prob[white];
                prob[white] = tmp;
                blue--;
            }
        }
        System.out.println(Arrays.toString(prob));
    }  

    public static void main(String[] args) {
        int[][] probs = {
            {2,0,2,1,1,0},
            {2,0,1},
            {0},
            {1}
        };

        for (int[] prob: probs) {
            sort(prob);
        }
    }
}
