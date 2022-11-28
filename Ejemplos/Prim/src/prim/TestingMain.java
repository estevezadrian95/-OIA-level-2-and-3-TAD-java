package prim;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) {
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		System.out.println("Grafo original:");
		g.imprimirGrafo();
		Grafo arbol = new Grafo(g.getCantidadNodos());
		System.out.println("Arbol:");
		int costo = Prim.Prim(g, arbol);
		arbol.imprimirGrafo();
		System.out.println("Costo: " + costo);

	}

}
