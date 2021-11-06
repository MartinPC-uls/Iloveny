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

/**
 *
 * @author Roberto
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
        String sql = "SELECT * FROM Administrador WHERE Usuario=? AND Contraseña=?;";
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
    
    public boolean addMedidaG(int Largo, int Alto, int Ancho, String Articulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO MedidaGeneral (Largo,Alto,Ancho,NombreArticulo) VALUES (?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Largo);
            ps.setInt(2, Alto);
            ps.setInt(3, Ancho);
            ps.setString(4, Articulo);
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
    
    public boolean addMedidaE(String Medida, String Articulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO MedidaEspecifica (Medida,NombreArticulo) VALUES (?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Medida);
            ps.setString(2, Articulo);
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
    
    public boolean addArticulo(int idTipoObj,int idMarca,String NombreArticulo,int Stock, String RutaImg,int PrecioUnitario){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "INSERT INTO Articulo (idTipoObj, idMarca, NombreArticulo, Stock, RutaImg, PrecioUnitario) VALUES (?,?,?,?,?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            ps.setInt(2, idMarca);
            ps.setString(3, NombreArticulo);
            ps.setInt(4, Stock);
            ps.setString(5, RutaImg);
            ps.setInt(6, PrecioUnitario);
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
        String sql = "SELECT * FROM MedidaGeneral ORDER BY ? ;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("NombreArticulo"));
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
        String sql = "SELECT * FROM MedidaEspecifica ORDER BY ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("NombreArticulo"));
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
    
    /**
     * Devuelve en orden Articulo, Tipo, Marca, Stock, PrecioUnitario
     * @param orden : String que indica el orden de la tabla. 
     * Debe ser: NombreArticulo, NombreTipo, NombreMarca, Stock o PrecioUnitario.
     * Mandar NombreArticulo por defecto.
     * @return ArrayList. Dentro de cada elemento del ArrayList, se encuentra otro ArrayList String con los datos de cada columna.
     */
    public ArrayList getListaArticulo(String orden){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "SELECT NombreArticulo, NombreTipo, NombreMarca, Stock, PrecioUnitario"
                    + "FROM Articulo, Marca, TipoObj"
                    + "WHERE Articulo.idMarca = Marca.idMarca"
                    + "AND Articulo.idTipoObj = TipoObjeto.idTipoObj" 
                    + "ORDER BY ? ;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, orden);
            rs = ps.executeQuery();
            ArrayList<ArrayList> fila = new ArrayList<>();
            while(rs.next()){
                ArrayList<String> columna = new ArrayList<>();
                columna.add(rs.getString("NombreArticulo"));
                columna.add(rs.getString("NombreTipo"));
                columna.add(rs.getString("NombreMarca"));
                columna.add(rs.getString("Stock"));
                columna.add(rs.getString("PrecioUnitario"));
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
    
    public boolean updtMedidaG(int Largo, int Alto, int Ancho, String ArticuloNuevo, String ArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaGeneral SET Largo= ?,Alto= ?,Ancho= ?,NombreArticulo= ? WHERE NombreArticulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Largo);
            ps.setInt(2, Alto);
            ps.setInt(3, Ancho);
            ps.setString(4, ArticuloNuevo);
            ps.setString(5, ArticuloAntiguo);
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
    
    public boolean updtMedidaE(String Medida, String ArticuloNuevo, String ArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE MedidaEspecifica SET Medida= ? ,NombreArticulo= ? WHERE NombreArticulo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Medida);
            ps.setString(2, ArticuloNuevo);
            ps.setString(3, ArticuloAntiguo);
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
    
    public boolean updtArticulo(int idTipoObj,int idMarca,String NombreArticulo,int Stock, String RutaImg,int PrecioUnitario, String NombreArticuloAntiguo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "UPDATE Articulo SET IdTipoObjeto= ?, idMarca= ?, NombreArticulo= ?, Stock= ?, RutaImg= ?, PrecioUnitario =? WHERE NombreArticulo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoObj);
            ps.setInt(2, idMarca);
            ps.setString(3, NombreArticulo);
            ps.setInt(4, Stock);
            ps.setString(5, RutaImg);
            ps.setInt(6, PrecioUnitario);
            ps.setString(7, NombreArticuloAntiguo);
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
    
    public boolean delArticulo(String Articulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE * FROM Articulo WHERE NombreArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Articulo);
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
    
    public boolean delMedidaG(String Articulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE * FROM MedidaGeneral WHERE NombreArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Articulo);
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
    
    public boolean delMedidaE(String Articulo){
        PreparedStatement ps;
        Connection con = conectar();
        String sql = "DELETE * FROM MedidaEspecifica WHERE NombreArticulo = ?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Articulo);
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
}
