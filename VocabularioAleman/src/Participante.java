
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Participante {
	
	private String Ingame;
	private String Elo;
	private String Nombre;
	

	public Participante(String Ingame,String Nombre, String Elo) {
		
		this.Ingame=Ingame;
		this.Nombre=Nombre;
		this.Elo=Elo;
	}
	public String toString() {
		
		return this.Nombre+" con " + this.Ingame+ " está en: " + this.Elo;
	}
	
	public String getIngame() {
		return Ingame;
	}
	public void setIngame(String ingame) {
		Ingame = ingame;
	}
	public String getElo() {
		return Elo;
	}
	public void setElo(String elo) {
		Elo = elo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	public static void main (String args[] ) {
		Participante[] players= new Participante[6];
		int contador =0;
		
		try {
		      File myObj = new File("C:\\Users\\rafam\\OneDrive\\Escritorio\\SoloQ Challenge\\ListaPlayers.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  
		        String data = myReader.nextLine();
		        
		        String[] parse=data.split("-", 2);
		        
		        players[contador]= new Participante(parse[0],parse[1],"Unranked");
		        contador++;
		        
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			
			for(Participante p1 : players) {
				System.out.print(p1+"\n");				
			}
			
		  }
	
		
	}
	

