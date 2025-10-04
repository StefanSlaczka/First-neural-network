import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TestDots {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("data.txt"));

            // Read line from array A
            String[] lineA = fileScanner.nextLine().split(" ");
            int[] a = new int[lineA.length];
            for (int i = 0; i < lineA.length; i++){
                a[i] = Integer.parseInt(lineA[i]);
            }

            // Read line from array B
            String[] lineB = fileScanner.nextLine().split(" ");
            int[] b = new int[lineA.length];
            for (int i = 0; i < lineB.length; i++){
                b[i] = Integer.parseInt(lineB[i]);
            }
            fileScanner.close();

            DotProduct dp = new DotProduct();
            dp.setArrays(a, b);

            // compute the dot product
            System.err.println("Dot product = " + dp.totalSum());
        } catch(FileNotFoundException e){
            System.err.println("File not");
        }
    }
}