package dfs;

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
				setArista(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
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
	
	public void setArista(int i, int j){
//		mat.setValue(i, j, costo);
		mat[i][j] = 1;
	}
	
	public int getArista(int i, int j){
//		return mat.getValue(i, j);
		return mat[i][j];
	}
	
	
	public void imprimirGrafo(){
		for (int i = 1; i <= this.getCantidadNodos(); i++) {
			for (int j = 1; j <= this.getCantidadNodos(); j++) {
				if(getArista(i,j)!=0)
					System.out.println(i + "-" + j);
			}
		}
	}
	
	
//	public int getGradoMax(){
//		int max = 0;
//		int act;
//		for (int i = 1; i <= cantNodos; i++) {
//			act = 0;
//			for (int j = 1; j <= cantNodos; j++) {
//				if(getArista(i, j))act++;
//			}
//			if(act > max) max = act;
//		}
//		return max;
//	}
	
//	public int getGradoMin(){
//		int min = -1;
//		int act;
//		for (int i = 1; i <= cantNodos; i++) {
//			act = 0;
//			for (int j = 1; j <= cantNodos; j++) {
//				if(getArista(i, j))act++;
//			}
//			if(min == -1 || act < min) min = act;
//		}
//		return min;
//	}
	
	public int getCantidadAristas(){
		if(cantAristas == -1){
			int contCA = 0;
			for (int i = 1; i <= cantNodos; i++) {
				for (int j = i+1; j <= cantNodos; j++) {
					if(getArista(i, j)!=0)
						contCA++;
				}
			}
			cantAristas = contCA;
		}
		return cantAristas;
	}
	
//	public int getPorcentajeAdyacencia(){
//		if(porcentajeAdyacencia ==-1)
//			porcentajeAdyacencia = (200*getCantidadAristas())/(cantNodos*(cantNodos-1));
//		return porcentajeAdyacencia;		
//	}
	
//	public void imprimirAristas() {
//		
//		System.out.println(cantNodos + " " + getCantidadAristas() + " " + getPorcentajeAdyacencia() + " " + getGradoMax() + " " + getGradoMin());
//		
//		for (int i = 1; i <= cantNodos; i++) {
//			for (int j = i+1; j <= cantNodos; j++) {
//				if(getArista(i, j))System.out.println(i + " " + j);
//			}
//		}
//	}
	
//	public void guardarEnArchivo(File arch){
//		FileWriter fw = null;
//		PrintWriter pw = null;
//		try {
//			fw = new FileWriter(arch);
//			pw = new PrintWriter(fw);
//			pw.println(cantNodos + " " + getCantidadAristas() + " " + getPorcentajeAdyacencia() + " " + getGradoMax() + " " + getGradoMin());
//			for (int i = 1; i <= cantNodos; i++) {
//				for (int j = i+1; j <= cantNodos; j++) {
//					if(getArista(i, j))pw.println(i + " " + j);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				if(pw!=null){
//					pw.close();
//					fw.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public int getCantidadNodos() {
		return cantNodos;
	}
	
//	public int getGradoNodo(int n){
//		int grado = 0;
//		for (int i = 1; i <= cantNodos; i++) {
//			if(getArista(n, i))grado++;
//		}
//		return grado;
//	}
	
	
}
