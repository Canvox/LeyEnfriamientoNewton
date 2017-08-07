/**
 *
 * @author INTEL-COREi7
 */

package enfriamientonewton;

import javax.swing.JOptionPane;

public class EnfriamientoCalc {
	
        //Calculo de temperatura dado el tiempo, temperatura inicial y constante
	public static double T(double tiempo, double ti, double ta, double k){
		double temp = ta + (ti - ta) * Math.exp((-k) * tiempo);
		return temp;	
	}
	
        //Calculo de k dado el tiempo, temperatura del objeto y temperatura del ambiente
	public static double kCalc(double tiempo, double ti, double ta, double temp){
		
		//Catch divide by zero error
		if(tiempo == 0 || temp == 0){
			JOptionPane.showMessageDialog(null, "Error: El Tiempo/Temperatura no puede ser 0!", "Error", 
    				JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		else{
                    double k = Math.log((ta/(ta - temp)- (ti/(ta - temp)))) / tiempo;
                    return k;
		}
	}
	
        //Calculo de temperatura inicial dado k, tiempo y temperatura del ambiente
	public static double tiCalc(double tiempo, double ta, double temp, double k){
		
		//Calculate t0
		double t0 = Math.exp(k * tiempo) - ta * Math.exp(k * tiempo) + ta;
		
		return t0;
	}
	
        //Calculo de temperatura del ambiente dado temperatura inicial, tiempo y constante
	public static double taCalc(double tiempo, double temp, double k, double ti){
		double ts = (Math.exp(k * tiempo) - ti) / (Math.exp(k * tiempo) - 1);
		
		return ts;
	}
	
        //Calculo del tiempo dado temperatura del ambiente, temperatura inicial y constante
	public static double tiempoCalc(double temp, double ti, double ta, double k){
		
		if(k == 0){
			JOptionPane.showMessageDialog(null, "Error: Constant may not be zero!", "Error", 
    				JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		else {
			double time = Math.log( (ta) / (ta - temp) - (ti / (ta - temp))) / k;
			
                        //Division para cero
			if(Double.isNaN(time)){
				JOptionPane.showMessageDialog(null, "Error: No se puede dividir para cero!", "Error", JOptionPane.ERROR_MESSAGE);
				return 0;
			}
			
			else{
				return time;
			}
			
		}
	}
	
	
}
