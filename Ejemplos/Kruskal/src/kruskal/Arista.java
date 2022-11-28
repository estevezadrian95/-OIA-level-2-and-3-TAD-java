package kruskal;

public class Arista implements Comparable<Arista>{
	@Override
	public String toString() {
		return "Arista [costo=" + costo + ", nodo1=" + nodo1 + ", nodo2=" + nodo2 + "]";
	}

	private int costo;
	private int nodo1;
	private int nodo2;

	public Arista(int c, int n1, int n2){
		costo = c;
		nodo1 = n1;
		nodo2 = n2;
	}

	public int compareTo(Arista a) {
		if(this.costo < a.costo)
			return -1;
		if(this.costo > a.costo)
			return 1;
		return 0;
	}

	public int getCosto() {
		return costo;
	}

	public int getNodo1() {
		return nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}

}
