package batiendoAlMinotauro;

import java.util.LinkedList;

public class Prim {

	public static int resolver(Grafo g, Grafo a) {

		int costo = 0;

		LinkedList<Integer> s = new LinkedList<>();
		LinkedList<Integer> v = new LinkedList<>();

		s.add(1); /* comienzo el recorrido con el nodo 1 */

		for (int i = 2; i <= g.getCantNodos(); i++) {
			/* en la otra lista voy a poner todos los demas nodos y voy a ir sacando */
			v.add(i);
		}

		double min;
		int desde;
		int hacia;

		while (!v.isEmpty()) {

			min = Double.POSITIVE_INFINITY;
			desde = -1;
			hacia = -1;

			for (Integer n1 : s) {
				for (Integer n2 : v) {
					if (g.getPesoArista(n1, n2) != 0 && g.getPesoArista(n1, n2) < min) {
						min = g.getPesoArista(n1, n2);
						desde = n1;
						hacia = n2;
					}
				}
			}
			
			a.setPesoArista(desde, hacia, (int) min); /* tengo que castear porque el Double lo uso para ponerlo en infinito */
			costo += min;
			s.add(hacia);
			v.remove(v.indexOf(hacia));
		}
	return costo; /*retorno el costo pero el ejercicio no me lo pide*/
	}
}
