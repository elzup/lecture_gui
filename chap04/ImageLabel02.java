package chap04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabel02 extends JFrame{
	static String DIR_IMG = "./gui/chap04/imgs/";
	public static void main(String[] args) {
		ImageLabel02 w = new ImageLabel02("Imagelabel01" );
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(250, 150);
		w.setVisible(true);

	}

	public ImageLabel02 (String title) {
		super(title);
		JLabel panel = new JLabel(new DrawIcon());
		getContentPane().add(panel);
	}

	public static class DrawIcon implements Icon {
		static final int width = 100;
		static final int height = 100;

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(Color.green);
			g.fillOval( x,  y,  width,  height );
		}
		@Override
		public int getIconWidth() {
			return this.width;
		}
		@Override
		public int getIconHeight() {
			// TODO 自動生成されたメソッド・スタブ
			return this.height;
		}
	}
}
