package mongodb;

public class ArticuloRegistroCompra {

	private String nombretipo;
	private String nombremarca;
	private int stock;
	private int preciounitario;
	private String descripcion;
	
	public ArticuloRegistroCompra(String nombretipo, String nombremarca, int stock, int preciounitario, String descripcion) {
		this.nombretipo = nombretipo;
		this.nombremarca = nombremarca;
		this.stock = stock;
		this.preciounitario = preciounitario;
		this.descripcion = descripcion;
	}
	
	// getters
	public String get_nombretipo() {
		return nombretipo;
	}
	public String get_nombremarca() {
		return nombremarca;
	}
	public int get_stock() {
		return stock;
	}
	public int get_preciounitario() {
		return preciounitario;
	}
	public String get_descripcion() {
		return descripcion;
	}
	
	// setters
	public void set_nombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	public void set_nombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	public void set_stock(int stock) {
		this.stock = stock;
	}
	public void set_preciounitario(int preciounitario) {
		this.preciounitario = preciounitario;
	}
	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
