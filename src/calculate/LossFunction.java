package calculate;

public class LossFunction {

	protected double[][] input;
	protected double[][] training;

	LossFunction(double[][] input, double[][] training){
		this.input = input;
		this.training = training;
	}

	public double[][] getInput() {
		return this.input;
	}
	public double[][] getTraining(){
		return this.training;
	}
}
