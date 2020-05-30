package general;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class sample {
	private static int numImages;
    private static int numDimensions;
    private static double[][] feature;

	public static double[][] imageInput() throws IOException {
		System.out.println("file is opened");
		String filename = "./t10k-images.idx3-ubyte";
		FileInputStream file = new FileInputStream(filename);
//		GZIPInputStream zipfile = new GZIPInputStream(file);
		DataInputStream datafile = new DataInputStream(file);
		datafile.readInt();
		numImages = datafile.readInt();
        numDimensions = datafile.readInt() * datafile.readInt();
        System.out.println("reading file...");
        feature = new double[numImages][numDimensions];
        for (int i = 0; i < numImages; i++) {
            for (int j = 0; j < numDimensions; j++) {
                feature[i][j] = (double) datafile.readUnsignedByte() / 255.0;
//                System.out.println(feature[i][j]);
            }
        }

        datafile.close();
//        zipfile.close();
        file.close();
        System.out.println("read");
        return feature;
	}

	public static int[] labelinput() throws IOException{
		System.out.println("file is opened");
		String filename = "./t10k-labels.idx1-ubyte";
		FileInputStream bfile = new FileInputStream(filename);
		DataInputStream dfile = new DataInputStream(bfile);

		dfile.readInt();
		int number = dfile.readInt();
		int[] label = new int[number];
		for (int i=0; i<number;i++) {
			label[i] = dfile.readUnsignedByte();
		}

		bfile.close();
//       zipfile.close();
        dfile.close();
        System.out.println("read");
		return label;
	}

	private static double[] oneHotLabel(int) {

	}
}
