package def;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class imwrite {
	public static void main(String[] args) {
		// load opencv
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// instantiating the imagecodecs variable
		Imgcodecs imgcodecs = new Imgcodecs();
		
		// reading the image
		String fpath = "C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\profile.jpg";
		
		// reading the file using the codecs
		Mat matrix = imgcodecs.imread(fpath);
		
		System.out.println(matrix);		
		System.out.println("Image loaded...");
		
		// loading 2nd file
		String file2 = "C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\profile2.jpg";
		imgcodecs.imwrite(file2, matrix);
		
		System.out.println("Image Saved...");
	}
}
