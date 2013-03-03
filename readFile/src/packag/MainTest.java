package packag;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class MainTest {
	
	FileInputStream fstream;
	DataInputStream in;
	BufferedReader br;

	@Test
	public void reading(){
		try{
			  fstream = new FileInputStream("text.txt");
			 
			  in = new DataInputStream(fstream);
			  br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  
			  while ((strLine = br.readLine()) != null)   {
			  
				  	System.out.println (strLine);
			  
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  fail();
			  }
	}
}
