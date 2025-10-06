import java.util.Scanner;

class Matrix{
    public static void main(String[] arr){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size for the square matrix");
        int n = scanner.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];

        // input matrix for A
        System.out.println("Enter elements for the first matrix");
        for(int i =  0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        // input matrix for B
        System.out.println("Enter elements for the secent matrix");
        for(int i =  0; i < n; i++){
            for (int j = 0; j < n; j++){
                b[i][j] = scanner.nextInt();
            }
        }
        // This is not needed but makes decoding more easyer
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

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
                    C[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        // Print the resulting matrix
        System.out.println("Resultant Matrix (A * B):");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println(); // move to the next row
        }

    }
}