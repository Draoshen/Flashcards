import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileOutputStream;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;



public class pruebas {

	
	private boolean append_to_file=false;
	
public Calendar parse(String s) {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	try {
		cal.setTime(sdf.parse(s));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// all done
	return cal;
}
public static void main(String[] args) {
	int contador=0;
	File fileDir = new File("C:\\Users\\rafam\\OneDrive\\Escritorio\\SoloQ Challenge\\AddingFileds.txt");
	try {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(fileDir), "UTF-8"));
		try {
			
			while(contador<5){
			contador++;
			if(contador==5)
				out.write("Katana Zero");
			else
				out.write("Katana Zero"+"\n");
			}
			out.close(); // Closes the stream, flushing it first. Once the stream has been closed, further write() or flush() invocations will cause an IOException to be thrown. Closing a previously closed stream has no effect. 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} catch (UnsupportedEncodingException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (FileNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	try {
		BufferedReader in = new BufferedReader(
		   		   new InputStreamReader( new FileInputStream(fileDir), "UTF8"));
		
		String data;

		try {
			while ((data = in.readLine()) != null) {
			
			    
			    String[] parse=data.split("-", 3);
			    
			    
			    
			    
			   
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	Calendar cal = Calendar.getInstance();
	System.out.println(cal.getTime());
	
	SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	try {
		cal.setTime(sdf.parse("Wed Jul 08 20:16:01 CEST 2020"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// all done
	
	System.out.println(cal.getTime());
	}
	
	






}