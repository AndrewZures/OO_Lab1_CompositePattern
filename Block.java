
public class Block {
	public String type;
	public int numShares;
	public double purchasePrice;
	
	public Block(){
		//overload constructor
	}
	
	public Block (String InvestmentType, int numberOfShares, double price){
		type = InvestmentType;
		numShares = numberOfShares;
		purchasePrice = price;
	}
	
	public void setType(String newType){
		type = newType;
	}
}
