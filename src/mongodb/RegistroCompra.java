package mongodb;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class RegistroCompra {

	@BsonProperty("nombreprov")
	private String nombreprov;
	@BsonProperty("usuario")
	private String usuario;
	@BsonProperty("unidadesadquiridas")
	private int unidadesadquiridas;
	@BsonProperty("costounitario")
	private int costounitario;
	@BsonProperty("fechapedida")
	private String fechapedida; // pasar a Date
	@BsonProperty("fecharecibo")
	private String fecharecibo; // pasar a Date
	
	public RegistroCompra(String nombreprov, String usuario, int unidadesadquiridas, int costounitario, String fechapedida, String fecharecibo) {
		this.nombreprov = nombreprov;
		this.usuario = usuario;
		this.unidadesadquiridas = unidadesadquiridas;
		this.costounitario = costounitario;
		this.fechapedida = fechapedida;
		this.fecharecibo = fecharecibo;
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
	
}
