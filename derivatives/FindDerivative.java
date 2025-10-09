class FindDerivative{
    String function = "6x**2";
    String powered;
    String insual;
    char[] charArray;
    
    public FindDerivative(){}
    public FindDerivative(String function){
        if (function.contains("**") == true) {
            // powered = function[-1]
            // insual = function[0]

            charArray = function.toCharArray();
            powered = function[-1];
            insual = function[0];

            if (insual == "x"){

            }
        }
    }
    
}