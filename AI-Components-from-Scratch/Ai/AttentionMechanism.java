import java.util.Arrays;
import java.util.HashSet;

class AttentionMechanism{

    String input;

    public AttentionMechanism(){}

    public AttentionMechanism(String input){
        this.input = input;
    }

    // toListString seprates the sentence into its own words
    public String[] toListString(String input){
        return input.split(" ");
    }

    public double[][] computeAttentionScores(String[] words){
        // Making an array of doubles so we can see the Sttention scores of each word
        double[][] scores = new double[words.length][2];

        // importent nouns
        HashSet<String> nounWords = new HashSet<>(Arrays.asList(
            "cat", "mat", "dog", "Alice", "Bob"
        ));

        // importent verbs
        HashSet<String> verbWords = new HashSet<>(Arrays.asList(
            "sat", "run", "walk", "Swim", "fight"
        ));

        // adding vaules to each word

        // needs to be worked on logic is not correct
        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            scores[i][0] = 0.1;
            scores[i][1] = 0.1;
            if (nounWords.contains(word)){
                scores[i][0] += 0.5;
                scores[i][1] += 0.1;
            }if (verbWords.contains(word)){
                scores[i][0] += 0.1;
                scores[i][1] += 0.5;
            }
        }
        return scores;
    }

    public void printAttention(String[] words, double[][] scores){
        System.out.println("Word Feature Vectores:");
        for (int i = 0; i < words.length; i++){
            System.out.printf("%-10s -> %s%n", words[i], Arrays.toString(scores[i]));
        }
    }
}