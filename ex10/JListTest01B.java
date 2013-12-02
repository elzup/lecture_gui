
package ex10;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class JListTest01B extends JFrame {

	public static void main(String[] args) {
		JListTest01B w = new JListTest01B("JListTest01B");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 320);
		w.setVisible(true);
	}

	public JListTest01B(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();

		String[] choice = (new String("apple,base,cup,deepGreen,emeraldGreen,file,google,hop,io,joy,kick")).split(",");
		JList list = new JList(choice);

		pane.add(list, BorderLayout.CENTER);
	}
}
