package modelo;

import java.util.Arrays;

public class inventario {
    protected String categoria;
    protected String nombre;
    protected String color;
    protected String marca;
    protected String[] caracteristicas;
    protected int stock;


    public inventario(String categoria, String nombre, String color, String marca, String[] caracteristicas, int stock) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.color=color;
        this.marca = marca;
        this.caracteristicas = caracteristicas;
        this.stock = stock;
    }

    public inventario(String categoria, String nombre, String color, String marca) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.color = color;
        this.marca = marca;
    }

    public inventario() {

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String codigo) {
        this.categoria = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String obtenerCaracteristicas(){
        String caracter= Arrays.toString(caracteristicas);
        return caracter;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "\n====================INVENTARIO=====================" +
                "\nCodigo: " + categoria +
                "\nNombre: " + nombre +
                "\nColor: " + color +
                "\nMarca: " + marca +
                "\nCaracteristicas: " +obtenerCaracteristicas() +
                "\nStock: " + stock +"\n";
    }
}
