package chap03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class JFrame11 extends JFrame{
	JPanel contentPane;
	public static void main(String...args) {
		new JFrame11("JFrame11");
	}


	public JFrame11(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);


		setSize(400, 300);
		setVisible(true);
	}


}
