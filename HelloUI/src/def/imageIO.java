package def;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageIO {

	public static void main(String[] args) {
		// input file
		
		File input = new File("C:\\Users\\Shirley\\eclipse-workspace\\HelloUI\\src\\drawable\\profile.jpg");
		
		try {
			// reading the file
			BufferedImage image = ImageIO.read(input);
			
			// saving the image with a different name
			File output = new File("C:\\\\Users\\\\Shirley\\\\eclipse-workspace\\\\HelloUI\\\\src\\\\saved.jpg");
			ImageIO.write(image, "jpg", output);
			System.out.println("Image Saved");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(input);
	}
}
