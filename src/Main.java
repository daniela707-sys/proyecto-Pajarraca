

import modelo.BDinventario;
import modelo.BDproductos;
import vista.vista;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        vista v=new vista();
        v.conectar();
    }
}