package boletin7;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase utilizada para gestionar la reserva de los asientos de un vuelo.
 * Teniendo en cuenta dos zonas diferencias para fumadores, y no fumadores.
 * 
 * @author Raul SG
 * 
 * En la clase se han indicado algunos metodos como public, para describirlos con Javadoc a modo de ejemplo
 * 
 * Otros metodos son private, y esa es la razon de porque no tienen Javadoc, ya que no es necesario
 * para estos metodos.
 *
 */
public class Ejercicio6 {

	public static final int NUMERO_ASIENTOS=20;//Creo una constante para el numero de asientos del avion.
	//La escribo en este lugar para que sea global. Ojo, solo hacer esto con  las constantes, no
	//con las variables.


	public static void main(String[] args) {

		int  opcion;
		int quiereElegirEnOtraZona;//Entero que valdra 0, si no estaba completa la zona, 1
		//Si estaba completa y se eligio reservar en la otra zona, y 2, si estaba completa y se eligio no resevar.
		//TODO cambiar la estructura para que quiereElegirEnOtraZona sea un booleano
		int[] asientosAvion=new int[NUMERO_ASIENTOS];//La array representa los asientos
		//disponibles en el avion. 0  indica que esta libre, y 1 que esta ocupado. Realmente
		//habria sido mejor para este proposito haber utilizado una array de booleanos.
		do {
			mostrarMenuPrincipal();//Se muestra el menu principal
			opcion=Teclado.elegirEnteroEntre(1, 4);//Se elige una opcion entre 1 y 4
			switch (opcion) {
			case 1->{
				quiereElegirEnOtraZona=resevarAsientoFumadores(asientosAvion);//Reserva asiento para fumadores
				if(quiereElegirEnOtraZona==1)//Si se quiere elegir en la otra zona, al estar completo
					resevarAsientoNoFumadores(asientosAvion);//Resevar asiento para no fumadores
				else if (quiereElegirEnOtraZona==2)//Si estaba completo y se selecciono la opcion 2
					mostrarSiguienteVuelo();//Se muestra el proximo vuelo

			}
			case 2->{
				quiereElegirEnOtraZona=resevarAsientoNoFumadores(asientosAvion);//Resevar asiento para no fumadores
				if(quiereElegirEnOtraZona==1)//Si se quiere elegir en la otra zona, al estar completo
					resevarAsientoFumadores(asientosAvion);//Resevar asiento para no fumadores
				else if (quiereElegirEnOtraZona==2)//Si estaba completo y se selecciono la opcion 2
					mostrarSiguienteVuelo();//Se muestra el proximo vuelo
			}
			case 3 -> mostrarEstadoAvion(asientosAvion);//Se muestra el estado actual de los asientos del avion
			}

		}while(opcion!=4);//Mientras no se seleccione la opcion para salir
	}



	private static int resevarAsientoNoFumadores(int[] asientosAvion) {
		//Constantes
		final int ASIENTO_PRIMERO_NO_FUMADORES=1;
		final int ASIENTO_ULTIMO_NO_FUMADORES=15;
		final String NOMBRE_ZONA_NO_FUMADORES="no fumadores";
		//Llamamos al metodo reservaAsiento, indicandole los limites de la zona de no fumadores, y el nombre de la misma
		return reservarAsiento(asientosAvion, ASIENTO_PRIMERO_NO_FUMADORES, ASIENTO_ULTIMO_NO_FUMADORES, NOMBRE_ZONA_NO_FUMADORES); //Se reserva un asiento de un no fumador
		//y se devuelve el resultado de dicho metodo
	}

	private static int resevarAsientoFumadores(int[] asientosAvion) {
		//Constantes
		final int ASIENTO_PRIMERO_FUMADORES=16;
		final int ASIENTO_ULTIMO_FUMADORES=20;
		final String NOMBRE_ZONA_FUMADORES="fumadores";
		//Llamamos al metodo reservaAsiento, indicandole los limites de la zona de fumadores, y el nombre de la misma
		return reservarAsiento(asientosAvion,ASIENTO_PRIMERO_FUMADORES, ASIENTO_ULTIMO_FUMADORES, NOMBRE_ZONA_FUMADORES); //Se reserva un asiento de un fumador
		//y se devuelve el resultado de dicho metodo

	}

	private static int reservarAsiento(int[] asientosAvion, int primerASiento, int ultimoAsiento, String zona) {
		int quiereElegirEnOtraZona=0;//La variable valdra 0 si no se ha elegido nada porque no esta completa la zona
		//, 1 si se quiere elegir en la otra zona, al estar completa la seleccionada, y 2, si esta completa pero no se quiere elegir en la otra zona.
		int seleccionAsiento;//Asiento que elige el usuario
		boolean completo=comprobarCompleto(asientosAvion,primerASiento,ultimoAsiento);//Se comprueba si la zona esta completa
		if(completo) {//En caso de estar completa
			mostrarMenuCompleto(zona);//Se muestra las opciones
			quiereElegirEnOtraZona=Teclado.elegirEnteroEntre(1, 2);//Se elige una de las dos opciones
		}
		else {//En caso de haber asientos libres
			mostraAsientosDisponibles(asientosAvion,primerASiento,ultimoAsiento);//Se muestran los asientos disponibles
			seleccionAsiento=elegirAsiento(asientosAvion,primerASiento,ultimoAsiento);//Se elige un asiento entre los disponibles
			asientosAvion[seleccionAsiento-1]=1;//Se marca el asiento como reservado
		}
		return quiereElegirEnOtraZona;//Se devuelve que ha elegido el usuario
	}


