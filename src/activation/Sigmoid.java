package activation;

import calculate.ActivateFunction;

public class Sigmoid {

	private double[] output;
	private double[] input;
	public Sigmoid(double[] input) {
		this.input = input;
		output = new double[input.length];
	}

	public double[] forward() {
		this.output = ActivateFunction.sigmoid(this.input);
		return this.output;
	}

	public double[] backward(double[] back) {
		double[] moreOut = new double[back.length];
		for (int i=0; i<back.length; i++) {
			moreOut[i] = back[i] * (1.0 - this.output[i]) * this.output[i];
		}
		return moreOut;
	}
}
