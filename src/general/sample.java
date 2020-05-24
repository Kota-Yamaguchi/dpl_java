package general;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class sample {
	private static int numImages;
    private static int numDimensions;
    private static double[][] feature;

	public static double[][] imageInput() throws IOException {
		String filename = "./t10k-images.idx3-ubyte";
		FileInputStream file = new FileInputStream(filename);
//		GZIPInputStream zipfile = new GZIPInputStream(file);
		DataInputStream datafile = new DataInputStream(file);
		datafile.readInt();
		numImages = datafile.readInt();
        numDimensions = datafile.readInt() * datafile.readInt();
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
        return feature;
	}

}
