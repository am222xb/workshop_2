package workshop_2;

import java.util.ArrayList;

public class Registry {

	public ArrayList<Member> listOfMembers;
	private static int iD = 5;
	private static int NextValidID = 6;
	
	public static int getNextValidID() {
		// TODO Auto-generated method stub
		return NextValidID;
	}
	public int getID() {

		return iD;
	}
	public static boolean containsID(int test) {
		if(iD == test){
			return true;
		}
		else{
			return false;
		}
	
	}
	public void deleteMember(){
	}
	public static int numberOfBoats() {
		// TODO Auto-generated method stub
		return 0;
	}
}
