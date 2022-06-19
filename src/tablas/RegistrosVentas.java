package tablas;

public class RegistrosVentas {

	private String Fecha;
	private int CantidadVendida;
	private String Rut;
	private String ID;
	
	public RegistrosVentas(String Fecha, int CantidadVendida, String Rut, String ID) {
		this.Fecha = Fecha;
		this.CantidadVendida = CantidadVendida;
		this.Rut = Rut;
		this.ID = ID;
	}
	
	// getters
	public String get_Fecha() {
		return Fecha;
	}
	public int get_CantidadVendida() {
		return CantidadVendida;
	}
	public String get_Rut() {
		return Rut;
	}
	public String get_ID() {
		return ID;
	}
	
	// setters
	public void set_Fecha(String Fecha) {
		this.Fecha = Fecha;
	}
	public void set_CantidadVendida(int CantidadVendida) {
		this.CantidadVendida = CantidadVendida;
	}
	public void set_Rut(String Rut) {
		this.Rut = Rut;
	}
	public void set_ID(String ID) {
		this.ID = ID;
	}
	
}
