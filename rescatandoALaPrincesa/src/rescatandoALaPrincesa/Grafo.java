package rescatandoALaPrincesa;

import java.util.LinkedList;

public class Grafo {

	double[][] mat;
	int nodoInicio;
	int cantAristas;
	int nodoFinal;
	Dragon nodosDragones[];
	int cantNodos;
	double costoAlPrincipe;
	LinkedList<Integer> recorridoFinal;

	public Grafo(int cantNodos, double[][] mat, int nodoInicio, int nodoFinal, Dragon[] nodosDragones, int cantAristas) {
		this.cantNodos = cantNodos;
		this.cantAristas = cantAristas;
		this.mat = mat;
		this.nodoInicio = nodoInicio;
		this.nodoFinal = nodoFinal;
		this.nodosDragones = nodosDragones;
	}

	public void mostrarMatriz() {

		for (int i = 1; i <= cantNodos; i++) {
			for (int j = 1; j <= cantNodos; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public double getPesoDeArista(int i, int j) {
		return mat[i][j];
	}

	public void colocarCostoDragones(double[] distancias) {

		for (int i = 0; i < nodosDragones.length; i++) {
			nodosDragones[i].distanciaDelDragon = distancias[nodosDragones[i].nodoDelDragon];
		}
		costoAlPrincipe = distancias[nodoInicio];
	}

	public void setRecorridoFinal(LinkedList<Integer> recorridoFinal) {
		this.recorridoFinal = recorridoFinal;
	}

	public void mostrarNodosDeDragones() {
		for (int i = 0; i < nodosDragones.length; i++) {
			System.out.println(nodosDragones[i].nodoDelDragon + " - " + nodosDragones[i].distanciaDelDragon);
		}

	}

}
