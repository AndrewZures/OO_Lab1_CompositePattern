
public class Stock extends Investment implements Component {
	
	public String thisType = "Stock";

	//constructors
	
	public Stock(String thisName){
		super.type = thisType;
		super.name = thisName;
	}
	
	public Stock(String thisName, int shareNumber, double price) {
		super.name = thisName;
		super.type = thisType;
		super.add(shareNumber, price);
	}
	
	//allow visitor
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	
	/*
	 *Majority of Functionality found in Investment Class
	 */
		
}
