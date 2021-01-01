package def;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Point;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class faceDetection {
	public static void main(String[] args) {
		// loading the library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		/*
		 * Instantiating classifier class 
		 */
		
		String xmlFile = "C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\xml\\face_detect.xml";
		CascadeClassifier classifier = new CascadeClassifier(xmlFile);
		
		/*
		 * Detect the faces 
		 */
		
		// reading the image
		String fpath = "C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\drawable\\blackpink.jpg";
		Mat matrix = Imgcodecs.imread(fpath);
		
		// MatOfRect is used to draw rectangles around the face
		MatOfRect faceDetections = new MatOfRect();
		classifier.detectMultiScale(matrix, faceDetections);
		
		System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
		
		// drawing the boxes
		for (Rect rect : faceDetections.toArray()) {			
			Point point1 = new Point(rect.x, rect.y);
			Point point2 = new Point(rect.x + rect.width, rect.y + rect.height);			
			Imgproc.rectangle(matrix, point1, point2, new Scalar(0,255,0), 3);
			
			// Adding Text
		      Imgproc.putText (
		         matrix,                          // Matrix obj of the image
		         String.format("Detected %s faces", faceDetections.toArray().length),          // Text to be added
		         new Point(10, 50),               // point
		         Font.ITALIC ,      // front face
		         1,                               // front scale
		         new Scalar(0, 255, 0),             // Scalar object for color
		         3                                // Thickness
		      );
		}
		
		System.out.println(matrix);		
		
		MatOfByte matOfByte = new MatOfByte();		
		Imgcodecs.imencode(".jpg", matrix, matOfByte);
		byte[] byteArray = matOfByte.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		
		try {
			BufferedImage img = ImageIO.read(in);
			JFrame frame = new JFrame();
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			frame.setVisible(true);
			frame.pack();
			frame.setTitle("OpenCV Face Detection by Jake SJK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String writePath = new String("C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\drawable\\\\saved.jpg");				
		Imgcodecs.imwrite(writePath, matrix);		
	}
}
