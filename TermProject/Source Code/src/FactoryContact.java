import java.util.HashMap;

public class FactoryContact{

	private static FactoryContact singleInstance;
	@SuppressWarnings("rawtypes")
	private static final HashMap contactMap = new HashMap();

	public static FactoryContact getInstance(){

		if(singleInstance == null) singleInstance = new FactoryContact();
		return singleInstance;
	}
	@SuppressWarnings("unchecked")
	public Contact getContact(String fName, String lName, String city, String phone, String email){

		Contact contact = (Contact)contactMap.get(fName);

		if(contact == null){
			contact = new Contact(fName, lName,city, phone, email);
			contactMap.put(fName, contact);
		}
		return contact;
	}
}