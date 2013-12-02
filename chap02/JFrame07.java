package chap02;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class JFrame07 extends JFrame{
	public static void main(String...arg) throws InterruptedException {
		JFrame07 jf = new JFrame07("JFrame07");
		for(int i = 0; i < 1000; i++) {
			Thread.sleep(10);
			jf.setBounds(i, 100, 400-(i/5), 400-(i/5));
		}
	}

	public JFrame07(String title) throws InterruptedException {
		super (title) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowEventHandler());
		setSize(500,300);
		System.out.println("ウィンドウの準備が出来ました。");
		setVisible(true);
		System.out.println("ウィンドウの表示が音になりました");
		setVisible(false);
		setVisible(true);

	}

	class WindowEventHandler implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			System.out.println("1");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("2");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("3");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("4");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("5");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("6");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("7");
		}


	}

}
