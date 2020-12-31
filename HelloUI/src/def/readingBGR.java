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

public class readingBGR {
	public static void main(String[] args) {
		
		// load the opencv library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// get the path to the image
		String fpath = "C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\profile.jpg";
		
		// create the codec
		Imgcodecs imgcodecs = new Imgcodecs();
		Mat src = Imgcodecs.imread(fpath, Imgcodecs.IMREAD_COLOR);
		
		byte[] data1 = new byte[src.rows() * src.cols() * (int)(src.elemSize())];
		src.get(0,0,data1);
		
		// creating buffered image
		BufferedImage img = new BufferedImage(src.cols(), src.rows(), BufferedImage.TYPE_3BYTE_BGR);
		
		// setting data elements to the image
		img.getRaster().setDataElements(0, 0, src.cols(), src.rows(), data1);
					
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JLabel( new ImageIcon(img)));
		frame.pack(); // automatically sizes the window
		frame.setTitle("Arknights");
		frame.setVisible(true);	
		
	
	}
}
