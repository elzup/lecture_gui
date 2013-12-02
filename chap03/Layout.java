package chap03;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout extends JFrame {
	public static void main(String... args) {
		Layout w = new Layout("Layout");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(350, 200);
		w.setVisible(true);
	}


	public Layout( String title) {
		super(title);

		JPanel pane = (JPanel)getContentPane();

		JButton buttonNorth = new JButton( "North" );
		buttonNorth.setPreferredSize(new Dimension(1000, 40));
		pane.add(buttonNorth, BorderLayout.NORTH);
		JButton buttonCenter = new JButton( "Center" );
		pane.add(buttonCenter, BorderLayout.CENTER);
		JButton buttonSouth = new JButton( "South" );
		pane.add(buttonSouth, BorderLayout.SOUTH);
		JButton buttonWest = new JButton( "West" );
		pane.add(buttonWest, BorderLayout.WEST);
		JButton buttonEast = new JButton( "East" );
		pane.add(buttonEast, BorderLayout.EAST);

	}
}
