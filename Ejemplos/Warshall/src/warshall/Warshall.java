package warshall;

public class Warshall {
	public static boolean[][] Warshall(Grafo g){
		boolean[][] matAnterior = new boolean[g.getCantidadNodos()+1][g.getCantidadNodos()+1];
		boolean[][] matActual = new boolean[g.getCantidadNodos()+1][g.getCantidadNodos()+1];
		int nroPasada = 1;
		//inicializar matAnterior y matActual
		for(int i = 1; i <= g.getCantidadNodos(); i++) {
			for (int j = 1; j <= g.getCantidadNodos(); j++){
				if(g.getCostoArista(i, j) != 0)
					matAnterior[i][j] = true;
				else
					matAnterior[i][j] = false;
			}
		}
		matActual = matAnterior.clone();

		while(nroPasada <= g.getCantidadNodos()){
			//desarrollo matActual
			for (int i = 1; i < matActual.length; i++) {
				for (int j = 1; j < matActual.length; j++){
					if(i != j && i != nroPasada && j != nroPasada)
						if(matAnterior[i][j] || (matAnterior[i][nroPasada] && matAnterior[nroPasada][j]) )
							matActual[i][j] = true;
				}
			}
			matAnterior = matActual.clone();
			nroPasada++;
		}
		return matActual;
	}
}
