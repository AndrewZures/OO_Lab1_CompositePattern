README:  Lab 1 - Andrew Zures

To Run:  normal java compile ("javac $(find . | grep .java)") then run "java TestPortfolioManager"

Design:  

Account and Portfolio classes are subclasses of Composite and implement Component.  For my design, the majority of the code is actually within the superclass: Composite since I didn't get too fancy with the differences between account and portfolio.  

Stock, Bond, and MoneyMarket classes are subclasses of Investment and implement Component.  Again, for my design, the majority of the code is within the superclass: Investment since I didn't get fancy with distinguishing the types of investment.  

All of the components allow for a visitor.  The PortfolioVisitor class is a specific implementation of the Visitor interface.  Since the Visitor required the specific subclass for all components in order to tailor actions to subclass types but I wanted the visitor to handle a generic composite class (without known subclass), my PortfolioVisitor internally handles a generic component argument and diverts it to the correct, specific visitor method for the composite's implemented subclass.  

PortfolioIterator is my implementation of the interface CustomIterator.  The PortfolioIterator allows for non-linear iteration by holding all the components it has come across and indexing them individually.  This allows for recursive movement using one iterator.  

PortfolioManager is essentially everything put together.  The Portfolio Manager, will recursively search all the components and ask the visitor to visit each component.  

TestPortfolioManager sets up the environment, creating a test portfolio, and testing some basic functionality of the design. 