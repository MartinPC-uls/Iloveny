package mongodb;

public class RegistroVenta {
	
	private int id;
	private String fechaventa; // probablemente cambiar despues a Date
	private int cantidadvendida;
	private Usuario usuario;
	private ArticuloRegistroVenta articulo;
	
	public RegistroVenta(int id, String fechaventa, int cantidadvendida, Usuario usuario, ArticuloRegistroVenta articulo) {
		this.id = id;
		this.fechaventa = fechaventa;
		this.cantidadvendida = cantidadvendida;
		this.usuario = usuario;
		this.articulo = articulo;
	}
	
	// getters
	public int get_id() {
		return id;
	}
	public String get_fechaventa() {
		return fechaventa;
	}
	public int get_cantidadvendida() {
		return cantidadvendida;
	}
	public Usuario get_usuario() {
		return usuario;
	}
	public ArticuloRegistroVenta get_articulo() {
		return articulo;
	}
	
	// setters
	public void set_id(int id) {
		this.id = id;
	}
	public void set_fechaventa(String fechaventa) {
		this.fechaventa = fechaventa;
	}
	public void set_cantidadvendida(int cantidadvendida) {
		this.cantidadvendida = cantidadvendida;
	}
	public void set_usuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void set_articulo(ArticuloRegistroVenta articulo) {
		this.articulo = articulo;
	}
	
}
