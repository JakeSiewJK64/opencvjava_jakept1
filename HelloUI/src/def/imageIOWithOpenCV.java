package def;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class imageIOWithOpenCV {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// instantiate imgcodecs class
		Imgcodecs imageCodecs = new Imgcodecs();
		
		// reading the image from the file
		Mat matrix = imageCodecs.imread("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\profile.jpg");
		
		// display information with print statement
		System.out.println(matrix);
		
		
	}
}
