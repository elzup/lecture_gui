package ex11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldTest3A extends JFrame{

	public static void main(String[] args) {
		JFrame w = new JTextFieldTest3A("JTextFieldTest3A");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(200, 240);
		w.setVisible(true);
	}

	public JTextFieldTest3A(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JTextField tf1 = new JTextField();
		tf1.setBorder(new TitledBorder("copy source"));
		pane.add(tf1);

		JTextField tf2 = new JTextField();
		tf2.setBorder(new TitledBorder("paste target"));
		pane.add(tf2);
		tf1.addActionListener(new CopyAction(tf2));
	}

	class CopyAction implements ActionListener {

		JTextField target;

		CopyAction(JTextField target) {
			this.target = target;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField source = (JTextField) e.getSource();
			String str = source.getText();
			source.setText("");
			target.setText(str);
		}
	}
}
