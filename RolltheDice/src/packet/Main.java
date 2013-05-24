package packet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		long dados,result=0,iter,one=0,two=0,three=0,four=0,five=0,six=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca el numero de dados que quiera tirar");
		dados = Integer.parseInt(br.readLine());
		System.out.println("Iteraciones");
		iter = Integer.parseInt(br.readLine());
		for(int j = 0 ; j < iter; j++){
			Hilo h = new Hilo(dados);
			h.run();
			one+=h.getOne();
			two+=h.getTwo();
			three+=h.getThree();
			four+=h.getFour();
			five+=h.getFive();
			six+=h.getSix();
			result+=h.getResult();
		}
		float res=result/(dados*iter);
		System.out.println("Resultado: "+res+"\n1: "+one+" 2: "+two+" 3: "+three+" 4: "+four+" 5: "+five+" 6: "+six);
	}
}
