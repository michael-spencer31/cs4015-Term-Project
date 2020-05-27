
public class RemoveCommand extends Command{
	
	private DataManager dm = new DataManager();
	private Contact[] list = dm.retrieveList();
	private int i = 15;

	public RemoveCommand(ContactQueue queue) {
		
		this.queue = queue;
	}
	public void execute() {
		
		memento = queue.createMemento();
		//queue.dequeue();
		list[i] = queue.head();
		i++;
	}
	public Contact unexecute() {
		
		queue.setMemento(memento);
		return null;
	}
	@Override
	public Command cloneMe() {
		// TODO Auto-generated method stub
		RemoveCommand command = new RemoveCommand(queue);
		
		return command;
	}
}
