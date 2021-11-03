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
public class Venta {
    private String Fecha;
    private String Articulo;
    private int Rut;
    private int Cantidad;

    public Venta(String Fecha, String Nombre, int Rut, int Cantidad) {
        this.Fecha = Fecha;
        this.Articulo = Nombre;
        this.Rut = Rut;
        this.Cantidad = Cantidad;
    }
// asdasd
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Articulo;
    }

    public void setNombre(String Nombre) {
        this.Articulo = Nombre;
    }

    public int getRut() {
        return Rut;
    }

    public void setRut(int Rut) {
        this.Rut = Rut;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
}
