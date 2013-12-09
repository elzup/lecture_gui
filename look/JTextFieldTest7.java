package look;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldTest7 extends JFrame{
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	ActionListener actionListener = new ActionTest();
	
	public static void main(String[] args) {
		JTextFieldTest7 w = new JTextFieldTest7("JTextFieldTest7");
		w.setSize(300,300);
		w.setVisible(true);
	}
	public JTextFieldTest7(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BorderLayout());
		TitledBorder tb = new TitledBorder("項目一覧");
		tf1.setBorder(tb);
		pane.add(tf1, BorderLayout.CENTER);
		tf1.addActionListener(actionListener);
		
		tf2.setBorder(new TitledBorder("項目入力"));
		pane.add(tf2, BorderLayout.SOUTH);
		tf2.addActionListener(actionListener);
		
		JScrollPane scr = new JScrollPane(tf1); // スクロールできるようにする
	    scr.setViewportView(tf1);
	    getContentPane().add(scr, BorderLayout.CENTER);
	}
	class ActionTest implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tf2.getText();
		      JTextField source = (JTextField)e.getSource();
		      String string = source.getText();
		      if( source == tf2 ){
		        tf2.setText(null);
		        tf1.setText(string);
		      }
		}
	}
}
