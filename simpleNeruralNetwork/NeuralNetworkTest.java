import java.util.Arrays;

public class NeuralNetworkTest{
    public static void main(String[] args) {
        testANDGate();
        testORGate();
        testSingleNeuron();
        testWeightInitialization();;
        System.out.println("All test complete");
    }

    // test one AND Gate
    public static void testANDGate(){
        System.out.println("\n=== Testing AND Gate ===");
        SimpleNeuralNetwork nn = new SimpleNeuralNetwork(2, 0.5);

        // AND gate truth table
        double[][] inputs = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        double[] targets = {0, 0, 0, 1};

        // Train for multiple epoch
        for (int epoch = 0; epoch < 1000; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                nn.train(inputs[i], targets[i]);
            }
        }

        // Test predictions
        System.out.println("AND Gate Results:");
        for (int i = 0; i < inputs.length; i++) {
            double prediction = nn.predict(inputs[i]);
            System.out.printf("Input: %s -> Prediction: %.3f (Expected: %.0f)%n",
                    Arrays.toString(inputs[i]), prediction, targets[i]);
        }

        // Verify final weights are reasonable
        double[] weights = nn.getWeights();
        System.out.printf("Final weights: [%.3f, %.3f], bias: %.3f%n",
            weights[0], weights[1], nn.getBias());

    }
    // test one OR Gate
    public static void testORGate(){
        System.out.println("\n=== Testing OR Gate ===");
        SimpleNeuralNetwork nn = new SimpleNeuralNetwork(2, 0.5);

        // OR gate truth table
        double[][] inputs = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        double[] targets = {0, 1, 1, 1};

        // Train for multiple epoch
        for (int epoch = 0; epoch < 1000; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                nn.train(inputs[i], targets[i]);
            }
        }

        // Test predictions
        System.out.println("OR Gate Results:");
        for (int i = 0; i < inputs.length; i++) {
            double prediction = nn.predict(inputs[i]);
            System.out.printf("Input: %s -> Prediction: %.3f (Expected: %.0f)%n",
                    Arrays.toString(inputs[i]), prediction, targets[i]);
        }

        // Verify final weights are reasonable
        double[] weights = nn.getWeights();
        System.out.printf("Final weights: [%.3f, %.3f], bias: %.3f%n",
            weights[0], weights[1], nn.getBias());
        
    }
    // Test case 3: single input nuron( Learning y= 2x)
    public static void testSingleNeuron(){
        System.out.println("\n=== Testing Single Input (y = 2x) ===");
        SimpleNeuralNetwork nn = new SimpleNeuralNetwork(1, 0.1);

        // AND gate truth table
        double[][] inputs = {{0.1}, {0.3}, {0.5}, {0.7}, {0.9}};
        double[] targets = {0.2, 0.6, 1.0, 1.4, 1.8}; // 2x scaled

        // Train for multiple epoch
        for (int epoch = 0; epoch < 500; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                nn.train(inputs[i], targets[i]);
            }
        }

        // Test
        System.out.println("Linear Function Results:");
        for (int i = 0; i < inputs.length; i++) {
            double prediction = nn.predict(inputs[i]);
            double expected  = targets[i];
            double error = Math.abs(prediction - expected);
            System.out.printf("Input: %.1f -> Prediction: %.3f (Expected: %.1f, Error: %.3f)%n",
                    inputs[i][0], prediction, expected, error);
        }
    }

    // Test Case 4: weight Initia;ization
    public static void testWeightInitialization() {
        System.out.println("\n=== Testing Weight Initializaion ===");
        SimpleNeuralNetwork nn = new SimpleNeuralNetwork(3, 0.1);
        double[] weights = nn.getWeights();

        System.out.println("Intial Wieghts: " + Arrays.toString(weights));

        // Verify weights are small and not 0;s
        boolean allSmall = true;
        for (double w : weights) {
            if (Math.abs(w) > 0.1){
                allSmall = false;
                break;
            }
        }
        System.out.println("All weights are small: " + allSmall);
    }
}