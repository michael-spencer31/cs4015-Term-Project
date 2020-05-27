public abstract class ContactDecorator implements SuperContact{

	protected Contact decoratedContact; 

	public ContactDecorator(Contact decoratedContact){

		this.decoratedContact = decoratedContact;
	}
	public void draw(){

		decoratedContact.draw();
	}
}