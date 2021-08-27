public class P07_Lavenshtine_edit_distance {

    private static int getEditCount(String source, String target) {
        int[][] editMatrix = new int[source.length()+1][target.length()+1];

        int i;

        // Fill first column and row with index values;
        for (i = 0; i < editMatrix.length; i++) {
            editMatrix[i][0] = i;
        }
        for (i = 0; i < editMatrix[0].length; i++) {
            editMatrix[0][i] = i;
        }

        int insertion, deletion, replacement;

        for (i = 1; i < editMatrix.length; i++) {
            for(int j = 1; j < editMatrix[0].length; j++) {
                if (source.charAt(i-1) == target.charAt(j-1)) {
                    editMatrix[i][j] = editMatrix[i-1][j-1];
                } else {
                    insertion = editMatrix[i][j-1];
                    deletion = editMatrix[i-1][j];
                    replacement = editMatrix[i-1][j-1];
                    
                    editMatrix[i][j] =  1 + findMin(insertion, deletion, replacement);
                }
            }
        }        
        return editMatrix[source.length()][target.length()];
    }

    private static int findMin(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        } else if (y <= x && y <= z) {
            return y;
        } else {
            return z;
        }
    }
    public static void main(String [] args) {
        String[][] probs = {
            {"vanish", "tarnish"},
            {"horse", "ros"}
        };
        for (String[] prob: probs) {
            System.out.println(getEditCount(prob[0], prob[1]));
        }
    }
}