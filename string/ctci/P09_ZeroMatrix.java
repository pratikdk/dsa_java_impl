public class P09_ZeroMatrix {

    private static void setZeros(int[][] matrix) {
        int[] rowZeroflag = new int[matrix.length];
        int[] colZeroFlag = new int[matrix[0].length];
        // default intialization to zero arrays

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZeroflag[i] = 1;
                    colZeroFlag[j] = 1;
                }
            }
        }

        // nullify rows
        for (int i = 0; i < rowZeroflag.length; i++) {
            if (rowZeroflag[i] == 1) {
                nullifyRow(matrix, i);
            }
        }

        // nullify columns
        for (int i = 0; i < colZeroFlag.length; i++) {
            if (colZeroFlag[i] == 1) {
                nullifyCol(matrix, i);
            }
        }
    }


    private static void nullifyRow(int[][] matrix, int rowIndex) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[rowIndex][i] = 0;
        }
    }

    private static void nullifyCol(int[][] matrix, int colIndex) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][colIndex] = 0;
        }
    }


    private static void printMatrix(int[][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\n\n");
        }
    }

    public static void main(String[] args) {
        int nRows = 5;
        int nCols = 7;
        int[][] matrix = new int[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                matrix[i][j] = (nCols*i)+(j+1);
            }
        }

        printMatrix(matrix);

        int[][] zeroPositions = {
            {0, 0}, {2, 2}, {4, 4}
        };
        for (int[] position: zeroPositions) {
            matrix[position[0]][position[1]] = 0;
        }

        setZeros(matrix);

        System.out.println();

        printMatrix(matrix);
    }
}
