
public interface CustomIterator {

	public void iterate(Component component);
	public boolean hasNext(Component component);
	public Component next(Component component);
	public void remove(Component component);
	public void resetIndexForComponent(Component component);  //allows for breadth-first movement through Nodes
}
