import javax.swing.*;

public class JuiceWindow extends JFrame {

	private JuiceMachine jm;
	private JButton apple;
	private JButton orange;
	private JButton mango;
	private JButton fruit;
	public JuiceWindow(JuiceMachine jm) {
		this.jm = jm;
		this.initGUI();
	}
	
	public void initGUI() {
		this.setSize(600, 420);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Fruit Juice Machine");
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}
}
