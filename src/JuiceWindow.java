import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;

public class JuiceWindow extends JFrame {
	// METHODS FIRST
	public JuiceWindow(JuiceMachine jm) {
		this.jm = jm;
		this.initGUI();
		this.initSelectPanel();
		this.initDetailsPanel();
		this.setVisible(true);
	}
	
	private void initGUI() {
		this.setSize(600, 420);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Fruit Juice Machine");
		//this.getContentPane().setBackground(Color.darkGray);
		this.getContentPane().setLayout(null);
	}
	
	private void initSelectPanel() {
		selectionPanel.setLayout(new GridLayout(4,1, 0, 20));
		
		selectionPanel.setBounds(50,35,200, 200);
		this.add(selectionPanel);
		
		apple.setText("Apple");
		apple.setBackground(Color.pink);
		orange.setText("Orange");
		orange.setBackground(Color.orange);
		mango.setText("Mango");
		mango.setBackground(Color.yellow);
		fruit.setText("Fruit");
		fruit.setBackground(Color.MAGENTA);
		
		
		selectionPanel.add(apple);
		selectionPanel.add(orange);
		selectionPanel.add(mango);
		selectionPanel.add(fruit);
	}
	// Name of product, Cost, Availability
	private void initDetailsPanel() {
		detailsPanel.setLayout(new GridLayout(3,1, 0, 25));
		detailsPanel.setBackground(Color.lightGray);
		detailsPanel.setBounds(380,10,200, 150);
		
		this.add(detailsPanel);
		
		pName.setText("Juice: ");
		//pName.setBackground(Color.lightGray);
		pName.setFont(new Font("Times New Roman", Font.BOLD | Font.CENTER_BASELINE, 25));
		
		cost.setText("Cost: ");
		cost.setFont(new Font("Times New Roman", Font.BOLD | Font.CENTER_BASELINE, 25));
		avail.setText("Available: ");
		avail.setFont(new Font("Times New Roman", Font.BOLD | Font.CENTER_BASELINE, 25));
		pName.setEditable(false);
		cost.setEditable(false);
		avail.setEditable(false);
		
		
		detailsPanel.add(pName);
		detailsPanel.add(cost);
		detailsPanel.add(avail);
	}
		
		
		

	// ALL VARIABLES BELOW
		// Variable for the only instance of JuiceMachine class
	private JuiceMachine jm;
	
	// BUTTONS
	private JButton 
	apple = new JButton("APPLE"), 
	orange = new JButton("ORANGE"),
	mango = new JButton("MANGO"),
	fruit = new JButton("FRUIT");
	// TEXT AREA
	private JTextArea
	pName = new JTextArea(),
	cost = new JTextArea(),
	avail = new JTextArea();
	
	// PANELS
	private JPanel detailsPanel = new JPanel();
	private JPanel selectionPanel = new JPanel();
}
