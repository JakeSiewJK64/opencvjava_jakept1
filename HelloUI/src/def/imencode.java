package def;

import java.awt.image.BufferedImage;
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

public class imencode {
	
	/*
	 * 
	 * IN THIS JAVA CLASS, WE WILL DEMONSTRATE HOW TO IMMEDIATELY DISPLAY PROCESSED IMAGES TO JFRAME
	 * 
	 */
	public static void main(String[] args) {
		
		// load the opencv library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Reading the image
		String fpath = "C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\profile.jpg";
		
		// codec 
		Imgcodecs imgcodecs = new Imgcodecs();
		Mat matrix = imgcodecs.imread(fpath);
		
		System.out.println(matrix);
		
		/** 
		 *  Step 1: convert image matrix to MatOfByte
		 */
		
		// Instantiating MatOfByte
		MatOfByte matOfByte = new MatOfByte();
		
		// converting the Mat object to MatOfByte
		Imgcodecs.imencode(".jpg", matrix, matOfByte);
		
		/** 
		 *  Step 2: convert MatOfByte object to byte array
		 */
		
		byte[] byteArray = matOfByte.toArray();
		
		/** 
		 *  Step 3: byte input stream class	
		 */ 	
		InputStream in = new ByteArrayInputStream(byteArray);
		
		try {
			BufferedImage bufImage = ImageIO.read(in);
			
			/** 
			 *  Displaying Image using Abstract Windows Toolkit
			 */
			
			JFrame frame = new JFrame();
			frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
			frame.pack();
			frame.setVisible(true);
			System.out.println("Image Loaded...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
