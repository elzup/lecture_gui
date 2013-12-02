package ex04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLabel02B extends JFrame {
	static String DIR_IMG = "./gui/chap04/imgs/";

	public static void main(String[] args) {
		ImageLabel02B w = new ImageLabel02B("Imagelabel01");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(250, 150);
		w.setVisible(true);

	}

	public ImageLabel02B(String title) {
		super(title);
		JLabel panel = new JLabel(new DrawIcon());
		getContentPane().add(panel);
	}

	public static class DrawIcon implements Icon {
		static final int width = 100;
		static final int height = 100;

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
						g.setColor(Color.blue);
						g.fillRect(x, y, width, height);

						g.setColor(new Color(150, 150, 255));
						g.fillRoundRect(x + width / 6, y + height / 6, width * 2 / 3, height * 2 / 3, width / 5, height / 5);

		}

		public void drawOvalStroke(Graphics g, int x, int y, int w, int h, int thin) {
			for (int i = 0; i < thin; i++) {
				g.drawOval(x + i, y + i, w - i * 2, h - i * 2);
			}
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