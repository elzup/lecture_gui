package ex04;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout01D extends JFrame{
	static String DIR_IMG = "./gui/chap04/imgs/";
	public static void main(String[] args) {
		Layout01D w = new Layout01D("Layout01D" );
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(350, 200);
		w.setVisible(true);
	}

	public Layout01D (String title) {
		super(title);
		JPanel outPane = (JPanel)getContentPane();
		JButton bN = new JButton("North");
		JButton bS = new JButton("South");
		JButton bW = new JButton("West");
		JButton bE = new JButton("East");

		JPanel inPane = new JPanel();
		JButton bn = new JButton("north");
		JButton bs = new JButton("south");
		JButton bw = new JButton("west");
		JButton be = new JButton("east");
		JButton bc = new JButton("center");

//		inPane.setLayout(new FlowLayout());
		inPane.setLayout(new BorderLayout());
		inPane.add(bn, BorderLayout.NORTH);
		inPane.add(bs, BorderLayout.SOUTH);
		inPane.add(bc, BorderLayout.CENTER);
		inPane.add(bw, BorderLayout.WEST);
		inPane.add(be, BorderLayout.EAST);

		outPane.add(bN, BorderLayout.NORTH);
		outPane.add(bS, BorderLayout.SOUTH);
		outPane.add(inPane, BorderLayout.CENTER);
		outPane.add(bW, BorderLayout.WEST);
		outPane.add(bE, BorderLayout.EAST);
	}
}
