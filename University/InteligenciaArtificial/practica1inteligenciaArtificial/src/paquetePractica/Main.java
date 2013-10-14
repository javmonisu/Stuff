package paquetePractica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/**
 * Clase principal de la aplicacion, se encarga de la muestra por pantalla, las pruebas de ejecucion y la muestreo de las pruebas.
 * @author Javier
 *
 */
public class Main {
	/**
	 * Array que almacena las estadisticas de la prueba
	 */
	static ArrayList<DatosExtraidos> arrayInformacion;
	/**
	 * Aux toma toda la informacion de los nodos.
	 */
	static ArrayList<Nodo> aux;
	/**
	 * Variable que almacena el tiempo de inicio del periodo de ejecuciones
	 */
	static long init;
	/*/
	 * 
	 */
	static long tiempoEstimado;
	/**
	 * Variable que almacena que escoje el usuario en el menu de la aplicacion
	 * <br />
	 * <ul>
	 * <li>Si vale 1 accederemos a BPA</li>
	 * <li>Si vale 2 accederemos a BPP</li>
	 * <li>Si vale 3 accederemos a BPM</li>
	 * <li>Si vale 4 accederemos a BPL</li>
	 * <li>Si vale 5 cambiaremos el numero de repeticiones</li>
	 * <li>Si vale 6 saldremos de la aplicacion.</li>
	 * <li>Si vale 7 se continua en el bucle</li>
	 * </ul>
	 */
	static int seleccionMenu;
	public static void main(String[] args) {		
		seleccionMenu = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * Array que almacena el <i>feedback</i> de la aplicacion tras las ejecuciones
		 */
		arrayInformacion = new ArrayList<>();
		//Si altera este valor, el programa se ejecutara las veces que indique ( >0).
		DatosExtraidos numeroRepeticiones = new DatosExtraidos(50);
		arrayInformacion.add(numeroRepeticiones);
		InicializacionDatos id = new InicializacionDatos();
		aux = id.extraerNodos();
		System.out.println("Bienvenido a la aplicacion que le permite probar las distintas Estrategias de Busqueda.");
		try {
			do{
					System.out.println("Indique que algoritmo desea probar\n 1. Busqueda Primero en Anchura.\n 2. Busqueda Primero en Profundidad.\n 3. Busqueda Primero el Mejor.\n 4. Busqueda Primero en Profundidad Limitada.\n 5. Cambiar el numero de ejecuciones \n 6. Salir de la aplicacion.");
					try {
						seleccionMenu = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Entrada erronea");
					}				
					if(seleccionMenu==1||seleccionMenu==2||seleccionMenu==3){
						benchmark(seleccionMenu,0);
						seleccionMenu=7;
					}else if(seleccionMenu==4){
						try{
							System.out.println("Introduzca el limite");
							int limiteBPL = Integer.parseInt(br.readLine());
							benchmark(seleccionMenu,limiteBPL);
							seleccionMenu=7;
						}catch(Exception ex){
							System.out.println("Limite invalido");
							seleccionMenu=7;
						}						
					}else if(seleccionMenu==6){
						System.out.println("Saliendo de la aplicacion");
						System.exit(0);				
					}else if(seleccionMenu==5){
						System.out.println("Indique el numero de repeticiones deseadas.\nValor Actual: "+arrayInformacion.get(0).getNumero());
						int aux = Integer.parseInt(br.readLine());
						if( aux > 0 ){
							numeroRepeticiones.setNumero(aux);
							arrayInformacion.set(0, numeroRepeticiones);
							System.out.println("Valor cambiado a: "+aux);
						}else{
							System.out.println("Introduzca un numero de repeticiones mayor que cero ( 0 )");
						}
						seleccionMenu=7;
					}		
						else{
						System.out.println("Opcion incorrecta");
						seleccionMenu=7;
					}
			}while(seleccionMenu==7);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}			
	}
	/**
	 * Metodo que se encarga de la ejecucion de las estrategias de busqueda
	 * @param option opcion tomada en el menu.
	 * @param limit este parametro es para el BPL, indicando el limite de profundidad.
	 */
	public static void benchmark(int option, int limit){
		Random aleatorio = new Random();
		int numeroEntrada,numeroSalida;
		BusquedaPrimeroMejor bpm = new BusquedaPrimeroMejor();
		BusquedaPrimeroAnchura bpa = new BusquedaPrimeroAnchura();
		BusquedaPrimeroProfundidad bpp = new BusquedaPrimeroProfundidad();
		BusquedaPrimeroProfundidadLimitada bpl = new BusquedaPrimeroProfundidadLimitada();
		ArrayList<Integer> resultadosTemporales = null,resultadosFinales = new ArrayList<>();
		resultadosFinales.add(0);
		resultadosFinales.add(0);
		
		for(int i = 0 ; i < arrayInformacion.size() ; i++){
			Date horainicio = new Date();
			init = horainicio.getTime();
			
			for(int j = 0 ; j < arrayInformacion.get(i).getNumero();j++){
					//Localizacion desde la que sale el viajante
					numeroEntrada = aleatorio.nextInt(11);
					//Localizacion a la que desea llegar el viajante					
					numeroSalida = aleatorio.nextInt(11);
					System.out.println("\nViaje numero "+(j+1));
					if(option==1){
						resultadosTemporales = bpa.algoritmo(aux, numeroEntrada, numeroSalida);
					}else if(option==2){
						resultadosTemporales = bpp.algoritmo(aux, numeroEntrada, numeroSalida);
					}else if(option==3){
						resultadosTemporales = bpm.algoritmo(aux, numeroEntrada, numeroSalida);
					}else if(option==4){
						resultadosTemporales = bpl.algoritmo(aux, numeroEntrada, numeroSalida, limit);
					}
					int aux2 = resultadosTemporales.get(0);
					//Soluciones a las que ha llegado
					if(aux2 == 1){
						//Ha llegado al objetivo y por tanto se le suma al contador de soluciones contradas.
						resultadosFinales.set(0, resultadosFinales.get(0)+1);
					}
					aux2= resultadosTemporales.get(1);
					//Iremos almacenando en esta variable todos los resultados recogidos, el numero de nodos abiertos
					resultadosFinales.set(1, resultadosFinales.get(1)+aux2);
			}
			Date horafin = new Date();
			tiempoEstimado = (horafin.getTime() - init);
			System.out.println("Soluciones encontradas: "+resultadosFinales.get(0)+" Nodos abiertos: "+resultadosFinales.get(1)+" Nodos abiertos medios: "+resultadosFinales.get(1)/arrayInformacion.get(0).getNumero());
			arrayInformacion.set(i, new DatosExtraidos(arrayInformacion.get(i).getNumero(), tiempoEstimado));
		}
		for(int i = 0 ; i < arrayInformacion.size(); i++){
			System.out.println("Repeticiones: "+arrayInformacion.get(i).getNumero()+" Tiempo empleado: "+arrayInformacion.get(i).getTiempoProlongado()+" milisegundos\n\n");
		}
	}
}
