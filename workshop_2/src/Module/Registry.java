package Module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry {


	public List<Member> listOfMembers;
	private String[][] compactList;
	private String[][] verboseList;

	/**
	 * List of members, Short list, Long list
	 * */
	public Registry(){
		listOfMembers = loadRegistry();
		compactList = compactList(listOfMembers);
		verboseList = verboseList(listOfMembers);
	}
	/**
	 * Returns next valid member ID
	 * @return nextValidID
	 * */
	public int getNextValidID() {
		int nextValidID= compactList.length+1;
		for (int i = 1; i < compactList.length+1; i++) {
			if(!containsID(i)){
				nextValidID = i;
				break;
			}
		}
		return nextValidID;
	}

	/**
	 * Returns member from registry's list of members at specified index
	 * @param inputID
	 * @return The element at the specified position in this list
	 * */
	public Member getMember(int inputID){
		for (int i = 0; i < listOfMembers.size(); i++) {
			if(listOfMembers.get(i).getID()==inputID){
				return listOfMembers.get(i);

			}
		}
		return null;
	}
	/**
	 * Returns list of member: ID, Name, Security Number, boats with boat information
	 * @return verboseList
	 * */
	public String[][] getVerboseList(){
		return verboseList;
	}
	/**
	 * Returns list of member:Name, ID, Number of boats
	 * @return compactList
	 * */

	public String[][] getCompactList(){
		return compactList;
	}
	/**
	 * Load list of all members with boats to the registry
	 * */
	public List<Member> loadRegistry(){
		List<Member> arr = new ArrayList<Member>();
		String temp[];
		Member tempMember;
		Boat tempBoat;
		String member = "member";
		String boat = "boat_";
		for(int i = 0; i <20; i++){	
			temp = loadFromFile(member, i);
			if(temp != null){
				tempMember =  new Member( Integer.parseInt(temp[0]),temp[1], temp[2]);
				arr.add(tempMember);
				for (int j = 0; j < 5; j++) {
					temp = loadFromFile(boat+(j+1),i);
					if(temp != null){
						tempBoat = new Boat(temp[1],temp[2]);
						tempMember.addNumberOfBoats();
						tempMember.setBoat(j,tempBoat);
					}
				}
			}	
		}
		return arr;
	}
	/**
	 * Loads data from file
	 * @param file
	 * @param iD
	 * */
	public static String[] loadFromFile(String file, int iD){
		String temp[] = new String[3];
		try {
			String line = null;
			FileReader fileReader = new FileReader(iD+"/"+file+".txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int innerCounter = 0;
			while((line = bufferedReader.readLine()) != null) {
				innerCounter++;
				if(innerCounter == 1){
					temp[0] = line;
				}
				else if (innerCounter == 2){
					temp[1] = line;
				}
				else if (innerCounter == 3){
					temp[2] = line;
				}  	
			} 
			bufferedReader.close();    
			return temp;
		}
		catch(FileNotFoundException ex) {            
		}
		catch(IOException ex) {
			System.out.println("Error reading file");                  
		}
		return null;
	}
	/** 
	 * Creates a compact List from the registry, contains: name, member id and number of boats
	 * @param inputList
	 * @return shortList
	 * */
	public String[][] compactList(List<Member> inputList){

		String[][] shortList = new String[inputList.size()][3];
		Iterator<Member> memberIterator = inputList.iterator();
		int i=0;
		Member tempMember;
		while (memberIterator.hasNext()) {
			tempMember = memberIterator.next();
			shortList[i][0] = tempMember.getID()+"";
			shortList[i][1] = tempMember.getName();
			shortList[i][2] = tempMember.getNumberOfBoats()+"";
			i++;
		}
		return shortList;
	}
	/** 
	 * Creates a verbose List from the registry, contains: ID, Name, Security Number, boats with boat information
	 * @param inputList
	 * @param longList
	 * */
	public String[][] verboseList(List<Member> inputList){
		String[][] longList = new String[inputList.size()][13];
		Iterator<Member> memberIterator = inputList.iterator();
		int i=0;
		Member tempMember;
		while (memberIterator.hasNext()) {
			tempMember = memberIterator.next();
			longList[i][0] = tempMember.getID()+"";
			longList[i][1] = tempMember.getName();
			longList[i][2] = tempMember.getSecurityNumber();
			int counter=0;
			for (int j = 3; j < 13; j+=2) {
				if(tempMember.getAllBoats()[counter]!=null){
					longList[i][j] = tempMember.getAllBoats()[counter].getType();
					longList[i][j+1] = tempMember.getAllBoats()[counter].getLength();
				}
				counter++;
			}
			i++;
		}
		return longList;
	}
	/**
	 * Returns true if registry's list of members contains the specified ID
	 * @param inputID
	 * @return Returns true if registry's list of members contains the specified ID
	 * */
	public boolean containsID(int inputID) {
		for (int i = 0; i < verboseList.length; i++) {
			if(Integer.parseInt(verboseList[i][0]) == inputID){
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns true if registry's list of members contains the specified name
	 * @param inputName
	 * @return list of members containing the specified name
	 * */
	public String[][] containsName(String inputName){
		List<Member> tempList = new ArrayList<Member>();
		inputName = inputName.toLowerCase();
		for (int i = 0; i < listOfMembers.size(); i++) {
			String temp = listOfMembers.get(i).getName().toLowerCase();
			if(inputName.length()<= temp.length()){
				temp = temp.substring(0,inputName.length());
				if(inputName.equals(temp)){
					tempList.add(listOfMembers.get(i));
				}
			}	
		}
		return verboseList(tempList);
	}
	/**
	 * Returns a verbose list of members who owns a boat with same type as specified
	 * @param inputBoat
	 * @return list of members containing the specified type of boat
	 * */
	public String[][] containsTypeOfBoat(String inputBoat){
		List<Member> tempList = new ArrayList<Member>();
		inputBoat = inputBoat.toLowerCase();
		for (int i = 0; i < listOfMembers.size(); i++) {
			Member tempMember = listOfMembers.get(i);
			for (int j = 0; j < 5 ; j++) {
				if(tempMember.getAllBoats()[j] != null){
					String tempBoatType  = tempMember.getAllBoats()[j].getType().toLowerCase();
					if(inputBoat.length()<=tempBoatType.length()){
						tempBoatType = tempBoatType.substring(0,inputBoat.length());
						if(tempBoatType.equals(inputBoat)){
							tempList.add(listOfMembers.get(i));
						}
					}
				}
			}
		}
		return verboseList(tempList);
	}
	/**
	 * Returns a verbose list of members who has the same security number as specified
	 * @param inputSecurityNumber
	 * @return list of members containing the specified security number
	 * */
	public String[][] containsSecurityNumber(String inputSecurityNumber){
		/*For managable error handling, only people born between 1900-1999 are allowed to register,
		  Then again, who is 116 years old and people under 18 are not allowed to register.
		 */
		List<Member> tempList = new ArrayList<Member>();
		inputSecurityNumber = validateSecurityNumber(inputSecurityNumber);// Removes unnecessary numbers, i.e. 1992 -> 92.  
		for (int i = 0; i < listOfMembers.size(); i++) {
			String tempSecurityNumber = validateSecurityNumber(listOfMembers.get(i).getSecurityNumber());
			if(inputSecurityNumber.length()<= tempSecurityNumber.length()){
				tempSecurityNumber = tempSecurityNumber.substring(0,inputSecurityNumber.length());
				if(inputSecurityNumber.equals(tempSecurityNumber)){
					tempList.add(listOfMembers.get(i));
				}
			}	
		}
		return verboseList(tempList);
	}
	/**
	 * If specified security number is '1' or '19' all members are returned.
	 * @param inputNumber
	 * @return Returns security Number shortened down to YYMMDD-xxxx
	 * */
	private String validateSecurityNumber(String inputNumber) {
		if(inputNumber.length()==1 && inputNumber.substring(0,1).equals("1")){
			return "";
		}
		else if(inputNumber.length()>1 && inputNumber.substring(0,2).equals("19")){
			return inputNumber.substring(2,inputNumber.length());
		}
		else{
			System.out.println(inputNumber);
			return inputNumber;
		}

	}

}
