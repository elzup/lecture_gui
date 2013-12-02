package chap04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabel01 extends JFrame{
	static String DIR_IMG = "./gui/chap04/imgs/";
	public static void main(String[] args) {
		ImageLabel01 w = new ImageLabel01("Imagelabel01" );
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(350, 250);
		w.setVisible(true);

	}

	public ImageLabel01 (String title) {
		super(title);
		JLabel panel = new JLabel(new ImageIcon(DIR_IMG + "stream.png"));
		getContentPane().add(panel);
	}

}
