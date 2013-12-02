package ex05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionTest02C extends JFrame {

	public static int val;

	public static void main(String[] args) {
		ActionTest02C w = new ActionTest02C("ActionTest02C");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 200);
		w.setVisible(true);
		val = 0;
		System.out.println("Value (initialize): " + val);
	}

	public ActionTest02C(String title) {
		super(title);
		JButton button = new JButton(new Action02());
		getContentPane().add(button, BorderLayout.NORTH);
	}

	class Action02 extends AbstractAction {
		Action02() {
			putValue(Action.NAME, "Increment");
			putValue(Action.SHORT_DESCRIPTION, "インクリメント");
		}

		public void actionPerformed(ActionEvent e) {
			val++;
			System.out.println("Value: " + val);
		}
	}
}
