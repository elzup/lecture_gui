package chap04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class MenuTest extends JFrame {

	public static void main(String[] args) {
		MenuTest w = new MenuTest("MenuTest");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(350, 250);
		w.setVisible(true);
	}

	ButtonGroup bg1;

	public MenuTest(String title) {
		super(title);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar) ;

		JMenu file= new JMenu("File");
		menuBar.add(file);

		JMenuItem item;

		item = new JMenuItem("Open", new ImageIcon(""));
		item.setHorizontalTextPosition(SwingConstants.CENTER);
		item.setToolTipText("開く");
		file.add(item);

		item = new JMenuItem("Save", new ImageIcon(""));
		item.setHorizontalTextPosition(SwingConstants.CENTER);
		item.setToolTipText("保存");
		file.add(item);
		file.addSeparator();
		item = new JMenuItem("Exit", new ImageIcon(""));
		item.setHorizontalTextPosition(SwingConstants.CENTER);
		item.setToolTipText("終了");
		file.add(item);

		bg1 = new ButtonGroup();




		JMenu menuR = new JMenu("Radios");
		menuBar.add(menuR);

		item = new JRadioButtonMenuItem("和食");
		menuR.add(item);
		bg1.add(item);
		item = new JRadioButtonMenuItem("洋食");
		menuR.add(item);
		bg1.add(item);
		item = new JRadioButtonMenuItem("中華");
		menuR.add(item);
		bg1.add(item);


		JMenu menuC = new JMenu("CBoxs");
		menuBar.add(menuC);
		item = new JCheckBoxMenuItem("和食");
		menuC.add(item);
		item = new JCheckBoxMenuItem("洋食");
		menuC.add(item);
		item = new JCheckBoxMenuItem("中華");
		menuC.add(item);


		JButton btn = new JButton("Clear");
		btn.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			bg1.clearSelection();
		}
		});
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(btn);



	}
}
