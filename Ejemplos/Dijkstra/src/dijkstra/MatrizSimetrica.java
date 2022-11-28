package dijkstra;

public class MatrizSimetrica {
	private int n;
	private int[] m;
	
	public MatrizSimetrica(int n) {
		this.n = n;
		int tam = (int) ((Math.pow(n, 2) - n) / 2);
		m = new int[tam];
	}
	
	public void setValue(int i, int j, int costo) {
		int idx;
		
		if (i == j)
			return;
		
		if (i > j) {
			int aux = i;
			i = j;
			j = aux;
		}
		i--;
		j--;
		idx = (int) ((i * n + j - (Math.pow(i, 2) + 3 * i + 2) / 2));
		
		m[idx] = costo;
	}
	
	public int getValue(int i, int j) {
		int idx;
		
		if (i == j)
			return -1;
		
		if (i > j) {
			int aux = i;
			i = j;
			j = aux;
		}
		i--;
		j--;
		idx = ((int) (i * n + j - (Math.pow(i, 2) + 3 * i + 2) / 2));
		
		return m[idx];
	}
}
