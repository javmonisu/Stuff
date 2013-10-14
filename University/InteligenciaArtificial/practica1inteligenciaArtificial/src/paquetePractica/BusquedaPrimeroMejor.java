package paquetePractica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Estrategia de Busqueda Primero el Mejor ( Busqueda Avara o Voraz)
 * @author Javier
 *
 */
public class BusquedaPrimeroMejor extends Algoritmo{
	
public String[] tokens;

public BusquedaPrimeroMejor() {
	// TODO Auto-generated constructor stub
}
	public ArrayList<Integer> algoritmo(ArrayList<Nodo> nodos,int n1, int n2){
		ArrayList<Integer> solucionYnodos = new ArrayList<>();
		try{
			solucionYnodos.add(0);
			solucionYnodos.add(0);
			nodosAlgoritmo=nodos;
			numeroEntrada = n1;
			numeroSalida = n2;
			int heuristicaMenor = 1000;		
			String solucion = nodosAlgoritmo.get(numeroSalida).getNombre();
			n = nodosAlgoritmo.get(numeroEntrada);
			System.out.println("Viaje de: "+n.getNombre() +" a "+solucion);
			abiertos = new ArrayList<>();
			cerrados = new ArrayList<>();
			abiertos.add(n);
			nodosvisitados="";
			Nodo nodoAnt = new Nodo();
			try{
				lecturaArchivoDatosNodos();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			ActualizarHeuristicas(nodosAlgoritmo, numeroSalida);
			
			while(abiertos != null){		
				//anadido el nodo a cerrados
				cerrados.add(n);
				//le eliminamos de cerrados
				abiertos.remove(n);
				nodoAnt=n;			
				String nombreNodo = n.getNombre();
				nodosvisitados=nodosvisitados+n.getNombre()+"-";			
				if(nombreNodo.equals(solucion)){
					//return solucion
					System.out.println("\nEl viaje ha concluido: "+nodosvisitados);
					solucionYnodos.set(0, 1);
					return solucionYnodos;
				}				
				//Anadimos los nodos hijo a abiertos
				for(int i = 0; i < n.getNodos_hijo().size() ;i++){
					//Se añaden los hijos del nodo a abiertos.
					ActualizarHijos(n.getNodos_hijo().get(i));
					if(n.getNodos_hijo().get(i).getNodos_hijo().size()>0||n.getNodos_hijo().get(i).getNombre().equals(solucion)){
						abiertos.add(n.getNodos_hijo().get(i));
						solucionYnodos.set(1, solucionYnodos.get(1)+1);
					}
					//System.out.println("Añadido a abiertos: "+n.getNodos_hijo().get(i).getNombre());
				}
				//Eliminacion de nodos que estan en cerrados y en abiertos de forma simultanea
				for(int i = 0 ; i < abiertos.size() ; i++){
					//Nombre del abierto que sea para comprobarlo con los cerrados existentes
					name1=abiertos.get(i).getNombre();
					for (int j = 0 ; j < cerrados.size() ; j++){
					//Nombre de los cerrados
					name2=cerrados.get(j).getNombre();
						if(name1.equals(name2)){
									abiertos.remove(i);			
									solucionYnodos.set(1, solucionYnodos.get(1)-1);
						}						
					}				
				}
				//Recogemos el nodo con menor heuristica para trabajar con el en la prox.
				for( int i = 0 ; i < abiertos.size(); i++){
					if(abiertos.get(i).getHeuristica()<heuristicaMenor){
						heuristicaMenor=abiertos.get(i).getHeuristica();
						n=abiertos.get(i);
					}
				}
				//Si abiertos esta vacia, O  el NODO ANTERIOR es identico al Actual. Hecho para evitar  bucles.
				if(abiertos.isEmpty()||nodoAnt==n){
					//System.out.println("Abiertos está vacio");
					solucionYnodos.set(0, 0);
					return solucionYnodos;
				}
			}
			//System.out.println("SALIDA ERRONEA");
			solucionYnodos.set(0, 0);
			return solucionYnodos;			
		}catch(Exception e){
			//System.out.println("EXCEPTION : "+e.toString());
			solucionYnodos.set(0, 0);
			return solucionYnodos;
			}
	}
	/** 
	 * Metodo que nos actualiza los nodos recogidos ( necesita ser recogido para posteriormente asignar las heuristicas a los hijos etc.)
	 * @param arrayNoActualizado
	 * @param nodo_final
	 * @return array actualizado
	 * @throws IOException 
	 */
	public void lecturaArchivoDatosNodos() throws IOException{
		String lectura="";
		BufferedReader br = new BufferedReader(new FileReader("ciudades.txt"));
		//Lectura
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        lectura = sb.toString();
	    } finally {
	        br.close();
	    }	
	    tokens = lectura.split("&");
	}
	/**
	 * Metodo que actualiza las heuristicas del arraydeNodos(seleccionando la heuristica hacia la ciudad que nos interese)
	 * @param arrayNoActualizado
	 * @param nodo_final
	 * @return
	 */
	public ArrayList<Nodo> ActualizarHeuristicas(ArrayList<Nodo> arrayNoActualizado,int nodo_final){
			// TODO Auto-generated constructor stub
			
				ArrayList<Nodo> arrayActualizado = arrayNoActualizado;
					for(int j = 0 ; j < tokens.length; j++){
						String[] tokensAux = tokens[j].split(";");
						Nodo n1 = new Nodo();
						String nombreNodo = tokensAux[0];
						n1.setNombre(nombreNodo);
						n1.setNodos_hijo(arrayNoActualizado.get(j).getNodos_hijo());
						String[] Heuristicas = tokensAux[2].split("-");
						n1.setHeuristica(Integer.parseInt(Heuristicas[nodo_final]));						
						arrayActualizado.remove(j);
						arrayActualizado.add(j, n1);
					}
					return arrayActualizado;
	}
	/**
	 * Actualizacion de los nodos hijo del nodo actual
	 * @param n2 nodo sin actualizar
	 * @return nodo con sus hijos actualizado
	 */
	public Nodo ActualizarHijos(Nodo n2){
		String nombre1;
		Nodo n1 = n2;
		//Vemos los hijos que tiene un nodo
		nombre1 = n1.getNombre();
					for(int k = 0 ; k < nodosAlgoritmo.size();k++){
									////System.out.println(n.getNodos_hijo().get(j).getNombre()+"-"+abiertos.get(k).getNombre());									
									String nombre2 = nodosAlgoritmo.get(k).getNombre();
									if(nombre1.equals(nombre2)){
										//System.out.println("Cambiando nodo hijo:" + nombre2);
										n1.setNodo_padre(n);
										n1.setHeuristica(nodosAlgoritmo.get(k).getHeuristica());
										n1.setNodos_hijo(nodosAlgoritmo.get(k).getNodos_hijo());
										return n1;
									}
								}
					return null;
	}	
}
