
public class TestPortfolioManager {

	public static void main (String args[]){
		
		//Test 1: Create Portfolio Manager, check singleton status
		System.out.println("Test 1: Check Singleton Status");
		
		PortfolioIterator iterator = new PortfolioIterator();
		PortfolioVisitor visitor = new PortfolioVisitor();
		
		//PortfolioManager hello = new PortfolioManager();  <-- this won't compile, which is good
		
		//get singleton instance
		PortfolioManager manager = PortfolioManager.getInstance(iterator, visitor);
		
		//try to get another instance, should throw warning, but not exception
		PortfolioManager gecko = PortfolioManager.getInstance(iterator, visitor);
		
		
		//Test 2: Create Portfolio of different composites and leafs, evaluate it using manager
		System.out.println(""); //blank line
		System.out.println("Test 2: create portfolio, evaluate using portfolio manager");
		
		Portfolio portfolio1 = new Portfolio("Portfolio 1");
		
		//create stock (leaf), add to portfolio
		Stock stock1 = new Stock("Stock 1");
		stock1.add(200, 84);
		portfolio1.add(stock1);
		
		//create composite account, add to portfolio
		Account account1 = new Account("Account 1");
		portfolio1.add(account1);
		
		//create two bonds (leafs), add to Account
		Bond bond1 = new Bond("Bond 1", 20, 40);
		Bond bond2 = new Bond("Bond 2", 30, 15);
		account1.add(bond1);
		account1.add(bond2);
		
		//create second account, add MM to it, then add the account to Account 1
		Account account2 = new Account("Account 2");
		MoneyMarket moneyM1 = new MoneyMarket("Money Market 1", 30, 15);
		account2.add(moneyM1);
		account1.add(account2);
		
		//At this point, there are three composite levels, Portfolio1, Account1, Account2, with leaves at each each level
		
		//evaluate portfolio1 using PortfolioManager manager
		manager.evaluate(portfolio1);

		/*  END Test 2 */
		
		//Test 3:  attempt to add leaf to leaf
		System.out.println(""); //blank line
		System.out.println("Test 3: attempt to add and delete leaf to leaf");
		Stock stock2 = new Stock("Stock 2", 100, 25);
		stock1.add(stock2);
		bond1.add(stock1);
		moneyM1.delete(bond1);
		
		// END Test 3
		
		//Test 4: delete child from composite
		System.out.println(""); //blank line
		System.out.println("Test 4: delete child from composite component");
		System.out.println("removing Account 1 and evaluation portfolio using manager");
		portfolio1.delete(account1);
		manager.evaluate(portfolio1);
		
		//END Test 4
		
		//Test 5: Test Investment functionality (minor)
		System.out.println(""); //blank line
		System.out.println("Test 5 (minor): test investment functionality: add and remove stock with prices");
		System.out.println("Stock 1 value should change without error:");
		stock1.add(100, 90);
		stock1.remove(50, 92);
		manager.evaluate(portfolio1);
		
	}

}  //end class
