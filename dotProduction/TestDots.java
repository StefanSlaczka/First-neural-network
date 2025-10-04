class TestDots{
    public static void main(String[] args) {
        int[] a = {2, 3, 2};
        int[] b = {1, 5, 2};

        DotProduct dp = new DotProduct();
        dp.setArrays(a, b);

        System.err.println("Dot product = " + dp.totalSum(a, b));
    }
}