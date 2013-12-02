package chap03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout02 extends JFrame implements ActionListener{

	public static void main(String...args) {

		Layout02 w = new Layout02("Layout02") ;
		w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		w.setSize(250, 300);
		w.setVisible(true);
	}

	public Layout02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new FlowLayout() );

		for(int i = 0 ; i < 16; i++) {
			pane.add(new JButton( Integer.toString(i)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
