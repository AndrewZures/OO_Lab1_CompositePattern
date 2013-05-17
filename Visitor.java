
public interface Visitor {
	//visitor interface
	
	void visit (Component component);
	void visit (Portfolio portfolio);
	void visit (Account account);
	void visit (Bond bond);
	void visit (MoneyMarket moneyMarket);
	void visit (Stock stock);
}
