package neurolayer;

import general.RandomG;
public class Layer {
	private double[][] wParam;
	private double[] bParam;

	public Layer(int row, int col){
		this.wParam = RandomG.randomMatrix(row, col);
		this.bParam = RandomG.randomArray(row);

	}
	public double[] affine(double[] input) {
		double[] result;
		result = new double[this.wParam.length];
		for (int i=0;i<this.wParam.length;i++) {
			int sum = 0;
			for (int j=0; j<this.wParam[0].length;j++) {
				sum += (this.wParam[i][j] * input[j]);
			}
			result[i] = sum+this.bParam[i];

		}
		return result;
	}
	public double[] affine(double[] input,double[][] wParam, double[] bParam) {
		double[] result;
		result = new double[wParam.length];
		for (int i=0;i<wParam.length;i++) {
			int sum = 0;
			for (int j=0; j<wParam[0].length;j++) {
				sum += (wParam[i][j] * input[j]);
			}
			result[i] = sum+bParam[i];

		}
		return result;
	}
	

}
