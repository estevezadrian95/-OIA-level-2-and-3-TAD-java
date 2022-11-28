package dijkstra;

import java.util.LinkedList;

public class Dijkstra {
	public static double[] Dijkstra(Grafo g, int nodoOrig){
		double[] distancias = new double[g.getCantidadNodos()+1]; //el +1 es porque la pos cero no la uso. 
		LinkedList<Integer> S = new LinkedList<Integer>();
		LinkedList<Integer> V = new LinkedList<Integer>();
		//Inicializo el vector
		for (int i = 1; i < distancias.length; i++) {
			distancias[i] = g.getCostoArista(nodoOrig, i);
		}
		
//		for (int i = 1; i < distancias.length; i++) {
//		System.out.println(distancias[i]);
//		}
		
		//Inicializo los conjuntos
		S.add(2);
		for (int i = 1; i < distancias.length; i++) {
			if(i!=2)
				V.add(i);
		}
		
		while(!V.isEmpty()){
			
			double min = Double.POSITIVE_INFINITY;
			int posMin = -1;
			
			for (Integer integer : V) {
				//System.out.println(integer);
				if(distancias[integer]<min){
					min = distancias[integer];
					posMin = integer;
				}
			}
			
			
			S.add(V.get(V.indexOf(posMin)));
			V.remove(V.indexOf(posMin));
			for (int i = 1; i < distancias.length; i++) {
				if(distancias[i] > (distancias[posMin] + g.getCostoArista(posMin, i))){
					distancias[i] = (distancias[posMin] + g.getCostoArista(posMin, i));
				}
			}
		}
		
		return distancias;

		
	}

}
