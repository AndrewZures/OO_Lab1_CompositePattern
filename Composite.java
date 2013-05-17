import java.util.ArrayList;

public abstract class Composite {
	private ArrayList<Component> childList = new ArrayList<Component>();  //component array for composites
	protected String type = "no type specified"; //composite's type
	public String name;  //specific composite instance's name
	
	public Component getChild(int index){
		//if child at index exists, return the child component, else return null
		
		if (index > childList.size()-1){
			return null;
		}
		return childList.get(index);
	}
	
	public void add(Component component){
		//add component to childlist
		childList.add(component);	
	}
	
	public void delete(Component component){
		//delete component from child list if it exists in the list
		if (childList.contains(component)){
			childList.remove(component);
		}
		else {
			System.out.println(component.getClass().getName() + " is not a child of this component, could not be deleted");
		}
	}
		
	public double currentValue(){
		//composite's value is the sum of the values of its children
		
		//iterate through child list, sum child values, return the total sum
		double totalValue = 0;
		for (int i = 0; i < childList.size(); i++){
			totalValue += childList.get(i).currentValue();
		}
		return totalValue;
	}
	
	public void printCurrentValue(){
		//get current value and print
		double totalValue = this.currentValue();
		System.out.println("Value of " + name + " is: " + totalValue);
	}
	
	public void print(){
		//print type of component and number of children
		System.out.println("I am a " + type +". I have " + childList.size() + " children.");
		
	}
	
	public String getName(){
		//get instance's specific name
		return name;
	}
}
