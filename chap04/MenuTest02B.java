package chap04;

import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class MenuTest02B extends JFrame {

	public static void main(String[] args) {
		MenuTest02B w = new MenuTest02B("MenuTest02B");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(500, 250);
		w.setVisible(true);
	}

	ButtonGroup bg1;

	public static String DEF_CEP = "___";

	public MenuTest02B(String title) {
		super(title);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		String[][] fileContents = {
				{ "ファイル(F)", "file" },
				{ "編集(E)", "edit" },
				{ "表示(V)", "view" },
				{ "履歴(S)", "story" },
				{ "ブックマーク(B)", "book" },
				{ "ツール(T)", "tool" },
				{ "ヘルプ(H)", "help"}
		};
		HashMap<String, JMenu> menuMap = new HashMap<String, JMenu>();
		for(String[] s : fileContents) {
			JMenu jm = new JMenu(s[0]);
			menuMap.put(s[1], jm);
			menuBar.add(jm);
		}

		JMenuItem item;

		String[] contents = {
				"新しいウィンドウ(N)",
				"新しいタブ(T)",
				"URLを開く(L)",
				"ファイルを開く(O)",
				"ウィンドウを閉じる",
				"タブを閉じる(C)",
				DEF_CEP,
				"名前をつけてページを保存(A)",
				"ページをPDFで保存(F)",
				"ページのURLをメールで送信(E)",
				DEF_CEP,
				"ページ設定(O)",
				"印刷プレビュー(V)",
				"印刷(P)...",
				DEF_CEP,
				"設定とデータのインポート(I)...",
				DEF_CEP,
				"オフライン作業(W)",
				"終了(Q)"
		};

		for (String s : contents) {
			if (s == DEF_CEP) {
				menuMap.get("file").addSeparator();
				continue;
			} else {
				item = new JMenuItem(s);
				item.setHorizontalTextPosition(SwingConstants.CENTER);
				menuMap.get("file").add(item);
			}
		}
	}
}
