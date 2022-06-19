package mongodb;

public class ArticuloID {

	public String objectId;
	public String descripcion;
	public String nombretipo;
	public String nombremarca;
	
	public ArticuloID(String objectId, String descripcion, String nombretipo, String nombremarca) {
		this.objectId = objectId;
		this.descripcion = descripcion;
		this.nombretipo = nombretipo;
		this.nombremarca = nombremarca;
	}
	
}
