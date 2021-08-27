public class P12_62_FindUniquePaths {
    private static int find(int m, int n) {
        // Construct matrix
        int[][] mat = new int[m][n];
        mat[0][0] = 1;
        // fill matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    mat[i][j] += mat[i-1][j];
                }
                if (j > 0) {
                    mat[i][j] += mat[i][j-1];
                }
            }
        }
        return mat[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] probs = {
            {3, 7},
            {3, 2},
            {7, 3},
            {3, 3}
        };
        for (int[] prob: probs) {
            System.out.println(find(prob[0], prob[1]));
        }
    }
}

// Start from (0,0), 
// note incoming paths for all cells

// 0 1 1
// 1 2 3
// 1 3 6
