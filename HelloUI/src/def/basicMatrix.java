package def;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

public class basicMatrix {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// creating matrix
		Mat matrix = new Mat(5,5,CvType.CV_8UC1, new Scalar(0));
		
		// retrieving the row with index 0
		Mat row0 = matrix.row(0);
		
		// setting values of al elements in the row with index 0
		row0.setTo((new Scalar(1)));
		
		// setting values of all elements in the arow with index 3
		Mat col = matrix.col(3);
		
		// setting the column to 3
		col.setTo(new Scalar(3));
		
		System.out.println(matrix.dump());
	}
}
