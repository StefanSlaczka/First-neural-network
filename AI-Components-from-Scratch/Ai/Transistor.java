import java.util.Arrays;

class Transistor{
    String[] words;
    double[][] scores;
    double bias;
    double sum;

    public Transistor(){}
    
    public Transistor(String[] words, double[][] scores, double bias){
        this.words = words;
        this.scores = scores;
        this.bias = bias;
    }

    // Step 1: Compute weighted sum
    public double computeWeightedSum(){
        sum = 0; // reset before summing
        for (int i = 0; i < scores.length; i++){
            // We are taking the first feature as the weight
            sum += scores[i][0];
        }
        sum += bias;
        return sum;
    }

    public double activate(double z, String type){
        switch(type.toLowerCase()){
            case "sigmoid":
                return 1 / (1 + Math.exp(-z));
            case "relu":
                return Math.max(0, z);
            case "tanh":
                return Math.tanh(z);
            case "linear":
                return z;
            default:
                throw new IllegalArgumentException("Unknown activation type: " + type);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Transistor Info ===\n");
        sb.append("Words and scores: \n");
        
        for (int i = 0; i < words.length; i++) {
            sb.append(String.format("%-10s -> %s%n", words[i], Arrays.toString(scores[i])));
        }

        sb.append("\nWeighted sum (z): ").append(String.format("%.4f", sum));
        sb.append("\nActivation outputs:\n");
        sb.append(String.format("Sigmoid: %.4f%n", activate(sum, "sigmoid")));
        sb.append(String.format("ReLU: %.4f%n", activate(sum, "ReLU")));
        sb.append(String.format("Tanh: %.4f%n", activate(sum, "Tanh")));
        sb.append(String.format("Linear: %.4f%n", activate(sum, "Linear")));

        return sb.toString();
    }
}