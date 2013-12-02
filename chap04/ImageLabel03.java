package chap04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ImageLabel03 extends JFrame{
	static String DIR_IMG = "./gui/chap04/imgs/";
	public static void main(String[] args) {
		ImageLabel03 w = new ImageLabel03("Imagelabel03" );
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(250, 150);
		w.setVisible(true);
	}

	public ImageLabel03 (String title) {
		super(title);
		JPanel panel = (JPanel)getContentPane();
		panel.setLayout(new FlowLayout());

//		getContentPane().add(panel);

//		Icon icon = new DrawIcon();
		Icon icon = new ImageIcon("exit.gif");

		JLabel item;
		item = new JLabel("Default") ;
		item.setIcon(icon);
		item.setBorder(new LineBorder(Color.black));
		panel.add(item);

		item = new JLabel("Float left", icon, SwingConstants.LEFT);
		item.setPreferredSize(new Dimension(350, 50));
		item.setBorder(new LineBorder(Color.black));
		panel.add(item);

	    item = new JLabel( "中央", icon, SwingConstants.CENTER );
	    item.setPreferredSize( new Dimension(350, 50) );
	    item.setBorder( new LineBorder( Color.black) );
	    panel.add( item );

	    item = new JLabel( "右寄せ", icon, SwingConstants.RIGHT );
	    item.setPreferredSize( new Dimension(350, 50) );
	    item.setBorder( new LineBorder( Color.black) );
	    panel.add( item );

	    item = new JLabel( "LEADING", icon, SwingConstants.LEADING );
	    item.setPreferredSize( new Dimension(350, 50) );
	    item.setBorder( new LineBorder( Color.black) );
	    panel.add( item );

	    item = new JLabel( "TRAILING", icon, SwingConstants.TRAILING );
	    item.setPreferredSize( new Dimension(350, 50) );
	    item.setBorder( new LineBorder( Color.black) );
	    panel.add( item );

	    item = new JLabel( "左寄せ" );
	    item.setIcon( icon );
	    item.setHorizontalAlignment( SwingConstants.LEFT );
	    item.setPreferredSize( new Dimension(350, 50) );
	    item.setBorder( new LineBorder( Color.black) );
	    panel.add( item );
	}

	class DrawIcon implements Icon {
		static final int width = 20;
		static final int height = 20;

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
