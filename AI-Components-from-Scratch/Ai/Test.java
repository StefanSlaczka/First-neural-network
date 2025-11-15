class Test{
    public static void main(String[] args) {

        // Create new object and using the toListString
        AttentionMechanism am = new AttentionMechanism();
        String sentence = "The cat sat on the mat because it was tired";

        String[] words = am.toListString(sentence);
        double[][] scores = am.computeAttentionScores(words);

        // Prints out the words one at a time
        System.out.println("Words in the sentence and scores");
        am.printAttention(words, scores);

        // Send the data to the Transistor
        Transistor transistor = new Transistor(words, scores, am.getBias());

        // Compute the weighted sum
        transistor.computeWeightedSum();

        // Print the result
        System.out.println("\n" + transistor);

        // Tells us the network output ans what is the importent words
        System.out.println("\n Network Output: ");
        System.out.println(SentenceGenerator.genrate(transistor));
    }
}