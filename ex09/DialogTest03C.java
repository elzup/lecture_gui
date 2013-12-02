package ex09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DialogTest03C extends JFrame {
  JPanel pane;
  public static void main(String[] args) {
    DialogTest03C w = new DialogTest03C( "DialogTest03C" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 550, 300 );
    w.setVisible( true );
  }
  public DialogTest03C( String title ) {
    super( title );
    pane = (JPanel)getContentPane();
    JToolBar tool = new JToolBar();
    pane.add( tool, BorderLayout.NORTH );
    tool.add( new Dialog03( "Confirm Dialog" ) );
  }
  class Dialog03 extends AbstractAction {
    Dialog03( String text ){ super( text ); }
    public void actionPerformed( ActionEvent e ){

      Object[] msg = { "Javaは得意ですか？"};
      int ans = JOptionPane.showConfirmDialog( pane, msg, "はい・いいえ", JOptionPane.YES_NO_OPTION ); // 確認ダイアログを生成・表示、選択した結果が返ってくる
      switch(ans) {

      }
      msg = null;
      String msg2 = "Javaは" + ((ans == 0) ? "得意です" : "苦手です");
      JOptionPane.showMessageDialog( pane, msg2, "Java answer", JOptionPane.WARNING_MESSAGE); // 確認ダイアログを生成・表示、選択した結果が返ってくる
    }
  }
}
