package ex06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Muni extends JFrame {
	
    public static void main(String[] args) {
    Muni w = new Muni( "Muni" );
    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    w.setSize( 300, 200 );
    w.setVisible( true );
    
  }
  public Muni( String title ){
    super( title );
    JButton button1 = new JButton( new Action01() ); // ボタンの生成と共にActionクラスのインスタンスを設定
    getContentPane().add( button1, BorderLayout.NORTH );
    JButton button2 = new JButton( new Action02() );
    getContentPane().add( button2, BorderLayout.SOUTH);
    JButton button3 = new JButton( new Action03() );
    getContentPane().add( button3, BorderLayout.CENTER);
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    JMenu ope = new JMenu( "操作" );
    menuBar.add( ope );
    JMenuItem item;
    item = new JMenuItem( new Action01() );
    ope.add(item);
    item = new JMenuItem( new Action02() );
    ope.add(item);
    ope.addSeparator();
    item = new JMenuItem( new Action03() );
    ope.add(item);

  }
  class Action01 extends AbstractAction{ // Action クラスの定義
    Action01(){
      putValue( Action.NAME, "む" );
      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
      putValue( Action.SHORT_DESCRIPTION, "ツールチップ" );
    }
    public void actionPerformed( ActionEvent e ){ // ボタンがクリックされたときの処理
      System.out.println( "む");
    }
  }
  class Action02 extends AbstractAction{ // Action クラスの定義
	    Action02(){
	      putValue( Action.NAME, "に" );
	      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
	      putValue( Action.SHORT_DESCRIPTION, "ツールチップ" );
	    }
	   
	    public void actionPerformed( ActionEvent e ){ // ボタンがクリックされたときの処理
	      System.out.println( "に");
	    }
	  }
  class Action03 extends AbstractAction{ // Action クラスの定義
	    Action03(){
	      putValue( Action.NAME, "(ﾉ)・ω・(ヾ)" );
	      putValue( Action.SMALL_ICON, new ImageIcon( "open.gif" ) );
	      putValue( Action.SHORT_DESCRIPTION, "ツールチップ" );
	    }
	   
	    public void actionPerformed( ActionEvent e ){ // ボタンがクリックされたときの処理
	      System.out.println( "(ﾉ)・ω・(ヾ)");
	    }
	  }
}
