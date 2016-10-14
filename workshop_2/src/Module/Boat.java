package Module;

public class Boat {
	
	private String typeOfBoat; //Sailboat, Motorsailer, kayak/Canoe, Other 
	private String lengthOfBoat; //Length of boat in cm
	/**
	 * Type of boat, length of boat
	 * @param typeOfBoat
	 * @param lengthOfBoat
	 * */
	public Boat(String typeOfBoat, String lengthOfBoat){
		this.typeOfBoat = typeOfBoat;
		this.lengthOfBoat = lengthOfBoat;
	}
	/**
	 * Returns type of boat
	 * @return typeOfBoat
	 * */
	public String getType(){
		return typeOfBoat;
	}
	/**
	 * Returns length of boat
	 * @return lengthOfBoat
	 * */
	public String getLength(){
		return lengthOfBoat;
	}
	/**
	 * Sets type of boat
	 * @param typeOfBoat
	 * */
	public void setType(String typeOfBoat){
		this.typeOfBoat = typeOfBoat;
	}
	/**
	 * Sets length of boat
	 * @param lengthOfBoat
	 * */
	public void setLength(String lengthOfBoat){
		this.lengthOfBoat = lengthOfBoat;
	}
	
}