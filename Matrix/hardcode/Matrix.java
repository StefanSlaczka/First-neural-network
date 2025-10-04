class Matrix{
    public static void main(String[] arr){

        /* TestCases
        int[][] A = {
            {1, 2},
            {3, 4}
        };
        int[][] B = {
            {5, 6},
            {7, 8}
        };
        == 19, 22
           43, 50 
        */

        // Matrixs being made
        int[][] A = {
            {2, 3},
            {1, 4}
        };
        int[][] B = {
            {5, 6},
            {7, 8}
        };

        /*
        should output
        31, 36
        33, 38
        */

        // New Matrix
        int[][] C = multiplication(A, B);

        // Printing new matrix out
        System.out.println("Resiling matrix");
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < C.length; j++){
                System.out.println(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplication(int[][] A, int[][] B){
        // This is not needed but makes decoding more easyer
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // Makes sure the Matrixs have the sane size
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix does not match");
        }
        
        // creating a new matrix to store A * B
        int[][] C = new int[rowsA][colsB];

        // Mathmedical part
        for (int i = 0; i < rowsA; i++){
            for (int j = 0; j < colsB; j++){
                for (int k = 0; k < colsA; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
}