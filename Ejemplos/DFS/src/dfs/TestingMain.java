package dfs;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) {
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		System.out.println("Grafo original:");
		g.imprimirGrafo();
		int[] estado = DFS.DFS(g);
		System.out.println("Vector distancias resultante: ");
		for (int i = 1; i < estado.length; i++) {
			System.out.printf("[%d]\t", estado[i]);
		}

	}

}
