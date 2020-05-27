
public class PrototypeDisplay {

	private EnterCommand enterPrototype;
	private RemoveCommand removePrototype;
	
	public void displayEnter() {
		
		Command enterCommand = enterPrototype.cloneMe();
	}
	public void displayRemove() {
		
		Command removeCommand = removePrototype.cloneMe();
	}
	public void setEnterPrototype(EnterCommand command) {
		
		this.enterPrototype = command;
	}
	public void setRemovePrototype(RemoveCommand command) {
		
		this.removePrototype = command;
	}
	public Command getEnterCommand() {
		
		return enterPrototype;
	}
	public Command getRemoveCommand() {
		
		return removePrototype;
	}
}
