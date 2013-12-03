package ex11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldTest7 extends JFrame {
	DefaultListModel listModel;
	public static void main(String[] args) {
		JFrame w = new JTextFieldTest7("JTextFieldTest7");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 320);
		w.setVisible(true);
	}

	public JTextFieldTest7(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();
//		pane.setLayout(new GridLayout(2, 1));

		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.setBorder(new TitledBorder("項目一覧"));
		list.setAutoscrolls(true);

		JTextField tf = new JTextField();
		tf.setBorder(new TitledBorder("項目入力"));
		tf.addActionListener(new TextActionListener());

		JScrollPane scrollPane = new JScrollPane(list);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(tf, BorderLayout.SOUTH);

	}

	class TextActionListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField tf = (JTextField) e.getSource();
			String text = tf.getText();
			if ("".equals(text))
				return;
//			System.out.println(text);
			tf.setText("");
			listModel.addElement(text);
		}
	}
}

