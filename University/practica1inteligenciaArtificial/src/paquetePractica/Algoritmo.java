package paquetePractica;

import java.util.ArrayList;

public abstract class Algoritmo {
	public ArrayList<Nodo> abiertos;
	public ArrayList<Nodo> nodosAlgoritmo;
	public ArrayList<Nodo> cerrados;
	public int numeroEntrada;
	public int numeroSalida;
	public String name1, name2 ,name3,nodosvisitados="";
	public Nodo n;
	public int getNumeroEntrada() {
		return numeroEntrada;
	}
	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}
	public int getNumeroSalida() {
		return numeroSalida;
	}
	public void setNumeroSalida(int numeroSalida) {
		this.numeroSalida = numeroSalida;
	}
	public ArrayList<Nodo> getAbiertos() {
		return abiertos;
	}
	public void setAbiertos(ArrayList<Nodo> abiertos) {
		this.abiertos = abiertos;
	}
	public ArrayList<Nodo> getCerrados() {
		return cerrados;
	}
	public void setCerrados(ArrayList<Nodo> cerrados) {
		this.cerrados = cerrados;
	}
	public ArrayList<Nodo> getNodosAlgoritmo() {
		return nodosAlgoritmo;
	}
	public void setNodosAlgoritmo(ArrayList<Nodo> nodosAlgoritmo) {
		this.nodosAlgoritmo = nodosAlgoritmo;
	}

}
