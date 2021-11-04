/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.Modelo;

/**
 *
 * @author Roberto
 */

// cambio añadido para testear xd (desde github.com)
public class Compra {
    private String Fecha_pedido;
    private String Fecha_recibo;
    private String Proveedor;
    private String Usuario;
    private String Articulo;
    private int Precio_unitario;
    private int Cantidad;

    public Compra(String Fecha_pedido, String Fecha_recibo, String Proveedor, String Usuario, String Articulo, int Precio_unitario, int Cantidad) {
        this.Fecha_pedido = Fecha_pedido;
        this.Fecha_recibo = Fecha_recibo;
        this.Proveedor = Proveedor;
        this.Usuario = Usuario;
        this.Articulo = Articulo;
        this.Precio_unitario = Precio_unitario;
        this.Cantidad = Cantidad;
    }

    public String getFecha_pedido() {
        return Fecha_pedido;
    }

    public void setFecha_pedido(String Fecha_pedido) {
        this.Fecha_pedido = Fecha_pedido;
    }

    public String getFecha_recibo() {
        return Fecha_recibo;
    }

    public void setFecha_recibo(String Fecha_recibo) {
        this.Fecha_recibo = Fecha_recibo;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public int getPrecio_unitario() {
        return Precio_unitario;
    }

    public void setPrecio_unitario(int Precio_unitario) {
        this.Precio_unitario = Precio_unitario;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
    //uwu
    
}
