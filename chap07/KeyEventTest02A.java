package chap07;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyEventTest02A extends JFrame{

	public static void main(String...args) {

		KeyEventTest02A w = new KeyEventTest02A("KeyEvent") ;
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 120);
		w.setVisible(true);
	}

	public KeyEventTest02A(String title) {
		super(title);
		JPanel p = (JPanel)getContentPane();
		p.setLayout(new GridLayout(3, 2));

		JTextField tf1 = new JTextField();
		tf1. setName("TF1");
		JTextField tf2 = new JTextField();
		tf2. setName("TF2");
		JTextField tf3 = new JTextField();
		tf3. setName("TF3");

		tf1.addKeyListener( new KeyCheck());
		tf2.addKeyListener( new KeyCheck());
		tf3.addKeyListener( new KeyCheck());
		
		p.add(new JLabel("TF 1"));
		p.add(tf1);
		p.add(new JLabel("TF 2"));
		p.add(tf2);
		p.add(new JLabel("TF 3"));
		p.add(tf3);
	}
	
	class KeyCheck implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			JTextField com = (JTextField)e.getSource();
			System.out.println(com.getName());
			// TODO method
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO method
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO method
			
		}
	}
}
