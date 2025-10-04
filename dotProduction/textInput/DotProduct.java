class DotProduct{
    int[] a;
    int[] b;

    public DotProduct(){}

    public DotProduct(int[] a, int[] b){
        
    }

    public int totalSum(){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i] * b[i];
        }
        return sum;
    }

    public void setArrays(int[] newA, int[] newB) {
        if (newA.length != newB.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }
        this.a = newA;
        this.b = newB;
    }
}