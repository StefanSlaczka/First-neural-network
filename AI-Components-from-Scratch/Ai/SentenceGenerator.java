class SentenceGenerator {
    public static  String genrate(Transistor transistor){
        
        // Getting data from transitor
        String[] words = transistor.words;
        double[][] scores = transistor.scores;
        double bias  = transistor.bias;

        StringBuilder importantWords = new StringBuilder();
        double threshold = bias + 0.3; // Minimum score required to consider a word "important"
        
        // Select words whose scores exceed the threshold in either dimension
        for (int i = 0; i < words.length; i++){
            if (scores[i][0] > threshold || scores[i][1] > threshold){
                importantWords.append(words[i]).append(" ");
            }
        }

        // Convert important words into a keyword string
        String kewwords = importantWords.toString().trim();
        if (kewwords.isEmpty()){
            kewwords = "nothing specific";
        }

        // Compute activation level using the transistor's internal model
        double z = transistor.computeWeightedSum();
        double activation  = transistor.activate(z , "sigmoid");

         // Generate a textual description based on activation strength
        String description;
        if (activation > 0.8) {
            description = "a very active or dynamic scene";
        } else if (activation > 0.5){
            description = "a calm or ordinary situation";
        }else {
            description = "a low activity or neutral statemnt";
        }

        return String.format(
            "Based on analysis, the sentence focuses on '%s' and represents %s.",
            kewwords,
            description
        );
    }
}