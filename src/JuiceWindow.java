import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JuiceWindow extends JFrame {
	// METHODS FIRST
	public JuiceWindow(JuiceMachine jm) {
		this.jm = jm;
		this.initGUI();
		this.initSelectPanel();
		this.initDetailsPanel();
		this.buttonListeners();
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
		detailsPanel.setBackground(Color.gray);
		detailsPanel.setBounds(380,10,205, 150);
		
		this.add(detailsPanel);
		
		pName.setText("Juice: ");
		//pName.setBackground(Color.lightGray);
		pName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		cost.setText("Cost: ");
		cost.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		avail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		pName.setEditable(false);
		cost.setEditable(false);
		avail.setEditable(false);
		
		
		detailsPanel.add(pName);
		detailsPanel.add(cost);
		detailsPanel.add(avail);
	}
		
		private void buttonListeners() {
			// Apple button press listener
			apple.addActionListener(new ActionListener() {
				DispenserType a = jm.getApple();
				public void actionPerformed(ActionEvent e) {
					pName.setText("Juice: " + "Apple");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = a.isSoldOut() == true ? "Sold Out!" : "Available";
					avail.setText(str);
				}
			});
			orange.addActionListener(new ActionListener() {
				DispenserType a = jm.getOrange();
				public void actionPerformed(ActionEvent e) {
					pName.setText("Juice: " + "Orange");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = a.isSoldOut() == true ? "Sold Out!" : "Available";
					avail.setText(str);
				}
			});
			mango.addActionListener(new ActionListener() {
				DispenserType a = jm.getMango();
				public void actionPerformed(ActionEvent e) {
					pName.setText("Juice: " + "Mango lassi");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = a.isSoldOut() == true ? "Sold Out!" : "Available";
					avail.setText(str);
				}
			});
			fruit.addActionListener(new ActionListener() {
				DispenserType a = jm.getFruit();
				public void actionPerformed(ActionEvent e) {
					pName.setText("Juice: " + "Fruit punch");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = a.isSoldOut() == true ? "Sold Out!" : "Available";
					avail.setText(str);
				}
			});
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
