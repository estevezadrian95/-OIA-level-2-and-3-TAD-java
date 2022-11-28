package rescatandoALaPrincesa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Archivo {

	public static Grafo leer(String miDOC) throws FileNotFoundException {
		File archivo = new File(miDOC);// creo el nuevo archivo para lectura
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(archivo);

		int cantNodos = sc.nextInt();
		int cantAristas = sc.nextInt();
		Dragon[] nodosDragones = new Dragon[sc.nextInt()];
		int nodoFinal = sc.nextInt();
		int nodoInicio = sc.nextInt();
		double[][] matriz = new double[cantNodos + 1][cantNodos + 1];// pongo el +1 porque el 0 no lo voy a utilizar

		for (int i = 0; i < nodosDragones.length; i++) {
			nodosDragones[i] = new Dragon(sc.nextInt(), 0);

		}

		int inicio = 0;
		int fin = 0;
		int peso = 0;

		for (int i = 0; i <= cantNodos; i++) {
			for (int j = 0; j <= cantNodos; j++) {
				matriz[i][j] = Double.POSITIVE_INFINITY;
			}
		}

		for (int i = 0; i < cantAristas; i++) {
			inicio = sc.nextInt();
			fin = sc.nextInt();
			peso = sc.nextInt();

			matriz[inicio][fin] = peso; // al ser bi-direccional, es una matriz simetrica
			matriz[fin][inicio] = peso;

		}
		return new Grafo(cantNodos, matriz, nodoInicio, nodoFinal, nodosDragones, cantAristas);
	}

	public static void imprimirResultados(String miDoc, Grafo g) throws FileNotFoundException {

		File file = new File(miDoc);
		@SuppressWarnings("resource")
		PrintWriter salida = new PrintWriter(file);

		if (g.costoAlPrincipe == Double.POSITIVE_INFINITY) {
			salida.println("NO HAY CAMINO");
			salida.close();
			return;
		} else {

			for (int i = 0; i < g.nodosDragones.length; i++) {

				if (g.nodosDragones[i].distanciaDelDragon < g.costoAlPrincipe) {
					salida.println("INTERCEPTADO");
					salida.close();
					return;
				}
			}

		}
		/*
		 * Si llegamos hasta aca es porque hay un camino posible, tenemos que invertir
		 * la lista ya que hicimos el recorrido de la princesa al principe y se tiene
		 * que invertir... ademas hay que sacar los nodos que estan de mas
		 */
		int i = 0;
		LinkedList<Integer> rf = new LinkedList<>();

		while (g.recorridoFinal.get(i) != g.nodoInicio) {
			rf.add(g.recorridoFinal.get(i));
			i++;
		}
		rf.add(g.recorridoFinal.get(i));
		Collections.reverse(rf); /* envierto la lista */

		salida.print(rf.toString());
		salida.close();

	}

}
