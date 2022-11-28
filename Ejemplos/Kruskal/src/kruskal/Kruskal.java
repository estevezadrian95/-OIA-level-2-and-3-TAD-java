package kruskal;

import java.util.Arrays;

public class Kruskal {
	
	public static int kruskal(Grafo g, Grafo arbol){
		int costo = 0; //costo total
		int costoAux;
		Arista a; //arista aux
		int cantAristas = g.getCantidadAristas();
		int contAristas = 0; //indice para moverme por el vec de aristas
		Arista[] vectorAristas = new Arista[cantAristas]; //vec de aristas de menor a mayor (segun el costo)
		int[] representantes = new int[g.getCantidadNodos()+1]; //el vector de representantes para Union-Find. Le pongo el +1 porque cuento de la pos 1 en adelante (la cero no la uso)
		
		//armo un array de aristas..
		for (int i = 1; i <= g.getCantidadNodos(); i++) {
			for (int j = i+1; j <= g.getCantidadNodos(); j++) {
				costoAux = g.getCostoArista(i, j);
				if(costoAux != 0){
					a = new Arista(costoAux, i, j);
					vectorAristas[contAristas] = a;
					contAristas++;
				}
			}
		}
		
		for(int i=0;i<vectorAristas.length;i++)
			System.out.println(vectorAristas[i].toString());
		
		
		Arrays.sort(vectorAristas);
		//inicializo vec de rep
		for (int i = 1; i < representantes.length; i++) {
			representantes[i] = i;
		}
		
		//debo recorrer el vector de aristas, si esa arista no cierra ciclo, entonces agrego esa arista al arbol.
		int contAristAgregadas = 0;
		for (int i = 0; i < vectorAristas.length; i++) {
			if(unionFind(vectorAristas, representantes, i)){
				arbol.setArista(vectorAristas[i].getNodo1(), vectorAristas[i].getNodo2(), vectorAristas[i].getCosto());
				costo+= vectorAristas[i].getCosto();
				contAristAgregadas++;
			}
//			if(contAristAgregadas == (g.getCantidadNodos()-1))
//				break;
		}
		return costo;
	}
	
	private static boolean unionFind(Arista[] vectorAristas, int[] representantes, int i){
		int nodo1 = vectorAristas[i].getNodo1();
		int nodo2 = vectorAristas[i].getNodo2();
		while(representantes[nodo1] != nodo1)
			nodo1 = representantes[nodo1];
		while(representantes[nodo2] != nodo2)
			nodo2 = representantes[nodo2];
		if(nodo1 != nodo2){
			representantes[vectorAristas[i].getNodo2()] = nodo1;
			return true; //no cierra ciclo
		}
		else
			return false; //cierra ciclo
	}

}
