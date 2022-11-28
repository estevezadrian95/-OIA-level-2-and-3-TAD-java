package bfs;

import java.util.PriorityQueue;

public class BFS {
	public static Double[] BFS(Grafo g){
		
		
		char[] estado = new char[g.getCantidadNodos()+1];
		
		Double[] dist = new Double[g.getCantidadNodos()+1];
		int[] padre = new int[g.getCantidadNodos()+1];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int u;
		
		//inicializo vec dist
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Double.POSITIVE_INFINITY;
		}
		//inicializo vec estado
		for (int i = 1; i < estado.length; i++) {
			estado[i] = 'N';
		}
		
		estado[1] = 'V';
		dist[1] = (double) 0;
		q.add(1);
		
		while(!q.isEmpty()){
			u = q.poll();
			
			for (int i = u+1; i < estado.length; i++) {
				
				if(g.getArista(u, i) == 1 && estado[i] != 'V'){
					estado[i] = 'V';
					dist[i] = dist[u]+1;
					padre[i] = u; ///????????
					q.add(i);
				}
			}
		}
		for(int i=1;i<padre.length;i++) {
			System.out.print(padre[i]+" ");
		}
		

		return dist;
	}
}
