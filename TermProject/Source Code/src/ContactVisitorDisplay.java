public class ContactVisitorDisplay implements ContactVisitor{

	@Override
	public boolean visit(Contact contact, String name){

		if(contact.getFirstName() != null){

			if(contact.getFirstName().equals(name)){

				return true;
			}
		}
		return false;	
	}
}