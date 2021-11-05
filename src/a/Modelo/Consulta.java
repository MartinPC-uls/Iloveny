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

public class Consulta extends Conexion{
	
    public ArrayList getListaArticulos(String orden){
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
    
    /**
     * Esta funcion permite agregar una nueva fila a la tabla de RegistroCompra con sus correspondientes datos.
     * @param NombreArticulo Corresponde al dato que se va a agregar en la columna NombreArticulo.
     * @param Usuario Corresponde al dato que se va a agregar en la columna Usuario.
     * @param idProv Corresponde al dato que se va a agregar en la columna idProv.
     * @param UnidadesAdquiridas Corresponde al dato que se va a agregar en la columna UnidadesAdquiridas.
     * @param CostoUnitario Corresponde al dato que se va a agregar en la columna CostoUnitario.
     * @param FechaPedida Corresponde al dato que se va a agregar en la columna FechaPedida.
     * @param FechaRecibo Corresponde al dato que se va a agregar en la columna FechaRecibo.
     */
    public void addNuevoRegistroCompra(String NombreArticulo, String Usuario, int idProv, int UnidadesAdquiridas, int CostoUnitario, Date FechaPedida, Date FechaRecibo ) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conectar();
        String sql = "INSERT INTO RegistroCompra (NombreArticulo, Usuario, idProv, UnidadesAdquiridas, CostoUnitario, FechaPedida, FechaRecibo)"
        		+ " VALUES (?,?,?,?,?,?,?)";
        try {
			ps = con.prepareStatement(sql);
			ps.setString(1, NombreArticulo);
			ps.setString(2, Usuario);
			ps.setInt(3, idProv);
			ps.setInt(4,UnidadesAdquiridas);
			ps.setInt(5,CostoUnitario);
			ps.setDate(6, (java.sql.Date) FechaPedida);
			ps.setDate(7, (java.sql.Date) FechaRecibo);
			ps.executeUpdate();
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
 
}
