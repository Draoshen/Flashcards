import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;


import javax.swing.*;    

public class InterfazGrafica  extends JFrame implements ActionListener{  
	Launcher pp=new Launcher();
	ArrayList<Flashcard> tarjetasGraficas;
	Flashcard tarjetaVisualizada;
	
	
public void cambiarTarjeta() {
	
	//Primero borro la tarjeta, y después busco una nueva
	if(tarjetasGraficas.size()>1) { 
	tarjetasGraficas.remove(tarjetaVisualizada);
	
	//Ahora cambiamos la tarjeta
	this.tarjetaVisualizada=tarjetasGraficas.get(0);
    palabraClave.setText(tarjetaVisualizada.getAleman());
    fraseContexto.setText(tarjetaVisualizada.getFraseContexto());
	tf.setText("");
	}
	
	else {
		etiquetaResultado.setText("Terminaste, bien hecho :)");
	}
  
	
}

	
	 JTextField tf; JLabel palabraClave,fraseContexto,etiquetaResultado,borrar; JButton nextButton;
	 
	 JButton correcto, incorrecto; 

	 InterfazGrafica(){  
		 
		 	JFrame f=new JFrame("Repaso Con Flashcards");   
			pp.generadorFlashcards();
			
			tarjetasGraficas=pp.getTarjetas();// Esta es la lista de tarjetas que provienen del txt con el vocabulario
			
			tarjetaVisualizada=tarjetasGraficas.get(0);// Esta va a ser la tarjeta que vamos a mostrar para ver si el usuario la sabe o no
			
	        tf=new JTextField();  
	        tf.setBounds(150,120, 150,20);  
	       
	        palabraClave=new JLabel(); 
	        palabraClave.setBounds(50,100, 250,20);    
	        palabraClave.setText(tarjetaVisualizada.getAleman());
	        etiquetaResultado=new JLabel();
	        etiquetaResultado.setBounds(100,100,400,200);
	        
	        fraseContexto=new JLabel();
	        fraseContexto.setText(tarjetaVisualizada.getFraseContexto());
	        fraseContexto.setBounds(50,50,400,20);
	        
	        
	        borrar=new JLabel();
	        borrar.setBounds(150,130,220,220);
	       
	          
	        nextButton=new JButton("Siguiente");  
	        nextButton.setBounds(150,250,120,30);  
	        nextButton.addActionListener(this); 
	        
	        correcto=new JButton("Bien");  
	        correcto.setBounds(250,400,120,30);  
	        correcto.addActionListener(this); 
	        
	        incorrecto=new JButton("Repasar de Nuevo");  
	        incorrecto.setBounds(100,400,150,30);  
	        incorrecto.addActionListener(this); 
	       
	        f.add(nextButton);f.add(tf);f.add(palabraClave);f.add(etiquetaResultado);f.add(borrar);
	        f.add(correcto);f.add(incorrecto);f.add(fraseContexto);
	        
	        f.setLayout(null);  
	        f.setVisible(true);  
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        Toolkit myScreen= Toolkit.getDefaultToolkit();
	        
	        Dimension Screensize =myScreen.getScreenSize();
	        int alturaPantalla=Screensize.height,anchuraPantalla=Screensize.width;
	        
	        f.setBounds(anchuraPantalla/4,alturaPantalla/4,anchuraPantalla/2,alturaPantalla/2);
	        
	        Image myImage=myScreen.getImage("C:/Users/rafam/Downloads/Deutsch-icon.png");
	        f.setIconImage(myImage);
	    } 
	 
	 public void actionPerformed(ActionEvent e) { 
		
		
		if(e.getSource()==nextButton) {
			 int comparacion=this.tarjetaVisualizada.getEspaniol().compareToIgnoreCase(tf.getText());
			 	if(comparacion==0) {
			 			etiquetaResultado.setText("Has Acertado");
			 			cambiarTarjeta();
			 
			 						}
		 else {
		 etiquetaResultado.setText("La respuesta correcta era:  "+ tarjetaVisualizada.getEspaniol());
		 borrar.setText(tf.getText()+tarjetaVisualizada.getEspaniol()+"/"+comparacion);
		 		
		 	cambiarTarjeta();
		 	
		 	}
			 
		}
		
		 }
		
		 
	  
	 
	 public void windowClosed(WindowEvent e){
		    System.exit(0);
		}

	 class LaminaString extends JPanel{
		 
		 public void paintComponent(Graphics g, String str,int x, int y) {
			 super.paintComponent(g);
			 g.drawString(str, x, y);
			 
		 }
	
	 }
public static void main(String[] args) {  
		
	   
	   new InterfazGrafica();  
	   


	}


}