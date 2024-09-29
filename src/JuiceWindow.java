import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class JuiceWindow extends JFrame {
	// METHODS FIRST
	public JuiceWindow(JuiceMachine jm) throws IOException{
		this.jm = jm;
		DispenserType[] arr = {jm.getApple(), jm.getOrange(), jm.getMango(), jm.getFruit()};
		this.dArr = arr;
		img = ImageIO.read(new File("./src/pic.jpg"));
		showSelection();
		boolean t = true;
		long c = 1;
		while(t) {
			
			if(c*6e-5 >= 60) {
			
				try {
					System.out.println("FPS: " + c*6e-5);
					Thread.sleep(10000);
					img = ImageIO.read(new File("./src/pic2.jpg"));
					this.getContentPane().repaint();
					Thread.sleep(10000);
					img = ImageIO.read(new File("./src/pic.jpg"));
					this.getContentPane().repaint();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				c = 1;
			}		
			c+=1;
		};
	}
	
	private void showSelection() {
		this.initGUI();
		this.initSelectPanel();
		this.initDetailsPanel();
		this.buttonListeners();
		buyButton();
		repaint();
		this.setVisible(true);
		
	}
	

	private void initGUI() {
		this.setSize(600, 420);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Fruit Juice Machine");
		this.setContentPane(new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0,0,600, 420, this);
			}
		});

		this.getContentPane().setLayout(null);
		
	}
	
	private void initSelectPanel() {
		selectionPanel.setLayout(new GridLayout(4,1, 0, 20));
		selectionPanel.setBackground(new Color(255,255,255, Color.TRANSLUCENT));
		selectionPanel.setBounds(50,35,200, 200);
		this.add(selectionPanel);
		
		apple.setText("Apple juice");
		apple.setBackground(Color.pink);
		orange.setText("Orange juice");
		orange.setBackground(Color.orange);
		mango.setText("Mango lassi");
		mango.setBackground(Color.yellow);
		fruit.setText("Fruit punch");
		fruit.setBackground(Color.MAGENTA);
		
		
		selectionPanel.add(apple);
		selectionPanel.add(orange);
		selectionPanel.add(mango);
		selectionPanel.add(fruit);
	}
	
	
	// Name of product, Cost, Availability
	private void initDetailsPanel() {
		detailsPanel.setLayout(new GridLayout(3,1, 0, 25));
		detailsPanel.setBackground(new Color(255,255,255, Color.TRANSLUCENT));
		detailsPanel.setBounds(370,10,205, 150);
		
		this.add(detailsPanel);
		
		pName.setText("Juice: ");
		cost.setText("Cost: ");
		cost.setLineWrap(true);
		pName.setBorder(new LineBorder(Color.black, 3, true));
		cost.setBorder(new LineBorder(Color.black, 3, true));
		avail.setBorder(new LineBorder(Color.black, 3, true));
		
		pName.setFocusable(false);
		cost.setFocusable(false);
		avail.setFocusable(false);
		
		pName.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
		cost.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		avail.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		
		avail.setEditable(false);
		pName.setEditable(false);
		cost.setEditable(false);
		
		detailsPanel.add(pName);
		detailsPanel.add(cost);
		detailsPanel.add(avail);
		
		
	}
		
	private void buyButton() {
		buyButton.setEnabled(false);
		buyButton.setBounds(470, 190, 100, 50);
		

		buyButton.addActionListener(new ActionListener() {
		
			private String str = "";
			private JOptionPane pPane = new JOptionPane();
			private JPanel pane = new JPanel();
			private boolean inpStatus = false;
			
			
			private boolean moneyChecker(int money) {
				boolean res;
			
				if(money >= dispType.getCost()) {
					res = true;
				}else {
					res= false;
				}
				return res;
			}
			
			// Button click listener
			public void actionPerformed(ActionEvent e) {
				// If user did not select anything
				if(dispType == null) {
					JOptionPane.showMessageDialog(null, "No dispenser available!","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				// Start of payment gui loop
				int money = 0;
				int c = 0;
				while(inpStatus == false) {
					String str = inpStatus == false && c >0? "Enter amount:\nInsufficient amount." : "Enter amount: ";
					
					String inp = JOptionPane.showInputDialog(null, str, "Checkout: ", JOptionPane.INFORMATION_MESSAGE);
					if(inp == null)break;
					try {
						money = Integer.parseInt(inp);
						inpStatus = moneyChecker(money);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Invalid Input","Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
					c++;
				}
				c = 0;
				//End of Loop
				
				// Official Receipt JOptionPane
				
				str = inpStatus == true ?"Official Receipt.\n   Order:\n        " 
				+ dispType.getName() 
				+ "     1x"
				+ "\n                                                      Cost: " 
				+ dispType.getCost()
				+ " cents"
				+ "\n                                                      Amount paid: " 
				+ money
				+" cents"
				+ "\n                                                      Change: " 
				+ (money-dispType.getCost())
				+" cents" : "Continue? ";
				
				JOptionPane.showMessageDialog(pPane, str,"Receipt: ",JOptionPane.INFORMATION_MESSAGE);
				if(inpStatus == true) {
					jm.register.acceptAmount(dispType.getCost());
					dispType.makeSale();
					inpStatus = false;
					pName.setText("Juice: ");
					cost.setText("Cost: ");
					avail.setText("");
					buyButton.setEnabled(false);
				}
					
				
				
				String msg = "" + jm.register.getCurrentBalance();
				System.out.println(msg);
				
			}
		});
		
		this.add(buyButton);
	}
		
		
		private void buttonListeners() {
			// Apple button press listener
			/*apple.addActionListener(new ActionListener() {
				DispenserType a = jm.getApple();
				public void actionPerformed(ActionEvent e) {
					dispType = a;
					pName.setText("Juice: " + "Apple");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = res == true ? "Sold Out!" : "Available!!!";
					availStatus = res == true ? true : false;
					avail.setText(str);
					if(availStatus == true) {
						buyButton.setEnabled(false);
					}else {
						buyButton.setEnabled(true);
					}
					
				}
			});
			orange.addActionListener(new ActionListener() {
				DispenserType a = jm.getOrange();
				public void actionPerformed(ActionEvent e) {
					dispType = a;
					pName.setText("Juice: " + "Orange");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = res == true ? "Sold Out!" : "Available!!!";
					availStatus = res == true ? true : false;
					avail.setText(str);
					if(availStatus == true) {
						buyButton.setEnabled(false);
					}else {
						buyButton.setEnabled(true);
					}
					
				}
			});
			mango.addActionListener(new ActionListener() {
				DispenserType a = jm.getMango();
				public void actionPerformed(ActionEvent e) {
					dispType = a;
					pName.setText("Juice: " + "Mango lassi");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = res == true ? "Sold Out!" : "Available!!!";
					availStatus = res == true ? true : false;
					avail.setText(str);
					if(availStatus == true) {
						buyButton.setEnabled(false);
					}else {
						buyButton.setEnabled(true);
					}
					
				}
			});
			fruit.addActionListener(new ActionListener() {
				DispenserType a = jm.getFruit();
				public void actionPerformed(ActionEvent e) {
					dispType = a;
					pName.setText("Juice: " + "Fruit punch");
					cost.setText("Cost: " + a.getCost());
					boolean res = a.isSoldOut();
					if(res == true) avail.setForeground(Color.red);
					else avail.setForeground(Color.green);
					String str = res == true ? "Sold Out!" : "Available!!!";
					availStatus = res == true ? true : false;
					avail.setText(str);
					if(availStatus == true) {
						buyButton.setEnabled(false);
					}else {
						buyButton.setEnabled(true);
					}
					
				}
			});*/
			 int i = 0;
			for(;i < 4;i++) {
				JButton d = jArr[i];
				DispenserType dis= dArr[i];
				d.addActionListener(new JuiceButtonListener(this, dis));
			}
		}
		
		
	public void helperFunc(DispenserType dis) {
		dispType = dis;
		pName.setText("Juice: " + dis.getName());
		cost.setText("Cost: " + dis.getCost());
		boolean res = dis.isSoldOut();
		if(res == true) avail.setForeground(Color.red);
		else avail.setForeground(Color.green);
		String str = res == true ? "Sold Out!" : "Available!!!";
		availStatus = res == true ? true : false;
		avail.setText(str);
		if(availStatus == true) {
			buyButton.setEnabled(false);
		}else {
			buyButton.setEnabled(true);
		}
	}

	// ALL VARIABLES BELOW
		
		// Variable for the only instance of JuiceMachine class
	private JuiceMachine jm;
	
	// Status checkers
	private boolean availStatus = true;
	private DispenserType dispType = null;
	
	private  DispenserType[] dArr;
	// BUTTONS
	private JButton 
	buyButton = new JButton("BUY"),
	apple = new JButton("APPLE"), 
	orange = new JButton("ORANGE"),
	mango = new JButton("MANGO"),
	fruit = new JButton("FRUIT");
	
	private JButton[] jArr= {apple, orange, mango, fruit};
	// TEXT AREA
	private JTextArea
	pName = new JTextArea(),
	cost = new JTextArea(),
	avail = new JTextArea();
	
	// Images
	private Image img;
	
	// PANELS
	private JPanel detailsPanel = new JPanel();
	private JPanel selectionPanel = new JPanel();
}
