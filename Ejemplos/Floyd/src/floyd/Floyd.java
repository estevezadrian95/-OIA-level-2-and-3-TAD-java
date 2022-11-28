package floyd;

public class Floyd {
	public static double[][] Floyd(Grafo g){
		double[][] costosActual = new double[g.getCantidadNodos()+1][g.getCantidadNodos()+1];
		double[][] costosAnterior = new double[g.getCantidadNodos()+1][g.getCantidadNodos()+1];
		int nroPasada = 1;
		//inicializar costosAnterior y costosActual
		for(int i = 1; i <= g.getCantidadNodos(); i++) {
			for (int j = 1; j <= g.getCantidadNodos(); j++) {
				if(i != j && g.getCostoArista(i, j) == 0)
					costosAnterior[i][j] = Double.POSITIVE_INFINITY;
				else
					costosAnterior[i][j] = g.getCostoArista(i, j);
					
			}
		}
		costosActual = costosAnterior.clone();

		while(nroPasada <= g.getCantidadNodos()){
			//desarrollo costosActual
			for (int i = 1; i < costosActual.length; i++) {
				for (int j = 1; j < costosActual.length; j++) {
					if(i != j && i != nroPasada && j != nroPasada)
						if(costosAnterior[i][j] > (costosAnterior[i][nroPasada] + costosAnterior[nroPasada][j]) )
							costosActual[i][j] = (costosAnterior[i][nroPasada] + costosAnterior[nroPasada][j]);
				}

			}
			costosAnterior = costosActual.clone();
			nroPasada++;
		}
		return costosActual;
		
		
	}
}
