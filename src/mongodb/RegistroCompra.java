package mongodb;

public class RegistroCompra {

	//public String _id;
	private String usuario;
	private String nombreprov;
	private int unidadesadquiridas;
	private int costounitario;
	// TODO
	// pasar fechas a formato Date
	private String fechapedida;
	private String fecharecibo;
	private Articulo articulo;
	
	public RegistroCompra(String nombreprov, String usuario, int unidadesadquiridas, int costounitario, String fechapedida, String fecharecibo,
			Articulo articulo) {
		this.nombreprov = nombreprov;
		this.usuario = usuario;
		this.unidadesadquiridas = unidadesadquiridas;
		this.costounitario = costounitario;
		this.fechapedida = fechapedida;
		this.fecharecibo = fecharecibo;
		this.articulo = articulo;
	}
	
	// getters
	public String get_nombreprov() {
		return nombreprov;
	}
	public String get_usuario() {
		return usuario;
	}
	public int get_unidadesadquiridas() {
		return unidadesadquiridas;
	}
	public int get_costounitario() {
		return costounitario;
	}
	public String get_fechapedida() {
		return fechapedida;
	}
	public String get_fecharecibo() {
		return fecharecibo;
	}
	public Articulo get_articulo() {
		return articulo;
	}
	
	// setters
	public void set_nombreprov(String nombreprov) {
		this.nombreprov = nombreprov;
	}
	public void set_usuario(String usuario) {
		this.usuario = usuario;
	}
	public void set_unidadesadquiridas(int unidadesadquiridas) {
		this.unidadesadquiridas = unidadesadquiridas;
	}
	public void set_costounitario(int costounitario) {
		this.costounitario = costounitario;
	}
	public void set_fechapedida(String fechapedida) {
		this.fechapedida = fechapedida;
	}
	public void set_fecharecibo(String fecharecibo) {
		this.fecharecibo = fecharecibo;
	}
	public void set_articulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
