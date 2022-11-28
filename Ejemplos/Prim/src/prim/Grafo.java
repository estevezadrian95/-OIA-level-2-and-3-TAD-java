package prim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Grafo {
	
//	MatrizSimetrica mat;
	private int[][] mat;
	private int cantNodos;
	private int cantAristas = -1;
//	private int porcentajeAdyacencia = -1;
	
	
	public Grafo(int n){
		mat = new int[n+1][n+1];
		cantNodos = n;
	}

	public Grafo(File arch){
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(arch);
			br = new BufferedReader(fr);
			String[] datos = br.readLine().split(" ");
			cantNodos = Integer.parseInt(datos[0]);
			cantAristas = Integer.parseInt(datos[1]);
			mat = new int[cantNodos+1][cantNodos+1];
			
			for (int i = 0; i < cantAristas; i++) {
				datos = br.readLine().split(" ");
				
				setArista(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
				setArista(Integer.parseInt(datos[1]), Integer.parseInt(datos[0]), Integer.parseInt(datos[2]));
			}
			

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(br!=null){
					br.close();
					fr.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void setArista(int i, int j, int costo){
//		mat.setValue(i, j, costo);
		mat[i][j] = costo;
	}
	
	public int getCostoArista(int i, int j){
//		return mat.getValue(i, j);
		return mat[i][j];
	}
	
	
	public void imprimirGrafo(){
		for (int i = 1; i <= this.getCantidadNodos(); i++) {
			for (int j = 1; j <= this.getCantidadNodos(); j++) {
				if(getCostoArista(i,j)!=0)
					System.out.println(i + "-" + j + "  "+ getCostoArista(i,j));
			}
		}
	}
	
	

	
	public int getCantidadAristas(){
		if(cantAristas == -1){
			int contCA = 0;
			for (int i = 1; i <= cantNodos; i++) {
				for (int j = i+1; j <= cantNodos; j++) {
					if(getCostoArista(i, j)!=0)
						contCA++;
				}
			}
			cantAristas = contCA;
		}
		return cantAristas;
	}
	



	public int getCantidadNodos() {
		return cantNodos;
	}

	
	
}
