package general;

import java.io.IOException;

import activation.Sigmoid;
import neurolayer.Layer;
public class Main {
	public static void main(String[] args) {
		int row=0;
		int col=0;
		double[][] feature = null;
		try {
			double[][] img = sample.imageInput();
			row = img.length;
			col = img[0].length;
			feature = new double[row][col];
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(col);
//		double[] input = RandomG.randomArray(32);

		int input_dimension = 784;

		Layer lay1 = new Layer(input_dimension,32,feature);
		double[][] input2 = lay1.affine();
		Sigmoid act1 = new Sigmoid(input2);
		double[][] output1 = act1.forward();

		Layer lay2 = new Layer(32, 16, output1);
		double[][] input3 = lay2.affine();
		Sigmoid act2 = new Sigmoid(input3);
		double[][] output2 = act2.forward();

		for (int i=0; i<output2.length;i++) {
			System.out.println(output2[0][i]);
		}
	}

}
