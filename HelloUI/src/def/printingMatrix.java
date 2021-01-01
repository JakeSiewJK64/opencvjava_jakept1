package def;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class printingMatrix {

	public static void main(String[] args) {
		
		// loading the library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// print version
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		
		// creating new matrix
		Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
		
		System.out.println("OpenCV Matrix: " + m);
		
		Mat mr1 = m.row(1);
		mr1.setTo(new Scalar(1));
		
		Mat mr5 = mr1.col(5);
		mr5.setTo(new Scalar(3));
		
		System.out.println(m.dump());		
	}
}
