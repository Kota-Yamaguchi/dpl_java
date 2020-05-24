
package neurolayer;

import general.RandomG;
public class Layer {
	private double[][] wParam;
	private double[] bParam;
	private double[] input;


	public Layer(int row, int col, double[] input){
		this.wParam = RandomG.randomMatrix(row, col);
		this.bParam = RandomG.randomArray(row);
		this.input = input;
	}
//	順伝播用のメソッド
	public double[] affine() {
		double[] result;
		result = new double[this.wParam.length];
		for (int i=0;i<this.wParam.length;i++) {
			int sum = 0;
			for (int j=0; j<this.wParam[0].length;j++) {
				sum += (this.wParam[i][j] * this.input[j]);
			}
			result[i] = sum+this.bParam[i];

		}
		return result;
	}

	public double[] backward(double[] out) {
		double[] moreOut = new double[this.input.length];
		for (int i=0;i<this.wParam.length;i++) {
			for (int j=0; j<this.wParam[0].length;j++){
				this.wParam[i][j] += out[j]*this.input[i];
				moreOut[i] += out[j]*this.wParam[i][j];
			}

		}
		return moreOut;
}
//	Affineメソッドのオーバーロード
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

	private double[][] wParamDash(){
		double h = 0.000001;
		double[][] Wdash = new double[wParam.length][wParam[0].length];
		for (int i=0; i<wParam.length;i++) {
			for (int j=0; j<wParam[0].length;j++) {
				Wdash[i][j] = wParam[i][j]+h;
			}
		}
		return Wdash;
	}
	private double[] dashAffine(double[] input) {
		double[] result;
		double[][] Wdash = wParamDash();
		result = new double[Wdash.length];
		for (int i=0;i<Wdash.length;i++) {
			int sum = 0;
			for (int j=0; j<Wdash[0].length;j++) {
				sum += (Wdash[i][j] * input[j]);
			}
			result[i] = sum+this.bParam[i];

		}
		return result;


	}

}
