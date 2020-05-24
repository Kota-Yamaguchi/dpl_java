package calculate;

public class ActivateFunction {
		public static double sigmoid(double x) {
			return 1/(1+Math.exp(x));
		}

		public static double[] sigmoid(double[] x) {
			double[] y;
			y = new double[x.length];

			for (int c=0;c<x.length;c++) {
				y[c] = 1/(1+Math.exp(x[c]));
			}
			return y;
		}

		public static double[][] sigmoid(double[][] x){
			double[][] y;
			y = new double[x.length][x[0].length];
			for (int i=0 ;i<x.length; i++) {
				for (int j=0; j<x[0].length; j++) {
					y[i][j] = 1/(1+Math.exp(x[i][j]));
				}
			}
			return y;
		}

		public static double[] softmax(double[] x) {
			double[] y = new double[x.length];
			double sum = 0;
			for (int i=0;i<x.length;i++) {
				y[i] = Math.exp(x[i]);
				sum+=y[i];
			}

			for (int i=0; i<x.length;i++) {
				y[i] = y[i]/sum;
			}
			return y;
		}
}
