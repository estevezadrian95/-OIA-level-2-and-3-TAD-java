package acortandoElCamino;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Grafo {
	
	Arista[][] matPermitida;
	Arista[][] matNoPermitida;
	private int cantNodos;
	private int cantAristasPerminitdas = -1;
	private int cantAristasNoPerminitdas = -1;
	

	public Grafo(int n){
		matPermitida = new Arista[cantNodos+1][cantNodos+1];
		matNoPermitida = new Arista[cantNodos+1][cantNodos+1];
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
			cantAristasPerminitdas = Integer.parseInt(datos[1]);
			cantAristasNoPerminitdas = Integer.parseInt(datos[2]);
			matPermitida = new Arista[cantNodos+1][cantNodos+1];
			matNoPermitida = new Arista[cantNodos+1][cantNodos+1];
			Arista a;
			for (int i = 1; i < matPermitida.length; i++) {
				for (int j = 1; j < matPermitida.length; j++) {
					a = new Arista(Double.POSITIVE_INFINITY, 0);
					matPermitida[i][j] = a;
					matNoPermitida[i][j] = a;
				}
			}
		
			int f, c;
			double costo;
			for (int i = 1; i <= cantAristasPerminitdas; i++) {
				datos = br.readLine().split(" ");
				costo = Double.parseDouble(datos[2]);
				f = Integer.parseInt(datos[0]);
				c = Integer.parseInt(datos[1]);
				if(costo < matPermitida[f][c].getCosto()){
					matPermitida[f][c].setCosto(costo);
					matPermitida[f][c].setNro(i);
				}
			}
			
			for (int i = 1; i <= cantAristasNoPerminitdas; i++) {
				datos = br.readLine().split(" ");
				costo = Double.parseDouble(datos[2]);
				f = Integer.parseInt(datos[0]);
				c = Integer.parseInt(datos[1]);
				if(costo < matNoPermitida[f][c].getCosto()){
					matNoPermitida[f][c].setCosto(costo);
					matNoPermitida[f][c].setNro(i);
				}
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
	
//	public void setAristaPermitida(int i, int j, double costo){
//		matPermitida[i][j].setCosto(costo);
//	}
//	
//	public void setAristaNoPermitida(int i, int j, double costo){
//		matNoPermitida[i][j].setCosto(costo);
//	}
	
	public double getCostoAristaPermitida(int i, int j){
		return matPermitida[i][j].getCosto();
	}
	
	public double getCostoAristaNoPermitida(int i, int j){
		return matNoPermitida[i][j].getCosto();
	}
	
	public int getCantidadNodos() {
		return cantNodos;
	}
	
	
	
	public void guardarEnArchivo(File arch, int caso, LinkedList<Integer> nroAristasNoPerm, double distTotal){
	FileWriter fw = null;
	PrintWriter pw = null;
	try {
		fw = new FileWriter(arch);
		pw = new PrintWriter(fw);
		
		switch(caso){
		case 1:
			pw.println(caso + " " + distTotal);
			break;
		case 2:
			pw.println(caso + " " + nroAristasNoPerm.get(0) + " " + distTotal);
			break;
		case 3:
			pw.println(caso + " " + nroAristasNoPerm.get(0) + " " + nroAristasNoPerm.get(1) + " " + distTotal);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			if(pw!=null){
				pw.close();
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

	
	
	
//	public void imprimirGrafo(){
//		for (int i = 1; i <= this.getCantidadNodos(); i++) {
//			for (int j = 1; j <= this.getCantidadNodos(); j++) {
//				if(getCostoArista(i,j)!=0)
//					System.out.println(i + "-" + j + "  "+ getCostoArista(i,j));
//			}
//		}
//	}
	
	
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
	
//	public int getCantidadAristas(){
//		if(cantAristas == -1){
//			int contCA = 0;
//			for (int i = 1; i <= cantNodos; i++) {
//				for (int j = 1; j <= cantNodos; j++) {
//					if(getCostoArista(i, j)!=0)
//						contCA++;
//				}
//			}
//			cantAristas = contCA;
//		}
//		return cantAristas;
//	}
	
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
	


	
	
//	public int getGradoNodo(int n){
//		int grado = 0;
//		for (int i = 1; i <= cantNodos; i++) {
//			if(getArista(n, i))grado++;
//		}
//		return grado;
//	}
	
	
}
