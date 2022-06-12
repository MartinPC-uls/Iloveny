package mongodb;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class RegistroVenta {
	
	@BsonProperty("fechaventa")
	private String fechaventa; // probablemente cambiar después a Date
	@BsonProperty("cantidadvendida")
	private int cantidadvendida;
	@BsonProperty("articulo")
	private ArticuloRegistroVenta articulo;
	
	public RegistroVenta(String fechaventa, int cantidadvendida, ArticuloRegistroVenta articulo) {
		this.fechaventa = fechaventa;
		this.cantidadvendida = cantidadvendida;
		this.articulo = articulo;
	}
	
	// getters
	public String get_fechaventa() {
		return fechaventa;
	}
	public int get_cantidadvendida() {
		return cantidadvendida;
	}
	public ArticuloRegistroVenta get_articulo() {
		return articulo;
	}
	
	// setters
	public void set_fechaventa(String fechaventa) {
		this.fechaventa = fechaventa;
	}
	public void set_cantidadvendida(int cantidadvendida) {
		this.cantidadvendida = cantidadvendida;
	}
	public void set_articulo(ArticuloRegistroVenta articulo) {
		this.articulo = articulo;
	}
	
}
