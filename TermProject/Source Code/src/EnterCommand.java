
public class EnterCommand extends Command {

	private Contact contact;
	private DataManager dm = new DataManager();
	private Contact[] list = dm.retrieveList();
	
	public EnterCommand(ContactQueue queue, Contact contact) {
		
		this.queue = queue;
		this.contact = contact;
	}
	public void execute() {
		
		memento = queue.createMemento();
		queue.enqueue(contact);
	}
	public Contact unexecute(){
		
		queue.setMemento(memento);
		return contact;
	}
	@Override
	public Command cloneMe() {
		// TODO Auto-generated method stub
		EnterCommand command = new EnterCommand(queue, contact);
		
		return command;
	}
}
