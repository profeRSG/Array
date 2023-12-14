package boletin7;

import java.util.Arrays;

public class Ejercicios {
	public static void main(String[] args) {
		// Ejercicio 0
		int[] arrayEjercicio0 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Ejercicio 0: Numeros pares en el array: " + contarPares(arrayEjercicio0));

		// Ejercicio 1
		int[] arrayEjercicio1 = Util.generarArrayAleatorio(10, 1, 100);
		System.out.println("Ejercicio 1: Array original: " + Arrays.toString(arrayEjercicio1));
		int[] arrayPares = obtenerPares(arrayEjercicio1);
		System.out.println("Ejercicio 1: Array de números pares: " + Arrays.toString(arrayPares));

		// Ejercicio 2
		int[] arrayEjercicio2 = generarArrayNoRepetidos(20, 1, 300);
		System.out.println("Ejercicio 2: Array generado sin elementos repetidos: " + Arrays.toString(arrayEjercicio2));

		// Ejercicio 3
		int[] arrayEjercicio3 = generarArrayNoRepetidos(20, 200, 400);
		System.out.println("Ejercicio 3: Array generado sin elementos repetidos: " + Arrays.toString(arrayEjercicio3));

		// Ejercicio 4
		int[] arrayEjercicio4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Ejercicio 4: Array original: " + Arrays.toString(arrayEjercicio4));
		int[] arrayInvertido = invertirArray(arrayEjercicio4);
		System.out.println("Ejercicio 4: Array invertido: " + Arrays.toString(arrayInvertido));
	}

	// Ejercicio 0
	/**
	 * Ejercicio 0. Metodo que cuenta cuantos
	 * numero pares hay en una array
	 * @param array 
	 * @return cuantos pares hay en array
	 */
	public static int contarPares(int[] array) {
		int contadorPares = 0;//El contador, inicialmente empieza en cero
		for (int num : array) {//Recorremos el array con un for-each
			if (num % 2 == 0) {//Si el numero es divisible por dos, quiere decir que es par
				contadorPares++;//En ese caso, incrementamos en uno el contador de pares
			}
		}
		return contadorPares;//Devolvemos el contador
	}

	// Ejercicio 1
	/**
	 * Ejercicio 1. El metodo recibe un array como entrada, y devuelve
	 * un array con los numeros pares contenidos en el array de entrada
	 * @param array con los datos de entrada
	 * @return un array con los numeros pares. Su tamaño es igual al
	 * numero de pares que hay en array
	 */
	public static int[] obtenerPares(int[] array) {
		int[] arrayPares = new int[contarPares(array)]; //Creamos un array, con el tamaño de numeros pares que hay en array.
		int i=0;//indice para ir guardando los numeros pares en arrayPares.
		for (int num : array) {//Recorremos el array con un for-each
			if (num % 2 == 0) {//Si el numero es divisible por dos, quiere decir que es par
				arrayPares[i]=num;//En ese caso, lo guardamos en la arrayPares, e incrementamos el indice
				i++;
			}
		}
		return arrayPares;//Devolvemos el resultado.
	}

	// Ejercicio 2 y 3
	/**
	 * Ejercicio 2 y 3. El metodo crea un array con tamaño igual a size
	 * con nmumeros aleatorios entre min y max, los cuales no pueden estar repetidos.
	 * @param size tamaño de la array que se va a devolver
	* @param min numero mas bajo del rango del numero aleatorio
	 * @param max numero mas alto del rango del numero aleatorio
	 * @return array con los numeros aleatorios generados sin repetir. 
	 * @apiNote El ejercicio 2 y 3 Son lo mismo pero con diferentes parametros. Importante utilizar el mismo metodo para evitar duplicidad de codigo
	 */
	public static int[] generarArrayNoRepetidos(int size, int min, int max) {
		

		int[] arrayRandom=new int[size];//Creamos un array con el tamaño indicado
		int numerAleatorio;
		//Numero que se va a generar con un random;
		for(int i=0;i<arrayRandom.length;i++){//Recorremos el array
			do {
				numerAleatorio=Util.generaNumeroRandom(min, max);//Generamos un numero aleatorio entre min y max
				
			}while(estaRepetido(arrayRandom,numerAleatorio, i));//Mientras este repetido , seguiremos generando un numero.
			//Cuando no este repetido, el bucle terminara
			arrayRandom[i]=numerAleatorio;//Asignamos el numero aleatorio en la posicion i
		}
		return arrayRandom;
	}

	//Metodo que comprueba si numero esta en array, mirando las posiciones desde cero
	//hasta limite, sin incluir el limite
	private static boolean estaRepetido(int[] array, int numero, int limite) {
		boolean estaRepetido=false;
				for(int i=0;i<limite && !estaRepetido;i++) {//Recorremos hasta limite. En caso de encontrar un numero repetido, dejamos de buscar
					if(array[i]==numero) {//Si encontramos uno repetido
						estaRepetido=true;
					}
				}
		return estaRepetido;
	}

	// Ejercicio 4
	/**
	 * Metodo que recibe un array de entrada, y devuelve como resultado
	 * un array con el mismo contenido, pero con el orden invertido
	 * @param array. Array de enteros
	 * @return array de enteros, con el contenido del parametro array, pero
	 * invertido.
	 */
	public static int[] invertirArray(int[] array) {
		int[] arrayInvertido = new int[array.length];
		int j = array.length - 1;
		for (int i = 0; i < array.length; i++) {//El indice i va hacia delante
			arrayInvertido[j] = array[i];
			j--;//El indice j va hacia atras. 
		}
		return arrayInvertido;
	}
}
