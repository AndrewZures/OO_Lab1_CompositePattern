
public interface Component {
	
	public void accept (Visitor visitor); 	 
	public void add(Component component);	 
	public void delete(Component component);	 
	public double currentValue();			
	public Component getChild(int index);	 
	public void print();
	public String getName();
	public void printCurrentValue();
	
}
