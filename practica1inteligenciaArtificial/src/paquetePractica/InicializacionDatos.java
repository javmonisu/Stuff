package paquetePractica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Clase que se encarga de extraer los nodos del documento TXT que los almacena y de la actualizacion del arbol de nodos
 * @author Javier
 *
 */
public class InicializacionDatos {
	ArrayList<Nodo> datosCiudades;
	ArrayList<Nodo> nodosHijo;
	Nodo n1;
	
	public 	ArrayList<Nodo> extraerNodos (){
				try{
					datosCiudades = new ArrayList<>();
					String lectura="";
					BufferedReader br = new BufferedReader(new FileReader("ciudades.txt"));
					//Lectura de los datos
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
				    //Division entre las lineas
						String[] tokens = lectura.split("&");
						
						for(int j = 0 ; j < tokens.length; j++){
							//Division entre los argumentos de una linea: NOMBRE, TOKENS HIJOS , HEURISTICAS
							String[] tokensAux = tokens[j].split(";");
							n1 = new Nodo();
							nodosHijo= new ArrayList<Nodo>();
							String nombreNodo = tokensAux[0];
							String[] tokensHijos = tokensAux[1].split("-");
							for(int i = 0 ; i < tokensHijos.length ; i++){
								Nodo n2 = new Nodo();
								n2.setNombre(tokensHijos[i]);
								nodosHijo.add(n2);
							}
							n1.setNombre(nombreNodo);
							n1.setNodos_hijo(nodosHijo);						
							datosCiudades.add(n1);						
						}
						ActualizarHijos();
						br.close();
						return datosCiudades;
					
				}	catch(Exception ex){
					System.out.println(ex.toString());
					return null;
				}				
	}
	/**
	 * Este método se encarga de actualizar los hijos de un nodo con los datos que tienen las ciudades "originales"
	 */
	public void ActualizarHijos(){
		String nombre1;
		ArrayList<Nodo> nodosHijos = new ArrayList<>();
		for(int i = 0 ; i< datosCiudades.size();i++){
					nodosHijos = new ArrayList<>();
				//Vemos los hijos que tiene un nodo
					for(int j = 0 ; j < datosCiudades.get(i).getNodos_hijo().size();j++){				
								nombre1 = datosCiudades.get(i).getNodos_hijo().get(j).getNombre();
								for(int k = 0 ; k < datosCiudades.size();k++){
									//System.out.println(datosCiudades.get(i).getNodos_hijo().get(j).getNombre()+"-"+datosCiudades.get(k).getNombre());									
									String nombre2 = datosCiudades.get(k).getNombre();
									if(nombre1.equals(nombre2)){
										//System.out.println("Cambiando nodo hijo:" + nombre2);
										nodosHijos.add(datosCiudades.get(k));
									}
								}					
					}	
					datosCiudades.get(i).setNodos_hijo(nodosHijos);		
		}//Nodos actualizados!
	}
}

