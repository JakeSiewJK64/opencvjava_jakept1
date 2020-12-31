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

public class imreadClass {
	
	public static void main(String[] args) {
		// read in the opencv library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// create
		String path = "C:\\\\\\\\Users\\\\\\\\Shirley\\\\\\\\eclipse-workspace\\\\\\\\HelloUI\\\\\\\\src\\\\\\\\profile.jpg";
		
		// create codec
		Imgcodecs imgcodec = new Imgcodecs();
		Mat matrix = imgcodec.imread(path, imgcodec.IMREAD_GRAYSCALE);
		System.out.println(matrix);
		
		// convert image matrix to MatOfByte
		MatOfByte matOfByte = new MatOfByte();
		
		Imgcodecs.imencode(".jpg", matrix, matOfByte);
		
		byte[] byteArray = matOfByte.toArray();
		
		System.out.println("Mat of byte: " + matOfByte);
		System.out.println(byteArray);
		
		InputStream in = new ByteArrayInputStream(byteArray);
		
		try {
			BufferedImage img = ImageIO.read(in);
			
			// display using Abstract Window Toolkit
			JFrame frame = new JFrame();
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			frame.pack();
			frame.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
