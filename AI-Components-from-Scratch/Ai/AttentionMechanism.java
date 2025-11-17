import java.util.Arrays;
import java.util.HashSet;

class AttentionMechanism{

    String input;
    double bias;

    public AttentionMechanism(){
        // Default bias vaule
        this.bias = 0.1;
    }

    public AttentionMechanism(String input){
        this.input = input;
        this.bias = 0.1;
    }

    // Setter for bias
    public void setBias(double bias){
        this.bias = bias;
    }

    public double getBias(){
        return bias;
    }

    // toListString seprates the sentence into its own words
    public String[] toListString(String input){
        return input.split(" ");
    }

    public double[][] computeAttentionScores(String[] words){
        // Making an array of doubles so we can see the Attention scores of each word
        double[][] scores = new double[words.length][2];

        // importent nouns
        HashSet<String> nounWords = new HashSet<>(Arrays.asList(
            "cat", "mat", "dog", "Alice", "bob"
        ));

        // importent verbs
        HashSet<String> verbWords = new HashSet<>(Arrays.asList(
            "sat", "run", "walk", "Swim", "fight"
        ));

        // adding vaules to each word

        // needs to be worked on logic is not correct
        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            scores[i][0] = bias;
            scores[i][1] = bias;
            if (nounWords.contains(word)){
                scores[i][0] += 0.5;
                scores[i][1] += 0.1;
            }else if (verbWords.contains(word)){
                scores[i][0] += 0.1;
                scores[i][1] += 0.5;
            }
        }
        return scores;
    }

    // Prints the words and scores
    public void printAttention(String[] words, double[][] scores){
        System.out.println("Word Feature Vectores:");
        for (int i = 0; i < words.length; i++){
            System.out.printf("%-10s -> %s%n", words[i], Arrays.toString(scores[i]));
        }
    }
}