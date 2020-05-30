package neurolayer;

import calculate.ActivateFunction;

public class Sigmoid extends Activation{
	int number;
	int dimension;
	public double[][] forward(double[][] input) {
		System.out.println("シグモイド");
		this.input = input;
		this.number = this.input.length;
		this.dimension = this.input[0].length;
		output = new double[number][dimension];
		for (int i=0; i<this.input.length;i++){
			this.output[i] = ActivateFunction.sigmoid(this.input[i]);
		}
		return this.output;
	}

	public double[][] backward(double[][] back) {
		double[][] toInput = new double[number][dimension];
		for (int k=0; k<number; k++) {
			for (int i=0; i<dimension; i++) {
				toInput[k][i] = back[k][i] * (1.0 - this.output[k][i]) * this.output[k][i];
			}
		}
		return toInput;
	}
}
