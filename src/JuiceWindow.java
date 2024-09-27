import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class JuiceWindow extends JFrame {

	private JuiceMachine jm;
	
	private JButton 
	apple = new JButton("APPLE"), 
	orange = new JButton("ORANGE"),
	mango = new JButton("MANGO"),
	fruit = new JButton("FRUIT");
	
	private JPanel selectionPanel = new JPanel();
	
	public JuiceWindow(JuiceMachine jm) {
		this.jm = jm;
		this.initGUI();
		this.initSelectPanel();
		this.setVisible(true);
	}
	
	private void initGUI() {
		this.setSize(600, 420);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Fruit Juice Machine");
		this.getContentPane().setLayout(null);
	}
	
	private void initSelectPanel() {
		selectionPanel.setLayout(new GridLayout(4,1, 0, 20));
		//selectionPanel.setBackground(Color.blue);
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

	
}