	//Menu que se muestra cuando en una zona ya no quedan asientos disponibles
	private static void mostrarMenuCompleto(String zona) {
		System.out.println("Lo sentimos no hay asientos disponibles en la zona de " +zona);
		System.out.println("¿Desea reservar en la otra zona?");
		System.out.println("1. Si");
		System.out.println("2. No");

	}

	/**
	 * Metodo cuya responsabilidad es mostrar por pantalla el estado de los asientos del avion
	 * @param asientosAvion array representa los asientos disponibles en el avion. 
	 * 0  indica que esta libre, y 1 que esta ocupado
	 * @author Raul SG
	 */
	public static void mostrarEstadoAvion(int[] asientosAvion) {
		System.out.println(Arrays.toString(asientosAvion));//Mostramos el contenido de la array
		System.out.println();//Salto de linea

	}

	/**
	 * Metodo que muestra el menu principal por pantalla
	 * @author Raul SG
	 */
	public static void mostrarMenuPrincipal() {
		System.out.println("¿Qué desea realizar?");
		System.out.println("1. Reservar asiento de fumador");
		System.out.println("2. Reservar asiento de no fumador");
		System.out.println("3. Ver estado actual del avion");
		System.out.println("4. Salir del programa");

	}

	//Metodo que muestra al usuario los asientos disponibles
	//En caso de elegir una opcion no disponible, es decir invalida
	//El metodo le volvera a preguntar al usuario
	private static int elegirAsiento(int[] asientosAvion, int primerAsiento, int ultimoAsiento){
		int eleccion;
		Scanner sc=new Scanner(System.in);
		eleccion=sc.nextInt();//Leemos por teclado la opcion del usuario
		while(eleccionAsientoIncorrecta(eleccion,asientosAvion,primerAsiento,ultimoAsiento)) {//Mientras la eleccion este fuera del rango
			System.out.println();//Salto de línea
			System.out.println("Eleccion incorrecta.");
			mostraAsientosDisponibles(asientosAvion,primerAsiento,ultimoAsiento );//Volvemos a mostrar los asientos disponibles
			eleccion=sc.nextInt();//Se lee de nuevo la eleccion
		}
		return eleccion;//Se devuelve el asiento elegido por el usuario
	}

	//Metodo para validar si la eleccion de un asiento del usuario es correcta
	//para ello se comprobora que este dentro de los limites de la array, y 
	//adicionalmente que el asiento este libre.
	private static boolean eleccionAsientoIncorrecta(int eleccion, int[] asientosAvion, int primerAsiento, int ultimoAsiento) {
		return eleccion<primerAsiento || eleccion>ultimoAsiento || asientosAvion[eleccion-1]==1;
		//La eleccion es incorrecta si es menor que el primer asiento de la zona seleccionada
		//o es mayor del asiento de la zona seleccionada, o el asiento esta ocupado.
		//Gracias a la evaluacion perezosa, en caso de que eleccion fuera un numero fuera del rango
		//del indice de la array, no se va a lanzar la excepcion IdexOutBoundException, ya que
		//no se va a llegar a evaluar dicha condicion.
	}

	//Metodo que muestra por pantalla los asientos que quedan libres de una zona
	//delimitada por primerAsiento y ultimoAsiento
	//Los numeros que se muestra son para el usuario, por lo que la posicion inicial 
	//no es cero, sino 1.
	private static void mostraAsientosDisponibles(int[] asientosAvion, int primerAsiento, int ultimoAsiento) {
		System.out.println("Seleccion uno de los siguientes asientos disponibles: ");
		for(int i=primerAsiento-1;i<=ultimoAsiento-1;i++) {//Recorremos la zona que va desde el primer asiento hasta el ultimo. Se resta uno, porque
			//Para el usuario el primer asiento es 1, pero las arrays comienzan con el indice 0
			if(asientosAvion[i]==0)//Si el asiento i esta libre
				System.out.print(" "+(i+1));//Se muestra por pantalla. Se suma uno porque para el usuario la primera posicion es el 1, en lugar del cero.
		}
		System.out.println();//Imprimimos un salto de linea
	}


	//Metodo utilizado para comprobar si una zona esta completa. Los parametros
	//primerAsiento y ultimoAsiento indican el principio y final de la zona
	//asientoAvion es una array que representa los asientos del avion. 0 indica que
	//esta libre, y 1 que esta reservado. El metodo devolvera true si
	//esta ocupado y false si hay algun asiento libre en la zona.
	private static boolean comprobarCompleto(int[] asientosAvion, int primerAsiento, int ultimoAsiento) {
		boolean completo=true;//Inicialmente se considera que esta completo el avion
		for(int i=primerAsiento-1;i<=ultimoAsiento-1 && completo;i++) {//Se revisa uno a uno los asientos. En el caso de que se encuentr uno libre, el bucle para.
			if(asientosAvion[i]==0){//Si encontramos un hueco, ya sabemos que la zona no esta completa, y por tanto no hay que seguir buscando.
				completo=false;//Completo pasa a ser falso, lo que detendra el bucle
			}
		}
		return completo;//Se devuelve completo. En caso de con encontrar ningun hueco, completo sera true.
	}

	//Metodo utilizado para mostar el mensaje de cuando parte el siguiente vuelo

	private static void mostrarSiguienteVuelo() {
		System.out.println("El siguiente vuelo sale mañana a las 15:00 ");
		System.out.println();

	}


}
