package rescatandoALaPrincesa;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		
		Grafo grafo = Archivo.leer("g2.in");
		Dijkstra.resolver(grafo);
		Archivo.imprimirResultados("g2.out",grafo);
		
		

	}

}
