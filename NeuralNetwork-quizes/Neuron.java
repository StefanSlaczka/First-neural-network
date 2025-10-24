class Neuron{
	String type;
	double activationValue;

	public Neuron(String type, double activationValue){
		this.type = type; this.activationValue = activationValue;
	}

	public String toString(){
		return "Type: " + type + ", Activation Value: " + activationValue;
	}

}