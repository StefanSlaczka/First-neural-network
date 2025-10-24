class InputNeuron extends Neuron{
	double inputSignal;

	public InputNeuron(String type, double inputSignal, double activationValue){
		super(type, activationValue);
		this.inputSignal = inputSignal;
	}

	public String toString(){
		return "InputNeuron -> Input Signal: " + inputSignal + ", Activation: " + activationValue;
	}

	public String toString(int x){
		return "Error: Invalid input value (" + x + ")";
	}
}