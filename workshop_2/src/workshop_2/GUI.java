package workshop_2;

public class GUI {

	public static void main(String[] args) {
		Authentication.createMember("Mikael Andersson","19921221-5298");
		Member test = new Member("Pelle",6,"19921221-5298");
		test.addBoat("Sailboat", "55.5");
		test.addBoat("Dingy", "80");
		test.addBoat("Submarine", "60");
		test.manageBoat(3,"Sub","50");
		
	}

}
