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
        String sql = "INSERT INTO  Marca (NombreMarca) VALUES (?);";
        
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
        String sql = "SELECT * FROM TipoObj;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                rs.getString("idTipoObj");
                rs.getString("NombreTipo");
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
                rs.getString("idMarca");
                rs.getString("NombreMarca");
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
                rs.getString("idProv");
                rs.getString("NombreProv");
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
                rs.getString("idRegion");
                rs.getString("NombreRegion");
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
                rs.getString("Usuario");
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
    
    public boolean verificarAdmin(String Usuario, String Contrasena){
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
                columna.add(rs.getString("Largo"));
                columna.add(rs.getString("Alto"));
                columna.add(rs.getString("Ancho"));
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
        String sql = "SELECT tipoobj.nombretipo FROM tipoobj";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("nombretipo"));
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
        String sql = "SELECT marca.nombremarca FROM marca";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> fila = new ArrayList<>();
            while(rs.next()){
                fila.add(rs.getString("nombremarca"));
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
        		+ "WHERE stock>0;";
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
    
    public boolean updtMedidaG(int Largo, int Alto, int Ancho, int idArticuloNuevo, int idArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaGeneral SET Largo= ?,Alto= ?,Ancho= ?,idArticulo= ? WHERE idArticulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Largo);
            ps.setInt(2, Alto);
            ps.setInt(3, Ancho);
            ps.setInt(4, idArticuloNuevo);
            ps.setInt(5, idArticuloAntiguo);
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
    
    public boolean updtMedidaE(String Medida, int idArticuloNuevo, int idArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaEspecifica SET Medida= ? ,idArticulo= ? WHERE idArticulo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Medida);
            ps.setInt(2, idArticuloNuevo);
            ps.setInt(3, idArticuloAntiguo);
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
        		+ "SET IdTipoObjeto= ?, idMarca= ?, Stock= ?, RutaImg= ?, PrecioUnitario =?, descripcion = ? "
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
    public void addRegistroCompra(int idCompra,int idArticulo, String Usuario, int idProv, int UnidadesAdquiridas, int CostoUnitario, Date FechaPedida, Date FechaRecibo ) {
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO RegistroCompra (idArticulo, Usuario, idProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo, idCompra) "
        		+ " VALUES (?,?,?,?,?,?,?,?)";
        try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idArticulo);
			ps.setString(2, Usuario);
			ps.setInt(3, idProv);
			ps.setInt(4,UnidadesAdquiridas);
			ps.setInt(5,CostoUnitario);
			ps.setDate(6, (java.sql.Date) FechaPedida);
			ps.setDate(7, (java.sql.Date) FechaRecibo);
			ps.setInt(8, idCompra);
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
    
    /*public ArrayList getBusquedaGeneral(String nombreTabla, String columnaString, String aBuscarEnColumna, String[] nombresColumnas) {
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
    }*/
    /*
    public ArrayList getBusquedaDinamica(String[] nombresTablas, String columnaString, String aBuscarEnColumna, String[] nombresColumnas) {
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
    }*/
    
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
    
    public boolean updtRegistroCompra(String UsuarioNuevo, int idProv, int UnidadesAdquiridas, int CostoUnitario, Date FechaPedidaNueva, Date FechaRecibo, int idArticuloNuevo, int idCompraAntiguo) {
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
            ps.setDate(6, (java.sql.Date) FechaPedidaNueva);
            ps.setDate(7, (java.sql.Date) FechaRecibo);
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
    
    public boolean updtRegistroVenta(int CantidadVendida, Date FechaVentaNueva, int idArticuloNuevo, String rutNuevo,int idVentaAntiguo) {
    	PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE RegistroCompra "
        		+ "SET idArticulo = ?, Rut = ?, FechaVenta = ?, CantidadVendida = ? "
        		+"WHERE idVenta = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idArticuloNuevo);
            ps.setString(2, rutNuevo);
            ps.setDate(3, (java.sql.Date) FechaVentaNueva);
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
    
    public boolean updtDireccion(String rutNuevo, int idRegion, int NumeroDomicilio, String Calle, String Ciudad, String Comuna, String rutAntiguo) {
    	PreparedStatement ps;
        Connection con = conectar();
    	String sql = "UPDATE Direccion "
    			+ "SET Rut = ?, idRegion = ?, NumeroDomicilio = ?, Calle = ?, Ciudad = ?, Comuna = ? "
    			+ "WHERE Rut = ?";
    	try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rutNuevo);
            ps.setInt(2, idRegion);
            ps.setInt(3, NumeroDomicilio);
            ps.setString(4, Calle);
            ps.setString(5, Ciudad);
            ps.setString(6, Comuna);
            ps.setString(7, rutAntiguo);
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