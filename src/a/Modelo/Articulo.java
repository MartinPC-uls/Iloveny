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
public class Articulo {
    private String Nombre;
    private String Ruta_imagen;
    private String Marca;
    private int Stock;
    private int Tipo; 
    //private ? Medida;
    // ?: array, obj, x...
    //El tipo debe ser un número dentro de la lista de tipos
    //qué pasa si el usuario elimina un tipo? // El usuario no podrá eliminar el tipo
    //Debemos definir qué Tipos tienen una u otra medida
    
    //Constructor:
    public Articulo(String Nombre, String Ruta_imagen, String Marca, int Stock, int Tipo){
        this.Nombre = Nombre;
        this.Ruta_imagen = Ruta_imagen;
        this.Marca = Marca;
        this.Stock = Stock;
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRuta_imagen() {
        return Ruta_imagen;
    }

    public void setRuta_imagen(String Ruta_imagen) {
        this.Ruta_imagen = Ruta_imagen;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }
    
}
