
package neurolayer;

import general.RandomG;
public class Affine extends Layer{
	double[][] wParam;
	double[] bParam;
	int number;
	int dimension;
	int outDimension;

	public Affine(int in_row, int out_col){
//		おもみだけ転置している
		this.wParam = RandomG.randomMatrix(out_col, in_row);
		this.bParam = RandomG.randomArray(out_col);
		this.outDimension = out_col;
	}

	public Affine(int in_row, int out_col, double[][] input){
//		おもみだけ転置している
		this.wParam = RandomG.randomMatrix(out_col, in_row);
		this.bParam = RandomG.randomArray(out_col);
		this.input = input;
		this.outDimension = out_col;
		this.number = this.input.length;
		this.dimension = this.input[0].length;

	}

//	Affineメソッドのオーバーロード
	public double[][] forward(double[][] input) {
		System.out.println("affine");
		this.input = input;
		this.number = this.input.length;
		this.dimension = this.input[0].length;
		double[][] output = new double[number][outDimension];
		System.out.println(output.length);

		for (int k=0; k<number;k++) {

			for (int i=0;i<outDimension;i++) {
				int sum = 0;

				for (int j=0; j<wParam[0].length;j++) {
					sum += (wParam[i][j] * input[k][j]);

				}
				output[k][i] = sum+bParam[i];
			}
		}
		return output;
	}
	public double[][] backward(double[][] out) {
		double[][] dW = new double[wParam.length][wParam[0].length];
		double[] db = new double[bParam.length];
		double[][] toInput = new double[number][dimension];

		for (int k =0;k<number;k++) {
			for (int i=0;i<dimension;i++) {
				for (int j=0;j<outDimension;j++) {
					toInput[k][i] += wParam[j][i] * out[k][j];
				}
			}
		}
//		Wの更新
//		bの更新
		for (int k =0;k<number;k++) {
			for (int i=0;i<dimension;i++) {
				for (int j=0;j<outDimension;j++) {
					this.wParam[j][i] += input[k][i]*out[k][j];
					this.bParam[k] += out[k][j];
				}
			}
		}
		return toInput;
	}


}
