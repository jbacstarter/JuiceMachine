
public class CashRegister {
	private static int cashOnHand = 0;
	
	public CashRegister() {
		CashRegister.cashOnHand = 500;
	};
	
	public CashRegister(int cashIn) {
		CashRegister.cashOnHand = cashIn;
	};
	public void acceptAmount(int amountIn) {
		// For debugging/error checking purposes
		if(amountIn <= 0)System.err.println("ERROR: Invalid amount deposited ");
		CashRegister.cashOnHand+=amountIn;
	};
	public int getCurrentBalance() {
		return cashOnHand;
	}
}
