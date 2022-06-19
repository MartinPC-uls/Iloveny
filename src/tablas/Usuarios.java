package tablas;

public class Usuarios {
	
	private String Rut;
	private String Nombre;
	private String Apellidos;
	private String Telefono;
	private String Email;
	
	public Usuarios(String Rut, String Nombre, String Apellidos, String Telefono, String Email) {
		this.Rut = Rut;
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Telefono = Telefono;
		this.Email = Email;
	}
	
	// getters
	public String get_Rut() {
		return this.Rut;
	}
	public String get_Nombre() {
		return this.Nombre;
	}
	public String get_Apellidos() {
		return this.Apellidos;
	}
	public String get_Telefono() {
		return this.Telefono;
	}
	public String get_Email() {
		return this.Email;
	}
	
	// setters
	public void set_Rut(String Rut) {
		this.Rut = Rut;
	}
	public void set_Nombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public void set_Apellidos(String Apellidos) {
		this.Apellidos = Apellidos;
	}
	public void set_Telefono(String Telefono) {
		this.Telefono = Telefono;
	}
	public void set_Email(String Email) {
		this.Email = Email;
	}
	
}
