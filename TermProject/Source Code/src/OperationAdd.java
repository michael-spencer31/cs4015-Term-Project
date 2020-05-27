public class OperationAdd implements Strategy{

	protected ContactBuilder cb = new ContactBuilder();
	
	@Override 
	public void doOperation(Contact c, int i){

		cb.buildContact(c, i);
	}
}