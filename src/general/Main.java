package general;

import calculate.ActivateFunction;
import neurolayer.Layer;
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double[] input = RandomG.randomArray(32);
		Layer lay1 = new Layer(32,32);
		double[] input2 = lay1.affine(input);
		double[] act2 = ActivateFunction.sigmoid(input2);
		
		
		for (int i=0; i<act2.length;i++) {
			System.out.println(act2[i]);
		}
	}

}
