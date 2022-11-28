package casoFatiga;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long mat[][]=new long[601][601];
		
		PrintWriter salida = new PrintWriter(new File("fatiga.in"));
		salida.println(600);
		for (int i = 1; i <= 600; i++) {
			for (int j = 1; j <= 600; j++) {
				double peso = Math.random() * 100;
				long p = (long) peso;
				
				if(p==0) {
					p++;
				}
				
				mat[i][j]=p;
			}
		}
		
		for (int i = 1; i <= 600; i++) {
			
			mat[i][i]=0;
		}
		
		for (int i = 1; i <= 600; i++) {
			for (int j = 1; j <= 600; j++) {
				salida.print(mat[i][j]+" ");
		
			}
			salida.println();
		}
		
		
		
		
		
		
		
		salida.close();
	}

}
