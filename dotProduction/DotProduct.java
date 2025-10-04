class DotProduct{
    // (2 * 1) + (3 * 5) + (2 * 2)
    // [2 3 2] * [1 5 2]    same thing should be implemnt
    int[] a;
    int[] b;

    public DotProduct(){}

    public DotProduct(int[] a, int[] b){
        this.a = a; this.b = b;
    }

    // getting the total sum
    public int totalSum(int[] a, int[] b){
        int sum = 0;

        for (int i = 0; i < a.length; i++){
            sum += (a[i] * b[i]);
        }
        return(sum);
    }

    // sets new list
    // made it where they have the same length
    public void setArrays(int[] newA, int[] newB){
        if (newA.length != newB.length){
            throw new IllegalArgumentException("Arrays must have the same lenght");
        }
        this.a = newA; this.b = newB;
    }
}

