package mongodb;

import org.bson.types.ObjectId;

public class ArticuloID {

	public String objectId;
	public String descripcion;
	
	public ArticuloID(String objectId, String descripcion) {
		this.objectId = objectId;
		this.descripcion = descripcion;
	}
	
}
