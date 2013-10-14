package paquetePractica;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Estrategia de Busqueda Primero en Profundidad
 * @author Javier
 *
 */
public class BusquedaPrimeroProfundidad extends Algoritmo{
	//Nodo actual

	public BusquedaPrimeroProfundidad() {
	}
	public ArrayList<Integer> algoritmo (ArrayList<Nodo> n1,int numeroE , int numeroS){
		ArrayList<Integer> solucionYnodos = new ArrayList<>();
		try{		
				solucionYnodos.add(0);
				solucionYnodos.add(0);
				nodosAlgoritmo=n1;
				numeroEntrada = numeroE;
				numeroSalida = numeroS;
				nodosvisitados="";
				Stack<Nodo> listaNodos = new Stack<>();			
				String solucion = nodosAlgoritmo.get(numeroSalida).getNombre();
				n = nodosAlgoritmo.get(numeroEntrada);
				System.out.println("Viaje de: "+n.getNombre() +" a "+solucion);
				cerrados = new ArrayList<>();
				listaNodos.push(n);
				// Si la lista tiene algun elemento
				while(!listaNodos.isEmpty()){					
					System.out.print("PILA: ");
					for(int i = 0 ; i < listaNodos.size();i++){
						System.out.print(" "+listaNodos.get(i).getNombre());
					}
					//Sacamos al ultimo elemento introducido de la pila, el que recoge n.

					listaNodos.pop();	
					System.out.println("\nPOP "+n.getNombre());	
					//Le añadimos a cerrado
					cerrados.add(n);					
					String nombreNodo = n.getNombre();
					nodosvisitados=nodosvisitados+n.getNombre()+"-";
					//Si es la solucion, saldra con un exito.
					if(nombreNodo.equals(solucion)){
						//return solucion
						solucionYnodos.set(0, 1);
						System.out.println("\nEl viaje ha concluido: "+nodosvisitados);
						return solucionYnodos;
					}					
					for(int i = 0; i < n.getNodos_hijo().size() ;i++){
						ActualizarHijos(n.getNodos_hijo().get(i));
						//Hijos que tiene ese Nodo
						solucionYnodos.set(1, solucionYnodos.get(1)+1);
						listaNodos.push(n.getNodos_hijo().get(i));
						System.out.println("PUSH "+n.getNodos_hijo().get(i).getNombre());
					}
					//Eliminacion de posibles duplicidades en la pila.
					for(int j = 0 ; j < listaNodos.size();j++){
						for(int k = 0 ; k < listaNodos.size();k++){
							if(listaNodos.get(j).getNombre().equals(listaNodos.get(k).getNombre())&&j!=k){
								System.out.println("Eliminado duplicados en la pila");
								listaNodos.remove(k);
								k--;								
								solucionYnodos.set(1, solucionYnodos.get(1)-1);								
							}
						}
					}
					//Eliminacion de elementos en la pila que hubieran sido ya cerrados.
					for(int m = 0 ; m < listaNodos.size();m++){
						for( int l = 0 ; l < cerrados.size();l++){
							if(listaNodos.get(m).getNombre().equals(cerrados.get(l).getNombre()) && listaNodos.size()>0){
								System.out.println("Eliminado de la pila por estar repetidos: "+listaNodos.get(m).getNombre());
								listaNodos.remove(m);
								solucionYnodos.set(1, solucionYnodos.get(1)-1);	
								//Imprescindible tras el borrado , para evitar ArrayOutOf.
								if(m>0){
									m--;
								}	
							}
						}	
					}
					//Si la pila no esta vacia
					if(!listaNodos.isEmpty()){
						n = new Nodo();
						n = listaNodos.get(listaNodos.size()-1);
						System.out.println("Nodo seleccionado "+n.getNombre());
					}
					else{
						//Caso imposible en este arbol, pero si se quiere implementar en otra solucion debe ser incluido
						System.out.println("<<<<ERROR EN EL ALGORITMO: No se ha llegado a la solucion>>>>");
						solucionYnodos.set(0, 0);
						return solucionYnodos;
					}
				}	
				//Se conserva por el RETURN obligatorio
				System.out.println("SALIDA ERRONEA");
				solucionYnodos.set(0, 0);
				return solucionYnodos;
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("EXCEPTION : "+e.toString());		
		solucionYnodos.set(0, 0);
		return solucionYnodos;
	}
}
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
									n1.setNodos_hijo(nodosAlgoritmo.get(k).getNodos_hijo());
									return n1;
								}
							}
				return null;
	}	
}
