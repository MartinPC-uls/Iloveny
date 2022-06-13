package mongodb;

public class Medida {

	private int alto;
	private int ancho;
	private int largo;
	
	private String medidaespecifica;
	
	public Medida(int alto, int ancho, int largo) {
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
		this.medidaespecifica = null;
	}
	public Medida(String medidaespecifica) {
		this.medidaespecifica = medidaespecifica;
		this.alto = 0;
		this.ancho = 0;
		this.largo = 0;
	}
	
	// getters
	public int get_alto() {
		return alto;
	}
	public int get_ancho() {
		return ancho;
	}
	public int get_largo() {
		return largo;
	}
	public String get_medidaespecifica() {
		return medidaespecifica;
	}
	
	// setters
	public void set_alto(int alto) {
		this.alto = alto;
	}
	public void set_ancho(int ancho) {
		this.ancho = ancho;
	}
	public void set_largo(int largo) {
		this.largo = largo;
	}
	public void set_medidaespecifica(String medidaespecifica) {
		this.medidaespecifica = medidaespecifica;
	}
	
}
