package ex11;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldTest7 extends JFrame {

	public static void main(String[] args) {
		JFrame w = new JTextFieldTest7("JTextFieldTest7");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(200, 240);
		w.setVisible(true);
	}

	public JTextFieldTest7(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JTextField tf1 = new JTextField();
		tf1.setBorder(new TitledBorder("copy source"));
		pane.add(tf1);

		JTextField tf2 = new JTextField();
		tf2.setBorder(new TitledBorder("paste target"));
		pane.add(tf2);
	}
}
