package dijkstra;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) throws GrafoException {

		
//		Grafo g = GeneradorGrafos.GeneradorRegularGrado(10,2);
//		g.imprimirGrafo();
//		int nodoOrig = 1;
//		System.out.println("Nodo Origen: " + nodoOrig);
//		double[] distancias = Dijkstra.Dijkstra(g, nodoOrig);
//		System.out.println("Vector distancias resultante: ");
//		for (int i = 1; i < distancias.length; i++) {
//			System.out.printf("[%.2f]\t", distancias[i]);
//		}
		
		///////////////////////
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		//System.out.println("Grafo original:");
		//g.imprimirGrafo();		
		int nodoOrig = 1;
		//System.out.println("Nodo Origen: " + nodoOrig);
		
		double[] distancias = Dijkstra.Dijkstra(g, nodoOrig);
		
		System.out.println("Vector distancias resultante: ");
		for (int i = 1; i < distancias.length; i++) {
			System.out.printf("[%.2f]\t", distancias[i]);
		}
	}

}
