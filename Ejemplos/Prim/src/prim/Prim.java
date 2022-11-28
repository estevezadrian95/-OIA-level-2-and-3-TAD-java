package prim;

import java.util.LinkedList;

public class Prim {
	public static int Prim(Grafo g, Grafo a){
		LinkedList<Integer> S = new LinkedList<Integer>();
		LinkedList<Integer> V = new LinkedList<Integer>();
		int costo = 0;
		S.add(2);
		for (int i = 1; i <g.getCantidadNodos() ; i++) {
			if(i!=2)
			V.add(i);
		}
		

		
		double min;
		int desde;
		int hacia = -1;
		
		while(!V.isEmpty()&&hacia!=7){
			min = Double.POSITIVE_INFINITY;
			desde = -1;
			hacia = -1;
			for (Integer n1 : S) {
				for (Integer n2 : V) {
					if(g.getCostoArista(n1, n2) != 0 && g.getCostoArista(n1, n2) < min){
						min = g.getCostoArista(n1, n2);
						desde = n1;
						hacia = n2;
					}
					

				}
			}
			if(hacia==7) {
				return costo;
			}
			a.setArista(desde, hacia, (int) min);
			
			costo+= min;
			S.add(hacia);
			V.remove(V.indexOf(hacia));
		}
	return costo;
	}
}
