package workshop_2;

public class Member {
	public String name;
	public int id;
	public int securityNumber;
	
	public Member(String name, int id, int securityNumber){
		this.name = name;
		this.id = id;
		this.securityNumber = securityNumber;
	}
	
	public String getName(){
		return name;
	}
	public int getID(){
		return id;
	}
	public int getSecurityNumber(){
		return securityNumber;
	}
	
	public void setName(String nameChange){
		this.name = nameChange;
	}
	public void setID(int idChange){
		this.id = idChange;
	}
	public void setSecurityNumber(int securityNumberChange){
		this.securityNumber = securityNumberChange;
	}
}
