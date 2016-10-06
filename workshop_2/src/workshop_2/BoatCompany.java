package workshop_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoatCompany {
	static Scanner scanner = new Scanner(System.in);
	static Authentication authenticate = new Authentication();
	static Registry registry = new Registry();
	static Member member;
	static int id = 0;

	public static void main(String[] args) throws FileNotFoundException {

		System.out.print("Welcome to Tors boats and hoes! \nLog in with your id if you�re a member. \nIf you�re not a member enter 0: ");
		id = scanner.nextInt(); 

		if(!authenticate.validateID(id)){
			System.out.print("You are not a member of Tors boats and hoes!\nDo you want to create a account? [y/n]");
			String createAcc = scanner.next(); 
			if(createAcc.charAt(0)== 'y'){
			System.out.print("Your first name: ");
			String name = scanner.next(); 

			System.out.print("Your lastname: ");
			name += " "+scanner.next();

			System.out.print("Your securitynumber: ");
			String securityNumber = scanner.next(); 

			System.out.println("Information: "+name+" "+securityNumber);
			authenticate.createMember(name, securityNumber);
			registry = new Registry();
			member = registry.getMember(id); 
			System.out.println("Welcome "+member.getName()+"to the club.\n");
			gui();
			}
			else{
				System.out.println("Bye!");
			}
		}
		else{
			registry = new Registry();
			member = registry.getMember(id); 
			System.out.println("Welcome back "+member.getName()+"!\n");
			gui();
		}
	}

	public static void gui() throws FileNotFoundException{
		menu();
		Boolean exit = true; 
		while(exit){

			System.out.print("\nEnter what you want to do: ");
			int state = scanner.nextInt();

			switch (state) {
			case 1:  
				System.out.print("\tWhat type of boat do you want to register: ");
				String boatType = scanner.next(); 

				System.out.print("\tHow long is the "+boatType+": ");
				String boatLength = scanner.next(); 
				member.writeBoatToFile(boatType, boatLength);
				System.out.println("Your boat is now registerd!");
				break;

			case 2:  
				System.out.print("	Which boat do you want to change: ");
				int boatNr = scanner.nextInt();
				
				System.out.println("\t1. Change boat type");
				System.out.println("\t2. Change boat length");
				System.out.println("\t3. Change both");
				System.out.print("	Enter what you want change: ");
				int boatChange = scanner.nextInt();

				switch (boatChange) {
				case 1:  
					System.out.print("Boat type: ");
					String boatTypeChange = scanner.next(); 
					member.manageBoat(boatNr, boatTypeChange, member.listOfBoats[boatNr-1].getLength());
					System.out.println("The boat type is now changed!");
					break;

				case 2:  
					System.out.print("\tHow long is the boat: ");
					String boatLengthChange = scanner.next(); 
					member.manageBoat(boatNr, member.listOfBoats[boatNr-1].getType(),boatLengthChange );
					System.out.println("The length of the boat is now changed!");
					break;
				case 3:  
					System.out.print("\tBoat type: ");
					boatTypeChange = scanner.next(); 
					System.out.print("\tHow long is the boat: ");
					boatLengthChange = scanner.next(); 
					member.manageBoat(boatNr, boatTypeChange, boatLengthChange);
					System.out.println("The boat information is now changed!");
					break;
				}
				break;

			case 3:  
				System.out.println("\tWhich boat do you want to delete: ");
				int deleteBoatId = scanner.nextInt();
				member.deleteBoat(deleteBoatId);
				System.out.println("Your boat is now removed");
				break;

			case 4:  
				System.out.println("\t1. Change name");
				System.out.println("\t2. Chnage security number");
				System.out.println("\t3. Change both");
				System.out.print("	Enter what you want change: ");
				int memberChange = scanner.nextInt();

				switch (memberChange) {
				case 1:  
					System.out.print("\nYour first name: ");
					String changeName = scanner.next(); 

					System.out.print("\nYour last name: ");
					changeName += " "+scanner.next();
					member.setName(changeName);
					System.out.println("Your name is now changed!");
					break;

				case 2:  
					System.out.print("\nSecurity number: ");
					String changeSecurityNumber = scanner.next(); 
					member.setSecurityNumber(changeSecurityNumber);
					System.out.println("Your Security number is now changed!");
					break;
				case 3:  
					System.out.print("\nYour first name: ");
					changeName = scanner.next(); 
					System.out.print("\nYour last name: ");
					changeName += " "+scanner.next();
					System.out.print("\nSecurity number: ");
					changeSecurityNumber = scanner.next(); 
					member.manageMember(changeName, changeSecurityNumber);
					System.out.println("Your member infromation is now changed!");
					break;
				}		
				break;

			case 5: 
				String[][] compactList = registry.getCompactList();
				for(int i = 0; i <compactList.length; i++){
					System.out.println("\nMember "+(i+1)+":");
					for(int k = 0; k <3; k++){

						if(k == 0)	System.out.println("\tId: "+compactList[i][k]);
						else if(k == 1)	System.out.println("\tName: "+compactList[i][k]);
						else if(k == 2)	System.out.println("\tNumber of boats: "+compactList[i][k]);
					}
				}
				break;

			case 6: 
				String[][] verboseList = registry.getVerboseList();
				System.out.println("\nVerbose list:");
				for(int i = 0; i <verboseList.length; i++){
					System.out.println("\nMember "+(i+1)+":");
					int numberOfBoats = 2*registry.listOfMembers.get(i).getNumberOfBoats();
					for(int k = 0; k <3; k++){
						if(k == 0)	System.out.println("\tId: "+verboseList[i][k]);
						else if(k == 1)	System.out.println("\tName: "+verboseList[i][k]);
						else if(k == 2)	System.out.println("\tSecurtynumber: "+verboseList[i][k]);
					}
					int counter = 1;
					for(int j = 3; j < (3+numberOfBoats); j+= 2){

						System.out.println("\tBoat "+counter);
						System.out.println("\t\tBoat type: "+verboseList[i][j]);
						System.out.println("\t\tLength: "+verboseList[i][j+1]+" m");
						counter++;
					}
				}
				break;

			case 7:  
				System.out.println("\t1. Search name");
				System.out.println("\t2. Search securitynumber");
				System.out.println("\t3. Search boat type");
				System.out.print("\tEnter what you want search for: ");
				int search = scanner.nextInt();

				switch (search) {
				case 1:  
					System.out.print("Name: ");
					String searchName = scanner.next(); 
					String[][] searchArr = registry.containsName(searchName);
					printArray(searchArr);
					break;

				case 2:  
					System.out.print("Security number: ");
					String searchSecurityNr= scanner.next(); 
					searchArr = registry.containsSecurityNumber(searchSecurityNr);
					printArray(searchArr);
					break;
				case 3:  
					System.out.print("Boat type: ");
					String searchBoatType = scanner.next(); 
					searchArr = registry.containsTypeOfBoat(searchBoatType);
					printArray(searchArr);
					break;
				}		
				break;
			case 8:  
				menu();
				break;

			case 9: 
				exit = false;
				break;

			default: 
				System.out.println("Not valid number");
				break;
			}
			registry = new Registry();
		}
		System.out.println("Good bye");
	}


	public static void menu(){
		System.out.println("1. Register new boat");
		System.out.println("2. Change boat�s infromation");
		System.out.println("3. Delete boat");
		System.out.println("4. Change your member infromation");
		System.out.println("5. View compact list");
		System.out.println("6. View verbose list");
		System.out.println("7. Search member");
		System.out.println("8. View menu again");
		System.out.println("9. Exit program");
	}
	public static void printArray(String [][] arr){
		
		for(int i = 0; i < arr.length; i++){
			System.out.println("\nMember "+(i+1)+":");
			int numberOfBoats = 2*registry.listOfMembers.get(i).getNumberOfBoats();
			for(int k = 0; k <3; k++){
				if(k == 0)	System.out.println("\tId: "+arr[i][k]);
				else if(k == 1)	System.out.println("\tName: "+arr[i][k]);
				else if(k == 2)	System.out.println("\tSecurtynumber: "+arr[i][k]);
			}
			int counter = 1;
			for(int j = 3; j < 13; j+= 2){
				if(arr[i][j]!= null){
				System.out.println("\tBoat "+counter);
				System.out.println("\t\tBoat type: "+arr[i][j]);
				System.out.println("\t\tLength: "+arr[i][j+1]+" m");
				counter++;
				}
			}
		}
	}
}
