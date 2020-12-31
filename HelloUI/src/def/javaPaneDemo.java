package def;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.DesktopPaneUI;

import javax.swing.JDesktopPane;

class CustomDesktopPane extends JDesktopPane {
	int numFrames = 3, x = 30, y = 30;
	public void display (CustomDesktopPane dp) {
		for(int i = 0; i < numFrames; ++i) {
			JInternalFrame jframe = new JInternalFrame("Internal Frame" + i, true, true, true, true);
			
			// x, y, width, height
			jframe.setBounds(x, y, 250, 85);
			
			// get container to store panes in a container
			Container contentPane = jframe.getContentPane();
			
			// add a new label
			contentPane.add(new JLabel("Arknights"));
			dp.add(jframe);
			jframe.setVisible(true);
			y += 85;
			
		}
	}
}

class JDPaneDemo extends JFrame {
	public JDPaneDemo() {
		CustomDesktopPane desktopPane = new CustomDesktopPane();
		Container container = getContentPane();
		container.add(desktopPane, BorderLayout.CENTER);
		desktopPane.display(desktopPane);
		
		setTitle("Example");
		setSize(300, 350);
		setVisible(true);
	}
}

public class javaPaneDemo {	
	
	public static void main(String[] args) {
		new JDPaneDemo();
	}
}
