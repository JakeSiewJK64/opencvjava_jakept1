package def;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

public class cannyEdgeDetection {

	public static void main(String[] args) {
		// loading the library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// declare the file path
		String fpath = new String("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\drawable\\blackpink.jpg");
		
		// reading the image from the file and storing it into a Matrix object
		Mat source = Imgcodecs.imread(fpath);
		
		// create Matrix object to store the result
		Mat mat = new Mat();
		
		// convert the image into grayscale
		Imgproc.cvtColor(source, mat, Imgproc.COLOR_BGR2GRAY);
		Mat edges = new Mat();
		
		// detecting the edges
		Imgproc.Canny(mat, edges, 60, 60 * 3);		
		
		MatOfByte matOfByte = new MatOfByte();		
		
		Imgcodecs.imencode(".jpg", edges, matOfByte);
		byte[] byteArray = matOfByte.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		BufferedImage img;
		
		try {
			img = ImageIO.read(in);
			System.out.println(img);
			
			// save as file
			Imgcodecs.imwrite("C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\drawable\\\\blackpink_canny.jpg", edges);
			System.out.println("Canny Image saved.");
			
			// Displaying the image using JFrame
			JFrame frame = new JFrame();
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			frame.pack();
			frame.setTitle("Canny Edge Detection --- Jake");
			frame.setVisible(true);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}
