// every conection (edge) has a direction from input to output
// infomation flows forward and no loops

import com.sun.jdi.connect.Transport;
import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;

class Transformer{
    /*
    Embedding layer → turns tokens (“hello”) into vectors.

    Self-Attention layer → each token looks at the others to understand context.

    Feedforward layer → processes each position’s information further.

    Residual + Normalization → adds shortcuts and stabilizes learning.
    */

   // input hello -> [h,e,l,l,o]

    public static void main(String[] args) {
        // input tokens
        String[] tokens = {"h", "e", "l", "l", "o"};

        // hard-cod embeddings(2d)
        double[][] embeddings = {
            {1.0, .05}, // h
            {0.8, .03}, // e
            {0.4, .07}, // l
            {0.4, .07}, // l
            {0.2, .09} // o
        };

        // Multiply X by the weight matrices W_Q, W_K, W_V (matrix multiplication).
        double[][]W_Q = {{0.2, 0.6}, {0.8, 0.4}};
        double[][]W_K = {{0.5, 0.1}, {0.3, 0.9}};
        double[][]W_V = {{0.9, 0.3}, {0.1, 0.7}};

        // compute Q, K, V
        double[][] Q = matMul(embeddings, W_Q);
        double[][] K = matMul(embeddings, W_K);
        double[][] V = matMul(embeddings, W_V);

        System.out.println("Queries (Q):");
        printMatrix(Q);
        System.out.println("Queries (K):");
        printMatrix(K);
        System.out.println("Queries (V):");
        printMatrix(V);

        // comput attention scores(Q * K ** T)
        double[][] K_T = transpose(K);
        double[][] scores = matMul(Q, K_T);

        System.out.println("Raw Attention Scores:");
        printMatrix(scores);

        double[][] attentionWeight = new double[scores.length][scores[0].length];
        for (int i = 0; i < scores.length; i++){
            attentionWeight[i] = softmax(scores[i]);
        }

        System.out.println("Attention Weight:");
        printMatrix(attentionWeight);

        //attention output =  weights * V
        double[][] attentionOutput = matMul(attentionWeight, V);
        System.out.println("Attention Output: ");
        printMatrix(attentionOutput);

        // simple feed forward (ReLU)
        double[][] W_ff = {{0.5, 0.3}, {0.2, 0.8}};
        double[] b_ff = {0.1, 0.1};
        double[][] feedforward = new double[attentionOutput.length][2];
        for (int i = 0; i < attentionOutput.length; i++){
            double[] out = new double[2];
            for (int j = 0; j < 2; j++){
                out[j] = Math.max(0, attentionOutput[i][0] * W_ff[0][j] + b_ff[j]);
            }
            feedforward[i] = out;
        }

        System.out.println("Feedforeward Output:");
        printMatrix(feedforward);

        // Mean polling to get final output
        double[] finalOutput = mean(feedforward);
        // What the computer learned "hello"
        System.out.println("Final Output Vector (represents 'there'):");
        System.out.println(Arrays.toString(finalOutput));
    }

    // matrix multipication
    static double[][] matMul(double[][] A, double[][] B){
        int n = A.length, m = B[0].length, p= B.length;
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for(int k = 0; k < p; k++){
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    static double[][] transpose(double[][] A){
        int n = A.length, m = A[0].length;
        double[][] result = new double[m][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    static double[] softmax(double[] x){
        double max = Arrays.stream(x).max().getAsDouble();
        double sum = 0.0;
        double[] exp = new double[x.length];
        for (int i = 0; i < x.length; i++){
            exp[i] = Math.exp(x[i] - max);
            sum += exp[i];
        }
        for (int i = 0; i< x.length; i++){
            exp[i] /= sum;
        }
        return exp;
    }

    // mean pooling
    static double[] mean(double[][] A){
        int n = A.length, m = A[0].length;
        double[] result = new double[m];
        for(double[] row : A){
            for(int j = 0; j < m; j++){
                result[j] += row[j];
            }
        }
        for (int j = 0; j < m; j++) {
            result[j] /= n;
        }
        return result;
    }

    static void printMatrix(double[][] M){
        for(double[] row : M){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("");
    }

}