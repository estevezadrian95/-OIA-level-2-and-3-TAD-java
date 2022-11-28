package floyd;

import java.io.File;

public class TestingMain {

	public static void main(String[] args) throws GrafoException {

//		creo q asi con generador no funca
//		Grafo g = GeneradorGrafos.GeneradorRegularGrado(6,3);
//		System.out.println("Grafo original:");
//		g.imprimirGrafo();
//		Double[][] costos = Floyd.Floyd(g);
//		System.out.println("Matriz de costos resultante: ");
//		for (int i = 1; i < costos.length; i++) {
//			System.out.printf("\n");
//			for (int j = 1; j < costos.length; j++) {
//				System.out.printf("[%.2f]\t", costos[i][j]);
//			}
//		}
		
		///////////////////////
		File arch = new File("grafo.in");
		Grafo g = new Grafo(arch);
		System.out.println("Grafo original:");
		g.imprimirGrafo();		
		double[][] costos = Floyd.Floyd(g);
		System.out.println("Matriz de costos resultante: ");
		for (int i = 1; i < costos.length; i++) {
			System.out.printf("\n");
			for (int j = 1; j < costos.length; j++) {
				System.out.printf("[%.2f]\t", costos[i][j]);
			}
		}

	}

}
