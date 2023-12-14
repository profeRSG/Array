package boletin7;

public class Util {
	
	/**
	 * Metodo para genera un numero aleatorio entre  dos numeros
	 * 
	 * @param min numero mas bajo del rango
	 * @param max numero mas alto del rango
	 * @return Se generar un numero aleatorio entre min y maz
	 * @author Raul SG
	 * @apiNote Antes de utilizar el metodo se debe validar que es max>min
	 * 
	 */
	public static int generaNumeroRandom(int min, int max){
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	/**
	 * Metodo utilizado para generar un array aleatorio de numeros.
	 * Muy util para hacer pruebas.
	 * 
	 * @param size tamaño de la array
	 * @param min numero mas bajo del rango del numero aleatorio
	 * @param max numero mas alto del rango del numero aleatorio
	 * @return array con los numeros aleatorios, de tamaño size.
	 * @author Raul SG
	 * @apiNote Antes de utilizar el metodo se debe validar que es max>minin
	 * 
	 * 
	 * 
	 */
	public static int[] generarArrayAleatorio(int size, int min, int max) {
	        int[] array = new int[size];
	        for (int i = 0; i < size; i++) {
	            array[i] = generaNumeroRandom(min, max);
	        }
	        return array;
	    }

}
