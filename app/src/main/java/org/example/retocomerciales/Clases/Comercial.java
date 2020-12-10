/**
 * El comercial, el que inicia sesión en la app
 */

package org.example.retocomerciales.Clases;

public class Comercial {

    String email, nombre, apellidos, delegacion;

    //constructor
    public Comercial(String email, String nombre, String apellidos, String delegacion) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.delegacion = delegacion;
    }

    //getters
    public String getEmail() {return email;}
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getDelegacion() {return delegacion;}
}
