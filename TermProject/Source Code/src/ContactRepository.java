public class ContactRepository extends DataManager implements Container{

	protected Contact contacts[];

	@Override
	public Iterator getIterator(){

		return new NameIterator();
	}
	private class NameIterator implements Iterator{

		int index;

		@Override 
		public boolean hasNext(){

			if(index < contactList.length){

				return true;
			}
			return false;
		}
		@Override
		public Object next(){

			if(this.hasNext()){
				return contactList[index++];
			}
			return null;
		}
	}
}
