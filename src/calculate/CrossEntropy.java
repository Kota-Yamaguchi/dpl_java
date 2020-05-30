package calculate;

public class CrossEntropy extends LossFunction{


	CrossEntropy(double[][] input, double[][] training){
		super(input, training);
	}
	public double forward() {
		int imageNum = input.length;
		int imageDim = input[0].length;
		double[] loss= new double[imageNum];
		double sumLoss =0;
		for (int k=0; k<imageNum;k++) {
			for (int i=0; i<imageDim;i++) {
				loss[k] += training[k][i]*Math.log(input[k][i]+0.00000001);
			}
			sumLoss+=loss[k];
		}
		return -sumLoss;
	}

	public LossFunction backward() {
		LossFunction Loss = new LossFunction(this.input, this.training);
		return Loss;
	}

}
