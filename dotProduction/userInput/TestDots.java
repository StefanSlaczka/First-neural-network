import java.util.Scanner;

class TestDots{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("how many elemnts is in the lists");
        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        // Geting array a from user
        System.out.println("input the the numbers in A");
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        // Geting array b from user
        System.out.println("input the the numbers in B ");
        for (int i = 0; i < n; i++){
            b[i] = scanner.nextInt();
        }

        DotProduct dp = new DotProduct();
        dp.setArrays(a, b);

        // compute the dot product
        System.err.println("Dot product = " + dp.totalSum());
    }
}