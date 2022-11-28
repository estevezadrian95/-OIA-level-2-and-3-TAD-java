package acortandoElCamino;

public class Arista {
	private Double costo;
	private int nro;
	
	public Arista(Double c, int n){
		costo = c;
		nro = n;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public int getNro() {
		return nro;
	}


}
