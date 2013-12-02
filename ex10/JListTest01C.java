package ex10;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest01C extends JFrame {
	public static void main(String[] args) {
		JListTest01C w = new JListTest01C("JListTest01C");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(240, 200);
		w.setVisible(true);
	}

	public JListTest01C(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();

		String[] choice = (new String("apple,base,cup,deepGreen,emeraldGreen,file,google,hop,io,joy,kick")).split(",");
		JList list = new JList(choice);
		list.addListSelectionListener(new MyListSelect()); // リスナの設定
		pane.add(new JScrollPane(list), BorderLayout.CENTER);
		list.setBorder(new LineBorder(Color.black, 2));
	}

	class MyListSelect implements ListSelectionListener { // リスナの定義
		public void valueChanged(ListSelectionEvent e) { // 項目の変化イベントが起こると呼び出される
			JList li = (JList) e.getSource();
			if (e.getValueIsAdjusting() == false) { // 変更中のイベントか？
				String select = (String) li.getSelectedValue(); // 選択項目の値を得る
				System.out.printf("%sが選択されました\n", select);
			}
		}
	}
}
