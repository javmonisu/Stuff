package paquetePractica;
/**
 * Almacenamiento de datos para la muestra posterior por pantalla
 * @author Javier
 *
 */
public class DatosExtraidos {
	int numero;
	long tiempoProlongado;
	public DatosExtraidos(int numero) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
	}
	public DatosExtraidos(int numero,long tiempo) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		this.tiempoProlongado=tiempo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public long getTiempoProlongado() {
		return tiempoProlongado;
	}
	public void setTiempoProlongado(long tiempoProlongado) {
		this.tiempoProlongado = tiempoProlongado;
	}
}
