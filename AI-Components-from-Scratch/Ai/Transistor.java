import java.util.Arrays;

class Transistor{
    String[] words;
    double[][] scores;
    double[] weights;
    double bias;
    double sum;

    public Transistor(){}
    
    public Transistor(String[] words, double[][] scores, double bias){
        this.words = words;
        this.scores = scores;
        this.bias = bias;
        this.weights = new double[scores.length];

        // Initialize random weights
        for(int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() * 0.1; // Small random weights
        }

    }

    // Step 1: Compute weighted sum
    public double computeWeightedSum(){
        sum = 0; // reset before summing
        for (int i = 0; i < scores.length; i++){
            sum += scores[i][0] * weights[i];
        }
        sum += bias;
        return sum;
    }

    public double[] getFeatureScores() {
        double[] features = new double[scores.length];
        for (int i = 0; i < scores.length; i++){
            features[i] = scores[i][0] * weights[i] + scores[i][1] * weights[i];
        }
        return features;
    }

    public double[] softmax(double[] input){
        double[] expVaules = new double[input.length];
        double sum = 0.0;

        // Calcuate exponentials and sum
        for (int i = 0; i < input.length; i++){
            expVaules[i] = Math.exp(input[i]);
            sum+= expVaules[i];
        }

        // Normalizew to get probabilites
        double[] probabilities = new double[input.length];
        for (int i = 0; i < input.length; i ++){
            probabilities[i] = expVaules[i] / sum;
        }

        return probabilities;
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
            case "softmax":
                return 1.0;
            default:
                throw new IllegalArgumentException("Unknown activation type: " + type);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Transistor Info ===\n");
        sb.append("Words, scores and weights: \n");
        
        for (int i = 0; i < words.length; i++) {
            sb.append(String.format("%-10s -> %s, Weight: %4f%n",
                words[i], Arrays.toString(scores[i]), weights[i]));
        }

        sb.append("\nWeighted sum (z): ").append(String.format("%.4f", sum));
        sb.append("\nActivation outputs:\n");
        sb.append(String.format("Sigmoid: %.4f%n", activate(sum, "sigmoid")));
        sb.append(String.format("ReLU: %.4f%n", activate(sum, "ReLU")));
        sb.append(String.format("Tanh: %.4f%n", activate(sum, "Tanh")));
        sb.append(String.format("Linear: %.4f%n", activate(sum, "Linear")));

        // Softmax probailities
        double[] featureScores = getFeatureScores();
        double[] softmaxProbs = softmax(featureScores);
        sb.append("\nSoftmax Probao;otes: \n");
        for (int i = 0; i < words.length; i++){
            sb.append(String.format("%-10s -> %.4f (%.1f%%)%n",
                words[i], softmaxProbs[i], softmaxProbs[i] * 100));
        }

        return sb.toString();
    }
}