/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Roberto and Felipe B. B)
 */
public class Consulta extends Conexion{
    
    public boolean addProveedor(String Proveedor){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO  Proveedor (NombreProv) VALUES (?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Proveedor);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtTipoObj(String Tipo, int id){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE TipoObj SET NombreTipo = ? WHERE IdTipoObj = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Tipo);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtMarca(String Marca, int idMarca){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE marca SET Nombremarca = ? WHERE Idmarca = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Marca);
            ps.setInt(2, idMarca);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean addTipoObj(String Tipo){
	        PreparedStatement ps;
	        Connection con = conectar();
	        String sql = "INSERT INTO TipoObj (NombreTipo) VALUES (?);";
	        
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, Tipo);
	            ps.execute();
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }finally {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
    
    public boolean addMarca(String Marca){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO  Marca (?) VALUES (?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Marca);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList getTipoObjeto(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM TipoObj ORDER BY idTipoObj";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idTipoObj"));
                columna.add(rs.getString("NombreTipo"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getTipoObjetoBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM TipoObj ";
        if(isInteger) {
        	sql+= "WHERE UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "WHERE UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idTipoObj"));
                columna.add(rs.getString("NombreTipo"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public int getArticuloStock(int idArticulo) {
	    PreparedStatement ps;
	    ResultSet rs;
	    Connection con = conectar();
	    String sql = "SELECT * FROM Articulo WHERE idarticulo = " + idArticulo + ";";
	    try {
		    ps = con.prepareStatement(sql);
		    rs = ps.executeQuery();
		    int value = 0;
		    if (rs.next()) {
			    value = rs.getInt("stock");
		    }
		    return value;
	    } catch (SQLException ex) {
		    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
		    try {
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
	            }
	    }
	    return -1;
    }
    
    public ArrayList getMarca(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Marca;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idMarca"));
                columna.add(rs.getString("NombreMarca"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getMarcaBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Marca ";
        if(isInteger) {
        	sql+= "WHERE UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "WHERE UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idMarca"));
                columna.add(rs.getString("NombreMarca"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getProveedor(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Proveedor;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idProv"));
                columna.add(rs.getString("NombreProv"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getProveedorBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Proveedor ";
        if(isInteger) {
        	sql+= "WHERE UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "WHERE UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idProv"));
                columna.add(rs.getString("NombreProv"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
  
    public ArrayList getRegion(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Region;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idRegion"));
                columna.add(rs.getString("NombreRegion"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getAdmin(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT Usuario FROM Administrador;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("Usuario"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public synchronized boolean verificarAdmin(String Usuario, String Contrasena){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM administrador WHERE usuario=? AND contrasena=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Contrasena);
            rs = ps.executeQuery();
            return rs.next();   
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    } 
    
    public boolean addMedidaG(int Largo, int Alto, int Ancho, int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO MedidaGeneral (Largo,Alto,Ancho,idArticulo) VALUES (?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Largo);
            ps.setInt(2, Alto);
            ps.setInt(3, Ancho);
            ps.setInt(4, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean addMedidaE(String Medida, int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO MedidaEspecifica (Medida,idArticulo) VALUES (?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Medida);
            ps.setInt(2, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean addArticulo(int idTipoObj,int idMarca,int Stock,String descripcion, String RutaImg,int PrecioUnitario){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO Articulo (idTipoObj, idMarca, Stock, RutaImg, PrecioUnitario, descripcion) VALUES (?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            ps.setInt(2, idMarca);
            ps.setInt(3, Stock);
            ps.setString(4, RutaImg);
            ps.setInt(5, PrecioUnitario);
            ps.setString(6, descripcion);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    public ArrayList getListaMedidaG(String orden){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT medidageneral.idarticulo, tipoobj.nombretipo, medidageneral.alto, medidageneral.ancho, medidageneral.largo "
        		+ "FROM Medidageneral, articulo, tipoobj "
        		+ "WHERE articulo.idarticulo = medidageneral.idarticulo "
        		+ "AND tipoobj.idtipoobj = articulo.idtipoobj "
        		+ "ORDER BY ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("nombretipo"));
                columna.add(rs.getString("alto"));
                columna.add(rs.getString("ancho"));
                columna.add(rs.getString("largo"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaMedidaE(String orden){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT medidaespecifica.idarticulo, tipoobj.nombretipo, medidaespecifica.medida "
        		+ "FROM MedidaEspecifica, articulo, tipoobj "
        		+ "WHERE articulo.idarticulo = medidaespecifica.idarticulo "
        		+ "AND tipoobj.idtipoobj = articulo.idtipoobj "
        		+ "ORDER BY ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("nombretipo"));
                columna.add(rs.getString("Medida"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getNombresTipoObjeto(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM tipoobj ORDER BY idtipoobj";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idtipoobj")+" ("+rs.getString("nombretipo")+")");
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getNombresMarca(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM marca ORDER BY idmarca";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idmarca") +" ("+rs.getString("nombremarca")+")");
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getRuts(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT rut FROM usuario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("rut"));
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getIdArticuloSinMedidaEspecifica(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT articulo.idarticulo, tipoobj.nombretipo "
        		+ "FROM (SELECT articulo.idarticulo as idart "
        				+ "FROM articulo "
        				+ "LEFT JOIN medidaespecifica "
        				+ "ON medidaespecifica.idarticulo = articulo.idarticulo "
        				+ "WHERE medidaespecifica.idarticulo IS NULL) as idSinMedida, "
				+ "articulo, tipoobj "
				+ "WHERE idSinMedida.idart = articulo.idarticulo "
				+ "AND articulo.idtipoobj = tipoobj.idtipoobj "
				+ "ORDER BY idarticulo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idarticulo") + " ("+rs.getString("nombretipo")+")");
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getDescripcionArticulosConStock(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT articulo.idarticulo, articulo.descripcion "
        		+ "FROM articulo "
        		+ "WHERE stock>0 ORDER BY articulo.idarticulo;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idarticulo") + " ("+rs.getString("descripcion")+")");
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getIdArticuloSinMedidaGeneral(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT articulo.idarticulo, tipoobj.nombretipo "
        		+ "FROM (SELECT articulo.idarticulo as idart "
				+ "FROM articulo "
				+ "LEFT JOIN medidageneral "
				+ "ON medidageneral.idarticulo = articulo.idarticulo "
				+ "WHERE medidageneral.idarticulo IS NULL) as idSinMedida, "
		+ "articulo, tipoobj "
		+ "WHERE idSinMedida.idart = articulo.idarticulo "
		+ "AND articulo.idtipoobj = tipoobj.idtipoobj "
		+ "ORDER BY idarticulo";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
            	fila.add(rs.getString("idarticulo") + " ("+rs.getString("nombretipo")+")");
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    /**
     * Devuelve en orden idArticulo, Tipo, Marca, Stock, PrecioUnitario y descripcion
     * @param orden : String que indica el orden de la tabla. 
     * Debe ser: IdArticulo, NombreTipo, NombreMarca, Stock o PrecioUnitario.
     * Mandar idArticulo por defecto.
     * @return ArrayList. Dentro de cada elemento del ArrayList, se encuentra otro ArrayList String con los datos de cada columna.
     */
    public ArrayList getListaArticulo(String orden){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT idArticulo, NombreTipo, NombreMarca, Stock, PrecioUnitario, descripcion, rutaimg "
                    + "FROM Articulo, Marca, TipoObj "
                    + "WHERE Articulo.idMarca = Marca.idMarca "
                    + "AND Articulo.idTipoObj = TipoObj.idTipoObj "
                    + "ORDER BY ? ;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("NombreTipo"));
                columna.add(rs.getString("NombreMarca"));
                columna.add(rs.getString("Stock"));
                columna.add(rs.getString("PrecioUnitario"));
                columna.add(rs.getString("descripcion"));
                columna.add(rs.getString("rutaimg"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaUsuarioBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT DISTINCT * "
        		+ "FROM usuario ";
        if(isInteger) {
        	sql+= "WHERE UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "WHERE UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("NombreUsuario"));
                columna.add(rs.getString("Apellidos"));
                columna.add(rs.getString("Rut"));
                columna.add(rs.getString("Telefono"));
                columna.add(rs.getString("Email"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaMedidaEBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT medidaespecifica.idarticulo, tipoobj.nombretipo, medidaespecifica.medida "
        		+ "FROM MedidaEspecifica, articulo, tipoobj "
        		+ "WHERE articulo.idarticulo = medidaespecifica.idarticulo "
        		+ "AND tipoobj.idtipoobj = articulo.idtipoobj ";
        if(isInteger) {
        	sql+= "AND UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "AND UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("nombretipo"));
                columna.add(rs.getString("Medida"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaMedidaGBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT medidageneral.idarticulo, tipoobj.nombretipo, medidageneral.alto, medidageneral.ancho, medidageneral.largo "
        		+ "FROM Medidageneral, articulo, tipoobj "
        		+ "WHERE articulo.idarticulo = medidageneral.idarticulo "
        		+ "AND tipoobj.idtipoobj = articulo.idtipoobj ";
        if(isInteger) {
        	sql+= "AND UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "AND UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("nombretipo"));
                columna.add(rs.getString("alto"));
                columna.add(rs.getString("ancho"));
                columna.add(rs.getString("largo"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaDireccionBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT rut, nombreregion, numerodomicilio, calle, ciudad, comuna " 
    			+"FROM Direccion, Region " 
    			+"WHERE direccion.idRegion = region.idRegion ";
        if(isInteger) {
        	sql+= "AND UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "AND UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("rut"));
                columna.add(rs.getString("Nombreregion"));
                columna.add(rs.getString("numerodomicilio"));
                columna.add(rs.getString("calle"));
                columna.add(rs.getString("ciudad"));
                columna.add(rs.getString("comuna"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getListaArticuloBusqueda(String nombreColumna, String aBuscar, boolean isInteger){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT DISTINCT idArticulo, NombreTipo, NombreMarca, Stock, PrecioUnitario, descripcion, rutaimg "
        		+ "FROM Articulo, Marca, TipoObj "
        		+ "WHERE Articulo.idMarca = Marca.idMarca "
        		+ "AND Articulo.idTipoObj = TipoObj.idTipoObj ";
        if(isInteger) {
        	sql+= "AND UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "AND UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        		
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("NombreTipo"));
                columna.add(rs.getString("NombreMarca"));
                columna.add(rs.getString("Stock"));
                columna.add(rs.getString("PrecioUnitario"));
                columna.add(rs.getString("descripcion"));
                columna.add(rs.getString("rutaimg"));
                fila.add(columna);
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean updtMedidaG(int Largo, int Alto, int Ancho, int idArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaGeneral SET Largo= ?,Alto= ?,Ancho= ? WHERE idArticulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Largo);
            ps.setInt(2, Alto);
            ps.setInt(3, Ancho);
            ps.setInt(4, idArticuloAntiguo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtMedidaE(String Medida, int idArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaEspecifica SET Medida= ? WHERE idArticulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Medida);
            ps.setInt(2, idArticuloAntiguo);
            ps.execute();
            return true;
        } catch (SQLException ex) { 
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtArticulo(int idTipoObj,int idMarca,int Stock,int PrecioUnitario, int idArticuloAntiguo,String descripcion, String RutaImg){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE Articulo "
        		+ "SET IdTipoObj= ?, idMarca= ?, Stock= ?, RutaImg= ?, PrecioUnitario =?, descripcion = ? "
        		+ "WHERE idArticulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            ps.setInt(2, idMarca);
            ps.setInt(3, Stock);
            ps.setString(4, RutaImg);
            ps.setInt(5, PrecioUnitario);
            ps.setString(6, descripcion);
            ps.setInt(7, idArticuloAntiguo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delRegistroVentaIdArticulo(int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM registroventa WHERE idarticulo = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delRegistroVentaRut(String rut){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM registroventa WHERE rut = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delArticulo(int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM Articulo WHERE idArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delMedidaG(int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM MedidaGeneral WHERE idArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delMedidaE(int idArticulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM MedidaEspecifica WHERE idArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticulo);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    /**
     * Esta funcion permite agregar una nueva fila a la tabla de RegistroCompra con sus correspondientes datos.
     * @param idArticulo Corresponde al dato que se va a agregar en la columna idArticulo.
     * @param Usuario Corresponde al dato que se va a agregar en la columna Usuario.
     * @param idProv Corresponde al dato que se va a agregar en la columna idProv.
     * @param UnidadesAdquiridas Corresponde al dato que se va a agregar en la columna UnidadesAdquiridas.
     * @param CostoUnitario Corresponde al dato que se va a agregar en la columna CostoUnitario.
     * @param FechaPedida Corresponde al dato que se va a agregar en la columna FechaPedida.
     * @param FechaRecibo Corresponde al dato que se va a agregar en la columna FechaRecibo.
     */
    public void addRegistroCompra(int idArticulo, String Usuario, int idProv, int UnidadesAdquiridas, int CostoUnitario, String FechaPedida, String FechaRecibo ) {
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO RegistroCompra (idArticulo, Usuario, idProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo) "
        		+ " VALUES (?,?,?,?,?,?,?)";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idArticulo);
			ps.setString(2, Usuario);
			ps.setInt(3, idProv);
			ps.setInt(4,UnidadesAdquiridas);
			ps.setInt(5,CostoUnitario);
			ps.setDate(6, java.sql.Date.valueOf(FechaPedida));
			ps.setDate(7, java.sql.Date.valueOf(FechaRecibo));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addRegistroCompra_batch() {
	    	PreparedStatement ps = null;
	    	Connection con = conectar();
	    	String sql = "INSERT INTO RegistroCompra (idArticulo, Usuario, idProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo) "
	        		+ " VALUES (?,?,?,?,?,?,?)";
	    	try {
	    		
	    		System.out.println("Agregando datos...");
	    		
	    		ps = con.prepareStatement(sql);
	    		
	    		String usuario = "admin";
	   	    
	   	    int random_dia;
	   	    int random_mes;
	   	    int random_ano;
	   	    
	   	    int min_dia = 1, max_dia = 31;
	   	    int min_mes = 1, max_mes = 12;
	   	    int min_ano = 2018, max_ano = 2021;
	   	    
	   	    int random_idarticulo;
	   	    int min_idarticulo = 1, max_idarticulo = 20;
	   	    
	   	    int random_unidadesadquiridas;
	   	    int min_unidadesadquiridas = 1, max_unidadesadquiridas = 3;
	   	    
	   	    int random_idproveedor;
	   	    int min_idproveedor = 1, max_idproveedor = 2;
	   	    
	   	    
	   	    String fecha = "";
	   	    
	   	    int maxDatos = 99999;
	   	    for (int i = 0; i < maxDatos; i++) {
	   		    random_dia = (int)Math.floor(Math.random()*(max_dia-min_dia+1)+min_dia);
	   		    random_mes = (int)Math.floor(Math.random()*(max_mes-min_mes+1)+min_mes);
	   		    random_ano = (int)Math.floor(Math.random()*(max_ano-min_ano+1)+min_ano);
	   		    random_idarticulo = (int)Math.floor(Math.random()*(max_idarticulo-min_idarticulo+1)+min_idarticulo);
	   		    random_idproveedor = (int)Math.floor(Math.random()*(max_idproveedor-min_idproveedor+1)+min_idproveedor);
	   		    random_unidadesadquiridas = (int)Math.floor(Math.random()*(max_unidadesadquiridas-min_unidadesadquiridas+1)+min_unidadesadquiridas);
	   		    if (random_mes == 2 && random_dia > 28) {
	   			    random_dia = 28;
	   		    } else if (random_mes == 4 || random_mes == 6 || random_mes == 9 || random_mes == 11 && random_dia > 31) {
	   			    random_dia = 30;
	   		    }
	   		    
	   		    fecha = random_ano + "-" + String.format("%02d", random_mes) + "-" + String.format("%02d", random_dia);
	   		    
	   		    	ps.setInt(1, random_idarticulo);
				ps.setString(2, usuario);
				ps.setInt(3, random_idproveedor);
				ps.setInt(4, random_unidadesadquiridas);
				//ps.setInt(5, costounitario); ?
				//ps.setString(6, random_fechapedido); ?
				//ps.setString(7, random_fecharecibo); ?
				
				ps.addBatch();
				if ((i + 1) % 100 == 0) {
					ps.executeBatch();
				}
	   	    }
	    		
				
				
				ps.executeBatch();
				System.out.println("se ha terminado de ejecutar el script.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
    
    /**
     * Esta funcion permite agregar una nueva fila a la tabla de RegistroVenta con sus correspondientes datos.
     * @param idArticulo Corresponde al dato que se va a agregar en la columna idArticulo.
     * @param Rut Corresponde al dato que se va a agregar en la columna RUT.
     * @param CantidadVendida Corresponde al dato que se va a agregar en la columna CantidadVendida.
     * @param FechaVenta Corresponde al dato que se va a agregar en la columna FechaVenta.
     */
    public void addRegistroVenta(int idArticulo, String Rut, int CantidadVendida, String FechaVenta) {
    	PreparedStatement ps;
    	Connection con = conectar();
    	String sql = "INSERT INTO RegistroVenta (idArticulo, Rut, CantidadVendida, FechaVenta) "
    			+ "VALUES (?,?,?,?)";
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idArticulo);
			ps.setString(2, Rut);
			ps.setInt(3, CantidadVendida);
			ps.setDate(4, java.sql.Date.valueOf(FechaVenta));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addRegistroVenta_batch() {
	    	PreparedStatement ps = null;
	    	Connection con = conectar();
	    	String sql = "INSERT INTO RegistroVenta (idArticulo, Rut, CantidadVendida, FechaVenta) "
	    			+ "VALUES (?,?,?,?)";
	    	try {
	    		
	    		System.out.println("Agregando datos...");
	    		
	    		ps = con.prepareStatement(sql);
	    		
	    		String[] ruts = new String[12];
	   	    ruts[0] = "20.295.419-7";
	   	    ruts[1] = "18.755.052-5";
	   	    ruts[2] = "12.484.045-1";
	   	    ruts[3] = "8.622.158-9";
	   	    ruts[4] = "9.261.001-7";
	   	    ruts[5] = "12.159.963-3";
	   	    ruts[6] = "14.741.258-0";
	   	    ruts[7] = "7.751.102-4";
	   	    ruts[8] = "10.761.163-K";
	   	    ruts[9] = "13.451.418-7";
	   	    ruts[10] = "14.103.451-9";
	   	    ruts[11] = "16.551.777-8";
	   	    
	   	    int min = 0;
	   	    int max = 11;
	   	    int random_rut;
	   	    int random_idarticulo;
	   	    int random_cantidadvendida;
	   	    
	   	    int random_dia;
	   	    int random_mes;
	   	    int random_ano;
	   	    
	   	    int min_dia = 1, max_dia = 31;
	   	    int min_mes = 1, max_mes = 12;
	   	    int min_ano = 2018, max_ano = 2021;
	   	    
	   	    int min_idarticulo = 1, max_idarticulo = 20;
	   	    
	   	    int min_cantidadvendida = 1, max_cantidadvendida = 3;
	   	    
	   	    //Consulta consulta = new Consulta();
	   	    
	   	    String fecha = "";
	   	    
	   	    int maxDatos = 447200;
	   	    for (int i = 0; i < maxDatos; i++) {
	   		    random_rut =  (int)Math.floor(Math.random()*(max-min+1)+min);
	   		    random_dia = (int)Math.floor(Math.random()*(max_dia-min_dia+1)+min_dia);
	   		    random_mes = (int)Math.floor(Math.random()*(max_mes-min_mes+1)+min_mes);
	   		    random_ano = (int)Math.floor(Math.random()*(max_ano-min_ano+1)+min_ano);
	   		    random_idarticulo = (int)Math.floor(Math.random()*(max_idarticulo-min_idarticulo+1)+min_idarticulo);
	   		    random_cantidadvendida = (int)Math.floor(Math.random()*(max_cantidadvendida-min_cantidadvendida+1)+min_cantidadvendida);
	   		    if (random_mes == 2 && random_dia > 28) {
	   			    random_dia = 28;
	   		    } else if (random_mes == 4 || random_mes == 6 || random_mes == 9 || random_mes == 11 && random_dia > 31) {
	   			    random_dia = 30;
	   		    }
	   		    
	   		    fecha = random_ano + "-" + String.format("%02d", random_mes) + "-" + String.format("%02d", random_dia);
	   		    
	   		    	ps.setInt(1, random_idarticulo);
				ps.setString(2, ruts[random_rut]);
				ps.setInt(3, random_cantidadvendida);
				ps.setDate(4, java.sql.Date.valueOf(fecha));
				
				ps.addBatch();
				if ((i + 1) % 100 == 0) {
					ps.executeBatch();
				}
	   	    }
	    		
				
				
				ps.executeBatch();
				System.out.println("se ha terminado de ejecutar el script.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
    
    /**
     * Obtiene los datos de la tabla RegistrosCompra en conjunto de la proveedores
     * @param orden Es el atributo por el cual se va a ordenar la tabla (default: FechaPedida).
     * @return Retorna un arrayList con los datos obtenidos de la consulta.
     */
    public ArrayList getRegistrosCompra (String orden) {
    	PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT idArticulo, Usuario, NombreProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo, idCompra "
        		+ "FROM RegistroCompra, Proveedor "
        		+ "WHERE RegistroCompra.idProv = Proveedor.idProv "
        		+ "ORDER BY ?";
        try {
        	ps = con.prepareStatement(sql);
        	ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("Usuario"));
                columna.add(rs.getString("NombreProv"));
                columna.add(rs.getString("UnidadesAdquiridas"));
                columna.add(rs.getString("CostoUnitario"));
                columna.add(rs.getString("FechaPedida"));
                columna.add(rs.getString("FechaRecibo"));
                columna.add(rs.getString("idcompra"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public ArrayList getRegistrosCompraBusqueda (String nombreColumna, String aBuscar, boolean isInteger) {
    	PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT idArticulo, Usuario, NombreProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo, idCompra "
        		+ "FROM RegistroCompra, Proveedor "
        		+ "WHERE RegistroCompra.idProv = Proveedor.idProv ";
        if(isInteger) {
        	sql+= "AND UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "AND UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
        	ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("Usuario"));
                columna.add(rs.getString("NombreProv"));
                columna.add(rs.getString("UnidadesAdquiridas"));
                columna.add(rs.getString("CostoUnitario"));
                columna.add(rs.getString("FechaPedida"));
                columna.add(rs.getString("FechaRecibo"));
                columna.add(rs.getString("idcompra"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    /**
     * Obtiene los datos de la tabla de RegistrosVenta
     * @param orden Es el parametro que determinará el orden de la lista.
     * @return retorna una lista de arreglos con los datos obtenidos de la consulta.
     */
    public ArrayList getRegistrosVenta(String orden) {
    	PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * "
        		+ "FROM RegistroVenta "
        		+ "ORDER BY ?";
        try {
        	ps = con.prepareStatement(sql);
        	ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("Rut"));
                columna.add(rs.getString("FechaVenta"));
                columna.add(rs.getString("CantidadVendida"));
                columna.add(rs.getString("idventa"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public ArrayList getRegistrosVentaBusqueda(String nombreColumna, String aBuscar, boolean isInteger) {
    	PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * "
        		+ "FROM RegistroVenta ";
    
        if(isInteger) {
        	sql+= "WHERE UPPER(CAST("+nombreColumna+" as VARCHAR)) LIKE UPPER('%"+aBuscar+"%')";
        }else {
        	sql+= "WHERE UPPER("+nombreColumna+") LIKE UPPER('%"+aBuscar+"%')";
        }
        try {
        	ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("idArticulo"));
                columna.add(rs.getString("Rut"));
                columna.add(rs.getString("FechaVenta"));
                columna.add(rs.getString("CantidadVendida"));
                columna.add(rs.getString("idventa"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public ArrayList getBusquedaGeneral(String nombreTabla, String columnaString, String aBuscarEnColumna, String[] nombresColumnas) {
    	PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * "
        		+ "FROM ? "
        		+ "WHERE ? = ?";
        try {
        	ps = con.prepareStatement(sql);
        	ps.setString(1, nombreTabla);
        	ps.setString(2, columnaString);
        	ps.setString(3, aBuscarEnColumna);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                for(int i = 0; i<nombresColumnas.length;i++) {
                	columna.add(rs.getString(nombresColumnas[i]));
                }
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    /**
     * Borra una fila de la tabla RegistroCompra.
     * @param idArticulo Este parametro sirve para identificar la fila que se quiere borrar.
     * @param FechaPedida Este parametro sirve para identificar la fila que se quiere borrar.
     */
    public void delRegistroCompra(int idCompra) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM RegistroCompra "
        		+ "WHERE idCompra = ? ";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idCompra);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delRegistroCompraIdArticulo(int idArticulo) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM RegistroCompra "
        		+ "WHERE idArticulo = ? ";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idArticulo);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delProveedor(int idProveedor) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM Proveedor "
        		+ "WHERE idProv = ? ";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProveedor);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtRegistroCompra(String UsuarioNuevo, int idProv, int UnidadesAdquiridas, int CostoUnitario, String FechaPedidaNueva, String FechaRecibo, int idArticuloNuevo, int idCompraAntiguo) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE RegistroCompra "
        		+ "SET idArticulo = ?, Usuario = ?, idProv= ?, UnidadesAdquiridas = ?, CostoUnitario= ?, FechaPedida = ?, FechaRecibo =? "
        		+ "WHERE idCompra = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticuloNuevo);
            ps.setString(2, UsuarioNuevo);
            ps.setInt(3, idProv);
            ps.setInt(4, UnidadesAdquiridas);
            ps.setInt(5, CostoUnitario);
            ps.setDate(6, java.sql.Date.valueOf(FechaPedidaNueva));
            ps.setDate(7, java.sql.Date.valueOf(FechaRecibo));
            ps.setInt(8, idCompraAntiguo);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtRegistroVenta(int CantidadVendida, String FechaVentaNueva, int idArticuloNuevo, String rutNuevo,int idVentaAntiguo) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE RegistroVenta "
        		+ "SET idArticulo = ?, Rut = ?, FechaVenta = ?, CantidadVendida = ? "
        		+"WHERE idVenta = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticuloNuevo);
            ps.setString(2, rutNuevo);
            ps.setDate(3, java.sql.Date.valueOf(FechaVentaNueva));
            ps.setInt(4, CantidadVendida);
            ps.setInt(5, idVentaAntiguo);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Borra una fila de la tabla RegistroVenta.
     * @param idArticulo Este parametro sirve para identificar la fila que se quiere borrar.
     * @param FechaVenta Este parametro sirve para identificar la fila que se quiere borrar.
     */
    public void delRegistroVenta(int idVenta){
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "DELETE FROM RegistroVenta "
    			+ "WHERE idVenta = ? ";
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idVenta);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addUsuario (String NombreUsuario, String Apellidos, String Rut, String Telefono, String Email) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "INSERT INTO Usuario (NombreUsuario, Apellidos, Rut, Telefono, Email) "
    			+ "VALUES (?,?,?,?,?)";
    	try {
			ps = con.prepareStatement(sql);
			ps.setString(1, NombreUsuario);
			ps.setString(2, Apellidos);
			ps.setString(3, Rut);
			ps.setString(4, Telefono);
			ps.setString(5, Email);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addDireccion(String Rut, int idRegion, int NumeroDomicilio, String Calle, String Ciudad, String Comuna) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO Direccion (Rut, idRegion, NumeroDomicilio, Calle, Ciudad, Comuna) "
        		+ "VALUES (?,?,?,?,?,?)";
        try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Rut);
			ps.setInt(2, idRegion);
			ps.setInt(3, NumeroDomicilio);
			ps.setString(4, Calle);
			ps.setString(5, Ciudad);
			ps.setString(6, Comuna);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public ArrayList getDirecciones() {
    	PreparedStatement ps;
    	ResultSet rs;
        Connection con = conectar();
    	String sql = "SELECT rut, nombreregion, numerodomicilio, calle, ciudad, comuna " 
    			+"FROM Direccion, Region " 
    			+"WHERE direccion.idRegion = region.idRegion";
    	try {
        	ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("rut"));
                columna.add(rs.getString("Nombreregion"));
                columna.add(rs.getString("numerodomicilio"));
                columna.add(rs.getString("calle"));
                columna.add(rs.getString("ciudad"));
                columna.add(rs.getString("comuna"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public ArrayList getUsuarios(String orden) {
    	PreparedStatement ps;
    	ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * FROM Usuario ORDER BY ?";
        try {
        	ps = con.prepareStatement(sql);
        	ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList<String>> fila = new ArrayList<>();
            ArrayList<String> columna;
            while(rs.next()){
       	  columna = new ArrayList<>();
                columna.add(rs.getString("NombreUsuario"));
                columna.add(rs.getString("Apellidos"));
                columna.add(rs.getString("Rut"));
                columna.add(rs.getString("Telefono"));
                columna.add(rs.getString("Email"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public ArrayList getUsuarioEspecifico(String Rut) {
    	PreparedStatement ps;
    	ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT * "
        		+ "FROM Usuario "
        		+ "WHERE Rut = ?";
        try {
        	ps = con.prepareStatement(sql);
        	ps.setString(1, Rut);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("NombreUsuario"));
                columna.add(rs.getString("Apellidos"));
                columna.add(rs.getString("Rut"));
                columna.add(rs.getString("Telefono"));
                columna.add(rs.getString("Email"));
                fila.add(columna);
            }
            ps.close();
            return fila;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return null;
    }
    
    public boolean updtUsuario(String rutNuevo, String rutAntiguo, String NombreUsuario, String Apellidos, String Telefono, String Email) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "UPDATE Usuario "
    			+ "SET NombreUsuario = ?, Apellidos = ?, Rut = ?, Telefono = ?, Email = ?  "
    			+ "WHERE Rut = ?";
    	 try {
             ps = con.prepareStatement(sql);
             ps.setString(1, NombreUsuario);
             ps.setString(2, Apellidos);
             ps.setString(3, rutNuevo);
             ps.setString(4, Telefono);
             ps.setString(5, Email);
             ps.setString(6,rutAntiguo);
             ps.execute();
             ps.close();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }finally {
             try {
                 con.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
    
    public boolean updtDireccion(int idRegion, int NumeroDomicilio, String Calle, String Ciudad, String Comuna, String rutAntiguo) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "UPDATE Direccion SET "
    			+ "idRegion = ?, NumeroDomicilio = ?, Calle = ?, Ciudad = ?, Comuna = ? "
    			+ "WHERE Rut = ?";
    	try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRegion);
            ps.setInt(2, NumeroDomicilio);
            ps.setString(3, Calle);
            ps.setString(4, Ciudad);
            ps.setString(5, Comuna);
            ps.setString(6, rutAntiguo);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtProveedor(int idProv, String nombreprov) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "UPDATE proveedor "
    			+ "SET nombreprov = ? "
    			+ "WHERE idprov = ?";
    	try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreprov);
            ps.setInt(2, idProv);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean updtStockArticulo(int idArticulo, int stockNuevo) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "UPDATE articulo "
    			+ "SET stock = ? "
    			+ "WHERE idarticulo = ?";
    	try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stockNuevo);
            ps.setInt(2, idArticulo);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delUsuario(String Rut) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM Usuario WHERE Rut = ?";
        try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Rut);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delMarca(int idMarca) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM marca WHERE idMarca = ?";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idMarca);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList getidArticulosSegunMarca(int idMarca){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT idarticulo " +
        		"FROM articulo " + 
        		"WHERE idMarca = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMarca);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idarticulo"));
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList getidArticulosSegunIdTipoObj(int idTipoObj){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT idarticulo " +
        		"FROM articulo " + 
        		"WHERE idTipoObj = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("idarticulo"));
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean delArticuloSegunIdTipoObj(int idTipoObj){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM Articulo WHERE idtipoobj = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean delArticuloSegunMarca(int idMarca){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE FROM Articulo WHERE idMarca = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMarca);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delDireccion(String Rut) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE "
        		+ "From Direccion "
        		+ "WHERE Rut = ?";
        try {
			ps = con.prepareStatement(sql);
			ps.setString(1, Rut);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList getRutsSinDireccion(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT usuario.rut " +
        		"FROM usuario " + 
        		"LEFT JOIN direccion ON direccion.rut = usuario.rut " +
        		"WHERE direccion.rut IS NULL";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("rut"));
            }
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}