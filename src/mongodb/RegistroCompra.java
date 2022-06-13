package mongodb;

public class RegistroCompra {

	private int id;
	private String usuario;
	private String nombreprov;
	private int unidadesadquiridas;
	private int costounitario;
	// TODO
	// pasar fechas a formato Date
	private String fechapedida;
	private String fecharecibo;
	private ArticuloRegistroCompra articulo;
	private Medida medidas;
	
	public RegistroCompra(int id, String nombreprov, String usuario, int unidadesadquiridas, int costounitario, String fechapedida, String fecharecibo,
			ArticuloRegistroCompra articulo, Medida medidas) {
		this.id = id;
		this.nombreprov = nombreprov;
		this.usuario = usuario;
		this.unidadesadquiridas = unidadesadquiridas;
		this.costounitario = costounitario;
		this.fechapedida = fechapedida;
		this.fecharecibo = fecharecibo;
		this.articulo = articulo;
		this.medidas = medidas;
	}
	
	// getters
	public int get_id() {
		return id;
	}
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
	public ArticuloRegistroCompra get_articulo() {
		return articulo;
	}
	public Medida get_medidas() {
		return medidas;
	}
	
	// setters
	public void set_id(int id) {
		this.id = id;
	}
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
	public void set_articulo(ArticuloRegistroCompra articulo) {
		this.articulo = articulo;
	}
	public void set_medidas(Medida medidas) {
		this.medidas = medidas;
	}
	
}
