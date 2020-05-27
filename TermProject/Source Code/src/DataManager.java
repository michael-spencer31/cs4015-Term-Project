import java.util.*;
import java.io.*;

public class DataManager{

  //private Writer writer;
  public static Contact[] contactList = new Contact[30];
  protected int i = 0;

  	public void save(){

      @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);

      String fileName = "";
      System.out.println("What would you like to save your list as?");
      fileName = scan.next();

      try{
        PrintWriter writer = new PrintWriter(fileName + ".txt", "UTF-8");

        System.out.println(contactList.length);
        for(int i = 0; i < contactList.length; i++){

          if(contactList[i] != null){

            writer.println(contactList[i]);
          }
        }
        writer.close();
      }catch(IOException e){
        System.err.println("IO Error");
      }finally{
        System.out.println("Contact List Saved!");
      }
  	}
 	@SuppressWarnings("unused")
	public void load(){

      @SuppressWarnings("resource")
      Scanner scan = new Scanner(System.in);
      String fileName = "";
      System.out.println("What list would you like to load?");
      fileName = scan.next();

      for(int i = 0; i < contactList.length; i++){

        contactList[i] = null;
      }
      try{

        LineNumberReader lnr = new LineNumberReader(new FileReader(new File("Contacts.txt")));
        lnr.skip(Long.MAX_VALUE);

        long length = lnr.getLineNumber();
        lnr.close();

        BufferedReader in = new BufferedReader(new FileReader("Contacts.txt"));
        
        for(int j = 0; j < length / 1; j+=1){

          String firstName = in.readLine();
          String lastName = in.readLine();
          String address = in.readLine();
          String phone = in.readLine();
          String email = in.readLine();
          contactList[j] = new Contact(firstName, lastName, address, phone, email);
        }
        in.close();
      }catch(IOException e){
        System.err.println("IO Error");
      }finally{
        System.out.println("Contact List Loaded!");
      }
  	}
    public Contact getContact(String name){

      for(int i = 0; i < contactList.length; i++){

        if(contactList[i].getFirstName().equals(name)){

          return contactList[i];
        }
      }
      return null;
    }
    public void getList(){

      ContactRepository contactRepository = new ContactRepository();
      ContactListProxy clp = new ContactListProxy();
      
      for(Iterator iter = contactRepository.getIterator(); iter.hasNext();){

        Contact c1 = (Contact)iter.next();

        if(c1 != null){

          System.out.println("Contact: " + c1);
        }
      }
    }
    public Contact[] retrieveList() {
    	
    	return contactList;
    }
    public void addToList(Contact c1){

      OperationAdd addOp = new OperationAdd();
      addOp.doOperation(c1, i);

      i++;
    }
    public void deleteFromList(String name){
      System.out.println("Contact Removed!");

      for(int i = 0; i < contactList.length; i++){

        if(contactList[i] != null){

         String s = contactList[i].getFirstName();

         if(s.equals(name)){

          contactList[i] = null;
         }
        }
      }   
    }
    boolean found = false;
    
    public void locateContact(String name){
      ContactVisitorDisplay cvd = new ContactVisitorDisplay();

      for(int x = 0; x < contactList.length; x++){

        if(cvd.visit(contactList[x], name)){

          System.out.println(contactList[x]);
          found = true;
          break;
        }
    }
      if(!found) {
    	  
    	  System.out.println("Contact not found in list");
      }
  }
}
