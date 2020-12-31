package def;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class cvtColor {
	public static void main(String[] args) {
		// load the opencv library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// creating the image path variable
		String fpath = "C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\profile.jpg";
		
		// creating codecs
		Imgcodecs imgcodecs = new Imgcodecs();
		
		Mat matrix = imgcodecs.imread(fpath);
		
		// create empty destination matrix
		Mat dst = new Mat();
		
		// convert the image to grayscale and saving it to new matrix
		Imgproc improc = new Imgproc();
		
		// cvtColor		
		improc.cvtColor(matrix, dst, improc.COLOR_RGB2GRAY);
		
		// extracting data from the transformed image
		// creating a byte array from size of t
		byte[] data1 = new byte[dst.rows() * dst.cols() * (int)(dst.elemSize())];
		dst.get(0,0,data1);
		
		// creating the buffere image
		BufferedImage img = new BufferedImage(dst.cols(), dst.rows(), BufferedImage.TYPE_BYTE_GRAY);
		
		// setting thedata elemets to the image
		img.getRaster().setDataElements(0, 0, dst.cols(), dst.rows(), data1);
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));		
		frame.pack();
		frame.setVisible(true);
		
	}
}
