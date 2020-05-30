package neurolayer;

import calculate.ActivateFunction;
import calculate.LossFunction;

public class Softmax extends Activation{
	int number;
	int dimension;
	public double[][] forward(double[][] input) {

		this.input = input;
		this.number = this.input.length;
		this.dimension = this.input[0].length;
		output = new double[number][dimension];
		for (int k=0; k<number; k++) {
				this.output[k] = ActivateFunction.softmax(this.input[k]);
			}
		return this.output;
	}

	public double[][] backwardLoss(LossFunction lossf) {
		var y = lossf.getInput();
		var t = lossf.getTraining();

		double[][] out = new double[number][dimension];
		for (int k=0 ; k<number;k++) {
			for (int i = 0 ; i<dimension ; i++ ) {
				out[k][i] = (y[k][i]-t[k][i])/number;
			}
		}
		return out;
	}


}
