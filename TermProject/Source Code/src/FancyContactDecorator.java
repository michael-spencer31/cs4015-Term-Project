public class FancyContactDecorator extends ContactDecorator{

	public FancyContactDecorator(Contact decoratedContact){
		super(decoratedContact);
	}
	@Override
	public void draw(){

		setEffect(decoratedContact);
	}
	private void setEffect(Contact decoratedContact){

		System.out.println("===================================================");
		System.out.println("First Name: " + decoratedContact.getFirstName());
		System.out.println("Last Name: " + decoratedContact.getLastName());
		System.out.println("City: " + decoratedContact.getCity());
		System.out.println("Email: " + decoratedContact.getEmail());
		System.out.println("Phone Number: " + decoratedContact.getPhoneNumber());
		System.out.println("===================================================");

	}
}