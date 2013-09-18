package packag;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;

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
			 
			  }
		
	}

}
