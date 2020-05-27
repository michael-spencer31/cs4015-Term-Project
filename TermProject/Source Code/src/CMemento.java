import java.util.ArrayList;

public class CMemento {

	private ArrayList<Contact> arrayList = new ArrayList<Contact>();
	
	public ArrayList<Contact> getState(){
		return arrayList;
	}
	public void setState(ArrayList<Contact> state) {
		this.arrayList = state;
	}
}
