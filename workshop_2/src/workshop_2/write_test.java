package workshop_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class write_test {
	


	public static void main(String[] args) throws FileNotFoundException {

		
		File dir = new File("testfolder");
		dir.mkdir();
		File dir2 = new File("testfolder2");
		dir2.mkdir();
		List<File> list = new ArrayList<File>();
		list.add(dir);
		list.add(dir2);
		
		File file = new File(list.get(0)+"/TraceFile.txt");
		PrintWriter writer= new PrintWriter(file);
		int numberOfFiles = new File("testfolder").listFiles().length;
		
		System.out.println("Antal filer: "+numberOfFiles);
		
		writer.println("hejsan");
		writer.close();

	}

}