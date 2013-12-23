package ex12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

public class EJDicGUI extends JFrame {
	JTextField english, japanese;
	JList<String> list;
	JButton addButton, removeButton, updateButton;
	JPanel pane;
	EJDic dictionary;

	static String DIR =  "ex12/data/";

	public static void main(String[] args) {
		JFrame w = new EJDicGUI("EJDicGUI");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(300, 300);
		w.setVisible(true);
	}

	public EJDicGUI(String title) {
		super(title);
		dictionary = new EJDic();
		pane = (JPanel) getContentPane();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("ファイル");
		menuBar.add(fileMenu);
		JMenuItem item;
		item = new JMenuItem(new OpenAction());
		fileMenu.add(item);
		item = new JMenuItem(new SaveAction());
		fileMenu.add(item);
		fileMenu.addSeparator();
		item = new JMenuItem(new ExitAction());
		fileMenu.add(item);

		JPanel fields = new JPanel(new GridLayout(1, 2));
		english = new JTextField();
		english.setBorder(new TitledBorder("英語"));
		fields.add(english);
		japanese = new JTextField();
		japanese.setBorder(new TitledBorder("日本語"));
		fields.add(japanese);
		pane.add(fields, BorderLayout.SOUTH);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.addListSelectionListener(new WordSelect());
		JScrollPane sc = new JScrollPane(list);
		sc.setBorder(new TitledBorder("項目一覧"));
		pane.add(sc, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 3));
		addButton = new JButton(new AddAction());
		buttons.add(addButton);
		updateButton = new JButton(new UpdateAction());
		buttons.add(updateButton);
		removeButton = new JButton(new RemoveAction());
		buttons.add(removeButton);
		pane.add(buttons, BorderLayout.NORTH);
	}

	class WordSelect implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {

		}
	}

	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
			putValue(Action.SHORT_DESCRIPTION, "開く");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(DIR);

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle("ファイルを開く");
			fileChooser.setFileFilter(new TextFileFilter());

			int ret = fileChooser.showOpenDialog(pane);

			if (ret != JFileChooser.APPROVE_OPTION) return;

			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			dictionary.open(filename);
			DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
			for (String key : dictionary.keySet())
				model.addElement(key);
		}
	}

	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(Action.NAME, "保存");
			putValue(Action.SHORT_DESCRIPTION, "保存");
		}

		public void actionPerformed(ActionEvent e) {
			//ここから作る
			JFileChooser fileChooser = new JFileChooser(DIR);

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle("ファイルを保存する");
			fileChooser.setFileFilter(new TextFileFilter());

			int ret = fileChooser.showSaveDialog(pane);

			if (ret != JFileChooser.APPROVE_OPTION) return;

			String filename = fileChooser.getSelectedFile().getAbsolutePath();

			System.out.println(":" + filename);
			dictionary.save("");
		}
	}

	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
			putValue(Action.SHORT_DESCRIPTION, "終了");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	class AddAction extends AbstractAction {
		AddAction() {
			putValue(Action.NAME, "追加");
			putValue(Action.SHORT_DESCRIPTION, "追加");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	class UpdateAction extends AbstractAction {
		UpdateAction() {
			putValue(Action.NAME, "更新");
			putValue(Action.SHORT_DESCRIPTION, "更新");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	class RemoveAction extends AbstractAction {
		RemoveAction() {
			putValue(Action.NAME, "削除");
			putValue(Action.SHORT_DESCRIPTION, "削除");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	class TextFileFilter extends FileFilter {
		String[] extensions = {"txt"};
		String description = "image file";
		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) return true;
			String name = f.getName().toLowerCase();
			for (int i = 0; i < extensions.length; i++) {
				if (name.endsWith(extensions[i])) {
					return true;
				}
			}
			return false;
		}
		@Override
		public String getDescription() {
			return this.description;
		}
	}
}
