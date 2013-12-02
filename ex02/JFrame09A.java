package ex02;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrame09A {
	public static void main(String...args) {
		JFrame frame= new JFrame("JFrame09A");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height;
		frame.setBounds( 100, 100, 1000, 1000);
		frame.setMinimumSize(new Dimension(200, 400));
		frame.setMinimumSize(new Dimension(1111, 1111));
		frame.setVisible(true);
	}
}
