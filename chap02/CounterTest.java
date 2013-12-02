package chap02;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CounterTest extends Frame implements ActionListener {
	Button aButton;
	int count = 0;

	CounterTest() {
		setSize(200, 100);
		aButton.addActionListener(this);
		add(aButton);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}


	public void actionPerformed(ActionEvent ae) {
		String countString;
		count =  count + 1;
		countString = Integer.toString(count);
		aButton.setLabel(countString);
	}

	public static void main(String...arg) {
		CounterTest myCounterTestFrame = new CounterTest();
		myCounterTestFrame.setVisible(true);
	}
}
