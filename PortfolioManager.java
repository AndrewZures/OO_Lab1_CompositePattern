

public class PortfolioManager {
	
	private CustomIterator iterator;
	private Visitor visitor;
	private static PortfolioManager INSTANCE = null;
	
	private PortfolioManager() { }

	
    public static PortfolioManager getInstance(CustomIterator newIterator, Visitor newVisitor) { 
    		//create singleton instance if not already instantiated, using iterator and visitor
		if (INSTANCE == null){	
			INSTANCE = new PortfolioManager();
			INSTANCE.iterator = newIterator;
			INSTANCE.visitor = newVisitor;
		}
		else {
			System.out.println("Portfolio Manager Already Instantiated");
		}
		return INSTANCE;
    }
    
    public static PortfolioManager getInstance() { 
    		/* retrieve portfolio manager singleton instance, or instantiate without iterator and visitor
    		  a warning will occur if the instance is newly instantiated w/o iterator and visitor */
		if (INSTANCE == null){	
			
			//if no current instance, instantiate
			INSTANCE = new PortfolioManager();
			if (INSTANCE.iterator == null || INSTANCE.visitor == null){
				//if instantiation has no iterator or visitor, warn the user
				System.out.println("WARNING: Portfolio Manager instantiated without visitor and/or iterator!");
			}
		}
		else {
			//if instance already exists, give warning
			System.out.println("Portfolio Manager Already Instantiated");
		}
		return INSTANCE;
    }
    
    public void setVisitor(Visitor newVisitor){
    		//allow for visitor to be set to another type of visitor
    		visitor = newVisitor;
    }
    
    public void setIterator(CustomIterator newIterator){
    	//allow for iterator to be set to another type of iterator
    		iterator = newIterator;
    }
	

	public void evaluate (Component component){
		/*   iterate over component and provide a summary
		 *   if component is composite, print out values of sub-components
		 *   if component is leaf, print out value of leaf */
		
		System.out.print("Summary: ");  //title
		this.visitor.visit(component);  //visit the current component
		
		if (this.iterator.hasNext(component)){
			//if component is composite, show sub-Items title
			System.out.println("   -SubItems------");
		}
		int index = 1;
		while(this.iterator.hasNext(component)){
			//if component is composite, visit each subComponent
			Component subComponent = this.iterator.next(component);
			System.out.print("   " + index + ". ");
			visitor.visit(subComponent);
			index++;
		}	
		System.out.println("------------");
		
		/*since listing subComponents (above) required going through subComponent array w/o recursing
		 * reset the interator's index and go through array again, so that subComponents can be recursively evaluated */
		this.iterator.resetIndexForComponent(component);
		
		//recursively evaluate subComponents
		while(this.iterator.hasNext(component)){
				Component subComponent = this.iterator.next(component);
				this.evaluate(subComponent);  //recursive call
		}
	}

}
