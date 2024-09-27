
public class CashRegister {
	private int cashOnHand = 0;
	public CashRegister() {
		this.cashOnHand = 500;
	};
	
	public CashRegister(int cashIn) {
		this.cashOnHand = cashIn;
	};
	public void acceptAmount(int amountIn) {
		if(amountIn <= 0)System.err.println("ERROR: Invalid amount deposited ");
		this.cashOnHand+=amountIn;
	};
	public int getCurrentBalance() {
		return cashOnHand;
	}
}
