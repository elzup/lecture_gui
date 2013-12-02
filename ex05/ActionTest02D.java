package ex05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionTest02D extends JFrame {

	public static int val;

	public static void main(String[] args) {
		ActionTest02D w = new ActionTest02D("ActionTest02D");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 200);
		w.setVisible(true);
		val = 0;
		System.out.println("Value (initialize): " + val);
	}

	public ActionTest02D(String title) {
		super(title);
		JButton buttonI = new JButton(new Action02("Increment", "1増やす", 1));
		JButton buttonD = new JButton(new Action02("Decremenet", "1減らす", -1));
		getContentPane().add(buttonI, BorderLayout.NORTH);
		getContentPane().add(buttonD, BorderLayout.SOUTH);
	}

	class Action02 extends AbstractAction {
		int add;
		Action02(String name, String desc, int add) {
			this.add = add;
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, desc);
		}

		public void actionPerformed(ActionEvent e) {
			val += add;
			System.out.printf("Value: %2d" , val);
			for(int i = -10; i < 10; i++) {
				System.out.print((i == 0) ? "|" : (i < 0) ? ((i < val)? " " : "l") : (i <= val) ? "l" : " ");
			}
			System.out.println();
		}
	}
}

