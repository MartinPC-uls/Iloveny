package mongodb;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Medida {

	@BsonProperty("alto")
	private int alto;
	@BsonProperty("ancho")
	private int ancho;
	@BsonProperty("largo")
	private int largo;
	
	public Medida(int alto, int ancho, int largo) {
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
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
	
}
