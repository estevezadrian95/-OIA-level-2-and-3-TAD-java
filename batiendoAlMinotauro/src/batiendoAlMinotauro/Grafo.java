package batiendoAlMinotauro;

import java.util.ArrayList;

public class Grafo {

	private int mat[][];/* matriz de adyacencia */
	private int cantNodos;
	private ArrayList<Arista> aristas;
	
	public Grafo(int[][] mat, int cantNodos) {
		
		this.mat = mat;
		this.cantNodos = cantNodos;
		this.aristas = new ArrayList<>();

	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public Grafo(int cantNodos) {

		this.cantNodos = cantNodos;
		this.mat = new int[cantNodos + 1][cantNodos + 1];
		this.aristas = new ArrayList<>();
	}

	public int getPesoArista(int desde, int hacia) {
		return mat[desde][hacia];

	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void mostrarMatriz() {
		for (int i = 1; i <= cantNodos; i++) {
			for (int j = 1; j <= cantNodos; j++)
				System.out.print(this.mat[i][j] + " ");

			System.out.println();
		}
	}

	public void setPesoArista(int desde, int hacia, int peso) {

		this.mat[desde][hacia] = peso;

	}
	
	public void llenarListaDeAristas() {
	
		for (int i = 1; i <= cantNodos; i++) {
			for (int j = 1; j <= cantNodos; j++) {
				if (mat[i][j] != 0) {
					aristas.add(new Arista(i, j, mat[i][j]));
	
				}
			}
		}

	}
}
