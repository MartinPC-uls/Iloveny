package tablas;

public class Articulos {

	private String Tipo;
	private String Marca;
	private String Descripcion;
	private int Stock;
	private int PrecioUnitario;
	private String ID;
	
	public Articulos(String Tipo, String Marca, String Descripcion, int Stock, int PrecioUnitario, String ID) {
		this.Tipo = Tipo;
		this.Marca = Marca;
		this.Descripcion = Descripcion;
		this.Stock = Stock;
		this.PrecioUnitario = PrecioUnitario;
		this.ID = ID;
	}
	
	// getters
	public String get_Tipo() {
		return Tipo;
	}
	public String get_Marca() {
		return Marca;
	}
	public String get_Descripcion() {
		return Descripcion;
	}
	public int get_Stock() {
		return Stock;
	}
	public int get_PrecioUnitario() {
		return PrecioUnitario;
	}
	public String get_ID() {
		return ID;
	}
	
	// setters
	public void set_Tipo(String Tipo) {
		this.Tipo = Tipo;
	}
	public void set_Marca(String Marca) {
		this.Marca = Marca;
	}
	public void set_Descripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	public void set_Stock(int Stock) {
		this.Stock = Stock;
	}
	public void set_PrecioUnitario(int PrecioUnitario) {
		this.PrecioUnitario = PrecioUnitario;
	}
	public void set_ID(String ID) {
		this.ID = ID;
	}
	
}
