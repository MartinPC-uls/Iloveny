package mongodb;

public class Direccion {

	private String calle;
	private int numerodomicilio;
	private String ciudad;
	private String comuna;
	private String nombreregion;
	
	public Direccion(String calle, int numerodomicilio, String ciudad, String comuna, String nombreregion) {
		this.calle = calle;
		this.numerodomicilio = numerodomicilio;
		this.ciudad = ciudad;
		this.comuna = comuna;
		this.nombreregion = nombreregion;
	}
	
	// getters
	public String get_calle() {
		return calle;
	}
	public int get_numerodomicilio() {
		return numerodomicilio;
	}
	public String get_ciudad() {
		return ciudad;
	}
	public String get_comuna() {
		return comuna;
	}
	public String get_nombreregion() {
		return nombreregion;
	}
	
	// setters
	public void set_calle(String calle) {
		this.calle = calle;
	}
	public void set_numerodomicilio(int numerodomicilio) {
		this.numerodomicilio = numerodomicilio;
	}
	public void set_ciudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void set_comuna(String comuna) {
		this.comuna = comuna;
	}
	public void set_nombreregion(String nombreregion) {
		this.nombreregion = nombreregion;
	}
	
}
