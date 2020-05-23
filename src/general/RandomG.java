package general;

public class RandomG {
	
	public static double[] randomArray(int length) {
		double[] array;
		array = new double[length];
		for (int i=0; i<length;i++) {
			double num = randf();
			array[i] = num;
		}
		return array;
	}

	public static double[][] randomMatrix(int row, int col) {

		double[][] matrix;
		matrix = new double[row][col];

		for(int i=0; i<row;i++) {
			for (int j=0; j<col;j++) {
				double num = randf();
				matrix[i][j]=num;
			}
		}
		return matrix;
		
	}
	
	private static double randf() {
		return Math.random();
	}
}
