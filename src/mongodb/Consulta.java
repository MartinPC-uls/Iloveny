package mongodb;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.gt;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class Consulta extends Utils {

	private String password = "123";
	private String uri = "mongodb+srv://Iloveny_dev:" + password + "@iloveny.hfkrx.mongodb.net/?retryWrites=true&w=majority";
	private String db = "Iloveny";
	
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
	
	public Articulo getArticulo(int idArticulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
	        Document doc = collection.find(eq("_id", idArticulo)).first();
	        String json = doc.toJson();
	        
	        String nombretipo = readString("nombretipo", json);
	        String nombremarca = readString("nombremarca", json);
	        String descripcion = readString("descripcion", json);
	        int stock = readInteger("stock", json);
	        int preciounitario = readInteger("preciounitario", json);
	        
	        Medida medidas;
	        int alto = readIntegerInObject("medida", "alto", json);
	        int ancho = readIntegerInObject("medida", "ancho", json);
	        int largo = readIntegerInObject("medida", "largo", json);
	        medidas = new Medida(alto, ancho, largo);
	        
	        return new Articulo(idArticulo, descripcion, nombretipo, nombremarca, stock, preciounitario, medidas);
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
	public void addArticulo(Articulo articulo, Medida medidas) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        if (medidas.get_alto() == 0 && medidas.get_ancho() == 0 && medidas.get_largo() == 0) {
		       	 Document doc = new Document()
		       			 .append("_id", articulo.get__id())
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
		       			 .append("_id", articulo.get__id())
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
		        
		        ArticuloRegistroCompra articulo = registroCompra.get_articulo();
		        
		        Document doc = new Document()
		       		 .append("_id", registroCompra.get_id())
		       		 .append("usuario", registroCompra.get_usuario())
		       		 .append("nombreprov", registroCompra.get_nombreprov())
		       		 .append("unidadesadquiridas", registroCompra.get_unidadesadquiridas())
		       		 .append("costounitario", registroCompra.get_costounitario())
		       		 .append("fechapedida", registroCompra.get_fechapedida())
		       		 .append("fecharecibo", registroCompra.get_fecharecibo())
		       		 .append("articulo", new Document()
		       				 .append("nombretipo", articulo.get_nombretipo())
		       				 .append("nombremarca", articulo.get_nombremarca())
		       				 .append("stock", articulo.get_stock())
		       				 .append("preciounitario", articulo.get_preciounitario())
		       				 .append("descripcion", articulo.get_descripcion()));
		        if (registroCompra.get_medidas().get_alto() == 0 && registroCompra.get_medidas().get_ancho() == 0 
		       		 && registroCompra.get_medidas().get_largo() == 0) {
		       	 doc.append("medidas", new Document()
		       			 .append("alto", registroCompra.get_medidas().get_alto())
		       			 .append("ancho", registroCompra.get_medidas().get_ancho())
		       			 .append("largo", registroCompra.get_medidas().get_largo()));
		        } else {
		       	 doc.append("medidas", new Document()
		       			 .append("medidaespecifica", registroCompra.get_medidas().get_medidaespecifica()));
		        }
		        collection.insertOne(doc);
		}
	}
	
	public void addRegistroVenta(RegistroVenta registroVenta) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
		        
		        Document doc = new Document()
		       		 .append("_id", registroVenta.get_id())
		       		 .append("fechaventa", registroVenta.get_fechaventa())
		       		 .append("cantidadvendida", registroVenta.get_cantidadvendida())
		       		 .append("usuario", new Document()
		       				 .append("usuario", registroVenta.get_usuario().get__id())
		       				 .append("nombreusuario", registroVenta.get_usuario().get_nombreusuario())
		       				 .append("apellidos", registroVenta.get_usuario().get_apellidos())
		       				 .append("telefono", registroVenta.get_usuario().get_telefono())
		       				 .append("email", registroVenta.get_usuario().get_email())
		       				 .append("direccion", new Document()
		       						 .append("calle", registroVenta.get_usuario().get_direccion().get_calle())
		       						 .append("numerodomicilio", registroVenta.get_usuario().get_direccion().get_numerodomicilio())
		       						 .append("nombreregion", registroVenta.get_usuario().get_direccion().get_nombreregion())
		       						 .append("ciudad", registroVenta.get_usuario().get_direccion().get_ciudad())))
		       		 .append("articulo", new Document()
		       				 .append("nombremarca", registroVenta.get_articulo().get_nombremarca())
		       				 .append("nombretipo", registroVenta.get_articulo().get_nombretipo())
		       				 .append("descripcion", registroVenta.get_articulo().get_descripcion())
		       				 .append("preciounitario", registroVenta.get_articulo().get_preciounitario()));
		        collection.insertOne(doc);
		}
	}
	
	public RegistroVenta getRegistroVenta(int id) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROVENTA.toString());
	        Document doc = collection.find(eq("_id", id)).first();
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
	        
	        return new RegistroVenta(id, fechaventa, cantidadvendida, usuario, articulo);
		}
	}
	
	public RegistroCompra getRegistroCompra(String idArticulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.REGISTROCOMPRA.toString());
	        Document doc = collection.find(eq("_id", idArticulo)).first();
	        String json = doc.toJson();
	        
	        int id = readInteger("_id", json);
	        String usuario = readString("usuario", json);
	        String nombreprov = readString("nombreprov", json);
	        int unidadesadquiridas = readInteger("unidadesadquiridas", json);
	        int costounitario = readInteger("costounitario", json);
	        String fechapedida = readString("fechapedida", json);
	        String fecharecibo = readString("fecharecibo", json);
	        ArticuloRegistroCompra articulo;
	        String nombretipo = readStringInObject("articulo", "nombretipo", json);
	        String nombremarca = readStringInObject("articulo", "nombremarca", json);
	        int stock = readIntegerInObject("articulo", "stock", json);
	        int preciounitario = readIntegerInObject("articulo", "preciounitario", json);
	        String descripcion = readStringInObject("articulo", "descripcion", json);
	        articulo = new ArticuloRegistroCompra(nombretipo, nombremarca, stock, preciounitario, descripcion);
	        
	        Medida medidas = null;
	        try {
	       	 int alto = readIntegerInObject("medidas", "alto", json);
	       	 int ancho = readIntegerInObject("medidas", "ancho", json);
	       	 int largo = readIntegerInObject("medidas", "largo", json);
	       	 medidas = new Medida(alto, ancho, largo);
	        } catch (Exception e) {
	       	 String medidaespecifica = readStringInObject("medidas", "medidaespecifica", json);
	       	 medidas = new Medida(medidaespecifica);
	        }
	        
	        return new RegistroCompra(id, nombreprov, usuario, unidadesadquiridas, costounitario, fechapedida, fecharecibo, articulo, medidas);
		}
	}
	
	public ArrayList<ArticuloID> getDescripcionArticulosConStock() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase(db);
		        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
		        
		        Bson projectionFields = Projections.fields(Projections.include("descripcion", "preciounitario"));
		        
		        MongoCursor<Document> cursor = collection.find(gt("stock", 0))
		       		 .projection(projectionFields)
		       		 .sort(Sorts.ascending("stock")).iterator();
		        
		        ArrayList<ArticuloID> articulos = new ArrayList<ArticuloID>();
		        
		        try {
		       	 while (cursor.hasNext()) {
		       		 String json = cursor.next().toJson();
		       		 int id = readInteger("_id", json);
		       		 String descripcion = readString("descripcion", json);
		       		 articulos.add(new ArticuloID(id, descripcion));
		       	 }
		        } finally {
		       	 cursor.close();
		        }
		        return articulos;
		}
	}
	
	/*public int getNumRegistroVenta(String rut) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
	        Document doc = collection.find(eq("_id", rut)).first();
	        String json = doc.toJson();
	        
	        JSONObject object = new JSONObject(json);
	        JSONArray array = object.getJSONArray("registroventa");
	        
	        return array.length();
		}
	}
	
	public int getNumRegistroCompra(String idArticulo) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
	        Document doc = collection.find(eq("_id", idArticulo)).first();
	        String json = doc.toJson();
	        
	        JSONObject object = new JSONObject(json);
	        JSONArray array = object.getJSONArray("registrocompra");
	        
	        return array.length();
		}
	}*/
	
	
	
	/*public boolean updtTipoObj(String Tipo, int id) {
		
	}
	public boolean updtMarca(String Marca, int idMarca) {
		
	}
	public ArrayList getTipoObjeto() {
		
	}
	public ArrayList getTipoObjetoBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public int getArticuloStock(int idArticulo) {
		
	}
	public ArrayList getMarca() {
		
	}
	public ArrayList getMarcaBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getProveedor() {
		
	}
	public ArrayList getProveedorBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getRegion() {
		
	}
	public ArrayList getAdmin() {
		
	}
	public synchronized boolean verificarAdmin(String Usuario, String Contrasena) {
		
	}
	public boolean addArticulo(int idTipoObj,int idMarca,int Stock,String descripcion, String RutaImg,int PrecioUnitario) {
		
	}
	public ArrayList getListaMedidaG(String orden) {
		
	}
	public ArrayList getListaMedidaE(String orden) {
		
	}
	public ArrayList getNombresTipoObjeto() {
		
	}
	public ArrayList getNombresMarca() {
		
	}
	public ArrayList getRuts() {
		
	}
	public ArrayList getIdArticuloSinMedidaEspecifica() {
		
	}
	public ArrayList getDescripcionArticulosConStock() {
		
	}
	public ArrayList getIdArticuloSinMedidaGeneral() {
		
	}
	public ArrayList getListaArticulo(String orden) {
		
	}
	public ArrayList getListaUsuarioBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getListaMedidaEBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getListaMedidaGBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getListaDireccionBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getListaArticuloBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public boolean updtMedidaG(int Largo, int Alto, int Ancho, int idArticuloAntiguo) {
		
	}
	public boolean updtMedidaE(String Medida, int idArticuloAntiguo) {
		
	}
	public boolean updtArticulo(int idTipoObj,int idMarca,int Stock,int PrecioUnitario, int idArticuloAntiguo,String descripcion, String RutaImg) {
		
	}
	public boolean delRegistroVentaIdArticulo(int idArticulo) {
		
	}
	public boolean delRegistroVentaRut(String rut) {
		
	}
	public boolean delArticulo(int idArticulo) {
		
	}
	public boolean delMedidaG(int idArticulo) {
		
	}
	public boolean delMedidaE(int idArticulo) {
		
	}
	public void addRegistroCompra(int idArticulo, String Usuario, int idProv, int UnidadesAdquiridas, int CostoUnitario, String FechaPedida, String FechaRecibo ) {
		
	}
	public void addRegistroVenta(int idArticulo, String Rut, int CantidadVendida, String FechaVenta) {
		
	}
	public ArrayList getRegistrosCompra(String orden) {
		
	}
	public ArrayList getRegistrosCompraBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getRegistrosVenta(String orden) {
		
	}
	public ArrayList getRegistrosVentaBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
		
	}
	public ArrayList getBusquedaGeneral(String nombreTabla, String columnaString, String aBuscarEnColumna, String[] nombresColumnas) {
		
	}
	public void delRegistroCompra(int idCompra) {
		
	}
	public void delRegistroCompraIdArticulo(int idArticulo) {
		
	}
	public void delProveedor(int idProveedor) {
		
	}
	public boolean updtRegistroCompra(String UsuarioNuevo, int idProv, int UnidadesAdquiridas, int CostoUnitario, String FechaPedidaNueva, String FechaRecibo, int idArticuloNuevo, int idCompraAntiguo) {
		
	}
	public boolean updtRegistroVenta(int CantidadVendida, String FechaVentaNueva, int idArticuloNuevo, String rutNuevo,int idVentaAntiguo) {
		
	}
	public void delRegistroVenta(int idVenta) {
		
	}
	public void addUsuario (String NombreUsuario, String Apellidos, String Rut, String Telefono, String Email) {
		
	}
	public void addDireccion(String Rut, int idRegion, int NumeroDomicilio, String Calle, String Ciudad, String Comuna) {
		
	}
	public ArrayList getDirecciones() {
		
	}
	public ArrayList getUsuarios(String orden) {
		
	}
	public ArrayList getUsuarioEspecifico(String Rut) {
		
	}
	public boolean updtUsuario(String rutNuevo, String rutAntiguo, String NombreUsuario, String Apellidos, String Telefono, String Email) {
		
	}
	public boolean updtDireccion(int idRegion, int NumeroDomicilio, String Calle, String Ciudad, String Comuna, String rutAntiguo) {
		
	}
	public boolean updtProveedor(int idProv, String nombreprov) {
		
	}
	public boolean updtStockArticulo(int idArticulo, int stockNuevo) {
		
	}
	public void delUsuario(String Rut) {
		
	}
	public void delMarca(int idMarca) {
		
	}
	public ArrayList getidArticulosSegunMarca(int idMarca) {
		
	}
	public ArrayList getidArticulosSegunIdTipoObj(int idTipoObj) {
		
	}
	public boolean delArticuloSegunIdTipoObj(int idTipoObj) {
		
	}
	public boolean delArticuloSegunMarca(int idMarca) {
		
	}
	public void delDireccion(String Rut) {
		
	}
	public ArrayList getRutsSinDireccion() {
		
	}*/
	
	
}
