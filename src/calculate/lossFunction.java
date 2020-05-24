package calculate;

public class lossFunction {
	public static double squaredError(double[] input, double[] training) {
		double loss=0;
		for (int i=0;i<input.length; i++) {
			loss += Math.pow((training[i] - input[i]),2);
		}
		return (1/2)*loss;
	}

	public static double crossEntropyError(double[] input, double[] training) {
		double loss=0;
		for (int i=0; i<input.length;i++) {
			loss += training[i]*Math.log(input[i]+0.00000001);
		}
		return -loss;
	}

}
