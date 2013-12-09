package ex12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest10D extends JFrame {
	DefaultListModel<String> listModel;
	JList<String> list;
	JTextField tf;
	JPanel pane;
	public static void main(String[] args) {
		JFrame w = new JListTest10D("JListTest10D");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 320);
		w.setVisible(true);
	}

	public JListTest10D(String title) {
		super(title);
		pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());

		JPanel headPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		pane.add(headPane, BorderLayout.PAGE_START);

		JButton addButton = new JButton("追加");
		JButton updButton = new JButton("変更");
		JButton remButton = new JButton("消去");
		ActionListener tal = new TextAddActionListener();
		addButton.addActionListener(tal);
		updButton.addActionListener(new TextUpdateActionListener());
		remButton.addActionListener(new TextRemoveActionListener());
		headPane.add(addButton);
		headPane.add(updButton);
		headPane.add(remButton);

		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.addListSelectionListener(new TextSetListSelectionListener());
		list.setBorder(new TitledBorder("項目一覧"));
		list.setAutoscrolls(true);

		tf = new JTextField();
		tf.setBorder(new TitledBorder("項目名"));
		tf.addActionListener(tal);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setViewportView(list);
		pane.add(scrollPane, BorderLayout.CENTER);
		pane.add(tf, BorderLayout.SOUTH);
	}

	class TextAddActionListener implements ActionListener  {
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

	class TextUpdateActionListener implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = tf.getText();
			if ("".equals(text))
				return;
			int i = list.getSelectedIndex();
			listModel.set(i, text);
		}
	}

	class TextRemoveActionListener implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = list.getSelectedIndex();
			String text = listModel.get(i);
			String msg[] = {text + "\nを消去します"};
			int ans = JOptionPane.showInternalConfirmDialog(pane, msg, "データの消去", JOptionPane.YES_NO_CANCEL_OPTION);
			if (ans != 0) return;
			listModel.removeElementAt(i);
		}
	}

	class TextSetListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO method

			tf.setText(list.getSelectedValue());
		}
	}
}

