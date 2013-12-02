package ex11;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldTest6 extends JFrame {

	JTextField tf1, tf2, tfa;
	JButton buA, buS, buM, buD;

	public static void main(String[] args) {
		JFrame w = new JTextFieldTest6("JTextFieldTest6");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 300);
		w.setVisible(true);
	}

	public JTextFieldTest6(String title) {
		super(title);
		JPanel pane = (JPanel) getContentPane();
		pane.setLayout(new BorderLayout());


		tf1 = new JTextField(10);
		tf1.setBorder(new TitledBorder("整数1"));
		tf1.setDocument(new NumericDocument());
		pane.add(tf1, BorderLayout.WEST);

		tf2 = new JTextField(10);
		tf2.setBorder(new TitledBorder("整数2"));
		tf2.setDocument(new NumericDocument());
		pane.add(tf2, BorderLayout.EAST);

		tfa = new JTextField(10);
		tfa.setBorder(new TitledBorder("答え"));
		//		tfa.setDocument(new NumericDocument());
		pane.add(tfa, BorderLayout.SOUTH);

		//inner
		JPanel paneInner = new JPanel();
		//		paneInner.setLayout(new BorderLayout());
		paneInner.setLayout(new GridLayout(4, 1));
		buA = new JButton("+");
		buS = new JButton("-");
		buM = new JButton("*");
		buD = new JButton("/");
		buA.addActionListener(new CalcActionAdd());
		buS.addActionListener(new CalcActionSubtraction());
		buM.addActionListener(new CalcActionMultiplication());
		buD.addActionListener(new CalcActionDivision());
		paneInner.add(buA);
		paneInner.add(buS);
		paneInner.add(buM);
		paneInner.add(buD);
		//		paneInner.setMaximumSize(new Dimension(100, 100));
		//buttons

		pane.add(paneInner, BorderLayout.CENTER);
	}

	class NumericDocument extends PlainDocument { // PlainDocument を拡張して定義
		String validValues = "0123456789.+-";

		@Override
		public void insertString(int offset, String str, AttributeSet a) {
			if (validValues.indexOf(str) == -1) { // 有効文字でないか？
				return;
			}
			try {
				super.insertString(offset, str, a); // スーパクラスのメソッドを呼び出し
			} catch (BadLocationException e) {
				System.out.println(e);
			}
		}
	}

	class FieldAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		public FieldAction() {
			// TODO Constracter
		}
	}

	class CalcAction implements ActionListener {

		//割と必要なくなってしまった。
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO method
		}
	}

	class CalcActionAdd extends CalcAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("".equals(tf1.getText()) || "".equals(tf2.getText())) {
				tfa.setText("数字がセットされていません");
				return;
			}
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			tfa.setText(String.valueOf(num1 + num2));
		}
	}

	class CalcActionSubtraction extends CalcAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("".equals(tf1.getText()) || "".equals(tf2.getText())) {
				tfa.setText("数字がセットされていません");
				return;
			}
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			tfa.setText(String.valueOf(num1 - num2));
		}
	}

	class CalcActionMultiplication extends CalcAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("".equals(tf1.getText()) || "".equals(tf2.getText())) {
				tfa.setText("数字がセットされていません");
				return;
			}
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			//			System.out.println(num1 * num2 );
			tfa.setText(String.valueOf(num1 * num2));
		}
	}

	class CalcActionDivision extends CalcAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if ("".equals(tf1.getText()) || "".equals(tf2.getText())) {
				tfa.setText("数字がセットされていません");
				return;
			}
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			tfa.setText(String.valueOf((num2 != 0) ? num1 / num2 : "0で割れません"));
		}
	}
}
