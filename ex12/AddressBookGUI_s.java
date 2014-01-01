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

public class AddressBookGUI_s extends JFrame {
	JTextField nameField, addressField, telField, emailField;
	DefaultListModel model;
	JList list;
	JButton addButton, removeButton, updateButton;
	JPanel pane;
	AddressBook book;
	static String FILE_EXTENTION = "txt";

	public static void main(String[] args) {
		JFrame w = new AddressBookGUI_s("AddressBookGUI");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(400, 400);
		w.setVisible(true);
	}

	public AddressBookGUI_s(String title) {
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
			String name = (String)list.getSelectedValue();
			if (name == null) return ;
			Address address = book.findName(name);
			nameField.setText(name);
			addressField.setText(address.getAddress());
			emailField.setText(address.getEmail());
			telField.setText(address.getTel());
		}
	}

	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
			putValue(Action.SHORT_DESCRIPTION, "開く");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(".");

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle("アドレス選択");
			fileChooser.setFileFilter(new TextFileFilter()); // フィルタを設定

			int ret = fileChooser.showOpenDialog(pane);

			if (ret != JFileChooser.APPROVE_OPTION)
				return;
			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			book.open(filename);

			DefaultListModel model = (DefaultListModel) list.getModel();
			model.clear();
			for (String key : book.getNames()) {
				model.addElement(key);
			}
		}
	}

	class TextFileFilter extends FileFilter {
		String[] extensions = { FILE_EXTENTION }; // 拡張子を指定
		String description = "text file";

		public boolean accept(File f) { // 受け入れるファイルかどうかチェック
			if (f.isDirectory())
				return true; // これを行わないと他のディレクトリーに移れない
			String name = f.getName().toLowerCase();
			for (int i = 0; i < extensions.length; i++) {
				if (name.endsWith(extensions[i])) {
					return true;
				}
			}
			return false;
		}

		public String getDescription() {
			return description;
		}
	}


	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(Action.NAME, "保存");
			putValue(Action.SHORT_DESCRIPTION, "保存");
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(".");

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle("保存ファイル選択");
			fileChooser.setFileFilter(new TextFileFilter()); // フィルタを設定

			int ret = fileChooser.showSaveDialog(pane);

			System.out.println(ret + ":");
			if (ret != JFileChooser.APPROVE_OPTION)
				return;
			String filename = fileChooser.getSelectedFile().getAbsolutePath();
			if (!filename.endsWith("."+FILE_EXTENTION))
				filename += "."+FILE_EXTENTION;
			book.save(filename);
		}
	}

	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
			putValue(Action.SHORT_DESCRIPTION, "終了");
		}

		public void actionPerformed(ActionEvent e) {
			int anser = JOptionPane.showConfirmDialog(pane, "終了しますか？", "メッセージ", JOptionPane.YES_NO_OPTION);
			if (anser != JOptionPane.OK_OPTION) {
				return;
			}
			System.exit(0);
		}
	}

	class AddAction extends AbstractAction {
		AddAction() {
			putValue(Action.NAME, "追加");
			putValue(Action.SHORT_DESCRIPTION, "追加");
		}

		public void actionPerformed(ActionEvent e) {
			String na = nameField.getText();
			String ad = addressField.getText();
			String te = telField.getText();
			String em = emailField.getText();

			if(("".equals(na)||"".equals(ad)||"".equals(te)||"".equals(em))||book.getNames().contains(na)){
				return;
			}
			book.add(new Address(na, ad, te, em));
			DefaultListModel model = (DefaultListModel) list.getModel();
						model.addElement(na);

		}
	}

	class UpdateAction extends AbstractAction {
		UpdateAction() {
			putValue(Action.NAME, "更新");
			putValue(Action.SHORT_DESCRIPTION, "更新");
		}

		public void actionPerformed(ActionEvent e) {
			String na = nameField.getText();
			String ad = addressField.getText();
			String te = telField.getText();
			String em = emailField.getText();
			if((na==null||ad==null||te==null||em==null)||!book.getNames().contains(na)){
				return;
			}
			Address address =book.findName(na);
			address.setAddress(ad);
			address.setEmail(em);
			address.setTel(te);
		}
	}

	class RemoveAction extends AbstractAction {
		RemoveAction() {
			putValue(Action.NAME, "削除");
			putValue(Action.SHORT_DESCRIPTION, "削除");
		}

		public void actionPerformed(ActionEvent e) {
			DefaultListModel model = (DefaultListModel) list.getModel();

			int index =  list.getSelectedIndex();
			if(index==-1){
				return;
			}
			int anser = JOptionPane.showConfirmDialog(pane,"削除しますか？","メッセージ",JOptionPane.YES_NO_OPTION);
			if(anser!=JOptionPane.OK_OPTION){
				return;
			}
			book.remove(book.findName((String)list.getSelectedValue()));
			list.setSelectedIndex(-1);
			model.remove(index);
//			getContentPane().setVisible(false);
//			getContentPane().setVisible(true);
			pane.setVisible(false);
			pane.setVisible(true);
			//model.setSize(model.getSize());
		}
	}
}