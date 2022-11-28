package acortandoElCamino;

import java.util.LinkedList;

public class Dijkstra {
	public static double[] Dijkstra(Grafo g, int nodoOrig, int[] aristNoPerm){
		double[] distancias = new double[g.getCantidadNodos()+1]; //el +1 es porque la pos cero no la uso.
		LinkedList<Integer> S = new LinkedList<Integer>();
		LinkedList<Integer> V = new LinkedList<Integer>();
		
		Double distOrig, distPerm, distNoPerm;
		
		//Inicializo el vector
		for (int i = 1; i < distancias.length; i++) {
			distancias[i] = g.getCostoAristaPermitida(nodoOrig, i);
		}
		//Inicializo los conjuntos
		S.add(nodoOrig);
		for (int i = 1; i < distancias.length; i++) {
			if(i!=nodoOrig)
				V.add(i);
		}
		
		while(!V.isEmpty()){
			double min = Double.POSITIVE_INFINITY;
			int posMin = -1;
			for (Integer integer : V) {
				if(distancias[integer]<min){
					min = distancias[integer];
					posMin = integer;
				}
			}
			S.add(V.get(V.indexOf(posMin)));
			V.remove(V.indexOf(posMin));
			for (int i = 1; i < distancias.length; i++) {
				distOrig = distancias[i];
				distPerm = distancias[posMin] + g.getCostoAristaPermitida(posMin, i);
				distNoPerm = distancias[posMin] + g.getCostoAristaNoPermitida(posMin, i);
				
				if(distOrig > distPerm || distOrig > distNoPerm){
					if(distPerm > distNoPerm){
						distancias[i] = distNoPerm;
						aristNoPerm[i] = g.matNoPermitida[posMin][i].getNro();
					}
					else{
						distancias[i] = distPerm;
					}
				}
			}
		}
	
		return distancias;

	}

}
