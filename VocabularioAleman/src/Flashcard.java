import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
import java.util.Calendar; 

public class Flashcard {
	
	private String Espaniol;
	private String Aleman;
	private String FraseContexto;
	private final int printSize = 50;
	 Calendar fechaRevisar;
	
	public Flashcard(String aleman, String espaniol,String contexto) {
		
		this.Aleman = aleman;
		this.Espaniol = espaniol;
		this.FraseContexto= contexto;
		this.fechaRevisar = Calendar.getInstance();
		
	}
	
	
	public String getFraseContexto() {
		return FraseContexto;
	}




	public String getEspaniol() {
		return Espaniol;
	}
	public void setEspaniol(String espaniol) {
		Espaniol = espaniol;
	}
	public String getAleman() {
		return Aleman;
	}
	public void setAleman(String aleman) {
		Aleman = aleman;
	}
	
	public String getString() {
		String print = "";
		print= this.Aleman   +  "-"  +   this.Espaniol+"-"  + this.FraseContexto + "-" +this.fechaRevisar.getTime();
		return print;
	}
	
	@Override
	public String toString() {
		String flechitas="";
		while((printSize-flechitas.length()-this.FraseContexto.length())!=0) {
			flechitas+="-";
		}
		return "Flashcard ["+ this.FraseContexto + flechitas + "-> " + this.Espaniol + "]\n";
	}
	
	
	
}
