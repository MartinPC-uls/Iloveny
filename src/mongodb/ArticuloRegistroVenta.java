package mongodb;

public class ArticuloRegistroVenta {

	private String descripcion;
	private String nombretipo;
	private String nombremarca;
	private int preciounitario;
	
	public ArticuloRegistroVenta(String descripcion, String nombretipo, String nombremarca, int preciounitario) {
		this.descripcion = descripcion;
		this.nombretipo = nombretipo;
		this.nombremarca = nombremarca;
		this.preciounitario = preciounitario;
	}
	
	// getters
	public String get_descripcion() {
		return descripcion;
	}
	public String get_nombretipo() {
		return nombretipo;
	}
	public String get_nombremarca() {
		return nombremarca;
	}
	public int get_preciounitario() {
		return preciounitario;
	}
	
	// setters
	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void set_nombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	public void set_nombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	public void set_preciounitario(int preciounitario) {
		this.preciounitario = preciounitario;
	}
	
}
