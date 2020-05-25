package activation;

import calculate.ActivateFunction;

public class Sigmoid {

	private double[][] output;
	private double[][] input;

	public Sigmoid(double[][] input) {
		this.input = input;
		this.output = new double[input.length][input[0].length];
	}

	public double[][] forward() {
		for (int i=0; i<input.length;i++){
			this.output[i] = ActivateFunction.sigmoid(this.input[i]);
		}
		return this.output;
	}

//	public double[] backward(double[] back) {
//		double[] moreOut = new double[back.length];
//		for (int i=0; i<back.length; i++) {
//			moreOut[i] = back[i] * (1.0 - this.output[i]) * this.output[i];
//		}
//		return moreOut;
//	}
}
