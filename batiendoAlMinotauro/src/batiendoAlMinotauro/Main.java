package batiendoAlMinotauro;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Grafo grafo = Archivo.leer("fatiga.in");
		Grafo resultado = new Grafo(grafo.getCantNodos());
		Prim.resolver(grafo, resultado);
		resultado.llenarListaDeAristas();
		Archivo.crearArchivoResultado(resultado, "fatiga2.out");
	}

}
