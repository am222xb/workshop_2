package View;

import java.util.Scanner;
import Module.Boat;
import Module.Member;

public class Console {
	static Scanner scanner = new Scanner(System.in);

	public String userIsNotMember(){
		System.out.print("You are not a member at our boat company!\nDo you want to create a account? [y/n]: ");
		String createAcc = scanner.next(); 
		return createAcc;
	}

	public String[] createMember(int id){
		String[] memberInformation = new String[3];
		System.out.print("\nYour first name: ");
		memberInformation[0] = scanner.next(); 

		System.out.print("Your lastname: ");
		memberInformation[0] += " "+scanner.next();

		memberInformation[1] = ""+id;	

		System.out.print("Your securitynumber: ");
		memberInformation[2] = scanner.next(); 
		return memberInformation;
	}

	public int welcomeMessage(){
		System.out.print("Welcome to our boat company! \nLog in with your id if you�re a member. \nIf you�re not a member enter 0: ");
		int memberID = scanner.nextInt();
		return memberID;
	}

	public void logOutMessage(){
		System.out.print("See ya later!");
	}

	public void welcomeMember(String name){
		System.out.println("Welcome "+name+"!\n");
	}

	public String[] createBoat(){

		String[] boatInformation = new String[2];

		System.out.print("\tWhat type of boat do you want to register: ");
		boatInformation[0] = scanner.next(); 

		System.out.print("\tHow long is the "+boatInformation[0]+": ");
		boatInformation[1] = scanner.next(); 

		System.out.println("Your boat is now registerd!");
		return boatInformation;
	}

	public void menu(){
		System.out.println("1. Register new boat");
		System.out.println("2. Change boat�s information");
		System.out.println("3. Delete boat");
		System.out.println("4. Change your member information");
		System.out.println("5. Delete member");
		System.out.println("6. View compact list");
		System.out.println("7. View verbose list");
		System.out.println("8. View your information");
		System.out.println("9. Search");
		System.out.println("10. View menu again");
		System.out.println("11. Logout");
		System.out.println("12. Exit program");
	}

	public void printList(String [][] arr){

		for(int i = 0; i < arr.length; i++){
			System.out.println("\nMember "+(i+1)+":");
			for(int k = 0; k <3; k++){
				if(k == 0)	System.out.println("\tId: "+arr[i][k]);
				else if(k == 1)	System.out.println("\tName: "+arr[i][k]);
				else if(k == 2)	System.out.println("\tSecurtynumber: "+arr[i][k]);
			}
			int counter = 1;
			for(int j = 3; j < 13; j+= 2){
				if(arr[i][j]!= null){
					System.out.println("\tBoat: "+counter);
					System.out.println("\t\tBoat type: "+arr[i][j]);
					System.out.println("\t\tLength: "+arr[i][j+1]+" m");
					counter++;
				}
			}
		}
	}

	public void boatLimitError(){
		System.err.println("You have reached your boat limit");
	}

	public void boatExistError(){
		System.err.println("Boat doesn�t exist.");
	}

	public int switchState(){
		System.out.print("\nEnter what you want to do: ");
		int state = scanner.nextInt();
		return state;
	}

	public int whichBoatNumber(){
		System.out.print("\tWhich boat do you want to manage: ");
		int boatNumber = scanner.nextInt();
		return boatNumber;
	}

	public int switchStateChangeBoat(){
		System.out.println("\t1. Change boat type");
		System.out.println("\t2. Change boat length");
		System.out.println("\t3. Change both");
		System.out.print("	Enter what you want change: ");
		int boatChange = scanner.nextInt();
		return boatChange;
	}

	public String[] changeBoat(int state){
		String[] boatInformation= new String[2];

		if(state == 1){
			System.out.print("\t\tBoat type: ");
			boatInformation[0] = scanner.next(); 
			System.out.println("The boat type is now changed!");
		}
		if(state == 2){
			System.out.print("\t\tHow long is the boat: ");
			boatInformation[0] = scanner.next(); 
			System.out.println("The length of the boat is now changed!");
		}
		if(state == 3){
			System.out.print("\t\tBoat type: ");
			boatInformation[0] = scanner.next(); 
			System.out.print("\t\tHow long is the boat: ");
			boatInformation[1] = scanner.next(); 
			System.out.println("The boat information is now changed!");
		}
		return boatInformation;
	}

	public Boolean deleteMember(){
		System.out.println("\n\tYou have deleted yourself\n");
		return false;
	}

	public void deleteBoat(){
		System.out.println("\tYour boat is now removed");
	}

	public void defaultError(){
		System.err.println("Not valid number");
	}

	public int switchStateChangeMember(){
		System.out.println("\t1. Change name");
		System.out.println("\t2. Chnage security number");
		System.out.println("\t3. Change both");
		System.out.print("	Enter what you want change: ");
		int memberChange = scanner.nextInt();
		return memberChange;
	}

	public String[] changeMember(int state){
		String[] memberInformation = new String[2];
		if(state == 1){
			System.out.print("\t\tYour first name: ");
			memberInformation[0] = scanner.next(); 

			System.out.print("\t\tYour last name: ");
			memberInformation[0] += " "+scanner.next();
			System.out.println("Your name is now changed!");

		}
		if(state == 2){
			System.out.print("\t\tSecurity number: ");
			memberInformation[0] = scanner.next(); 
			System.out.println("Your security number is now changed!");

		}
		if(state == 3){
			System.out.print("\t\tYour first name: ");
			memberInformation[0] = scanner.next(); 
			System.out.print("\t\tYour last name: ");
			memberInformation[0] += scanner.next(); 
			System.out.print("\t\tSecurity number: ");
			memberInformation[1] = scanner.next(); 
			System.out.println("Your member infromation is now changed!");
		}
		return memberInformation;
	}

	public void compactList(String[][] compactList){
		for(int i = 0; i <compactList.length; i++){
			System.out.println("\nMember "+(i+1)+":");
			for(int k = 0; k <3; k++){

				if(k == 0)	System.out.println("\tId: "+compactList[i][k]);
				else if(k == 1)	System.out.println("\tName: "+compactList[i][k]);
				else if(k == 2)	System.out.println("\tNumber of boats: "+compactList[i][k]);
			}
		}
	}

	public int switchStateSearch(){
		System.out.println("\t1. Search name");
		System.out.println("\t2. Search securitynumber");
		System.out.println("\t3. Search boat type");
		System.out.print("\tEnter what you want search for: ");
		int searchState = scanner.nextInt();
		return searchState;
	}

	public String search(int state) {
		String searchReturn = "";
		if(state == 1){
			System.out.print("\t\tName: ");
			searchReturn = scanner.next(); 
		}
		else if(state == 2){
			System.out.print("\t\tSecurity number: ");
			searchReturn= scanner.next(); 
		}
		else if(state == 3){
			System.out.print("\t\tBoat type: ");
			searchReturn = scanner.next(); 
		}
		return searchReturn;
	}


	public void welcomeMemberInformation(String name, String securityNumber, String id) {
		System.out.println("Here is your member information:\nName: "+name+"\nSecurity number: "+securityNumber+"\nId: "+id+"\n"); 

	}
}

