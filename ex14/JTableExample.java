package ex14;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableExample extends JFrame {

  public static void main(String[] args) {
    JFrame frame = new JTableExample( "セリーグ順位表" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  JTableExample ( String title ) {
    super( title );
    JTable table = new JTable( new Table1Model() );
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 600, 200 );
    setVisible( true );
  }

  class Table1Model extends AbstractTableModel {
    String[] columnNames = {
      "チーム", "勝数", "負数", "分数", "勝率", "ゲーム差"
    };
    String[][] data = {
      { "阪神",     "11",  "2", "0", ".846", "-" },
      { "広島",     " 8",  "5", "0", ".615", "3.0" },
      { "巨人",     " 7",  "6", "0", ".538", "1.0" },
      { "ヤクルト", " 6",  "8", "0", ".428", "1.5" },
      { "中日",     " 5",  "8", "0", ".384", "0.5" },
      { "横浜",     " 3", "11", "0", ".214", "2.5" },
    };
    @Override
    public int getColumnCount() {
      return columnNames.length;
    }
    @Override
    public int getRowCount() {
      return data.length;
    }
    @Override
    public String getColumnName( int col ) {
      return columnNames[col];
    }
    @Override
    public Object getValueAt( int row, int col ) {
      return data[row][col];
    }
    @Override
    public Class getColumnClass( int col ) {
      return getValueAt( 0, col ).getClass();
    }
    @Override
    public boolean isCellEditable( int row, int col ) {
      return false;
    }
    @Override
    public void setValueAt( Object value, int row, int column ) {
      data[row][column] = (String)value;
    }
  }

}
