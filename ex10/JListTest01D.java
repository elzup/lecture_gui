package ex10;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest01D extends JFrame {
	JPanel pane;

	public static void main(String[] args) {
		JListTest01D w = new JListTest01D("JListTest01D");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(240, 200);
		w.setVisible(true);
	}

	public JListTest01D(String title) {
		super(title);
		pane = (JPanel) getContentPane();

		String[] choice = (new String("apple,base,cup,deepGreen,emeraldGreen,file,google,hop,io,joy,kick")).split(",");

		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < choice.length; i++) {
			listModel.addElement(choice[i]);
		}

		JList list = new JList(listModel);
		list.addListSelectionListener(new MyListSelect());

		pane.add(new JScrollPane(list), BorderLayout.CENTER);
	}

	class MyListSelect implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {

			JList list = (JList) e.getSource();
			if (e.getValueIsAdjusting() == false) {
				DefaultListModel model = (DefaultListModel) list.getModel(); //***
				int index = list.getSelectedIndex();
				String select = (String) model.get(index);
				System.out.printf("%sが選択されました\n", select);
			}
		}
	}
}
