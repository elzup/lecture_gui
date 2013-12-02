package ex08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

public class MouseEventTest04E extends JFrame {
	Point startPoint = new Point(-1, -1);
	Point endPoint = new Point(-1, -1);
	Point previouPoint = new Point(-1, -1);
	TestPanel testPanel;
	Dimension dim = null;
	Image buffer = null;
	Graphics bufferContext = null;

	public static void main(String...args) {
		MouseEventTest04E w = new MouseEventTest04E("MouseEventTEst04E");
		w.setBackground(Color.white);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(350, 250);
		w.setVisible(true);
	}

	public MouseEventTest04E(String title) {
		super(title);
		testPanel = new TestPanel();
		testPanel.addMouseListener(new MouseCheck());
		getContentPane().add(testPanel);
	}

	class TestPanel extends JPanel {
		public void paintComponent(Graphics g) {
			if (buffer == null) {
				dim = getSize();
				buffer = createImage(dim.width, dim.height);
				bufferContext = buffer.getGraphics();
			}
			bufferContext.setColor(Color.black);
			bufferContext.drawLine(startPoint.x,  startPoint.y,  endPoint.x,  endPoint.y);
			g.drawImage(buffer,  0,  0,  this);
		}
	}
	class MouseCheck extends MouseInputAdapter {
		@Override
		public void mousePressed( MouseEvent e) {
			startPoint = e.getPoint();
			previouPoint = startPoint;
			Graphics g = testPanel.getGraphics();
			g.setXORMode(Color.yellow);
			g.setColor(Color.blue);
			g.drawOval(e.getX(), e.getY(), 20, 20);
		}
		@Override
		public void mouseReleased( MouseEvent e) {
			endPoint = e.getPoint();
			testPanel.repaint();
			Graphics g = testPanel.getGraphics();
			g.setXORMode(Color.yellow);
			g.setColor(Color.yellow);
			g.drawOval(e.getX(), e.getY(), 20, 20);
		}
		@Override
		public void mouseDragged( MouseEvent e) {
			Point currentPoint = e.getPoint();
			Graphics g = testPanel.getGraphics();
			g.setXORMode(Color.yellow);
			g.drawLine(startPoint.x, startPoint.y, previouPoint.x, previouPoint.y);
			g.drawLine(startPoint.x, startPoint.y, currentPoint.x, currentPoint.y);
		}
		@Override
		public void mouseExited( MouseEvent e) {
			testPanel.setBorder(new CompoundBorder(
					new LineBorder(Color.red, 5),
					new BevelBorder(BevelBorder.RAISED)));
		}
		@Override
		public void mouseEntered( MouseEvent e) {
			testPanel.setBorder(new CompoundBorder(
					new LineBorder(Color.green, 5),
					new BevelBorder(BevelBorder.RAISED)));
		}
	}
}
