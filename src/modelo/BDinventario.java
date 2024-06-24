package modelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BDinventario {
    private HashMap<Integer, inventario> BD = new HashMap<>();

    private static final String filePath = "inventarioPajarraca.json";

    public BDinventario() {
        this.readJson();
    }

    public void readJson() {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<Integer, inventario>>() {}.getType();
            BD = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public void escribirjson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(BD);
        try (FileWriter escribir = new FileWriter(filePath)) {
            escribir.write(json);
        } catch (IOException e) {
            System.err.println("Error writing JSON file: " + e.getMessage());
        }
    }

    public String agregar(inventario i) {
        String mensaje = "";
        boolean validar = true;
        this.readJson();

        for (Map.Entry<Integer, inventario> j : BD.entrySet()) {
            inventario inventory = j.getValue();
            if (inventory.getNombre().equals(i.getNombre()) && inventory.getColor().equals(i.getColor())) {
                validar = false;
                mensaje = "El producto ya existe";
                break;
            }
        }

        if (validar) {
            BD.put(BD.size() + 1, i);
            mensaje = "Se agregó exitosamente";
            this.escribirjson();
        }

        return mensaje;
    }

    public String actualizar(String nombre, String color, inventario i){
        this.readJson();
        String mensaje="";
        boolean validar=false;
        for(Map.Entry<Integer,inventario> j:BD.entrySet()){
            inventario inventory = j.getValue();
            if(inventory.getNombre().equals(nombre)&&inventory.getColor().equals(color)){
                BD.put(j.getKey(), i);
                mensaje="se actualizo con exito";
                validar=true;
                this.escribirjson();
                break;
            }
        }
        if(!validar){
            mensaje="no se encontro el producto que desea actualizar";
        }
        return mensaje;
    }
    public String actualizarStock(String nombre, String color, int stock){
        this.readJson();
        String mensaje="";
        boolean validar=false;
        for(Map.Entry<Integer,inventario> j:BD.entrySet()){
            inventario inventory = j.getValue();
            if(inventory.getNombre().equals(nombre)&&inventory.getColor().equals(color)){
                inventory.setStock(stock);
                BD.put(j.getKey(), inventory);
                mensaje="se actualizo con exito";
                validar=true;
                this.escribirjson();
                break;
            }
        }
        if(!validar){
            mensaje="no se encontro el producto que desea actualizar";
        }
        return mensaje;
    }

    public String eliminar(String nombre, String color){
        this.readJson();
        String mensaje="";
        boolean validar=false;
        for(Map.Entry<Integer,inventario> i:BD.entrySet()){
            inventario inventory = i.getValue();
            if(inventory.getNombre().equals(nombre)&&inventory.getColor().equals(color)){
                BD.remove(i.getKey());
                mensaje="se elimino con exito";
                validar=true;
                this.escribirjson();
                break;
            }
        }
        if(!validar){
            mensaje="no se encontro el producto que desea eliminar";
        }
        return mensaje;
    }

    public String buscar(String categoria){
        this.readJson();
        String mensaje="";
        boolean validar=false;
        for(Map.Entry<Integer,inventario> i:BD.entrySet()){
            inventario inventory = i.getValue();
            if(inventory.getCategoria().equals(categoria)){
                mensaje= inventory.toString();
                validar=true;
            }
        }
        if(!validar){
            mensaje="no se encontro la categoria";
        }
        return mensaje;
    }

    public String buscarnombre(String nombre){
        this.readJson();
        String mensaje="";
        boolean validar=false;
        for(Map.Entry<Integer,inventario> i:BD.entrySet()){
            inventario inventory = i.getValue();
            if(inventory.getNombre().equals(nombre)){
                mensaje= inventory.toString();
                validar=true;
            }
        }
        if(!validar){
            mensaje="no se encontro el producto";
        }
        return mensaje;
    }

    public HashMap<Integer, inventario> getBD() {
        return BD;
    }

    public void setBD(HashMap<Integer, inventario> BD) {
        this.BD = BD;
    }

    @Override
    public String toString() {
        return BD.toString();
    }
}