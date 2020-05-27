
public abstract class Command {

	protected CMemento memento;
	protected ContactQueue queue;
	
	public void execute() {
		
	}
	public Contact unexecute() {
		return null;
		
		
	}
	public abstract Command cloneMe();
}
