package ex05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageButton02C extends JFrame {

	public static void main(String[] args) {
		ImageButton02C w = new ImageButton02C("ImageButton02C");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(200, 150);
		w.setVisible(true);
	}

	public ImageButton02C(String title) {
		super(title);

		JPanel pane = (JPanel) getContentPane();

		JButton item = new JButton();
		item.setIcon(new ShapeIcon());
		item.setPressedIcon(new ShapeIcon(Color.blue, ShapeIcon.SHAPE_OVALI));
		item.setRolloverIcon(new ShapeIcon(Color.green, ShapeIcon.SHAPE_OVALD));
		item.setRolloverEnabled(true);
		item.setToolTipText("Test");
		pane.add(item);

	}

	class ShapeIcon implements Icon {
		static final int width = 100;
		static final int height = 100;

		static final int SHAPE_OVAL = 0;
		static final int SHAPE_OVALD = 10;
		static final int SHAPE_OVALI = 20;
		static final int SHAPE_RECT = 1;
		static final int SHAPE_RECTC = 2;

		Color color;
		int shape;

		public ShapeIcon() {
			color = Color.white;
			shape = ShapeIcon.SHAPE_OVAL;
		}

		public ShapeIcon(Color c, int s) {
			color = c;
			shape = s;
		}

		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(this.color);
			switch (shape) {
			case ShapeIcon.SHAPE_OVAL:
				g.fillOval(x, y, width, height);
				break;
			case ShapeIcon.SHAPE_OVALD:
				g.drawOval(x, y, width, height);
				break;
			case ShapeIcon.SHAPE_OVALI:
				g.drawOval(x, y, width, height);
				g.fillOval(x + width / 6, y + height / 6, width * 2 / 3, height * 2 / 3);
				break;
			}
		}

		public int getIconWidth() {
			return this.width;
		}

		public int getIconHeight() {
			return this.height;
		}
	}

}
