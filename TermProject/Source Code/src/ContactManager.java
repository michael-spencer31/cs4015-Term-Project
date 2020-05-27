public class ContactManager{

	private DataManager dataManager = new DataManager();
	
	public void deleteContact(String c1){

		this.dataManager.deleteFromList(c1);

	}
	public void addContact(Contact c1){

		this.dataManager.addToList(c1);
	}
}