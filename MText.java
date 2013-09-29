
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class MText {
	private static final int AREA_COLUMNS = 33;
	private static final int AREA_ROWS = 30;
	
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("MText");
		myFrame.setSize(800,570);
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(new FlowLayout());
		
		
		JMenuBar myMenuBar = new JMenuBar();
		myFrame.setJMenuBar(myMenuBar);
		JMenu fileMenu = new JMenu("File");
		myMenuBar.add(fileMenu);
		JMenu editMenu = new JMenu("Edit");
		myMenuBar.add(editMenu);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		JMenuItem saveMenuItem = new JMenuItem("Save");
		fileMenu.add(saveMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);

		JMenuItem findMenuItem = new JMenuItem("Find");
		editMenu.add(findMenuItem);
		JMenuItem replaceMenuItem = new JMenuItem("Replace");
		editMenu.add(replaceMenuItem);
		JMenuItem replaceAllMenuItem = new JMenuItem("Replace All");
		editMenu.add(replaceAllMenuItem);
		
		
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