package mongodb;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	        // registroventa ...
	        
	        direccion = new Direccion(calle, numerodomicilio, ciudad, comuna, nombreregion);
	        return new Usuario(rut, nombreusuario, apellidos, telefono, email, direccion);
	    }
	}
	
	public RegistroVenta getRegistroVenta(String rut, int object_index) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.USUARIO.toString());
	        Document doc = collection.find(eq("_id", rut)).first();
	        String json = doc.toJson();
	        
	        // TODO
	        // fechaventa : Date
	        String fechaventa = readStringIntoAnArrayInObject("registroventa", object_index, "fechaventa", json);
	        // fechaventa : Date
	        int cantidadvendida = readIntegerIntoAnArrayInObject("registroventa", object_index, "cantidadvendida", json);
	        ArticuloRegistroVenta articulo;
	        String descripcion = readStringIntoAnArrayIntoAnObjectInObject("registroventa", object_index, "articulo",
	        		"descripcion", json);
	        String nombretipo = readStringIntoAnArrayIntoAnObjectInObject("registroventa", object_index, "articulo",
	        		"nombretipo", json);
	        String nombremarca = readStringIntoAnArrayIntoAnObjectInObject("registroventa", object_index, "articulo",
	        		"nombremarca", json);
	        int preciounitario = readIntegerIntoAnArrayIntoAnObjectInObject("registroventa", object_index, "articulo",
	        		"preciounitario", json);
	        
	        articulo = new ArticuloRegistroVenta(descripcion, nombretipo, nombremarca, preciounitario);
	        
	        return new RegistroVenta(fechaventa, cantidadvendida, articulo);
		}
	}
	
	public RegistroCompra getRegistroCompra(String idArticulo, int object_index) {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase(db);
	        MongoCollection<Document> collection = database.getCollection(Iloveny.ARTICULO.toString());
	        Document doc = collection.find(eq("_id", idArticulo)).first();
	        String json = doc.toJson();
	        
	        String nombreprov = readStringIntoAnArrayInObject("registrocompra", object_index, "nombreprov", json);
	        String usuario = readStringIntoAnArrayInObject("registrocompra", object_index, "usuario", json);
	        int unidadesadquiridas = readIntegerIntoAnArrayInObject("registrocompra", object_index, "unidadesadquiridas", json);
	        int costounitario = readIntegerIntoAnArrayInObject("registrocompra", object_index, "costounitario", json);
	        String fechapedida = readStringIntoAnArrayInObject("registrocompra", object_index, "fechapedida", json);
	        String fecharecibo = readStringIntoAnArrayInObject("registrocompra", object_index, "fecharecibo", json);
	        
	        return new RegistroCompra(nombreprov, usuario, unidadesadquiridas, costounitario, fechapedida, fecharecibo);
		}
	}
	
	public int getNumRegistroVenta(String rut) {
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
	}
	
	
	
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
