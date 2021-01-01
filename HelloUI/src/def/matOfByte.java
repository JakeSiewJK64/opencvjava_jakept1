package def;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

public class matOfByte {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		MatOfByte matOfByte = new MatOfByte();
		
		// matOfByte is really just an empty array
		System.out.println(matOfByte.dump());
		
		File fpath = new File("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\drawable\\blackpink.jpg");
		try {
			BufferedImage image = ImageIO.read(fpath);
			
			Mat m = Imgcodecs.imread(fpath.toString());
			
			System.out.println(m.dump());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
