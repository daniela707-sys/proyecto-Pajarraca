package vista;

import controlador.controlador;
import modelo.inventario;
import modelo.productos;

import javax.swing.*;
import java.util.HashMap;
public class vista {
    public vista() {
    }
    public inventario i;
    public productos p;

    public int menu(){
        int op=0;
        String option=JOptionPane.showInputDialog("============MENU========\n1.inventario\n2.productos\n3.salir");
        op=Integer.parseInt(option);
        return op;
    }

    public int menu1(){
        int op=0;
        String option=JOptionPane.showInputDialog("============MENU========\n1.agregar\n2.mostrar\n3.buscar por categoria\n4.buscar por nombre\n5.actualizar\n6.actualizar stock\n7.borrar\n8.salir");
        op=Integer.parseInt(option);
        return op;
    }
    public int menu2(){
        int op=0;
        String option=JOptionPane.showInputDialog("============MENU========\n1.agregar\n2.mostrar\n3.buscar por categoria\n4.actualizar\n5.borrar\n6.salir");
        op=Integer.parseInt(option);
        return op;
    }

    public inventario agregar(){
        String categoria=JOptionPane.showInputDialog("ingrese la categoria del producto");
        String nombre=JOptionPane.showInputDialog("ingrese el nombre del producto");
        String color=JOptionPane.showInputDialog("ingrese el color del producto");
        String marca=JOptionPane.showInputDialog("ingrese la marca del producto");
        String input = JOptionPane.showInputDialog(null,
                "Ingrese las nuevas características del producto, estas deben ser específicas y separadas por comas:",
                "Ingresar características", JOptionPane.INFORMATION_MESSAGE);
        String[] caracteristicas = input.strip().split(",");
        String cantidad=JOptionPane.showInputDialog("ingrese la cantidad del producto en stock");
        int stock=Integer.parseInt(cantidad);
        inventario i =new inventario(categoria,nombre,color,marca,caracteristicas,stock);
        return i;
    }
    public productos agregar2(){
        String categoria=JOptionPane.showInputDialog("ingrese la categoria del producto");
        String nombre=JOptionPane.showInputDialog("ingrese el nombre del producto");
        String color=JOptionPane.showInputDialog("ingrese el color del producto");
        String marca=JOptionPane.showInputDialog("ingrese la marca del producto");
        String descripcion=JOptionPane.showInputDialog("ingrese la descripcion que desea del producto");
        String precio=JOptionPane.showInputDialog("ingrese el precio del producto");
        int cop=Integer.parseInt(precio);
        productos h=new productos(categoria,nombre,color,marca,descripcion,cop);
        return h;
    }
    public String nombre(){
        String nombre=JOptionPane.showInputDialog("ingrese el nombre del producto");
        return nombre;
    }
    public String color(){
        String color=JOptionPane.showInputDialog("ingrese el color del producto");
        return color;
    }
    public int stock(){
        String cantidad=JOptionPane.showInputDialog("ingrese la cantidad del producto en stock");
        int stock=Integer.parseInt(cantidad);
        return stock;
    }
    public String categoria(){
        String categoria=JOptionPane.showInputDialog("ingrese la categoria del producto");
        return categoria;
    }
    public void imprimir(String texto){
        JOptionPane.showConfirmDialog(null,texto);
    }

    public String nombreproductos(){
        String caracteristicas=JOptionPane.showInputDialog("ingrese el nombre del producto que va a ingresar, recuerde que este producto tiene que estar posteriormente registrado en el inventario");
        return caracteristicas;
    }
    public String caracteristicas(){
        String caracteristicas=JOptionPane.showInputDialog("ingrese las caracteristicas del producto");
        return caracteristicas;
    }
    public float precio(){
        String precio=JOptionPane.showInputDialog("ingrese el precio del producto");
        int preci=Integer.parseInt(precio);
        return  preci;
    }
    public void conectar(){
        controlador c=new controlador();
        c.ejecucion();
    }
}
