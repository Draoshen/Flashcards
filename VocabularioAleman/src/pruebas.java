import java.text.SimpleDateFormat;
import java.util.Date;

public class pruebas {

public static void main(String[] args) {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	date.setMinutes(date.getMinutes()+10);
	System.out.println((date));
	
}
}