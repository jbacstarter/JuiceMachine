
public class DispenserType {
	
	public DispenserType(String name) {
		this.cost = 50;
		this.numberOfItems = 50;
		this.soldOut = false;
		this.name = name;
	}
	public DispenserType(int num,int cost, String name) {
		this.numberOfItems = num;
		this.name = name;
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
	public String getName() {
		return name;
	}
	private int numberOfItems = 0;
	private int cost = 0;
	private boolean soldOut = true;
	private String name = "";

}
