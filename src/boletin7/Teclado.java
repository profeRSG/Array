package boletin7;
import java.util.Scanner;

/**
 * Clase creada para gestionar la lectura del teclado
 * 
 * Recomendacion: Como este metodo, y muchos otros se van a utilizar mucho, lo mejor es
 * tenerlos en clases aparte que las añadas directamente a tu proyecto, sin tener
 * que estar copiando y pegando codigo.
 * 
 * @author Raul SG
 *
 */
public class Teclado {
	
	/**
	 * Metodo  que lee desde el teclado una opcion elegida por el usuario. Se comprueba que
	 * la eleccion elegida debe estar entre los parametros inicio y fin. Si la opcion no esta dentro
	 * del rango, se pregunta de nuevo al usuario. El valor inicio tiene que ser menor que fin.
	 * 
	 * @param inicio limite inferior del rango de valores permitido 
	 * @param fin limite superior del rango de valores permitido
	 * @return la eleccion seleccionada por el usuario. Sera un valor entre inicio y fin
	 */
	public static int elegirEnteroEntre(int inicio, int fin) {
		int eleccion;
		Scanner sc=new Scanner(System.in);
		eleccion=sc.nextInt();//Leemos por teclado la opcion del usuario
		while(eleccion<inicio || eleccion>fin) {//Mientras la eleccion este fuera del rango
			System.out.println();//Salto de línea
			System.out.println("Eleccion incorrecta. Se debe seleccionar un numero entre "+inicio+" y "+fin);
			eleccion=sc.nextInt();//Se lee de nuevo la eleccion
		}
		return eleccion;
	}

}
