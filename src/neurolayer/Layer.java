package neurolayer;

public abstract class Layer {
	double[][] input;
	double[][] output;

	public Layer() {
	}

	public double[][] forward(double[][] fake) {
		return output;
	}

	public void backward() {
	}
}
