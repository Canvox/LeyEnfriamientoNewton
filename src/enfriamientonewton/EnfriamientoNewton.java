/**
 *
 * @author INTEL-COREi7
 */

package enfriamientonewton;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;


public class EnfriamientoNewton {
	
	protected static void coolingLawGUI(){
		JFrame enfriamiento = new JFrame("Calculadora de Enfriamiento de Newton");
		enfriamiento.setPreferredSize(new Dimension(1000, 100));
		enfriamiento.setLayout(new FlowLayout());
		enfriamiento.setResizable(false);
		enfriamiento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enfriamiento.setIconImage(Toolkit.getDefaultToolkit().getImage("temperature-256.png"));
		
		JLabel taLabel = new JLabel("Temperatura del ambiente: ");
		enfriamiento.add(taLabel);
		
		JTextField taField = new JTextField(5);
		enfriamiento.add(taField);
		
		//Initial temperature JLabel/JTextField
		JLabel ti = new JLabel("Temperatura Inicial: ");
		enfriamiento.add(ti);
		
		JTextField tiField = new JTextField(5);
		enfriamiento.add(tiField);
		
		JLabel kLabel = new JLabel("Constante: ");
		enfriamiento.add(kLabel);
		
		JTextField kField = new JTextField(5);
		enfriamiento.add(kField);
		
		JLabel tempLabel = new JLabel("Temperatura del Objeto: ");
		enfriamiento.add(tempLabel);
		
		JTextField tempField = new JTextField(5);
		enfriamiento.add(tempField);

		JLabel tiempoLabel = new JLabel("Tiempo: ");
		enfriamiento.add(tiempoLabel);
		
		JTextField tiempoField = new JTextField(5);
		enfriamiento.add(tiempoField);
		
		JButton calcularButton = new JButton("Calcular");
		enfriamiento.add(calcularButton);
		
		JButton limpiarButton = new JButton("Limpiar");
		enfriamiento.add(limpiarButton);
		
		calcularButton.addActionListener(new ActionListener() {
          
                public void actionPerformed(ActionEvent e) {
            	
            	 double ti = 0;
            	 double ta = 0;
            	 double k = 0;
            	 double tiempo = 0;
            	 double temp = 0;
            	 
            	
            	//Check to see which fields contain data
            	boolean taVacio = (taField.getText().isEmpty());
            	boolean tiVacio = (tiField.getText().isEmpty());
            	boolean kVacio = (kField.getText().isEmpty());
            	boolean tiempoVacio = (tiempoField.getText().isEmpty());
            	boolean tempObVacio = (tempField.getText().isEmpty());
            	
            	
            	if(!taVacio){
            		 ta = Double.parseDouble(taField.getText());
            	}
            	
            	if(!tiVacio){
            		 ti = Double.parseDouble(tiField.getText());
            	}
            	
            	if(!kVacio){
            		 k = Double.parseDouble(kField.getText());
            	}
            	
            	if(!tiempoVacio){
            		 tiempo = Double.parseDouble(tiempoField.getText());
            	}
            	
            	if(!tempObVacio){
            		 temp = Double.parseDouble(tempField.getText());
            	}
            	
            	
                //Calculo de temp dado la temperatura del ambiente, temperatura inicial y k
            	if((tempObVacio) && !(taVacio && tiVacio && kVacio && tiempoVacio)){
            		
            		tempField.setText(Double.toString(EnfriamientoCalc.T(tiempo, ti, ta, k)));
            	
            	}

                //Calculo de k dado el tiempo, temperatura inicial y temperatura del ambiente
            	else if(kVacio && !(taVacio && tiVacio && tiempoVacio && tempObVacio)){
                	//Pass parsed data to kCalc
                	kField.setText(Double.toString(EnfriamientoCalc.kCalc(tiempo, ti, ta, temp)));
            		 
            	}
            	
            	//Calculo de la temperatura inicial
            	else if (tiVacio && !(taVacio && tiempoVacio && tempObVacio && kVacio)){
            		tiField.setText(Double.toString(EnfriamientoCalc.tiCalc(tiempo, ta, temp, k)));
            	}
            	
            	//Calculo de la temperatura del ambiente
            	else if (taVacio && !(tiVacio && tiempoVacio && tempObVacio &&kVacio)){
            		taField.setText(Double.toString(EnfriamientoCalc.taCalc(tiempo, temp, k, ti)));
            	}
            	
            	//Calculo del tiempo
            	else if (tiempoVacio && !(taVacio &&tempObVacio && kVacio && tiVacio)){
            		tiempoField.setText(Double.toString(EnfriamientoCalc.tiempoCalc(temp, ti, ta, k)));
            	}

            	//Si ningun campo esta lleno
            	else if ((taVacio == tiVacio == kVacio == tiempoVacio == tempObVacio == true)){
            		JOptionPane.showMessageDialog(null, "Error: no hay ningun campo lleno", "Error", 
            				JOptionPane.ERROR_MESSAGE);
            	}
            	          	 
            	//Si hay muchos campos muestra Error
            	else {
            		JOptionPane.showMessageDialog(null, "Error: muchos campos llenos", "Error", 
            				JOptionPane.ERROR_MESSAGE);
            	}
            	
            }
		});
		
		limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Setea todo vacio
            	taField.setText("");
            	tiField.setText("");
            	tempField.setText("");
            	kField.setText("");
            	tiempoField.setText("");
 	
            }
            });
		
		enfriamiento.pack();
		enfriamiento.setVisible(true);
			
	}
	
        //Muestra GUI
	public static void main(String args[]){
		coolingLawGUI();

	}
}