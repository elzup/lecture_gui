package ex08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ActionTest01B extends JFrame {
	int val = 0;

	int win_pos_x = 0;
	int win_pos_y = 0;

	TestPanel testPanel; // 作成したパネルを入れる
	Timer timer; // タイマーを入れる

	static int W = 400;
	static int H = 300;

	public static void main(String[] args) {
		ActionTest01B w = new ActionTest01B("ActionTest01B");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(W, H);
		w.setVisible(true);
	}

	public void update(int wx, int wy, int w, int h) {
		this.setBounds(wx, wy, w, h);

	}
	public ActionTest01B(String title) {
		super(title);
		JPanel panel = (JPanel) getContentPane();
		testPanel = new TestPanel(); // 描画用パネルの生成
		panel.add(testPanel);
		timer = new Timer(100, new Tick()); // タイマを生成
		timer.start(); // タイマ起動
	}

	class TestPanel extends JPanel {
		public void paintComponent(Graphics g) { // ここに描画したい内容を書く
			super.paintComponent(g); // 背景を再描画する
			g.setColor(Color.red);
			g.fillRect(0, 0, W, val); // 塗りつぶしの矩形を描く
		}
	}

	class Tick extends AbstractAction {
		public void actionPerformed(ActionEvent e) { // 一定時間ごとに呼び出される
			win_pos_x = (win_pos_x + 10) % 300;
			win_pos_y = (win_pos_y - 10) % 300;
			val = (val + 10) % W;
			testPanel.repaint(); // 再描画
		}
	}
}