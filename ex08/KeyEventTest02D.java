package ex08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest02D extends JFrame {
	int currentX = 200, currentY = 150; // 現在の座標を保持する
	TestPanel testPanel; // 作成したパネルを入れる

	public static void main(String[] args) {
		KeyEventTest02D w = new KeyEventTest02D("KeyEventTest02D");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 300);
		w.setVisible(true);
	}

	public static Map<Color, String> col_words;

	//	"black,BLACK,blue,BLUE,cyan,CYAN,DARK_GRAY,darkGray,gray,GRAY,green,GREEN,LIGHT_GRAY,lightGray,magenta,MAGENTA,orange,ORANGE,pink,PINK,red,RED,white,WHITE,yellow,YELLOW".split(",");
	public KeyEventTest02D(String title) {
		super(title);
		JPanel panel = (JPanel) getContentPane();

		testPanel = new TestPanel(); // 描画用パネルの生成
		testPanel.setFocusable(true); // パネルでキーボード入力を扱う場合に必要
		testPanel.addKeyListener(new KeyTest()); // リスナの設定

		panel.add(testPanel);

		col_words = new HashMap<Color, String>();
		col_words.put(Color.black, "black");
		col_words.put(Color.blue, "blue");
		col_words.put(Color.cyan, "cyan");
		col_words.put(Color.gray, "gray");
		col_words.put(Color.green, "green");
		col_words.put(Color.magenta, "magenta");
		col_words.put(Color.orange, "orange");
		col_words.put(Color.pink, "pink");
		col_words.put(Color.red, "red");
		col_words.put(Color.white, "white");
		col_words.put(Color.yellow, "yellow");
	}

	class TestPanel extends JPanel { // 独自のパネルを定義
		public void paintComponent(Graphics g) { // ここに描画したい内容を書く
			// super.paintComponent(g); // 背景を再描画するかどうか
			g.setColor(col);
			g.fillRect(currentX, currentY, 10, 10); // 塗りつぶしの矩形を描く
		}
	}

	public Color col = Color.red;
	public String stack = "";

	class KeyTest extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();

			stack += e.getKeyChar();
			System.out.println(stack);
			for (Map.Entry<Color, String> ele: col_words.entrySet()) {
				String cw = ele.getValue();
				int l = stack.length() - cw.length();
				if (l >= 0 && cw.equals(stack.substring(l))) {
					col = ele.getKey();
				}
			}
			if (stack.length() > 10) stack = stack.substring(1);

			switch (keyCode) { // キーによって
			case KeyEvent.VK_UP: // ↑
				currentY -= 2;
				break;
			case KeyEvent.VK_DOWN: // ↓
				currentY += 2;
				break;
			case KeyEvent.VK_LEFT: // ←
				currentX -= 2;
				break;
			case KeyEvent.VK_RIGHT: // →
				currentX += 2;
				break;
			default:
				break;
			}

			e.getKeyChar();

			testPanel.repaint(); // パネルを再描画
		}
	}
}
