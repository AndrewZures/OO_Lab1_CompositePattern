
public class Portfolio extends Composite implements Component {
	
	private String thisType = "Portfolio";
	
	//constructor
	
	public Portfolio(String thisName){
		super.type = thisType;
		super.name = thisName;
	}
	
	//allow visitor
	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	
	/*
	 * Majority of Functionality in Composite Class
	 */

	
}
