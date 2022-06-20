package mongodb;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;

import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import tablas.Articulos;
import tablas.RegistrosCompras;
import tablas.RegistrosVentas;
import tablas.Usuarios;

public class Consulta extends Utils {

	private String uri = DataBase.uri;
	private String db = DataBase.database_name;
	
	public boolean verificarAdministrador(String username, String password) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.ADMINISTRADOR.toString());
	        Document doc = collection.find(eq("username", "admin")).first();
	        String json = doc.toJson();
	        
	        String _username = readString("username", json);
	        String _password = readString("password", json);
	        
	        if (username.equals(_username) && password.equals(_password))
	        	return true;
	        else
	        	return false;
	    }
	}
	
	public Articulo getArticulo(String idArticulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
	        Document doc = collection.find(eq("_id", new ObjectId(idArticulo))).first();
	        String json = doc.toJson();
	        
	        String nombretipo = readString("nombretipo", json);
	        String nombremarca = readString("nombremarca", json);
	        String descripcion = readString("descripcion", json);
	        int stock = readInteger("stock", json);
	        int preciounitario = readInteger("preciounitario", json);
	        
	        Medida medidas = null;
	        try {
	       	 int alto = readIntegerInObject("medida", "alto", json);
	       	 int ancho = readIntegerInObject("medida", "ancho", json);
	       	 int largo = readIntegerInObject("medida", "largo", json);
	       	 medidas = new Medida(alto, ancho, largo);
	        } catch (Exception e) {
	       	 String medidaespecifica = readStringInObject("medida", "medidaespecifica", json);
	       	 medidas = new Medida(medidaespecifica);
	        }
	        
	        return new Articulo(descripcion, nombretipo, nombremarca, stock, preciounitario, medidas);
	    }
	}
	
	public Usuario getUsuario(String rut) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
	        Document doc = collection.find(eq("_id", rut)).first();
	        String json = doc.toJson();
	        
	        String nombreusuario = readString("nombreusuario", json);
	        String apellidos = readString("apellidos", json);
	        String telefono = readString("telefono", json);
	        String email = readString("email", json);
	        
	        Direccion direccion;
	        String calle = readStringInObject("direccion", "calle", json);
	        int numerodomicilio = readIntegerInObject("direccion", "numerodomicilio", json);
	        String ciudad = readStringInObject("direccion", "ciudad", json);
	        String comuna = readStringInObject("direccion", "comuna", json);
	        String nombreregion = readStringInObject("direccion", "nombreregion", json);
	        
	        direccion = new Direccion(calle, numerodomicilio, ciudad, comuna, nombreregion);
	        return new Usuario(rut, nombreusuario, apellidos, telefono, email, direccion);
	    }
	}

	public RegistroVenta getRegistroVenta(String id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
	        Document doc = collection.find(eq("_id", new ObjectId(id))).first();
	        String json = doc.toJson();
	        
	        String fechaventa = readString("fechaventa", json);
	        int cantidadvendida = readInteger("cantidadvendida", json);
	        Usuario usuario;
	        String rut = readStringInObject("usuario", "rut", json);
	        usuario = new Usuario(rut, null, null, null, null, null);
	        
	        ArticuloRegistroVenta articulo;
	        String nombremarca = readStringInObject("articulo", "nombremarca", json);
	        String nombretipo = readStringInObject("articulo", "nombretipo", json);
	        String descripcion = readStringInObject("articulo", "descripcion", json);
	        int preciounitario = readIntegerInObject("articulo", "preciounitario", json);
	        articulo = new ArticuloRegistroVenta(descripcion, nombretipo, nombremarca, preciounitario);
	        
	        return new RegistroVenta(fechaventa, cantidadvendida, usuario, articulo);
		}
	}
	
	public RegistroCompra getRegistroCompra(String idArticulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
	        Document doc = collection.find(eq("_id", new ObjectId(idArticulo))).first();
	        String json = doc.toJson();
	        
	        //String id = readInteger("_id", json);
	        String usuario = readString("usuario", json);
	        int unidadesadquiridas = readInteger("unidadesadquiridas", json);
	        int costounitario = readInteger("costounitario", json);
	        String fechapedida = readString("fechapedida", json);
	        String fecharecibo = readString("fecharecibo", json);
	        String nombreprov = readString("nombreprov", json);
	        Articulo articulo;
	        String descripcion = readStringInObject("articulo", "descripcion", json);
	        String nombretipo = readStringInObject("articulo", "nombretipo", json);
	        String nombremarca = readStringInObject("articulo", "nombremarca", json);
	        int stock = readIntegerInObject("articulo", "stock", json);
	        int preciounitario = readIntegerInObject("articulo", "preciounitario", json);
	        
	        Medida medidas = null;
	        try {
	       	 int alto = readIntegerIntoObjectInObject("articulo", "medidas", "alto", json);
	       	 int largo = readIntegerIntoObjectInObject("articulo", "medidas", "largo", json);
	       	 int ancho = readIntegerIntoObjectInObject("articulo", "medidas", "ancho", json);
	       	 medidas = new Medida(alto, ancho, largo);
	        } catch (Exception e) {
	       	 String medidaespecifica = readStringIntoObjectInObject("articulo", "medidas", "medidaespecifica", json);
	       	 medidas = new Medida(medidaespecifica);
	        }
	        
	        articulo = new Articulo(descripcion, nombretipo, nombremarca, stock, preciounitario, medidas);
	        
	        return new RegistroCompra(nombreprov, usuario, unidadesadquiridas, costounitario, fechapedida, fecharecibo, articulo);
		}
	}
	
	public ArrayList<ArticuloID> getDescripcionArticulosConStock() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        Bson projectionFields = Projections.fields(Projections.include("descripcion", "nombretipo", "nombremarca", "preciounitario"));
		        
		        MongoCursor<Document> cursor = collection.find(gt("stock", 0))
		       		 .projection(projectionFields)
		       		 .sort(Sorts.ascending("stock")).iterator();
		        
		        ArrayList<ArticuloID> articulos = new ArrayList<ArticuloID>();
		        
		        try {
		       	 while (cursor.hasNext()) {
		       		 String json = cursor.next().toJson();
	       			 String id = readObjectId("_id", json);
	       			 String descripcion = readString("descripcion", json);
	       			 String nombretipo = readString("nombretipo", json);
	       			 String nombremarca = readString("nombremarca", json);
	       			 articulos.add(new ArticuloID(id, descripcion, nombretipo, nombremarca)); 
		       	 }
		        } finally {
		       	 cursor.close();
		        }
		        return articulos;
		}
	}
	
	public void updtUsuario(String _id, Usuario usuario) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
		        
		        Document replaceDocument = new Document()
		       		 .append("_id", _id)
		       		 .append("nombreusuario", usuario.get_nombreusuario())
		       		 .append("apellidos", usuario.get_apellidos())
		       		 .append("telefono", usuario.get_telefono())
		       		 .append("email", usuario.get_email())
		       		 .append("direccion", new Document()
		       				 .append("calle", usuario.get_direccion().get_calle())
		       				 .append("numerodomicilio", usuario.get_direccion().get_numerodomicilio())
		       				 .append("ciudad", usuario.get_direccion().get_ciudad())
		       				 .append("comuna", usuario.get_direccion().get_comuna())
		       				 .append("nombreregion", usuario.get_direccion().get_nombreregion()));
		        collection.replaceOne(Filters.eq("_id", _id), replaceDocument);
		}
	}
	
	public void updtArticulo(String _id, Articulo articulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        Document replaceDocument = new Document()
		       		 .append("nombretipo", articulo.get_nombretipo())
		       		 .append("nombremarca", articulo.get_nombremarca())
		       		 .append("descripcion", articulo.get_descripcion())
		       		 .append("stock", articulo.get_stock())
		       		 .append("preciounitario", articulo.get_preciounitario());
		        
		        if (articulo.get_medida().get_alto() == 0 && articulo.get_medida().get_ancho() == 0 && articulo.get_medida().get_largo() == 0) {
		       	 replaceDocument.append("medida", new Document()
		       			 .append("medidaespecifica", articulo.get_medida().get_medidaespecifica()));
		        } else {
		       	 replaceDocument.append("medida", new Document()
		       			 .append("alto", articulo.get_medida().get_alto())
		       			 .append("ancho", articulo.get_medida().get_ancho())
		       			 .append("largo", articulo.get_medida().get_largo()));
		        }
		        collection.replaceOne(Filters.eq("_id", new ObjectId(_id)), replaceDocument);
		}
	}
	
	public void updtRegistroCompra(String _id, RegistroCompra registroCompra) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
		        
		        Document replaceDocument = new Document()
		       		 .append("usuario", registroCompra.get_usuario())
		       		 .append("unidadesadquiridas", registroCompra.get_unidadesadquiridas())
		       		 .append("costounitario", registroCompra.get_costounitario())
		       		 .append("fechapedida", registroCompra.get_fechapedida())
		       		 .append("fecharecibo", registroCompra.get_fecharecibo())
		       		 .append("nombreprov", registroCompra.get_nombreprov());
		        
		        if (registroCompra.get_articulo().get_medida().get_alto() == 0 && registroCompra.get_articulo().get_medida().get_ancho() == 0 &&
		       		 registroCompra.get_articulo().get_medida().get_largo() == 0) {
		       	 replaceDocument.append("articulo", new Document()
		       			 .append("descripcion", registroCompra.get_articulo().get_descripcion())
		       			 .append("nombretipo", registroCompra.get_articulo().get_nombretipo())
		       			 .append("nombremarca", registroCompra.get_articulo().get_nombremarca())
		       			 .append("stock", registroCompra.get_articulo().get_stock())
		       			 .append("preciounitario", registroCompra.get_articulo().get_preciounitario())
		       			 .append("medidas", new Document()
		       					 .append("medidaespecifica", registroCompra.get_articulo().get_medida().get_medidaespecifica())));
		        } else {
		       	 replaceDocument.append("articulo", new Document()
		       			 .append("descripcion", registroCompra.get_articulo().get_descripcion())
		       			 .append("nombretipo", registroCompra.get_articulo().get_nombretipo())
		       			 .append("nombremarca", registroCompra.get_articulo().get_nombremarca())
		       			 .append("stock", registroCompra.get_articulo().get_stock())
		       			 .append("preciounitario", registroCompra.get_articulo().get_preciounitario())
		       			 .append("medidas", new Document()
		       					 .append("alto", registroCompra.get_articulo().get_medida().get_alto())
		       					 .append("largo", registroCompra.get_articulo().get_medida().get_largo())
		       					 .append("ancho", registroCompra.get_articulo().get_medida().get_ancho())));
		        }
		        collection.replaceOne(Filters.eq("_id", new ObjectId(_id)), replaceDocument);
		}
	}
	
	public void updtRegistroVenta(String _id, RegistroVenta registroVenta) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
		        
		        Document replaceDocument = new Document()
		       		 .append("fechaventa", registroVenta.get_fechaventa())
		       		 .append("cantidadvendida", registroVenta.get_cantidadvendida())
		       		 .append("usuario", new Document()
		       				 .append("rut", registroVenta.get_usuario().get__id())
		       				 .append("nombreusuario", registroVenta.get_usuario().get_nombreusuario())
		       				 .append("apellidos", registroVenta.get_usuario().get_apellidos())
		       				 .append("telefono", registroVenta.get_usuario().get_telefono())
		       				 .append("email", registroVenta.get_usuario().get_email())
		       				 .append("direccion", new Document()
		       						 .append("calle", registroVenta.get_usuario().get_direccion().get_calle())
		       						 .append("numerodomicilio", registroVenta.get_usuario().get_direccion().get_numerodomicilio())
		       						 .append("nombreregion", registroVenta.get_usuario().get_direccion().get_nombreregion())
		       						 .append("ciudad", registroVenta.get_usuario().get_direccion().get_ciudad())
		       						 .append("comuna", registroVenta.get_usuario().get_direccion().get_comuna())))
		       		 .append("articulo", new Document()
		       				 .append("nombremarca", registroVenta.get_articulo().get_nombremarca())
		       				 .append("nombretipo", registroVenta.get_articulo().get_nombretipo())
		       				 .append("descripcion", registroVenta.get_articulo().get_descripcion())
		       				 .append("preciounitario", registroVenta.get_articulo().get_preciounitario()));
		        collection.replaceOne(Filters.eq("_id", new ObjectId(_id)), replaceDocument);
		}
	}
	
	public void addUsuario(Usuario usuario) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
		        
		        Direccion direccion = usuario.get_direccion();
		        
		        Document doc = new Document()
			        .append("_id", usuario.get__id())
			        .append("nombreusuario", usuario.get_nombreusuario())
			        .append("apellidos", usuario.get_apellidos())
			        .append("telefono", usuario.get_telefono())
			        .append("email", usuario.get_email())
			        .append("direccion", new Document()
			       		 .append("calle", direccion.get_calle())
			       		 .append("numerodomicilio", direccion.get_numerodomicilio())
			       		 .append("ciudad", direccion.get_ciudad())
			       		 .append("comuna", direccion.get_comuna())
			       		 .append("nombreregion", direccion.get_nombreregion()));
		        collection.insertOne(doc);
		}
	}
	
	public void addArticulo(Articulo articulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        Medida medidas = articulo.get_medida();
		        
		        if (medidas.get_alto() == 0 && medidas.get_ancho() == 0 && medidas.get_largo() == 0) {
		       	 Document doc = new Document()
		       			 //.append("_id", articulo.get__id())
		       			 .append("nombretipo", articulo.get_nombretipo())
		       			 .append("nombremarca", articulo.get_nombremarca())
		       			 .append("descripcion", articulo.get_descripcion())
		       			 .append("stock", articulo.get_stock())
		       			 .append("preciounitario", articulo.get_preciounitario())
		       			 .append("medida", new Document()
		       					 .append("medidaespecifica", medidas.get_medidaespecifica()));
		       	 collection.insertOne(doc);
		        } else {
		       	 Document doc = new Document()
		       			 //.append("_id", articulo.get__id())
		       			 .append("nombretipo", articulo.get_nombretipo())
		       			 .append("nombremarca", articulo.get_nombremarca())
		       			 .append("descripcion", articulo.get_descripcion())
		       			 .append("stock", articulo.get_stock())
		       			 .append("preciounitario", articulo.get_preciounitario())
		       			 .append("medida", new Document()
		       					 .append("alto", medidas.get_alto())
		       					 .append("ancho", medidas.get_ancho())
		       					 .append("largo", medidas.get_largo()));
		       	 collection.insertOne(doc);
		        }
		}
	}
	
	public void addRegistroCompra(RegistroCompra registroCompra) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
		        
		        Document doc = new Document()
		       		 //.append("_id", registroCompra.get_id())
		       		 .append("usuario", registroCompra.get_usuario())
		       		 .append("unidadesadquiridas", registroCompra.get_unidadesadquiridas())
		       		 .append("costounitario", registroCompra.get_costounitario())
		       		 .append("fechapedida", registroCompra.get_fechapedida())
		       		 .append("fecharecibo", registroCompra.get_fecharecibo())
		       		 .append("nombreprov", registroCompra.get_nombreprov());
		        
		        if (registroCompra.get_articulo().get_medida().get_alto() == 0 && registroCompra.get_articulo().get_medida().get_ancho() == 0 &&
		       		 registroCompra.get_articulo().get_medida().get_largo() == 0) {
		       	 doc.append("articulo", new Document()
		       			 .append("descripcion", registroCompra.get_articulo().get_descripcion())
	       				 .append("nombretipo", registroCompra.get_articulo().get_nombretipo())
	       				 .append("nombremarca", registroCompra.get_articulo().get_nombremarca())
	       				 .append("stock", registroCompra.get_articulo().get_stock())
	       				 .append("preciounitario", registroCompra.get_articulo().get_preciounitario())
	       				 .append("medidas", new Document()
	       						 .append("medidaespecifica", registroCompra.get_articulo().get_medida().get_medidaespecifica())));
		        } else {
		       	 doc.append("articulo", new Document()
		       			 .append("descripcion", registroCompra.get_articulo().get_descripcion())
	       				 .append("nombretipo", registroCompra.get_articulo().get_nombretipo())
	       				 .append("nombremarca", registroCompra.get_articulo().get_nombremarca())
	       				 .append("stock", registroCompra.get_articulo().get_stock())
	       				 .append("preciounitario", registroCompra.get_articulo().get_preciounitario())
	       				 .append("medidas", new Document()
	       						 .append("alto", registroCompra.get_articulo().get_medida().get_alto())
	       						 .append("largo", registroCompra.get_articulo().get_medida().get_largo())
	       						 .append("ancho", registroCompra.get_articulo().get_medida().get_ancho())));
		        }
		        collection.insertOne(doc);
		}
	}
	
	public void addRegistroVenta(RegistroVenta registroVenta) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
		        
		        Document doc = new Document()
		       		 //.append("_id", registroVenta.get_id())
		       		 .append("fechaventa", registroVenta.get_fechaventa())
		       		 .append("cantidadvendida", registroVenta.get_cantidadvendida())
		       		 .append("usuario", new Document()
		       				 .append("rut", registroVenta.get_usuario().get__id())
		       				 .append("nombreusuario", registroVenta.get_usuario().get_nombreusuario())
		       				 .append("apellidos", registroVenta.get_usuario().get_apellidos())
		       				 .append("telefono", registroVenta.get_usuario().get_telefono())
		       				 .append("email", registroVenta.get_usuario().get_email())
		       				 .append("direccion", new Document()
		       						 .append("calle", registroVenta.get_usuario().get_direccion().get_calle())
		       						 .append("numerodomicilio", registroVenta.get_usuario().get_direccion().get_numerodomicilio())
		       						 .append("nombreregion", registroVenta.get_usuario().get_direccion().get_nombreregion())
		       						 .append("ciudad", registroVenta.get_usuario().get_direccion().get_ciudad())
		       						 .append("comuna", registroVenta.get_usuario().get_direccion().get_comuna())))
		       		 .append("articulo", new Document()
		       				 .append("nombremarca", registroVenta.get_articulo().get_nombremarca())
		       				 .append("nombretipo", registroVenta.get_articulo().get_nombretipo())
		       				 .append("descripcion", registroVenta.get_articulo().get_descripcion())
		       				 .append("preciounitario", registroVenta.get_articulo().get_preciounitario()));
		        collection.insertOne(doc);
		}
	}
	
	public ArrayList<Usuarios> getUsuarios() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
       			 String _id = readString("_id", json);
       			 String nombreusuario = readString("nombreusuario", json);
       			 String apellidos = readString("apellidos", json);
       			 String telefono = readString("telefono", json);
       			 String email = readString("email", json);
       			 usuarios.add(new Usuarios(_id, nombreusuario, apellidos, telefono, email));
		        }
		        return usuarios;
		}
	}
	
	public ArrayList<Articulos> getArticulos() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<Articulos> articulos = new ArrayList<Articulos>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
		       	 String nombretipo = readString("nombretipo", json);
		       	 String nombremarca = readString("nombremarca", json);
		       	 String descripcion = readString("descripcion", json);
		       	 int stock = readInteger("stock", json);
		       	 int preciounitario = readInteger("preciounitario", json);
		       	 String _id = readObjectId("_id", json);
		       	 articulos.add(new Articulos(nombretipo, nombremarca, descripcion, stock, preciounitario, _id));
		        }
		        return articulos;
		}
	}
	
	public ArrayList<RegistrosCompras> getRegistrosCompras() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<RegistrosCompras> registrosCompras = new ArrayList<RegistrosCompras>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
		       	 String usuario = readString("usuario", json);
		       	 String nombreprov = readString("nombreprov", json);
		       	 int unidadesadquiridas = readInteger("unidadesadquiridas", json);
		       	 int costounitario = readInteger("costounitario", json);
		       	 String fechapedida = readString("fechapedida", json);
		       	 String fecharecibo = readString("fecharecibo", json);
		       	 String _id = readObjectId("_id", json);
		       	 registrosCompras.add(new RegistrosCompras(usuario, nombreprov, unidadesadquiridas, costounitario, fechapedida, fecharecibo, _id));
		        }
		        return registrosCompras;
		}
	}
	
	public ArrayList<RegistrosVentas> getRegistrosVentas() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
		        
		        FindIterable<Document> iterDoc = collection.find();
		        MongoCursor<Document> it = iterDoc.iterator();
		        
		        ArrayList<RegistrosVentas> registrosVentas = new ArrayList<RegistrosVentas>();
		        
		        while (it.hasNext()) {
		       	 String json = it.next().toJson();
		       	 String fechaventa = readString("fechaventa", json);
		       	 int cantidadvendida = readInteger("cantidadvendida", json);
		       	 String rut = readStringInObject("usuario", "rut", json);
		       	 String _id = readObjectId("_id", json);
		       	 registrosVentas.add(new RegistrosVentas(fechaventa, cantidadvendida, rut, _id));
		        }
		        return registrosVentas;
		}
	}
	
	public void delUsuario(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
		        
		        Bson query = eq("_id", _id);
		        try {
		       	 collection.deleteOne(query);
		        } catch (MongoException me) {
		       	 System.err.println("Unable to delete due to an error: " + me);
		        }
		}
	}
	
	public void delArticulo(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        Bson query = eq("_id", new ObjectId(_id));
		        try {
		       	 collection.deleteOne(query);
		        } catch (MongoException me) {
		       	 System.err.println("Unable to delete due to an error: " + me);
		        }
		}
	}
	
	public void delRegistroVenta(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
		        
		        Bson query = eq("_id", new ObjectId(_id));
		        try {
		       	 collection.deleteOne(query);
		        } catch (MongoException me) {
		       	 System.err.println("Unable to delete due to an error: " + me);
		        }
		}
	}
	
	public void delRegistroCompra(String _id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
		        
		        Bson query = eq("_id", new ObjectId(_id));
		        try {
		       	 collection.deleteOne(query);
		        } catch (MongoException me) {
		       	 System.err.println("Unable to delete due to an error: " + me);
		        }
		}
	}
	
}
