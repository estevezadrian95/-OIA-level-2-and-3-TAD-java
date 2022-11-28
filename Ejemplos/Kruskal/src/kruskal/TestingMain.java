package kruskal;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) throws GrafoException {
//		 genero un grafo, creo objeto arbol abarcador, llamo a kruskal, me arma el arbol y me devuelve el costo.
		
//		Grafo g = GeneradorGrafos.GeneradorRegularGrado(18000, 2);
//		System.out.println(g.getCantidadNodos());
//		Grafo arbol = new Grafo(g.getCantidadNodos());
//		int costo = Kruskal.kruskal(g, arbol);
//		System.out.println(costo);
		
		///////////////////////
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		System.out.println("Grafo original:");
		g.imprimirGrafo();
		Grafo arbol = new Grafo(g.getCantidadNodos());
		System.out.println("Arbol:");
		
		int costo = Kruskal.kruskal(g, arbol);
		arbol.imprimirGrafo();
		System.out.println("Costo: " + costo);

		
		
		
	}
}
