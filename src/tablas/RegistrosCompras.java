package tablas;

public class RegistrosCompras {

	private String Usuario;
	private String NombreProveedor;
	private int UnidadesAdquiridas;
	private int CostoUnitario;
	private String FechaPedida;
	private String FechaRecibo;
	private String ID;
	
	public RegistrosCompras(String Usuario, String NombreProveedor, int UnidadesAdquiridas, int CostoUnitario, String FechaPedida, String FechaRecibo, String ID) {
		this.Usuario = Usuario;
		this.NombreProveedor = NombreProveedor;
		this.UnidadesAdquiridas = UnidadesAdquiridas;
		this.CostoUnitario = CostoUnitario;
		this.FechaPedida = FechaPedida;
		this.FechaRecibo = FechaRecibo;
		this.ID = ID;
	}
	
	// getters
	public String get_Usuario() {
		return Usuario;
	}
	public String get_NombreProveedor() {
		return NombreProveedor;
	}
	public int get_UnidadesAdquiridas() {
		return UnidadesAdquiridas;
	}
	public int get_CostoUnitario() {
		return CostoUnitario;
	}
	public String get_FechaPedida() {
		return FechaPedida;
	}
	public String get_FechaRecibo() {
		return FechaRecibo;
	}
	public String get_ID() {
		return ID;
	}
	
	// setters
	public void set_Usuario(String Usuario) {
		this.Usuario = Usuario;
	}
	public void set_NombreProveedor(String NombreProveedor) {
		this.NombreProveedor = NombreProveedor;
	}
	public void set_UnidadesAdquiridas(int UnidadesAdquiridas) {
		this.UnidadesAdquiridas = UnidadesAdquiridas;
	}
	public void set_CostoUnitario(int CostoUnitario) {
		this.CostoUnitario = CostoUnitario;
	}
	public void set_FechaPedida(String FechaPedida) {
		this.FechaPedida = FechaPedida;
	}
	public void set_FechaRecibo(String FechaRecibo) {
		this.FechaRecibo = FechaRecibo;
	}
	public void set_ID(String ID) {
		this.ID = ID;
	}
	
}
