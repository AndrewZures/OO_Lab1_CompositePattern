
public abstract class Investment {
	
	public int amount = 0;
	public double totalCost;
	public String type;
	public String name;
	
	public void add(Component component){
		System.out.println(name + " is a leaf, cannot add sub-component");
	}
	
	public void add(int addedAmount, double price){
		amount += addedAmount;
		totalCost += price * addedAmount;
	}
	
	public void delete(Component component){
		System.out.println(name + " is a leaf, cannot delete sub-component");
	}
	
	public void remove(int removalAmount, double price){
		
		if (removalAmount > amount){
			System.out.println("You don't own " + removalAmount + " shares");
		}
		else {
			totalCost -= price * removalAmount;
			amount -= removalAmount;
		}

	}
	
	public Component getChild(int index){
		return null;
	}
	
	public double currentValue(){
		return totalCost;

	}
	
	public void print(){
		System.out.println("I am a " + type);
	}
	
	public void printCurrentValue(){
		System.out.println("Value of " + name + " is " + totalCost );
	}
	
	public String getName(){
		return name;
	}
	
}
