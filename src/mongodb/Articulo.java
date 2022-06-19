package mongodb;

public class Articulo {
	
	//private int _id;
	private String descripcion;
	private String nombretipo;
	private String nombremarca;
	private int stock;
	private int preciounitario;
	private Medida medida;
	
	public Articulo(/*int _id,*/ String descripcion, String nombretipo, String nombremarca, int stock, int preciounitario,
			Medida medida) {
		//this._id = _id;
		this.descripcion = descripcion;
		this.nombretipo = nombretipo;
		this.nombremarca = nombremarca;
		this.stock = stock;
		this.preciounitario = preciounitario;
		this.medida = medida;
	}
	
	// getters
	/*public int get__id() {
		return _id;
	}*/
	public String get_descripcion() {
		return descripcion;
	}
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
	public Medida get_medida() {
		return medida;
	}
	
	// setters
	/*public void set__id(int _id) {
		this._id = _id;
	}*/
	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}
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
	public void set_medida(Medida medida) {
		this.medida = medida;
	}
	
}
