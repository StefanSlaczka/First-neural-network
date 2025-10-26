import java.util.Arrays;
import java.util.HashSet;

class AttentionMechanism{

    /*
        Now I want to moving toward representing words as feature vectors
        so I am going to make a noun and then a verb for represive
        ex:
        the [0.1, 0.1]
        cat [1.0, 0.1]
        sat [0.1, 1.0]
    */

    String input;

    public AttentionMechanism(){}

    public AttentionMechanism(String input){
        this.input = input;
    }

    // toListString seprates the sentence into its own words
    public String[] toListString(String input){
        return input.split(" ");
    }

    public double[] computeAttentionScores(String[] words){
        // Making an array of doubles so we can see the Sttention scores of each word
        double[] scores = new double[words.length];

        // importent words (Entities)
        HashSet<String> importantWords = new HashSet<>(Arrays.asList(
            "cat", "mat", "dog", "Alice", "Bob"
        ));

        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            if (importantWords.contains(word)){
                scores[i] = 1.0;
            }else {
                scores[i] = 0.1;
            }
        }
        return scores;
    }


}