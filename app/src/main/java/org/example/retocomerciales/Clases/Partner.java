/**
 * Partner para quien será el pedido.
 */

package org.example.retocomerciales.Clases;

public class Partner {

    String nombre, direccion, poblacion, CIF, telefono, email;

    //Constructor
    public Partner(String nombre, String direccion, String poblacion, String CIF, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.CIF = CIF;
        this.telefono = telefono;
        this.email = email;
    }

    //Getters
    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getPoblacion() {return poblacion;}
    public String getCIF() {return CIF;}
    public String getTelefono() {return telefono;}
    public String getEmail() {return email;}

}
