import java.util.ArrayList;

public class ContactQueue {

	private ArrayList<Contact> arrayList = new ArrayList<Contact>();
	
	public void enqueue(Contact c) {
		
		arrayList.add(c);
	}
	public Contact head() {
		
		return arrayList.get(0);
	}
	public void dequeue() {
		
		arrayList.remove(0);
	}
	public boolean isEmpty() {
		
		if(arrayList.isEmpty()) {
			
			return true;
		}
		return false;
	}
	public void printAll() {
		
		for(int i = 0; i < arrayList.size(); i++) {
			
			System.out.print(arrayList.get(i) + " ");
		}
	}
	@SuppressWarnings("unchecked")
	public CMemento createMemento() {
		
		CMemento qm = new CMemento();
		
		@SuppressWarnings("rawtypes")
		ArrayList copiedList = new ArrayList(this.arrayList);
		qm.setState(copiedList);
		return qm;
	}
	public void setMemento(CMemento qm) {
		
		this.arrayList = qm.getState();
	}
}
