class AttentionMechanism{

    /*

        "The cat sat on the mat because it was tired"

        Goal change this into this

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
        String regex = " ";
        String[] myArray = input.split(regex);
        return myArray;
    }


}