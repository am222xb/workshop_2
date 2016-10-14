package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Module.Boat;
import Module.Member;
import Module.Registry;
import View.Console;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Registry registry = new Registry();
		boolean start = false;
		Console consoleView = new Console();
		Member user = new Member(0, null, null);

		int memberID = consoleView.welcomeMessage();
		if(!registry.containsID(memberID)){

			String createAccount = consoleView.userIsNotMember();

			if(createAccount.charAt(0)== 'y'){
				String[] memberInformation = consoleView.createMember(registry.getNextValidID());

				user.createMember(memberInformation[0], memberInformation[2], Integer.parseInt(memberInformation[1]));
				if(user.getID() != 0){
					registry = new Registry();
					user = registry.getMember(Integer.parseInt(memberInformation[1])); 
					consoleView.welcomeMember("to the boat club");
					start = true;
					consoleView.welcomeMemberInformation(user.getName(), user.getSecurityNumber(), memberInformation[1]);
				}
				else{
					main(args);
				}
			}
			else{
				main(args);
			}
		}
		else{
			registry = new Registry();
			user = registry.getMember(memberID); 
			consoleView.welcomeMember(user.getName());
			start = true;
		}


		consoleView.menu();
		while(start){

			switch (consoleView.switchState()) {
			case 1:  
				if(user.getNumberOfBoats() < 5){
					String[] boatInformation = consoleView.createBoat();
					user.addBoat(boatInformation[0], boatInformation[1]); //TODO new name
				}
				else{
					consoleView.boatLimitError();
				}
				break;

			case 2:  
				int boatNumber = consoleView.whichBoatNumber();

				if(user.getBoat(boatNumber) != null){				
					int boatChange = consoleView.switchStateChangeBoat();

					switch (boatChange) {
					case 1:  
						String[] boatType = consoleView.changeBoat(boatChange);
						user.manageBoat(boatNumber, boatType[0], user.getAllBoats()[boatNumber-1].getLength());//TODO listofboats
						break;
					case 2:  
						String[] boatLength = consoleView.changeBoat(boatChange);
						user.manageBoat(boatNumber, user.getAllBoats()[boatNumber-1].getType(),boatLength[0] );
						break;
					case 3:  
						String[] boatInformation= consoleView.changeBoat(boatChange);
						user.manageBoat(boatNumber, boatInformation[0], boatInformation[1]);
						break;
					}
				}
				else{
					consoleView.boatExistError();
				}
				break;

			case 3:  
				boatNumber = consoleView.whichBoatNumber();
				if(user.getBoat(boatNumber) != null){
					user.deleteBoat(boatNumber);
					consoleView.deleteBoat();
				}
				else{
					consoleView.boatExistError();
				}
				break;

			case 4:  
				int memberChange = consoleView.switchStateChangeMember();
				switch (memberChange) {
				case 1:  
					String[] changeName = consoleView.changeMember(memberChange);
					user.setName(changeName[0]);
					break;

				case 2:  
					String[] changeSecurityNumber = consoleView.changeMember(memberChange);
					user.setSecurityNumber(changeSecurityNumber[0]);
					break;
				case 3:  
					String[] memberInformation =consoleView.changeMember(memberChange);
					user.setName(memberInformation[0]);
					user.setSecurityNumber(memberInformation[1]);
					break;
				}		
				break;

			case 5: 
				user.deleteMember();
				start = consoleView.deleteMember();
				main(args);
				break;

			case 6: 
				consoleView.compactList(registry.getCompactList());
				break;

			case 7: 
				consoleView.printList(registry.getVerboseList());
				break;

			case 8:


				String[][] arr = new String[1][13];
				arr[0][0] = ""+user.getID();
				arr[0][1] = user.getName();
				arr[0][2] = user.getSecurityNumber();
				Boat[] boats = user.getAllBoats();
				int counter=0;
				for(int i = 3; i < (boats.length+3);i+=2){
					if(boats[counter]!= null){
						arr[0][i] = boats[counter].getType();
						arr[0][i+1] = boats[counter].getLength();
					}
					counter++;

				}
				consoleView.printList(arr);				
				break;

			case 9:  
				int searchState = consoleView.switchStateSearch();

				switch (searchState) {
				case 1:  
					String searchName = consoleView.search(searchState);
					String[][] searchArr = registry.containsName(searchName);
					consoleView.printList(searchArr);
					break;

				case 2:  
					String searchSecurityNr= consoleView.search(searchState);
					searchArr = registry.containsSecurityNumber(searchSecurityNr);
					consoleView.printList(searchArr);
					break;
				case 3:  
					String searchBoatType = consoleView.search(searchState);
					searchArr = registry.containsTypeOfBoat(searchBoatType);
					consoleView.printList(searchArr);
					break;
				}		
				break;
			case 10:  
				consoleView.menu();
				break;

			case 11: 
				main(args);
				break;

			case 12: 
				System.exit(1);
				break;

			default: 
				consoleView.defaultError();
				break;
			}
			registry = new Registry();
		}
		consoleView.logOutMessage();
	}




}
