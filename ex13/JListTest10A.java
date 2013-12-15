package ex13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JListTest10A extends JFrame {
	DefaultListModel<String> listModel;
	JTextField tf;
	public static void main(String[] args) {
		JFrame w = new JListTest10A("JListTest10A");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 320);
		w.setVisible(true);
	}

	public JListTest10A(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());

		JPanel headPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		pane.add(headPane, BorderLayout.PAGE_START);

		JButton addButton = new JButton("追加する");
		ActionListener tal = new TextActionListener();
		addButton.addActionListener(tal);
		headPane.add(addButton);

		listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		list.setBorder(new TitledBorder("項目一覧"));
		list.setAutoscrolls(true);

		tf = new JTextField();
		tf.setBorder(new TitledBorder("項目入力"));
		tf.addActionListener(tal);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setViewportView(list);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(tf, BorderLayout.SOUTH);
	}

	class TextActionListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = tf.getText();
			if ("".equals(text))
				return;
//			System.out.println(text);
			tf.setText("");
			listModel.addElement(text);
		}
	}
}

