
public class Account extends Composite implements Component {

	public String thisType = "Account";
	
	//constructor
	
	public Account(String thisName){
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
