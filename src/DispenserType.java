
public class DispenserType {
	
	public DispenserType() {
		this.cost = 50;
		this.numberOfItems = 50;
		this.soldOut = false;
	}
	public DispenserType(int num,int cost) {
		this.numberOfItems = num;
		this.cost = cost;
		if(this.numberOfItems <= 0)this.soldOut = true;
		else this.soldOut = false;
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
		if(this.numberOfItems <= 0) {
			this.numberOfItems = 0;
			this.soldOut =true;
		}else {
			this.soldOut = false;
		}
	}
	public boolean isSoldOut() {
		boolean res = false;
		if(soldOut == true) {
			res = true;
		}
		return res;
		
	}

	private int numberOfItems = 0;
	private int cost = 0;
	private boolean soldOut = true;
	
}
