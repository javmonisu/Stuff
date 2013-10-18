package paquetePractica;

import java.util.ArrayList;
/**
 * Clase que almacena los datos que debe tener un nodo
 * @author Javier
 *
 */
public class Nodo {
	
	public Nodo nodo_padre;
	public ArrayList<Nodo> nodos_hijo;
	public int heuristica;
	public String nombre;
	public int profundidad;
	
    
	public Nodo() {
		// TODO Auto-generated constructor stub
    	nodos_hijo = new ArrayList<>();
    	nombre = "";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Nodo getNodo_padre() {
		return nodo_padre;
	}
	public void setNodo_padre(Nodo nodo_padre) {
		this.nodo_padre = nodo_padre;
	}
	public ArrayList<Nodo> getNodos_hijo() {
		return nodos_hijo;
	}
	public void setNodos_hijo(ArrayList<Nodo> nodos_hijo) {
		this.nodos_hijo = nodos_hijo;
	}
	public int getHeuristica() {
		return heuristica;
	}
	public void setHeuristica(int heuristica) {
		this.heuristica = heuristica;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	
}
