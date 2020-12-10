package org.example.retocomerciales.Clases;

import java.io.Serializable;

/**
 * Cada producto individual. Dato cargado del XML/base de datos
 */

public class Producto implements Serializable {
    final static long serialVersionUID = 1L;

    //FALTA EXISTENCIAS
    String cod, nombre, descripcion, imagen;
    float pr_unidad;

    //Constructor
    public Producto(String cod, String nombre, String imagen, float pr_unidad) {
        this.cod = cod;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = "El innovador " + nombre + " de Pistacho.";
        this.pr_unidad = pr_unidad;
    }
    public Producto(String cod, String nombre, String descripcion, String imagen, float pr_unidad) {
        this.cod = cod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.pr_unidad = pr_unidad;
    }

    //Getters
    public String getCod() {return cod;}
    public String getNombre() {return nombre;}
    public String getImagen() {return imagen;}
    public float getPr_unidad() {return pr_unidad;}
    public String getDescripcion() {return descripcion;}

}
