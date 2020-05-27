public class SystemFacade{
	
	private ContactManager contactManager = new ContactManager();
	private ContactFinder contactFinder = new ContactFinder();
	private DataManager dataManager = new DataManager();

	public SystemFacade(){


	}
	public void addContact(Contact c1){

		this.contactManager.addContact(c1);
	}
	public void deleteContact(String c1){

		this.contactManager.deleteContact(c1);
	}
	public void searchContact(String name){

		this.contactFinder.findContact(name);

	}
	public void saveContact(){

		dataManager.save();
	}
	public void loadContact(){

		dataManager.load();
	}
}