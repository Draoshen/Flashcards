import java.io.File;  // Import the File class
import java.awt.*;  
import java.awt.event.*;  
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.*;


public class Launcher  {
	

	private ArrayList<Flashcard> tarjetas = new ArrayList<Flashcard>(); 
	
	
	public void generadorFlashcards() {
		 
		if(tarjetas.isEmpty()==false) {
			tarjetas.clear();
		}
		
		try {
		      File fileDir = new File("C:\\Users\\rafam\\OneDrive\\Escritorio\\SoloQ Challenge\\Reverso.txt");
		      BufferedReader in = new BufferedReader(
		   		   new InputStreamReader( new FileInputStream(fileDir), "UTF8"));
		      
		      String data;

				while ((data = in.readLine()) != null) {
				
				    
				    String[] parse=data.split("-", 3);
			        
			        
			        
			        tarjetas.add(new Flashcard(parse[0], parse[1],parse[2]));
			       
				}

		       
		        
		      
		   
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		   catch (UnsupportedEncodingException e)
	    {
			System.out.println(e.getMessage());
	    }
	    catch (IOException e)
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
		
	}
	
	
	

	public ArrayList<Flashcard> getTarjetas() {
		ArrayList<Flashcard> copia1Tarjetas= (ArrayList<Flashcard>) tarjetas.clone();
		return copia1Tarjetas;
	}







	@Override
	public String toString() {
		String rtn="";
		
	  
	  for (Flashcard flashcard : tarjetas) {
		  rtn+= flashcard.toString();
		   
	}
		return rtn;
		}
	
				




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Launcher los =new Launcher();
		los.generadorFlashcards();
		System.out.print(los);
		System.out.println("negar".compareToIgnoreCase("Negar"));
		
	
	}

}
