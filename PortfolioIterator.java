import java.util.HashMap;

public class PortfolioIterator implements CustomIterator {
	
	private HashMap<Component, Integer> componentMap = new HashMap<Component, Integer>();

	public void iterate (Component component){
		//component.print();
		System.out.println("class: " + component.getClass().getName());
		//visitor.visit(component);
		while(this.hasNext(component)){
			//System.out.print("iterating down");
			Component subComponent = this.next(component);
			this.iterate(subComponent);
		}
	}
	
	
	public boolean hasNext(Component component){
			
			if (componentMap.containsKey(component)){}    //if component is already in map, do nothing
			else {componentMap.put(component, -1);} //otherwise add the component to the map, initializing index to -1

			//get the subcomponent at current index + 1;
			Component subComponent = component.getChild(componentMap.get(component)+1);

			//if subComponent at next index is == null, return false
			 return subComponent != null ? true : false;
	}

	public Component first(Component component){
		return component.getChild(0);
	}
	
	public Component next(Component component) {
		// TODO Auto-generated method stub
		if (!componentMap.containsKey(component)){
			System.out.println("Component is not in iterator map, returning null");
			return null;
		}
		else {
			componentMap.put(component, componentMap.get(component)+1);
			return component.getChild(componentMap.get(component));
		}
		
	}
	
	public void resetIndexForComponent(Component component){
		if (!componentMap.containsKey(component)){
			System.out.println("Component is not in iterator map, cannot reset index");
		}
		else {
			componentMap.put(component, -1);
		}
	}

	public void remove(Component component) {
		// TODO Auto-generated method stub
		//iterator for this assignment does not remove anything
	}

}
