package ex14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class AddressTable extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new AddressTable("プログラミング言語表[");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static String file_path = "ex14/data/";
	public static String file_name = "address.txt";

	AddressTable(String title) {
		super(title);
		JTable table = new JTable(new Table1Model());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		DefaultTableColumnModel tcm = (DefaultTableColumnModel) table.getColumnModel();
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll);
		setSize(750, 200);
		setVisible(true);
	}

	class Table1Model extends AbstractTableModel {
		String[] columnNames = "名前,住所,電話,メール".split(",");
		ArrayList<String[]> list = new ArrayList<String[]>();

		public Table1Model() {
			super();
			try {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(new File(file_path + file_name)));
				String line;
				while ((line = br.readLine()) != null) {
					String[] words = line.split(",");
					list.add(words);
					for (String w: words) System.out.println(w);
				}
			} catch (FileNotFoundException e) {
				System.out.println(file_path + file_name + "が見つかりません。");
			} catch (IOException e) {
				System.out.println(e);
			}
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return list.size();
		}

		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public Object getValueAt(int row, int col) {
			System.out.println(row + ":" + col);
			return list.get(row)[col];
		}

		@Override
		public Class getColumnClass(int col) {
			return getValueAt(0, col).getClass();
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			list.get(row)[column] = (String) value;
		}
	}

}
