package general;

import java.io.IOException;
import java.util.ArrayList;

import neurolayer.Affine;
import neurolayer.Layer;
import neurolayer.Sigmoid;
import neurolayer.Softmax;

public class Main {
	public static void main(String[] args) {
		int row=0;
		int col=0;
		int batch_size = 32;
		int epochs = 10;
		double[][] feature = null;
		int[] label=null;

		try {
			double[][] img = sample.imageInput();
			row = img.length;
			col = img[0].length;
			feature = new double[row][col];

			label = sample.labelinput();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(col);
//		double[] input = RandomG.randomArray(32);





		int input_dimension = 784;

		Layer lay1 = new Affine(input_dimension,32);
		Layer act1 = new Sigmoid();
		Layer lay2 = new Affine(32, 16);
		Sigmoid act2 = new Sigmoid();
		Layer lay3 = new Affine(16,10);
		Softmax act3 = new Softmax();

		ArrayList<Layer> laylist = new ArrayList<Layer>();
		laylist.add(lay1);
		laylist.add(act1);
		laylist.add(lay2);
		laylist.add(act2);
		laylist.add(lay3);
		laylist.add(act3);

		double[][] input = new double[batch_size][input_dimension];
		double[] input_label = new double[batch_size];
		for (int n=0;n<epochs;n++) {
//			ランダムに数字を生成する
			int[] list = new int[batch_size];
			list = Radomarray.random(row, batch_size);
			System.out.println(n+"回目のバッチ処理をします");
			for (int k=0; k<batch_size;k++) {
				input[k] = feature[list[k]];
				input_label[k] = label[list[k]];
			}
			for (int i = 0; i<laylist.size();i++) {
				input = laylist.get(i).forward(input);
			}
			System.out.println("");
		}


		for (int i=0; i<input[0].length;i++) {
			System.out.println(input[0][i]);
		}
	}

}
