
public class DispenserType {

	public DispenserType() {
		this.cost = 50;
		this.numberOfItems = 50;
	}
	public DispenserType(int num,int cost) {
		this.numberOfItems = num;
		this.cost = cost;
	}
	
	
	public int getNumberOfItems() {
		return numberOfItems;
	}

	public int getCost() {
		return cost;
	}
	public void makeSale() {
		int temp = this.numberOfItems;
		temp--;
		this.numberOfItems = temp;
	}


	private int numberOfItems = 0;
	private int cost = 0;
	
	
}
