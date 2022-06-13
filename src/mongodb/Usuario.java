package mongodb;

public class Usuario {
	
	private String _id;
	private String nombreusuario;
	private String apellidos;
	private String telefono;
	private String email;
	private Direccion direccion;
	
	public Usuario(String _id, String nombreusuario, String apellidos, String telefono, String email, Direccion direccion) {
		this._id = _id;
		this.nombreusuario = nombreusuario;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
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
	
}
