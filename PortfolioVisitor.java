import java.util.HashMap;


public class PortfolioVisitor implements Visitor {

	public void visit(Component component) {

		/*
		 * Since Java does not have duck-typing options and the visitor 
		 * class needs the specific subclass of component to activate the 
		 * correct visitor method, this visit(component) method allows the 
		 * visitor to take in a general component, determine the specific 
		 * subclass and execute the correct visit method.  
		 * 
		 * It is admittedly a bit of a work-around but it allows the visitor
		 * class to handle a general component, instead of relying on other 
		 * classes to make sure the visitor gets the correct subclass.  Thus
		 * there is an encapsulation benefit.
		 * 
		 * There may be a better way of implementing this functionality but
		 * I've done quite a bit of research and this the one that is simple 
		 * to understand I am most comfortable implementing
		 */
		
		//look for the specific subclass of component and execute that class's visit method
		if (component instanceof Portfolio){
			Portfolio x = (Portfolio) component;
			visit(x);
		}
		else if (component instanceof Account){
			Account x = (Account) component;
			visit(x);
		}
		else if (component instanceof Stock){
			Stock x = (Stock) component;
			visit(x);
		}
		else if (component instanceof Bond){
			Bond x = (Bond) component;
			visit(x);
		}
		else if (component instanceof MoneyMarket){
			MoneyMarket x = (MoneyMarket) component;
			visit(x);
		}
		else {
			System.out.println("Component Unknown: Visitor failed to visit");
		}
		
	}  //end visit(component)
	
	
	/* NOTE: my visitor functions could be more complex, however I feel that for encapsulation reasons
	 * the specific components should handle most of their functionality.  Here, the visitor functions 
	 * are set up to handle interactions with specific component types.  I have added some print statements
	 * that require visitor interaction to prove that I understand the visitor concept
	 */

	public void visit(Portfolio portfolio) {
		portfolio.printCurrentValue();
	}

	public void visit(Account account) {
		account.printCurrentValue();
	}

	public void visit(Bond bond) {
		System.out.println(bond.amount +" shares of the bond " + bond.name + ", value: " + bond.currentValue());
	}

	public void visit(MoneyMarket moneyMarket) {
		System.out.println(moneyMarket.amount +" units of the money market " + moneyMarket.name + ", value: " + moneyMarket.currentValue());
	}

	public void visit(Stock stock) {
		System.out.println(stock.amount +" shares of the stock " + stock.name + ", value: " + stock.currentValue());
	}
	
}  //end class
