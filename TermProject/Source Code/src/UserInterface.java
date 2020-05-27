import java.util.*;

public class UserInterface{
	
	@SuppressWarnings("resource")
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		SystemFacade systemFacade = new SystemFacade();
		DataManager dataManager = new DataManager();
		
		ContactQueue cq = new ContactQueue();
		EnterCommand enterCommand;
		RemoveCommand removeCommand;
		ContactStack commandStack = new ContactStack();
		
		PrototypeDisplay prototypeDisplay = new PrototypeDisplay();
		

		int c;

		try{

			do{

				System.out.println("What would you like to do?");
				System.out.println("(1) Add a new Contact");
				System.out.println("(2) Delete a Contact");
				System.out.println("(3) Search for a Contact");
				System.out.println("(4) Load a list of Contacts");
				System.out.println("(5) Save a list of Contacts");
				System.out.println("(6) View your contact list");
				System.out.println("(7) Undo");
				System.out.println("(8) Exit the Program");

				c = scan.nextInt();

				if(c == 1){

					String firstName, lastName, city, email, phone;

					System.out.println("Enter contact first name: ");
					firstName = scan.next();
					System.out.println("Enter contact last name: ");
					lastName = scan.next();
					System.out.println("Enter contact city: ");
					city = scan.next();
					System.out.println("Enter contacts email: ");
					email = scan.next();
					System.out.println("Enter contacts phone number: ");
					phone = scan.next();

					FactoryContact contactFactory = new FactoryContact();
					Contact contact = contactFactory.getContact(firstName, lastName, city, email, phone);
					systemFacade.addContact(contact);
					
					enterCommand = new EnterCommand(cq, contact);
					prototypeDisplay.setEnterPrototype(enterCommand);
					prototypeDisplay.getEnterCommand();
					commandStack.add(prototypeDisplay.getEnterCommand());
					enterCommand.execute();
				}
				if(c == 2){

					String deleteName;
					System.out.println("Which contact would you like to delete?");
					deleteName = scan.next();

					systemFacade.deleteContact(deleteName);
					
					removeCommand = new RemoveCommand(cq);
					prototypeDisplay.setRemovePrototype(removeCommand);
					removeCommand.execute();
					commandStack.add(prototypeDisplay.getRemoveCommand());
				}
				if(c == 3){

					String findName;
					System.out.println("Which contact would you like to search for?");
					findName = scan.next();
					systemFacade.searchContact(findName);	
				}
				if(c == 4){

					systemFacade.loadContact();
				}
				if(c == 5){

					systemFacade.saveContact();
				}
				if(c == 6){

					Scanner scan2 = new Scanner(System.in);
					String userChoice;
					String contactToDecorate = "";
					System.out.println("Would you like to apply a decorator to your list? <y/n>");

					userChoice = scan2.next();

					if(userChoice.equals("y")){

						System.out.println("Which contact would you like to see?");
						contactToDecorate = scan.next();

						Contact newContact = dataManager.getContact(contactToDecorate);

						FancyContactDecorator fcd = new FancyContactDecorator(newContact);

						fcd.draw();
					}else{

						dataManager.getList();
					}
				}
				if(c == 7){

					Command command = commandStack.pop();
					command.unexecute();
				}
			}while(c != 8);
		}catch(InputMismatchException e){

			System.out.println("An error has occured: ");
			System.err.println(e);
		}catch(NullPointerException e) {
			
			System.out.println("An error has occured: ");
			System.err.println(e);
		}catch(StackOverflowError e) {
			
			System.out.println("An error has occured: ");
			System.err.println(e);
		}finally{
			System.out.println("Bye!");
		}
	}
}