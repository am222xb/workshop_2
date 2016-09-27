package workshop_2;

public class Member {
	public String name;
	public int id;									
	public String securityNumber;					// YYYYMMDD-xxxx or YYMMDD-xxxx
	public static Boat[] listOfBoats = new Boat[5]; // Limits number of boats to 5 per member.
	private static int numberOfBoats;
	
	public Member(String name, int id, String securityNumber){
		this.name = name;
		this.id = id;
		this.securityNumber = securityNumber;
		numberOfBoats = Registry.numberOfBoats();
	}
	
	public String getName(){
		return name;
	}
	public int getID(){
		return id;
	}
	public String getSecurityNumber(){
		return securityNumber;
	}
	
	public void setName(String nameChange){
		this.name = nameChange;
	}
	public void setID(int idChange){
		this.id = idChange;
	}
	public void setSecurityNumber(String securityNumberChange){
		this.securityNumber = securityNumberChange;
	}
	public static void addBoat(String inputType, String inputLength){
		try {
			if(correctLength(inputLength)){
				
				listOfBoats[numberOfBoats] = new Boat(inputType, inputLength);
				System.out.println("Type: "+inputType+", Security Number: "+inputLength);
				//TODO Write Member to File.
			}
			else{
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	private static Boolean correctLength(String input) {
		System.out.println(input);
		if( input.matches("[0-9 . ,]+")){
			return true;	
		}
		else{
			System.out.println("Wrong length");
			return false;
		}
	}
	
}
