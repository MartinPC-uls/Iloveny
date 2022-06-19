package mongodb;

public class ArticuloRegistroCompra {

	private String nombretipo;
	private String nombremarca;
	private String descripcion;
	private int stock;
	private int preciounitario;
	private Medida medidas;
	
	public ArticuloRegistroCompra(String nombretipo, String nombremarca, String descripcion, int stock, int preciounitario, Medida medidas) {
		this.nombretipo = nombretipo;
		this.nombremarca = nombremarca;
		this.descripcion = descripcion;
		this.stock = stock;
		this.preciounitario = preciounitario;
		this.medidas = medidas;
	}
	
	// getters
	public String get_nombretipo() {
		return nombretipo;
	}
	public String get_nombremarca() {
		return nombremarca;
	}
	public String get_descripcion() {
		return descripcion;
	}
	public int get_stock() {
		return stock;
	}
	public int get_preciounitario() {
		return preciounitario;
	}
	public Medida get_medidas() {
		return medidas;
	}
	
	// setters
	public void set_nombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	public void set_nombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void set_stock(int stock) {
		this.stock = stock;
	}
	public void set_preciounitario(int preciounitario) {
		this.preciounitario = preciounitario;
	}
	public void set_medidas(Medida medidas) {
		this.medidas = medidas;
	}
}
