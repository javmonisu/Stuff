package paquetePractica;

import java.util.ArrayList;
/**
 * Clase que implementa la estrategia de Busqueda Primero en Anchura
 * @author Javier
 *
 */
public class BusquedaPrimeroAnchura extends Algoritmo{
	//Nodo actual
	public BusquedaPrimeroAnchura() {
		// TODO Auto-generated constructor stub
	}
	public BusquedaPrimeroAnchura(ArrayList<Nodo> n1,int numeroE , int numeroS){
		algoritmo(n1,numeroE,numeroS);		
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Integer> algoritmo (ArrayList<Nodo> n1,int numeroE , int numeroS){
		ArrayList<Integer> solucionYnodos = new ArrayList<>();
		solucionYnodos.add(0);
		solucionYnodos.add(0);
		nodosAlgoritmo=n1;
		numeroEntrada = numeroE;
		numeroSalida = numeroS;
		nodosvisitados="";
		String solucion = nodosAlgoritmo.get(numeroSalida).getNombre();
		n = nodosAlgoritmo.get(numeroEntrada);
		System.out.println("Viaje de: "+n.getNombre() +" a "+solucion);
		abiertos = new ArrayList<>();
		cerrados = new ArrayList<>();
		
		abiertos.add(n);
		while(abiertos != null){
			
			cerrados.add(n);
			abiertos.remove(0);
			
			String nombreNodo = n.getNombre();
			nodosvisitados=nodosvisitados+n.getNombre()+"-";
			if(nombreNodo.equals(solucion)){
				//return sol
				solucionYnodos.set(0, 1);
				System.out.println("El viaje ha concluido: "+nodosvisitados);
				return solucionYnodos;
			}
			//Adicion de nodos hijos a abiertos
			for(int i = 0 ; i < n.getNodos_hijo().size();i++){
				solucionYnodos.set(1, solucionYnodos.get(1)+1);
				abiertos.add(n.getNodos_hijo().get(i));
				//System.out.println("Añadido a abiertos: "+n.getNodos_hijo().get(i).getNombre());
			}
			//Eliminacion de nodos cerrados que estan en abiertos
			for(int i = 0 ; i < abiertos.size() ; i++){
				name1=abiertos.get(i).getNombre();
				for (int j = 0 ; j < cerrados.size() ; j++){
				name2=cerrados.get(j).getNombre();
					if(name1.equals(name2)){
						abiertos.remove(i);
						solucionYnodos.set(1, solucionYnodos.get(1)-1);
						//System.out.println("Eliminado de abiertos: "+name2);
					}
				}
				
			}			
			if(!abiertos.isEmpty()){
				n=abiertos.get(0);				
			}			
		}
		System.out.println("Abiertos está vacio");
		solucionYnodos.set(0, 0);
		return solucionYnodos;
	}
}
