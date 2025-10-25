class Test{
    public static void main(String[] args) {
        AttentionMechanism am = new AttentionMechanism();
        String sentence = "The cat sat on the mat because it was tired";
        String[] result = am.toListString(sentence);

        System.out.println("Words in the sentence");
        for (String word : result){
            System.out.println(word);
        }

    }
}