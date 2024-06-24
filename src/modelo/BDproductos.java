package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BDproductos {
    private HashMap<Integer,productos> listaProductos=new HashMap<>();
    private String file="productos.json";
    public BDproductos(){
        this.leer();
    }

    public void leer(){
        try(FileReader leer=new FileReader(file)){
            Gson j=new Gson();
            Type tipo=new TypeToken<Map<Integer,productos>>(){}.getType();
            listaProductos=j.fromJson(leer,tipo);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void escribir(){
        Gson j =new GsonBuilder().setPrettyPrinting().create();
        String json=j.toJson(this.listaProductos);
        try (FileWriter escribir= new FileWriter(file)){
            escribir.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String agregar(productos p){
        this.leer();
        String mensaje="";
        boolean validar=true;
        for(Map.Entry<Integer,productos>i: listaProductos.entrySet()){
            if(i.getValue().getNombre().equals(p.getNombre())&&i.getValue().getColor().equals(p.getColor())){
                mensaje="este producto ya esta en la lista";
                validar=false;
                break;
            }
        }
        if(validar){
            BDinventario inventario=new BDinventario();
            for(Map.Entry<Integer,inventario>j:inventario.getBD().entrySet()){
                if(j.getValue().getNombre().equals(p.getNombre()) && j.getValue().getColor().equals(p.getColor())){
                    listaProductos.put(listaProductos.size()+1, p);
                    mensaje="se agrego exitosamente";
                    this.escribir();
                }else {
                    mensaje="no se encontro ese producto en el inventario";
                }
            }

        }
        return mensaje;
    }

    public String buscar(String categoria){
        this.leer();
        String mensaje="";
        for (Map.Entry<Integer,productos>i: listaProductos.entrySet()){
            if(i.getValue().getCategoria().equals(categoria)){
                HashMap<Integer,productos>nuevalista=new HashMap<>();
                nuevalista.put(i.getKey(),i.getValue());
                mensaje=nuevalista.toString();
            }else{
                mensaje="no se encontro esa categoria";
            }
        }
        return mensaje;
    }

    public String actualizar(String nombre, String color, productos p){
        this.leer();
        String mensaje="";
        boolean validar=false;
        Integer key=null;
        for(Map.Entry<Integer,productos>i:listaProductos.entrySet()){
            if(i.getValue().getNombre().equals(nombre) && i.getValue().getColor().equals(color)){
                validar = true;
                key=i.getKey();
                break;
            }
        }
        if(validar){
            BDinventario j=new BDinventario();
            for(Map.Entry<Integer,inventario>m:j.getBD().entrySet()){
                if(m.getValue().getNombre().equals(p.getNombre())){
                    listaProductos.put(key, p);
                    this.escribir();
                    mensaje="se actuaizo con exito";
                    break;
                }else{
                    mensaje="ese producto no se encuentra en inventario";
                    break;
                }
            }
        }else{
            mensaje="no se encontro el producto";
        }
        return mensaje;
    }

    public String eliminar(String nombre, String color){
        this.leer();
        String mensaje="";
        for(Map.Entry<Integer,productos>i: listaProductos.entrySet()){
            if(i.getValue().getNombre().equals(nombre)&&i.getValue().getColor().equals(color)){
                listaProductos.remove(i.getKey());
                this.escribir();
                mensaje="se elimino con exito";
                break;
            }else{
                mensaje="no se encontro el producto";
                break;
            }
        }
        return mensaje;
    }

    @Override
    public String toString() {
        return listaProductos.toString();
    }
}