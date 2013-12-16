package ex14;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;

public class JTableExample extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JTableExample("プログラミング言語表[");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	JTableExample(String title) {
		super(title);
		JTable table = new JTable(new Table1Model());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableColumnModel tcm = (DefaultTableColumnModel)table.getColumnModel();
		int[] width = {50, 200, 40, 60, 200, 200};
		for (int i =0; i < width.length; i++) {
			tcm.getColumn(i).setMinWidth(width[i]);
		}
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll);
		setSize(750, 200);
		setVisible(true);
	}

	class Table1Model extends AbstractTableModel {
		String[] columnNames = "名前,パラダイム,登場,型付け,影響を受けた言語,影響を与えた言語".split(",");
		String[][] data = {
				"Fortran,手続き・構造化・命令・オブジェクト指向,1957,強い静的,,ALGOL・BASIC・PL/I・C".split(","),
				"COBOL,構造・命令・オブジェクト指向,1959,強い静的,FLOW-MATIC・COMTRAN,PL/I".split(","),
				"LISP,関数・手続き,1958,強い動的,,LOGO,Perl,Python,Ruby,C#".split(","),
				"C言語,手続き,1972,弱い静的,B言語・ALGOL・pascal,C++・Objectiv-c・D言語・Java".split(","),
				"Ruby,構造、命令、オブジェクト指向,1995,強い動的,Smalltalk・LISP・Perl,Groovy".split(","),
				"Haskell,関数,1990,強い静的,Miranda,Factor".split(","),
				"Java,構造・命令・オブジェクト指向,1995,強い静的,Objective-C・Smalltalk・C++・Effel,C#・D".split(","),
				"PHP,命令・オブジェクト指向,1995,弱い動的,C・C++・Java・Perl,_".split(","),
		};

		public Table1Model() {
			super();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public Object getValueAt(int row, int col) {
			System.out.println(row + ":" + col);
			return data[row][col];
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
			data[row][column] = (String) value;
		}
	}

}
