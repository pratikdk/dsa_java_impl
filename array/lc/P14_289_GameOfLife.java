import java.util.Arrays;

public class P14_289_GameOfLife {
    
    private static void oneStep(int[][] prob) {
        int[][] offsets = {
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, 1},
            {1, 1}
        };
        int r, c;
        int nRows = prob.length;
        int nCols = prob[0].length;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int liveNeighbors = 0;
                for (int[] offset: offsets) {
                    r = (i + offset[0]);
                    c = (j + offset[1]);

                    if ((r >= 0 && r < nRows) && (c >= 0 && c < nCols) && (prob[r][j] == 1)) {
                        liveNeighbors += 1;
                    }
                }

                if (prob[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        prob[i][j] = -1;
                    }
                } 
                if (prob[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        prob[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < prob.length; i++) {
            for (int j = 0; j < prob[0].length; j++) {
                if (prob[i][j] > 0) {
                    prob[i][j] = 1;
                } else {
                    prob[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] prob = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        oneStep(prob);
        for (int[] row: prob) {
            System.out.println(Arrays.toString(row));
        }
    }
}

// ## Rules:
// # - Any live cell with fewer than two live neighbors dies, as if caused by under-population.
// # - Any live cell with two or three live neighbors lives on to the next generation.
// # - Any live cell with more than three live neighbors dies, as if by over-population..
// # - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

// # [
// #   [0,0,0],
// #   [1,0,1],
// #   [0,1,1],
// #   [0,1,0]
// # ]