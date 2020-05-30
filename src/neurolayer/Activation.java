package neurolayer;

public abstract class Activation extends Layer{
	double[][] output;
	double[][] input;

	public Activation(double[][] input) {
		this.input = input;
		this.output = new double[input.length][input[0].length];
	}

	public Activation() {

	}


}
