package eliabeolah;

/*
* @author Eliabe Olah - DM1E - 00eliabeed1@gmail.com -
* @since 08/05/2025
* @version 1.1
* @see https://github.com/HeOpen/ExamenEliabeOlah
*/

public class ImprimirEliabeOlah {

    /**
     * Imprime informaci�n en base al DNI pasado.El metodo realiza 4 prints comprobando si el alumno estudia en la misma ciudad que naci�,
     * si el nombre  y apellido tienen m�s de 3 vocales y por ultimo si el DNI es v�lido (tiene 9 caracteres. los 8 primeros son numeros y el 9� es una letra v�lida).
     * @since 08/05/2025
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param dni DNI a validarse
     * @param ciudadNac Ciudad donde la persona ha nacido
     * @exception NumberFormatException En caso de que el 9� caracter del DNI no sea un numero
     */

	public void imprimirDatosEliabeOlah(String nombre, String apellido, String dni, String ciudadNac) {
		
                //Comprueba si la ciudad de nacimiento es Madrid
		if(ciudadNac.equalsIgnoreCase("Madrid")) {
			System.out.println("El alumno estudia en la misma ciudad que naci�");
		} else {
			System.out.println("El alumno NO estudia en la misma ciudad que naci�");
		}
				
		
		int contadorVocales = 0;
		String letraDelNombre;
		
                //Bucle que percorre todo el nombre y comprueba si contiene alguna vocal, en el caso de que s�, se incrementa el contadorVocales
		for (int i = 0; i < nombre.length(); i++) {
			letraDelNombre = nombre.substring(i,i+1).toLowerCase();						
			if(letraDelNombre.equals("a")) contadorVocales ++;
			if(letraDelNombre.equals("e")) contadorVocales ++;
			if(letraDelNombre.equals("i")) contadorVocales ++;
			if(letraDelNombre.equals("o")) contadorVocales ++;
			if(letraDelNombre.equals("u")) contadorVocales ++;			
		}			
		
                
		if (contadorVocales<3) System.out.println("El nombre tiene pocas vocales"); 
		else System.out.println("El nombre tiene suficientes vocales");
				
		
		String letraMayuscula = ""; 
		boolean dniValido = true;
		
		// Aqu� excluimos cadenas distintas a 9 caracteres que debe tener un dni y tambi�n si el �ltimo caracter no es una letra
		if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false ) {
			System.out.println("El DNI intriducido no es v�lido");
			dniValido = false;
		}else {
			// Al superar la primera restricci�n, la letra la pasamos a may�scula
			letraMayuscula = (dni.substring(8)).toUpperCase();
			try {
				// Pasamos a integer la parte num�rica del DNI
				Integer myDni = Integer.parseInt(dni.substring(0,8));												
				int resto = 0;
				String[] letrasPosiblesDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J",
						"Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
				resto = myDni % letrasPosiblesDNI.length;
				if (letraMayuscula.equals(letrasPosiblesDNI[resto]) ) {
					System.out.println("La letra indicada en el DNI no es la esperada");
					dniValido = false;
				};
			} catch (Exception e) {
				System.out.println("Los 8 primeros caracteres deben ser num�ricos");
				dniValido = false;
			}
		}		

                //Bucle for sobre la logitud del apellido y en seguida un contador que va aumentando en el caso de que encuentre un vocal
		contadorVocales = 0;
		for (int i = 0; i < apellido.length(); i++) {
			letraDelNombre = apellido.substring(i,i+1).toLowerCase();					
			if(letraDelNombre.equals("a")) contadorVocales ++;
			if(letraDelNombre.equals("e")) contadorVocales ++;
			if(letraDelNombre.equals("i")) contadorVocales ++;
			if(letraDelNombre.equals("o")) contadorVocales ++;
			if(letraDelNombre.equals("u")) contadorVocales ++;		
			
		}			

                //Imprime si el apellido tiene suficiente vocales en base a si el contador tiene 3 o m�s vocales
                if (contadorVocales<3) System.out.println("El apellido tiene pocas vocales");
		else System.out.println("El apellido tiene suficientes vocales");
		
		if (dniValido) System.out.println("El DNI es v�lido");
	}

}
