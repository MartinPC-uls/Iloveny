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
public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Rut;
    private String Correo;
    private String Comuna;
    private String Ciudad;
    private String Calle;
    private int Domicilio; // Departamento
    private int Region;
    private int Telefono;

    public Usuario(String Nombre, String Apellido, String Rut, String Correo, String Comuna, String Ciudad, String Calle, int Domicilio, int Region, int Telefono) {
	 this.Nombre = Nombre;
	 this.Apellido = Apellido;
	 this.Rut = Rut;
	 this.Correo = Correo;
	 this.Comuna = Comuna;
	 this.Ciudad = Ciudad;
	 this.Calle = Calle;
	 this.Domicilio = Domicilio;
	 this.Region = Region;
	 this.Telefono = Telefono;
    }

    public String getNombre() {
	    return Nombre;
    }

    public void setNombre(String Nombre) {
	    this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public int getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(int Domicilio) {
        this.Domicilio = Domicilio;
    }

    public int getRegion() {
        return Region;
    }

    public void setRegion(int Region) {
        this.Region = Region;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
    
        
}
