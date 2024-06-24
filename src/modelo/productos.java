package modelo;

import java.util.Arrays;

public class productos extends inventario {
    protected String descripcion;
    protected float precio;

    public productos(){

    }

    public productos(String categoria, String nombre, String color, String marca, String descripcion, float precio) {
        super(categoria, nombre, color, marca);
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n============PRODUCTOS===============\n" +
                "\nCategoria: " + categoria + '\'' +
                "\nNombre: " + nombre + '\'' +
                "\nColor: " + color + '\'' +
                "\nMarca: " + marca + '\'' +
                "\nDescripcion: " + descripcion+
                "\nPrecio: " + precio;
    }
}
