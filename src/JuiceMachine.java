import java.io.IOException;

import javax.swing.JFrame;

/* Juices:

Apple Juice;
Orange Juice; 
Mango lassi;
Fruit punch;

	The program should do the following:
	1. Show the customer the different products sold by the juice machine.
	2. Let the customer make the selection.
	3. Show the customer the cost of the item selected.
	4. Accept money from the customer.
	5. Release the item.
	
*/
public class JuiceMachine{

private JuiceMachine() {};
public static void initJuiceMachine() {
	juiceMachine = new JuiceMachine();
	try {
		new JuiceWindow(juiceMachine);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public  DispenserType getApple() {
	return apple;
}
public  DispenserType getOrange() {
	return orange;
}
public  DispenserType getMango() {
	return mango;
}
public  DispenserType getFruit() {
	return fruit;
}
	private  static JuiceMachine juiceMachine = null;
	public  CashRegister 
	register = new CashRegister();
	private  DispenserType 
	apple = new DispenserType(10, 35, "Apple Juice"), 
	orange = new DispenserType(30, 25, "Orange Juice"), 
	mango = new DispenserType(15, 60, "Mango lassi"), 
	fruit = new DispenserType(0, 10, "Fruit punch");

}
