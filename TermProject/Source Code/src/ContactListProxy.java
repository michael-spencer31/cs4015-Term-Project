import java.util.List;

public class ContactListProxy {

	private DataManager dm;
	private Contact[] contactList;
	
	public Contact[] getContactList() {
		
		if(contactList == null) {
			
			contactList = dm.retrieveList();
		}
		return contactList;
	}
}
