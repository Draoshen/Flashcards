import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileOutputStream;
import java.util.Scanner; // Import the Scanner class to read text files

import javax.swing.JFrame;

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
import javax.swing.JOptionPane;
import javax.swing.JFrame;


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

	
	JFrame frame= new JFrame();	
	frame.setVisible(true);
	frame.setBounds(0, 0, 200, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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