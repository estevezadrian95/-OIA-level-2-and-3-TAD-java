package kruskal;

import java.util.LinkedList;

public class GeneradorGrafos {
	
//	public static Grafo GeneradorConexoMinimo(int n){
//		Grafo g = new Grafo(n);
//		LinkedList<Integer> noConectados = new LinkedList<Integer>();
//		for (int i = 1; i <= n; i++) {
//			noConectados.add(i);
//		}
//		LinkedList<Integer> conectados = new LinkedList<Integer>();
//		conectados.add(noConectados.pop());
//		for (int i = 1; i <= (n-1); i++) {
//			int nc = (int) (Math.random()*(noConectados.size()));
//			int c = (int) (Math.random()*(conectados.size()));
//			conectados.add(noConectados.get(nc));
//			g.setArista(noConectados.get(nc), conectados.get(c)); 
//			noConectados.remove(nc);
//		}
//		return g;
//	}
//	
//	public static Grafo GeneradorProbabilistico(int n, int p){
//		Grafo g = new Grafo(n);
//		for (int i = 1; i <= n; i++) {
//			for (int j = i+1 ; j <= n; j++) {
//				if(Math.random()*100 < p && !g.getArista(i, j)){
//					g.setArista(i, j);
//				}
//			}
//		}
//		return g;
//	}
//	
//	public static Grafo GeneradorPorcentajeAdyacencia(int n, int ady) {
//		int cantAr = ((n*(n-1)*ady)/200);
//		int adyMin = 200/n;
//		Grafo g;
//		if(ady < adyMin){
//			g = new Grafo(n);
//		} else {
//			g = GeneradorConexoMinimo(n);
//			cantAr -= (n-1); 
//		}
//		while(cantAr != 0){
//			int i = (int)(Math.random()*n)+1;
//			int j = (int)(Math.random()*n)+1;
//			if(i != j && !g.getArista(i, j)){
//				g.setArista(i, j );
//				cantAr--;
//			}
//		}
//		return g;
//	}
//	
//	public static Grafo generadorNPartitoCompleto(int n, int particiones)throws GrafoException{
//		if(particiones>n)
//			throw new GrafoException("no puedo n-partir en mas de n partes");
//		Grafo g = new Grafo(n);
//		LinkedList<Integer>[] lists = new LinkedList[particiones];
//		int idx;
//		int idx2;
//		
//		// Todas las particiones tienen al menos un nodo asignado, de manera que no quede ninguna vacia
//		for (int i = 0; i < particiones; i++) {
//			lists[i] = new LinkedList<Integer>();
//			lists[i].add(i+1);
//		}
//		
//		// Asigno los nodos restantes de manera aleatoria a cada particiones
//		for (int i = particiones+1; i <= n; i++) {
//			idx = (int) (Math.random() * particiones);
//			lists[idx].add(i);
//		}
//		
////		// Creo arista entre todas las particiones y la siguiente
////		for (int i = 0; i < particiones - 1; i++) {
////			idx  = (int) (Math.random() * lists[i].size());
////			idx2 = (int) (Math.random() * lists[i+1].size());
////			
////			g.setArista(lists[i].get(idx), lists[i+1].get(idx2));
////		}
////		
////		// Creo arista entre la ultima y primera particion
////		idx  = (int) (Math.random() * (lists[0].size()));
////		idx2 = (int) (Math.random() * (lists[particiones-1].size()));
////		
////		g.setArista(lists[0].get(idx), lists[particiones-1].get(idx2));
//		
//		// Hasta aca tengo un n-partito minimo
//		// Completos aristas
//		
//		for (int i = 0; i < lists.length; i++) {
//			for (int j = i+1; j < lists.length; j++) {
//				for (int nodo : lists[i]) {
//					for (int nodo2 : lists[j]) {
//						g.setArista(nodo, nodo2);
//					}
//				}
//			}
//		}
//		
//		return g;
//	}
//	
	public static Grafo GeneradorRegularGrado(int n, int gr) throws GrafoException {
		if (gr < 0)
			throw new GrafoException("El grado debe ser mayor igual a 0");
	
		if (gr >= n)
			throw new GrafoException("El grado debe ser menor o igual a la cant de nodos");
		
		if (gr % 2 != 0 && n % 2 != 0)
			throw new GrafoException("SI EL GRADO ES IMPAR, LA CANT DE NODOS NO PUEDE SER IMPAR.");
			
		Grafo g = new Grafo(n);
		int j;
		
		if(gr == 0)
			return g;
		
		if(gr>1){
			int saltos = (gr/2)-1;
			for (int s = 0; s <= saltos; s++) {
				for (int i = 1; i <=n ; i++) {
					
					j = i+s+1;
					
					if(j>n)
						j-=n;
					
					g.setArista(i, j, (int)(Math.random()*100));
					
				}
			}
		}
		
		if(gr %2 != 0){ //Asignar el opuesto si el grado es impar
			for (int i = 1; i <= n/2; i++)
				g.setArista(i, (n/2)+i, (int)(Math.random()*100));
			}
		
		return g;
	}
	
//	
//	public static Grafo GeneradorRegularPorcentajeAdyacencia(int n, double ady) throws GrafoException{
//		//VERIFICAR QUE CANTIDAD DE ARISTAS ES VALIDA, CANT DE ARISTAS < CANT NODOS -1.
//		
//		double cantAr= (n*(n-1)*ady)/200;
////		System.out.println(cantAr);
//		double grAux= (cantAr*2)/n;
////		System.out.println(grAux);
//		int gr;
//		//REDONDEO PRA ARRIBA O PARA ABAJO
//		double grDif = grAux - (int)grAux;
////		System.out.println(grDif);
//		if(grDif > 0.5)
//			gr = (int)grAux+1;
//		else
//			gr = (int)grAux;
//		
////		System.out.println(gr);
//		
//		//SI LA CANT DE NODOS ES IMPAR, EL GRADO NO PUEDE SER IMPAR, PERO NO DEBE SALTAR EXCEPCION!
//		if(n%2 !=0 && gr%2 !=0){ 
//			if(grDif > 0.5)
//				gr++;
//			else
//				gr--;
//		}
////		System.out.println(gr);
//			
//		
//		Grafo g = GeneradorRegularGrado(n, gr);
//		return g;
//
//	}
//	
}