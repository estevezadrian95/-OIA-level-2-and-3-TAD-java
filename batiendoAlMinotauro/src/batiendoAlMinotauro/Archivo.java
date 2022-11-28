package batiendoAlMinotauro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	public static Grafo leer(String miDoc) throws FileNotFoundException {

		File archivo = new File(miDoc);
		Scanner sc = new Scanner(archivo);

		int cantNodos = sc.nextInt();
		int[][] matriz = new int[cantNodos + 1][cantNodos + 1]; /* es +1 porque el cero no lo voy a utilizar */

		for (int i = 1; i <= cantNodos; i++)
			for (int j = 1; j <= cantNodos; j++)
				matriz[i][j] = sc.nextInt();
		sc.close();

	return new Grafo(matriz, cantNodos);
	}

	public static void crearArchivoResultado(Grafo g, String miDoc) throws FileNotFoundException {

		File file = new File(miDoc);
		PrintWriter salida = new PrintWriter(file);

		salida.println(g.getAristas().size());

		for (int i = 0; i < g.getAristas().size(); i++) {
			salida.println(g.getAristas().get(i).desde + " " + g.getAristas().get(i).hacia + " "
					+ g.getAristas().get(i).peso);
		}
	salida.close();
	}
}
