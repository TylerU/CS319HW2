
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


class MTextFileMenu extends JMenu{
	public MTextFileMenu(MTextFrame frame){
		super("New");
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(frame);
		add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(frame);
		add(openMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(frame);
		add(saveMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(frame);
		add(exitMenuItem);
	}
}


class MTextEditMenu extends JMenu {
	public MTextEditMenu(MTextFrame frame){
		super("Edit");
		JMenuItem findMenuItem = new JMenuItem("Find");
		findMenuItem.addActionListener(frame);
		add(findMenuItem);
		
		JMenuItem replaceMenuItem = new JMenuItem("Replace");
		replaceMenuItem.addActionListener(frame);
		add(replaceMenuItem);
		
		JMenuItem replaceAllMenuItem = new JMenuItem("Replace All");
		replaceAllMenuItem.addActionListener(frame);
		add(replaceAllMenuItem);
	}
}


class MTextMenu extends JMenuBar
{
	public MTextMenu(MTextFrame frame){
		JMenu fileMenu = new MTextFileMenu(frame);
		add(fileMenu);
		JMenu editMenu = new MTextEditMenu(frame);
		add(editMenu);
	}
}


public class MText{
	public static void main(String[] args){
		MTextFrame frame = new MTextFrame();
	}
}

class MTextFrame extends JFrame implements ActionListener, FocusListener {
	private static final int AREA_COLUMNS = 33;
	private static final int AREA_ROWS = 30;
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	private Component lastFocused;
	public MTextFrame(){
		super("MText");
		setSize(800,570);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		MTextMenu menu = new MTextMenu(this);
		setJMenuBar(menu);
		
		
		rightTextArea = new JTextArea("right", AREA_ROWS, AREA_COLUMNS);
		rightTextArea.setLineWrap(true);
		rightTextArea.addFocusListener(this);
		JScrollPane rightScrollPane = new JScrollPane(rightTextArea);
		
		leftTextArea = new JTextArea("left", AREA_ROWS, AREA_COLUMNS);
		leftTextArea.setLineWrap(true);
		leftTextArea.addFocusListener(this);
		JScrollPane leftScrollPane = new JScrollPane(leftTextArea);
		
		JPanel leftPanel = new JPanel();
		leftPanel.add(leftScrollPane);
		getContentPane().add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.add(rightScrollPane);
		getContentPane().add(rightPanel);
		
		setVisible(true);
	}
	
	private JTextArea getCurTextArea(){
		return (JTextArea) lastFocused;
	}
	
	private String getStringToReplace(){
		JTextArea cur = getCurTextArea();
		String selectedText = cur.getSelectedText();
		if(selectedText != null && selectedText.length() > 0){
			return selectedText;
		}
		else{
			String s = (String)JOptionPane.showInputDialog(
                    this,
                    "Enter text which will be replaced",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE);
			if(s != null && s.length() > 0){
				return s;
			}
			else{
				return "";
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String curAction = evt.getActionCommand();
		if(curAction.equals("Find")){	  
			  String s = (String)JOptionPane.showInputDialog(
	                    this,
	                    "Enter text to search for",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE);
		
			if ((s != null) && (s.length() > 0)) {
				JTextArea cur = getCurTextArea();
			
				String curStr = cur.getText();
				int where = curStr.indexOf(s, cur.getCaretPosition());
				if(where >= 0){			
					cur.setCaretPosition(where);
					cur.select(where, where + s.length());
				}
			}
		}
		else if(curAction.equals("Replace")){
			String from = getStringToReplace();
			JTextArea cur = getCurTextArea();
			String text = cur.getText();
			int indexof = text.indexOf(from, cur.getCaretPosition());
			if(indexof >= 0){
				 String s = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Enter replacement text",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE);
				 if(s != null && s.length() > 0){
					 text = text.substring(0, cur.getCaretPosition()) + text.substring(cur.getCaretPosition(), text.length()).replaceFirst(from, s);
					 cur.setText(text);
					 cur.setCaretPosition(indexof);
				 }
			}
			else{
				JOptionPane.showMessageDialog(this,
					    "Unable to locate that text",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(curAction.equals("Replace All")){
			String from = getStringToReplace();
			JTextArea cur = getCurTextArea();
			String text = cur.getText();
			int indexof = text.indexOf(from, cur.getCaretPosition());
			if(indexof >= 0){
				 String s = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Enter replacement text",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE);
				 if(s != null && s.length() > 0){
					 text = text.substring(0, cur.getCaretPosition()) + text.substring(cur.getCaretPosition(), text.length()).replace(from, s);
					 cur.setText(text);
					 cur.setCaretPosition(indexof);
				 }
			}
			else{
				JOptionPane.showMessageDialog(this,
					    "Unable to locate that text",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			}		}		
		else if(curAction.equals("New")){
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
			System.out.println("Unrecognized action event: " + curAction);
		}		
	}

	@Override
	public void focusGained(FocusEvent evt) {
		lastFocused = evt.getComponent();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}