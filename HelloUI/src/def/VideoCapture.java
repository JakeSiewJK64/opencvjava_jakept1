package def;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class VideoCapture {
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String fpath = new String("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\raw\\lfd_ideo.mp4");
		
		if(!Paths.get(fpath).toFile().exists()) {
			System.out.println("File " + fpath + " does not exist!");
			return;
		}
		
		org.opencv.videoio.VideoCapture camera = new org.opencv.videoio.VideoCapture(fpath);
		
		if(!camera.isOpened()) {
			System.out.println("Error! Camera cannot be opened!");
			return;
		}
		
		Mat frame = new Mat();
		
		// define time variable
		long startTime = System.currentTimeMillis();
		System.out.println(String.format("Start time %s", startTime));
		
		while(true) {
			if(camera.read(frame)) {
				System.out.println("Frame obtained");
				System.out.println("Captured Frame Width: " + frame.width() + " \nHeight: " + frame.height());
				Imgcodecs.imwrite("camera.jpg", frame);
				System.out.println("OK!");
				break;				
			}
		}
		
		System.out.println(String.format("Elapsed Time: %s", System.currentTimeMillis() - startTime));
		
		BufferedImage bufferedImage = matToBufferedImage(frame);
		showWindow(bufferedImage);
		camera.release();
	}

	private static void showWindow(BufferedImage bufferedImage) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JLabel(new ImageIcon(bufferedImage)));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}

	private static BufferedImage matToBufferedImage(Mat frame) {
		// TODO Auto-generated method stub
		
		int type = 0;
		
		if(frame.channels() == 1) type = BufferedImage.TYPE_BYTE_GRAY;
		else if(frame.channels() == 3) type = BufferedImage.TYPE_3BYTE_BGR;
		
		BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
		WritableRaster raster = image.getRaster();
		
		DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
		
		byte[] data = dataBuffer.getData();
		
		frame.get(0, 0, data);
		
		return image;		
	}
}
