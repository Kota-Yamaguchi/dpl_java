package general;

import activation.Sigmoid;
import neurolayer.Layer;
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double[] input = RandomG.randomArray(32);

		Layer lay1 = new Layer(32,16,input);
		double[] input2 = lay1.affine();
		Sigmoid act1 = new Sigmoid(input2);
		double[] output1 = act1.forward();

		Layer lay2 = new Layer(16, 1, output1);
		double[] input3 = lay2.affine();
		Sigmoid act2 = new Sigmoid(input3);
		double[] output2 = act2.forward();

		for (int i=0; i<output2.length;i++) {
			System.out.println(output2[i]);
		}
	}

}
