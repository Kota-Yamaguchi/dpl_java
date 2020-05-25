
package neurolayer;

import general.RandomG;
public class Layer {
	private double[][] wParam;
	private double[] bParam;
	private double[][] input;
	private int number;
	private int dimension;


	public Layer(int in_row, int out_col, double[][] input){
//		おもみだけ転置している
		this.wParam = RandomG.randomMatrix(out_col, in_row);
		this.bParam = RandomG.randomArray(out_col);
		this.input = input;

		this.number = this.input.length;
		this.dimension = this.input[0].length;

	}
//	順伝播用のメソッド
//	public double[] affine() {
//		double[] result;
//		result = new double[this.wParam.length];
//		for (int i=0;i<this.wParam.length;i++) {
//			int sum = 0;
//			for (int j=0; j<this.wParam[0].length;j++) {
//				sum += (this.wParam[i][j] * this.input[j]);
//			}
//			result[i] = sum+this.bParam[i];
//
//		}
//		return result;
//	}

//	public double[] backward(double[] out) {
//		double[] moreOut = new double[this.input.length];
//		for (int i=0;i<this.wParam.length;i++) {
//			for (int j=0; j<this.wParam[0].length;j++){
//				this.wParam[i][j] += out[j]*this.input[i];
//				moreOut[i] += out[j]*this.wParam[i][j];
//			}
//
//		}
//		return moreOut;
//}
//	Affineメソッドのオーバーロード
	public double[][] affine() {
		double[][] result;

		result = new double[number][dimension];
		for (int k=0; k<number;k++) {
			for (int i=0;i<wParam.length;i++) {
				int sum = 0;
				for (int j=0; j<wParam[0].length;j++) {
					sum += (wParam[i][j] * input[k][j]);
				}
				result[k][i] = sum+bParam[i];
			}
		}
		return result;
	}

}
