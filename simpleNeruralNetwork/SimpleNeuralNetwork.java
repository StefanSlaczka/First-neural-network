public class SimpleNeuralNetwork {
    private double[] weights;
    private double bias;
    private double learningRate;

    public SimpleNeuralNetwork(int inputSize, double learningRate) {
        this.weights = new double[inputSize];
        this.bias = 0;
        this.learningRate = learningRate;

        // Initialize with small random weights
        for (int i = 0; i < inputSize; i++) {
            // smallest value is between -.05 and .05
            weights[i] = Math.random() * 0.1 - 0.05;
        }
    }

    // Sigmoid activation function
    private double sigmoid(double x) {  // Fixed: was "sigmiod"
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Derivative of sigmoid - FIXED THIS!
    private double sigmoidDerivative(double x) {
        return x * (1 - x);  // FIXED: was 1.0 / (1 - x) which is wrong!
    }

    // Forward pass - make a prediction
    public double predict(double[] inputs) {  // Fixed: was "perdict"
        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sigmoid(sum);
    }

    // Train the network using one example
    public void train(double[] inputs, double target) {
        // Forward pass
        double prediction = predict(inputs);  // Fixed: was "perdict"

        // Calculate error
        double error = target - prediction;

        // Calculate gradient - THIS WAS CAUSING NaN!
        double gradient = error * sigmoidDerivative(prediction);

        // Update weights and bias
        for (int i = 0; i < weights.length; i++) {
            weights[i] += learningRate * gradient * inputs[i];
        }
        bias += learningRate * gradient;
    }

    // Get current weights for testing
    public double[] getWeights() {
        return weights.clone();
    }

    public double getBias() {
        return bias;
    }
}