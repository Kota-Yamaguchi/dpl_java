package activation;

import calculate.ActivateFunction;

public class Softmax {
	private double[] output;

	public Softmax(double[] input) {
		output = new double[input.length];
	}

	public double[] forward(double[] input) {
		this.output = ActivateFunction.softmax(input);
		return this.output;
	}

	public double[] backward(double[] input) {

	}
}
