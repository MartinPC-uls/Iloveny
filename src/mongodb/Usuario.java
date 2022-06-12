package mongodb;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Usuario {

	private static final String password = new DataBase().password;
	private static final String uri = new DataBase().uri;
	
	@BsonProperty("_id")
	private String _id;
	@BsonProperty("nombreusuario")
	private String nombreusuario;
	@BsonProperty("apellidos")
	private String apellidos;
	@BsonProperty("telefono")
	private String telefono;
	@BsonProperty("email")
	private String email;
	@BsonProperty("direccion")
	private Direccion direccion;
	/*@BsonProperty("registroventa")
	private RegistroVenta registroventa;*/
	
	public Usuario(String _id, String nombreusuario, String apellidos, String telefono, String email, Direccion direccion/*,
			RegistroVenta registroventa*/) {
		this._id = _id;
		this.nombreusuario = nombreusuario;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		//this.registroventa = registroventa;
	}
	
	// getters
	public String get__id() {
		return _id;
	}
	public String get_nombreusuario() {
		return nombreusuario;
	}
	public String get_apellidos() {
		return apellidos;
	}
	public String get_telefono() {
		return telefono;
	}
	public String get_email() {
		return email;
	}
	public Direccion get_direccion() {
		return direccion;
	}
	/*public RegistroVenta get_registroventa() {
		return registroventa;
	}*/
	
	// setters
	public void set__id(String _id) {
		this._id = _id;
	}
	public void set_nombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public void set_apellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void set_telefono(String telefono) {
		this.telefono = telefono;
	}
	public void set_email(String email) {
		this.email = email;
	}
	public void set_direccion(Direccion direccion) {
		this.direccion = direccion;
	}
	/*public void set_registroventa(RegistroVenta registroventa) {
		this.registroventa = registroventa;
	}*/
	
}
