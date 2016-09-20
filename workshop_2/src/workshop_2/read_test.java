package workshop_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class read_test {

	public static void main(String[] args) throws IOException {
		try {
		
		String line = null;
        FileReader fileReader = new FileReader("testfolder/member.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }   

        bufferedReader.close();       
		}
		 catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file ");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file");                  
	        }
	}

	}


