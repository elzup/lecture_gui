package ex14;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddressTableKai extends JFrame {
	JTable table;
	TableModel tableModel;

	public static void main(String[] args) {
		JFrame frame = new AddressTableKai("プログラミング言語表[");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static String file_path = "ex14/data/";
	public static String file_name = "address.txt";

	AddressTableKai(String title) {
		super(title);

		tableModel = new TableModel();
		table = new JTable(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		DefaultTableColumnModel tcm = (DefaultTableColumnModel) table.getColumnModel();
		JScrollPane scroll = new JScrollPane(table);
		JPanel pane = (JPanel) this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(scroll, BorderLayout.CENTER);

		JPanel headPane = new JPanel (new GridLayout(1, 3));
		JButton buAdd   = new JButton("行の追加");
		JButton buRead  = new JButton("読み込み");
		JButton buWrite = new JButton("書き込み");
		buAdd.addActionListener(new AddActionListener());
		buRead.addActionListener(new ReadActionListener());
		buWrite.addActionListener(new WriteActionListener());
		headPane.add(buAdd);
		headPane.add(buRead);
		headPane.add(buWrite);

		pane.add(headPane, BorderLayout.PAGE_START);

		setSize(750, 200);
		setVisible(true);
	}

	class AddActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tableModel.addRow();
		}
	}

	class WriteActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tableModel.write();
		}
	}

	class ReadActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			tableModel.read();
		}
	}

	class TableModel extends DefaultTableModel {
		String[] columnNames = "名前,住所,電話,メール".split(",");
		ArrayList<String[]> list;
		public TableModel() {
			super();
			list = new ArrayList<String[]>();
		}

		public void read() {
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
			this.fireTableStructureChanged();
		}

		public void write() {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file_path + file_name)));
				for (String[] cells : list) {
					String line = cells[0];
					for (int i = 1; i < cells.length; i++)
						line += "," + cells[i];
					System.out.println(line);
					bw.write(line + "\n");
				}
				bw.close();
			} catch (FileNotFoundException e) {
				System.out.println(file_path + file_name + "が見つかりません。");
			} catch (IOException e) {
				System.out.println(e);
			}
		}

		public void addRow() {
			String[] n  = new String[list.get(0).length];
			for (int i = 0; i < n.length; i++)
				n[i] = "";
			this.addRow(n);
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			if (list == null) return 0;
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
			return true;
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			list.get(row)[column] = (String) value;
		}
	}

}
