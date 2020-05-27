public interface List{
	
	public int count();
	public Object get(int index);
	public Object first();
	public Object last();
	public boolean include(Object obj);
	public void append(Object obj);
	public void delete(Object obj);
	public void prepend(Object obj);
	public void deleteLast();
	public void deleteFirst();
	public void deleteAll();
}