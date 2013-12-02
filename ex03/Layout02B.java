package ex03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout02B extends JFrame {

	public static void main(String...args) {

		Layout02B w = new Layout02B("Layout02B") ;
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		w.setSize(250, 300);
		w.setVisible(true);
	}

	public Layout02B(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new FlowLayout() );

		for(int i = 0 ; i < 50; i++) {
			pane.add(new JButton( Integer.toString(i)));
		}
	}
}
