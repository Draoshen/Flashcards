import java.awt.*;  
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


import javax.swing.*;    



class sortFlashcards implements Comparator<Flashcard> {

	@Override
	public int compare(Flashcard o1, Flashcard o2) {
		// TODO Auto-generated method stub
		
		Calendar f1=o1.fechaRevisar;
		Calendar f2=o2.fechaRevisar;
		
		return f1.compareTo(f2);
	}
	
}

public class InterfazGrafica  extends JFrame implements ActionListener{  
	private Launcher pp=new Launcher();
	private ArrayList<Flashcard> tarjetasGraficasFull;
	private ArrayList<Flashcard> tarjetasGraficas;
	private Flashcard tarjetaVisualizada;
	private Font fuente1 = new Font("Serif", Font.BOLD, 30);
	JFrame f=new JFrame("Repaso Con Flashcards");   
	private boolean primeraVez=true;
/* 
 * 
 * Funciona como es debido, pero ahora el problema está en que lo hace cada vez que cambias de tarjeta
 * que igual no es lo más eficiente
 * 
 */
public void finalizar() {
	tarjetasGraficasFull.size();
	 
	int contador=0;
	sort();
	Flashcard Flash =tarjetasGraficasFull.get(contador);
	File fileDir = new File("C:\\Users\\rafam\\OneDrive\\Escritorio\\SoloQ Challenge\\AddingFileds.txt");
	
	try {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(fileDir), "UTF-8"));
		try {
			
			while(contador<tarjetasGraficasFull.size()){
			Flash = tarjetasGraficasFull.get(contador);
			
			if(contador==tarjetasGraficasFull.size()-1)
				out.write(Flash.getString());
			else
				out.write(Flash.getString()+"\n");
			contador++;
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
}
public void cambiarTarjeta() {
	finalizar();
	//Primero borro la tarjeta, y despu�s busco una nueva
	if(tarjetasGraficas.size()>1) { 
	tarjetasGraficas.remove(tarjetaVisualizada);
	
	//Ahora cambiamos la tarjeta
	this.tarjetaVisualizada=tarjetasGraficas.get(0);
    palabraClave.setText(tarjetaVisualizada.getAleman());
    fraseContexto.setText(tarjetaVisualizada.getFraseContexto());
	tf.setText("");
	areaFrases.setText(fraseContexto.getText());
	}
	
	else {
		etiquetaResultado.setText("Terminaste, bien hecho :)");
	}
  
	
}

	
	 JTextField tf; JLabel palabraClave,fraseContexto,etiquetaResultado,etiquetaEspaniol; JButton showButton;
	 JTextArea areaFrases=new  JTextArea(); 
	 JButton correcto, incorrecto; 

	 InterfazGrafica(){  
		 
		 	
			pp.generadorFlashcards();
			
			tarjetasGraficas=pp.getTarjetas();// Esta es la lista de tarjetas que provienen del txt con el vocabulario
			tarjetasGraficasFull=pp.getTarjetas();//Esto lo vamos a ir introduciendo en el archivo con las fechas, de aqui no se borra ninguna tarjeta
			tarjetaVisualizada=tarjetasGraficas.get(0);// Esta va a ser la tarjeta que vamos a mostrar para ver si el usuario la sabe o no
			 
			 
			    
		    JLabel background=new JLabel(new ImageIcon("C:\\Users\\rafam\\OneDrive\\Escritorio\\SoloQ Challenge\\katanaZeroNewMecca.png"));     
	        tf=new JTextField();  
	        tf.setBounds(150,120, 150,20);  
	       
	        palabraClave=new JLabel(); 
	        palabraClave.setBounds(50,180, 250,40);    
	        palabraClave.setText(tarjetaVisualizada.getAleman());
	        etiquetaResultado=new JLabel();
	        etiquetaResultado.setBounds(100,100,400,200);
	        
	        areaFrases.setBounds(50,50,800,200);
	        fraseContexto=new JLabel();
	        fraseContexto.setText(tarjetaVisualizada.getFraseContexto());
	        fraseContexto.setFont(new Font("Courier", Font.BOLD,20));
	        fraseContexto.setBounds(50,50,800,40);
	        
	        
	        etiquetaEspaniol=new JLabel();
	        etiquetaEspaniol.setBounds(300,180,300,40);
	       
	          
	        showButton=new JButton("Mostrar");  
	        showButton.setBounds(150,250,120,30);  
	        showButton.addActionListener(this); 
	        
	        correcto=new JButton("Correcto");  
	        correcto.setBounds(250,400,120,30);  
	        correcto.addActionListener(this); 
	        
	        incorrecto=new JButton("Incorrecto");  
	        incorrecto.setBounds(100,400,150,30);  
	        incorrecto.addActionListener(this); 
	        
	        /*f.add(tf);
	         *f.add(fraseContexto)
	         */
	        areaFrases.setFont(fuente1);
	        areaFrases.setForeground(new Color(224, 205, 0));
	        areaFrases.setLineWrap(true);
	        areaFrases.setOpaque(false);
	        areaFrases.setEditable(false);
	        areaFrases.append(fraseContexto.getText());
	        
	        palabraClave.setForeground(new Color(184, 75, 2));
	        palabraClave.setFont(fuente1);
	        
	        etiquetaEspaniol.setForeground(new Color(255, 255, 255));
	        etiquetaEspaniol.setFont(fuente1);
	        
	        f.add(showButton);f.add(palabraClave);f.add(etiquetaResultado);f.add(etiquetaEspaniol);
	        f.add(correcto);f.add(incorrecto);f.add(areaFrases);
	        
			f.setLayout(new BorderLayout());
			f.add(background);   
	        f.setVisible(true);  
	        
	       //Con esto sé exactamente cuál es la resolución de la pantalla
	        Toolkit myScreen= Toolkit.getDefaultToolkit();
	        
	        Dimension Screensize =myScreen.getScreenSize();
	        int alturaPantalla=Screensize.height,anchuraPantalla=Screensize.width;
	        
	        f.setBounds(anchuraPantalla/4,alturaPantalla/4,anchuraPantalla/2,alturaPantalla/2);
	        
	        Image myImage=myScreen.getImage("C:/Users/rafam/Downloads/Deutsch-icon.png");
	        f.setIconImage(myImage);
	    } 
	 
	 public void actionPerformed(ActionEvent e) { 
		
		
		if(e.getSource()==showButton) {
			if(primeraVez) {
			
			 etiquetaEspaniol.setText(tf.getText()+tarjetaVisualizada.getEspaniol());
			 primeraVez=false;	 
			 showButton.setText("Ocultar");
			
			 
			}
			else {
				etiquetaEspaniol.setText(""); 
				 showButton.setText("Mostrar");
				 
				 primeraVez=true;
				 
				
			}
		}
		
		
		
		if(e.getSource()==incorrecto) {
			tarjetaVisualizada.fechaRevisar.add(Calendar.MINUTE, 5);
			cambiarTarjeta();
			etiquetaEspaniol.setText("");
		}
		if(e.getSource()==correcto) {
			tarjetaVisualizada.fechaRevisar.add(Calendar.DAY_OF_YEAR, 1);
			cambiarTarjeta();
			etiquetaEspaniol.setText("");
		}
	 }	//Antigua Version
			 /*int comparacion=this.tarjetaVisualizada.getEspaniol().compareToIgnoreCase(tf.getText());
			 	if(comparacion==0) {
			 			etiquetaResultado.setText("Has Acertado");
			 			cambiarTarjeta();
			 
			 						}
		
		 else {
		 etiquetaResultado.setText("La respuesta correcta era:  "+ tarjetaVisualizada.getEspaniol());
		 etiquetaEspaniol.setText(tf.getText()+tarjetaVisualizada.getEspaniol()+"/"+comparacion);
		 		
		 	cambiarTarjeta();
		 	
		 	}
		*/	 
			
			
		
		
	
		 
	 public void sort() {
		 
		 tarjetasGraficasFull.sort(new sortFlashcards());
		 
	 }
	 
	 public void windowClosed(WindowEvent e){
		 	System.out.print("Ayuda");
		    System.exit(0);
		    
		}

	 
public static void main(String[] args) {  
		
	   
	   new InterfazGrafica();  
	   


	}


}