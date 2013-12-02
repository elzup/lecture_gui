package ex06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
// JApplet を使うので追加


public class CalcApplet02 extends JApplet { // JApplet を拡張する

  JTextField field = new JTextField();
  int arg1, arg2; //**
  char opeCode;   //**
  String arg;     //**
  boolean lastTimeNum; //**

  // main() メソッドは削除してある

  public void init() { // 元はコンストラクタだった部分をinit()メソッドに変更
    // setSize() や setTitle() は JApplet にはないので削除する
    // スーパクラスのコンストラクタ呼び出し super() も削除

    JPanel pane = (JPanel)getContentPane();

    pane.add( field, BorderLayout.NORTH );
    field.setEditable(false);
    field.setBackground( Color.white );

    JPanel keyPanel = new JPanel( new GridLayout( 4,4 ) );
    pane.add( keyPanel, BorderLayout.CENTER );

    String[] a = { "7","8","9","/",
                   "4","5","6","*",
                   "1","2","3","C",
                   "0","+","-","="  };

    Action[] action = {
      new NumKey(a[0]),  new NumKey(a[1]),   new NumKey(a[2]),   new FuncKey(a[3]),
      new NumKey(a[4]),  new NumKey(a[5]),   new NumKey(a[6]),   new FuncKey(a[7]),
      new NumKey(a[8]),  new NumKey(a[9]),   new NumKey(a[10]),  new FuncKey(a[11]),
      new NumKey(a[12]), new FuncKey(a[13]), new FuncKey(a[14]), new FuncKey(a[15])
    };

    for( int i=0; i< action.length ; i++ ){
      keyPanel.add( new JButton( action[i] ) );
    }

    String[] keyStroke = { "NUMPAD7","NUMPAD8","NUMPAD9" ,"DIVIDE",
                           "NUMPAD4","NUMPAD5","NUMPAD6" ,"MULTIPLY",
                           "NUMPAD1","NUMPAD2","NUMPAD3" ,"C",
                           "NUMPAD0","ADD"    ,"SUBTRACT","ENTER" };

    InputMap imap =  keyPanel.getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
    ActionMap amap = keyPanel.getActionMap();

    for( int i=0; i< action.length ; i++ ){
      KeyStroke k = KeyStroke.getKeyStroke( keyStroke[i] );
      imap.put( k, action[i] );
      amap.put( action[i], action[i] );
    }

    arg1    = 0;   //**
    opeCode = '+'; //**
    arg     = "";  //**
    lastTimeNum = false;
  }

  class NumKey extends AbstractAction {
    NumKey( String num ){
      putValue( Action.NAME, num );
    }
    public void actionPerformed( ActionEvent e ){
      String num = (String)getValue( Action.NAME );
      arg += num;
      field.setText( arg );
      lastTimeNum = true;
    }
  }

  class FuncKey extends AbstractAction {
    FuncKey( String label ){
      putValue( Action.NAME, label );
    }
    public void actionPerformed( ActionEvent e ){
      int answer = 0;
      String text = (String)getValue( Action.NAME );
      char label = text.charAt(0);

      if( label == 'C' ){
        field.setText( "" );
        opeCode = '+';
        arg1 = 0;
        lastTimeNum = false;
        return;
      }

      if( lastTimeNum == false ){
        opeCode = label;
        lastTimeNum = false;
        return;
      }

      arg2 = Integer.parseInt( arg );
      if( opeCode=='+' ){
        answer = arg1 + arg2;
      }
      if( opeCode=='-' ){
        answer = arg1 - arg2;
      }
      if( opeCode=='*' ){
        answer = arg1 * arg2;
      }
      if( opeCode=='/' ){
        answer = arg1 / arg2;
      }

      if( label != '=' ){
        opeCode = label;
      }

      field.setText( Integer.toString( answer ) );
      arg1 = answer;
      arg = "";
      lastTimeNum = false;
    }
  }

}