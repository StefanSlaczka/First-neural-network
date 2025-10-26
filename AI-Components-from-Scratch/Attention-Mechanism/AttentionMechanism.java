import java.util.Arrays;
import java.util.HashSet;

class AttentionMechanism{

    /*
        ["The", "cat", "sat", "on", "the", "mat", "because", "it", "was", "tired"]
        
        Goal asign vausles to this
        words like cat should be higher because its an entity
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