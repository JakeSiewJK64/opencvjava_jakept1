package def;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class SobelOperator {
	
	public static void main(String[] args) {
		
		// load library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String fpath = new String("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\drawable\\blackpink.jpg");
		
		// matrix object
		Mat src = Imgcodecs.imread(fpath), dst = new Mat();
		
		// get start time
		long startTime = System.currentTimeMillis();
		
		// create the Sobel Image
		Imgproc.Sobel(src, dst, -1, 1, 1);
		
		// calculate time elapsed for operation
		System.out.println(String.format("Time elapsed: %s miliseconds.", System.currentTimeMillis() - startTime));
		
		String out_path = new String("C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\drawable\\\\blackpink_sobel.jpg");

		Imgcodecs.imwrite(out_path, dst);
		
		// create MatOfByte object
		MatOfByte matOfByte = new MatOfByte();			
		Imgcodecs.imencode(".jpg", dst, matOfByte);
		byte[] byteArray = matOfByte.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		
		try {
			BufferedImage img = ImageIO.read(in);
			JFrame frame = new JFrame();			
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			frame.pack();
			frame.setTitle("Sobel Edge Detection by Jake SJK...");
			frame.setVisible(true);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
