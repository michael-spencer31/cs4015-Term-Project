import java.util.Stack;

public class ContactStack {
	
	private Stack<Command> commandStack = new Stack<Command>();
	
	public void add(Command enterCommand) {
		
		commandStack.push(enterCommand);
	}
	public void push(Command enterCommand) {
		
	}
	public Command pop() {
		
		return commandStack.pop();
	}
}
