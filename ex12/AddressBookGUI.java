package ex12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

public class AddressBookGUI extends JFrame {
	JTextField nameField, addressField, telField, emailField;
	DefaultListModel model;
	JList list;
	JButton addButton, removeButton, updateButton;
	JPanel pane;
	AddressBook book;

	static String DIR = "ex12/data/";

	public static void main(String[] args) {
		JFrame w = new AddressBookGUI("AddressBookGUI");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 300);
		w.setVisible(true);
	}

	public AddressBookGUI(String title) {
		super(title);
		book = new AddressBook();
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

		model = new DefaultListModel();
		list = new JList(model);
		list.addListSelectionListener(new NameSelect());
		JScrollPane sc = new JScrollPane(list);
		sc.setBorder(new TitledBorder("名前一覧"));
		pane.add(sc, BorderLayout.CENTER);

		JPanel fields = new JPanel();
		fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
		nameField = new JTextField(20);
		nameField.setBorder(new TitledBorder("名前"));
		fields.add(nameField);
		addressField = new JTextField(20);
		addressField.setBorder(new TitledBorder("住所"));
		fields.add(addressField);
		telField = new JTextField(20);
		telField.setBorder(new TitledBorder("電話"));
		fields.add(telField);
		emailField = new JTextField(20);
		emailField.setBorder(new TitledBorder("メール"));
		fields.add(emailField);

		addButton = new JButton(new AddAction());
		fields.add(addButton);
		updateButton = new JButton(new UpdateAction());
		fields.add(updateButton);
		removeButton = new JButton(new RemoveAction());
		fields.add(removeButton);

		pane.add(fields, BorderLayout.EAST);
	}

	class NameSelect implements ListSelectionListener {
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
			if (ret != JFileChooser.APPROVE_OPTION)
				return;
			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			book.open(filename);
			DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
			model.clear();
			for (String name : book.getNames())
				model.addElement(name);
		}
	}

	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(Action.NAME, "保存");
			putValue(Action.SHORT_DESCRIPTION, "保存");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(DIR);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle("ファイルを保存する");
			fileChooser.setFileFilter(new TextFileFilter());
			int ret = fileChooser.showSaveDialog(pane);
			if (ret != JFileChooser.APPROVE_OPTION)
				return;
			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			if (!filename.endsWith(".txt"))
				filename += ".txt";
			book.save(filename);
		}
	}

	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
			putValue(Action.SHORT_DESCRIPTION, "終了");
		}

		public void actionPerformed(ActionEvent e) {
			Object[] msg = { "アプリケーションを終了してよろしいですか？" };
			int ans = (int) JOptionPane.showConfirmDialog(pane, msg, "確認", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.YES_OPTION == ans) {
				System.exit(0);
			}
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
		String[] extensions = { "txt" };
		String description = "テキストファイル *.txt";
		@Override
		public boolean accept(File f) {
			if (f.isDirectory())
				return true;
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
