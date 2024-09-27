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
	new JuiceWindow(juiceMachine);
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
private  DispenserType apple = new DispenserType(), orange = new DispenserType(), mango = new DispenserType(), fruit = new DispenserType();

}
