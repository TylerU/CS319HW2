
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class MTextFileMenu extends JMenu implements ActionListener{
	public MTextFileMenu(){
		super("New");
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(this);
		add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(this);
		add(openMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(this);
		add(saveMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		add(exitMenuItem);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String curAction = evt.getActionCommand();
		if(curAction.equals("New")){
			System.out.println("New");
		}
		else if(curAction.equals("Open")){
			System.out.println("Open");
		}
		else if(curAction.equals("Save")){
			System.out.println("Save");
		}
		else if(curAction.equals("Exit")){
			System.out.println("Exit");
		}
		else{
			System.out.println("Unrecognized action event in MTextFileMenu");
		}
	}
}


class MTextEditMenu extends JMenu implements ActionListener{
	public MTextEditMenu(){
		super("Edit");
		JMenuItem findMenuItem = new JMenuItem("Find");
		findMenuItem.addActionListener(this);
		add(findMenuItem);
		
		JMenuItem replaceMenuItem = new JMenuItem("Replace");
		replaceMenuItem.addActionListener(this);
		add(replaceMenuItem);
		
		JMenuItem replaceAllMenuItem = new JMenuItem("Replace All");
		replaceAllMenuItem.addActionListener(this);
		add(replaceAllMenuItem);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String curAction = evt.getActionCommand();
		if(curAction.equals("Find")){
			System.out.println("FIND");
		}
		else if(curAction.equals("Replace")){
			System.out.println("Replace");
		}
		else if(curAction.equals("Replace All")){
			System.out.println("Replace All");
		}
		else{
			System.out.println("Unrecognized action event in MTextEditMenu");
		}
	}
}


class MTextMenu extends JMenuBar
{
	public MTextMenu(JFrame frame){
		JMenu fileMenu = new MTextFileMenu();
		add(fileMenu);
		JMenu editMenu = new MTextEditMenu();
		add(editMenu);
	}
}

public class MText {
	private static final int AREA_COLUMNS = 33;
	private static final int AREA_ROWS = 30;
	
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("MText");
		myFrame.setSize(800,570);
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(new FlowLayout());
		
		MTextMenu menu = new MTextMenu(myFrame);
		myFrame.setJMenuBar(menu);
		
		
		JTextArea rightTextArea = new JTextArea("right", AREA_ROWS, AREA_COLUMNS);
		rightTextArea.setLineWrap(true);
		JScrollPane rightScrollPane = new JScrollPane(rightTextArea);
		
		JTextArea leftTextArea = new JTextArea("left", AREA_ROWS, AREA_COLUMNS);
		leftTextArea.setLineWrap(true);
		JScrollPane leftScrollPane = new JScrollPane(leftTextArea);
		
		JPanel leftPanel = new JPanel();
		leftPanel.add(leftScrollPane);
		myFrame.getContentPane().add(leftPanel); 
		
		JPanel rightPanel = new JPanel();
		rightPanel.add(rightScrollPane);
		myFrame.getContentPane().add(rightPanel);
		
		myFrame.setVisible(true);
	}
}