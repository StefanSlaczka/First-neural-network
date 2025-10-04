class dotProduct{
    // (2 * 1) + (3 * 5) + (2 * 2)
    // [2 3 2] * [1 5 2]    same thing should be implemnt
    int[] a;
    int[] b;

    public dotProduct(){}

    public dotProduct(int[] a, int[] b){
        this.a = a; this.b = b;
    }

    public static int totalSum(int[] a, int[] b){
        int sum = 0;

        for (int i = 0; i <= a.length(); i++){
            sum += (a[i] * b[i]);
        }
        return(sum);
    }

    public void setAList(int[] newA){
        a = newA;
    }
    public void setBList(int[] newB){
        b = newB;
    }
    
}

