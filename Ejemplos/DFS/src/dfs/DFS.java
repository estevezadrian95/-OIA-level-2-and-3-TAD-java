package dfs;

import java.util.Stack;

public class DFS {
	public static int[] DFS(Grafo g){
		
		
		char[] estado = new char[g.getCantidadNodos()+1];
		int[] padre = new int[g.getCantidadNodos()+1];
		Stack<Integer> p = new Stack<Integer>();
		int u, v;
		
		//inicializo vec estado
		for (int i = 1; i < estado.length; i++) {
			estado[i] = 'N';
		}
		
		estado[1] = 'V';
		p.push(1);
		
		while(!p.isEmpty()){
			u = p.pop();
			
			for (int i = u+1; i < estado.length; i++){
				v = i;
				if(g.getArista(u, v) == 1 && estado[v] != 'V'){
					estado[v] = 'V';
					padre[v] = u;
					p.push(v);
				}
			}
		}
		return padre;
		
	}

}
