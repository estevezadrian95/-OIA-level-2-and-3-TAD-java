package bfs;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) {
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		System.out.println("Grafo original:");
		g.imprimirGrafo();
		Double[] dist = BFS.BFS(g);
		System.out.println("Vector distancias resultante: ");
		for (int i = 1; i < dist.length; i++) {
			System.out.printf("[%.2f]\t", dist[i]);
		}

	}

}
