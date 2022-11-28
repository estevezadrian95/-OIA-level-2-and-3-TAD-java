package acortandoElCamino;

import java.io.File;
import java.util.LinkedList;

public class TestMain {

	public static void main(String[] args) {
		File file = new File("IN.in");
		Grafo g = new Grafo(file);
		int caso = 0;
		int[] aristNoPerm = new int[g.getCantidadNodos()+1];
		double[] distancias = Dijkstra.Dijkstra(g, 1, aristNoPerm);
		int contGalerias = 0;
		double distTotal;
		LinkedList<Integer> nroAristasNoPerm = new LinkedList<Integer>();
		for (int i = 1; i < aristNoPerm.length; i++) {
			if(aristNoPerm[i] != 0){
				contGalerias++;
				nroAristasNoPerm.add(aristNoPerm[i]);
			}
		}
		
		switch(contGalerias){
		case 0:
			caso = 1;
			break;
		case 1: 
			caso = 2;
			break;
		case 2:
			caso = 3;
			break;
		}
		
		distTotal = distancias[g.getCantidadNodos()];
		
		File file1 = new File("OUT.in");
		g.guardarEnArchivo(file1, caso, nroAristasNoPerm, distTotal);

	}

}
