class Test {
	public static void main(String[] args){
		Neuron n1 = new Neuron("simplest model", 57);
		InputNeuron inputN = new InputNeuron("simplest model", 77, 47);

		System.out.println(n1.toString());
		System.out.println(inputN.toString());
		System.out.println(inputN.toString(404));
	}
}