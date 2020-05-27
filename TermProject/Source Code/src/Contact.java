

public class Contact extends DataManager implements SuperContact, List{

	public String firstName;
	public String lastName;
	public String address;
	public String phone;
	public String email;

	public Contact(String firstName, String lastName, String address, String email, String phone){

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public String toString(){

		return this.firstName + " " + this.lastName + " " + this.address + " " + this.email + " " + this.phone;
	}
	public String getFirstName(){

		return this.firstName;
	}
	public String getLastName(){

		return this.lastName;
	}
	public String getCity(){

		return this.address;
	}
	public String getPhoneNumber(){

		return this.phone;
	}
	public String getEmail(){

		return this.email;
	}
	public void setFirstName(String name){
		this.firstName = name;
	}
	public void setLastName(String name){
		this.lastName = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void draw(){

	}
	public void deleteAll(){

		for(int i = 0; i < contactList.length; i++){

			contactList[i] = null;
		}
	}
	public void deleteFirst(){

		contactList[0] = null;
	}
	public void deleteLast(){

		contactList[contactList.length - 1] = null;
	}
	public int count(){

		return contactList.length;
	}
	public Object first(){

		return contactList[0];
	}
	public Object last(){

		return contactList[contactList.length];
	}
	public boolean include(Object obj){

		for(int i = 0; i < contactList.length; i++){

			if(contactList[i].equals(obj)){

				return true;
			}
		}
		return false;
	}
	public Object get(int i){

		return contactList[i];
	}
	public void prepend(Object obj){

		contactList[0] = (Contact)obj;
	}
	public void delete(Object obj){

		for(int i = 0; i < contactList.length; i++){

			if(contactList[i].equals(obj)){

				contactList[i] = null;
			}
		}
	}
	public void append(Object obj){
		
	
	}
}