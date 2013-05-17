
public class TestClass {

	public static void main (String args[]){
		
		Account account = new Account("Account 1");

		
		Stock newStock = new Stock("Stock 1");
		newStock.add(200, 84);
		newStock.add(100, 90);
		newStock.remove(50, 92);
		//newStock.printMargin(92);
		account.add(newStock);
		
		Bond bond = new Bond("Bond 1", 20, 40);
		Bond bond2 = new Bond("Bond 2", 30, 15);
		MoneyMarket moneyM1 = new MoneyMarket("Money Market 1", 30, 15);
		account.add(bond);
		
		Portfolio port = new Portfolio("Portfolio 1");
		port.add(account);
		
		Account account2 = new Account("Account 2");
		account2.add(bond2);
		port.add(account2);
		
		port.add(moneyM1);
		
		PortfolioIterator iterator = new PortfolioIterator();
		PortfolioVisitor visitor = new PortfolioVisitor();
		//visitor.visit(newStock);
		PortfolioManager pf = new PortfolioManager(iterator, visitor);
		pf.reportAllItems(port);
	
	}
	

	
}
