
public class ContactFinder{

	private DataManager dataManager = new DataManager();

	public void findContact(String name){

		this.dataManager.locateContact(name);
	}


}