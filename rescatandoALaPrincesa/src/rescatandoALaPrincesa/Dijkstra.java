package rescatandoALaPrincesa;

import java.util.LinkedList;

public class Dijkstra {

	public static void resolver(Grafo g) {

		double[] distancias = new double[g.cantNodos + 1]; // el +1 es porque la pos cero no la uso.
		LinkedList<Integer> S = new LinkedList<Integer>();
		LinkedList<Integer> V = new LinkedList<Integer>();
		// Inicializo el vector

		for (int i = 1; i < distancias.length; i++) {
			distancias[i] = g.getPesoDeArista(g.nodoFinal, i);
		}
		// Inicializo los conjuntos
		S.add(g.nodoFinal);
		for (int i = 1; i < distancias.length; i++) {
			if (i != g.nodoFinal)
				V.add(i);
		}

		int posMin = -1;
		while (!V.isEmpty()) {
			double min = Double.POSITIVE_INFINITY;
			posMin = -1;
			for (Integer integer : V) {
				if (distancias[integer] < min && (integer != 5 && integer != 8)) {
					min = distancias[integer];
					posMin = integer;
				}
			}

			if (posMin == -1) { /* si no hay camino hacia algun nodo devuelvo los que tengo ahora */

				distancias[g.nodoFinal] = Double.POSITIVE_INFINITY; /*
																	 * en el nodo en el que inicio el recorrido pongo
																	 * infinito
																	 */
				g.colocarCostoDragones(distancias);
				g.setRecorridoFinal(S);
				return;
			}

			S.add(V.get(V.indexOf(posMin)));
			V.remove(V.indexOf(posMin));
			for (int i = 1; i < distancias.length; i++) {
				if (distancias[i] > (distancias[posMin] + g.getPesoDeArista(posMin, i))) {
					distancias[i] = (distancias[posMin] + g.getPesoDeArista(posMin, i));
				}
			}

		}

		distancias[g.nodoFinal] = Double.POSITIVE_INFINITY; /*
															 * en el nodo en el que inicio el recorrido pongo infinito
															 */
		g.colocarCostoDragones(distancias);
		g.setRecorridoFinal(S);
	}
}
