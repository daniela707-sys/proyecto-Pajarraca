package GestionClase.BD_ClaseGestion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class BD_GC {
    public HashMap<Integer,Gestio_Clase> baseDatos_GC = new HashMap<>();

    public BD_GC() {
        this.leerJson();
    }

    public void leerJson(){
        try(FileReader leer = new FileReader("Gestion de Clase.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type tipo = new TypeToken<Map<Integer,Gestio_Clase>>(){}.getType();
            baseDatos_GC = gson.fromJson(leer,tipo);
        }catch (IOException e){
            System.out.println("Error json "+ e.getMessage());
        }
    }

    public void escribirJson(){
        try(FileWriter escribir = new FileWriter("Gestion de Clase.json")) {
            Gson gson = new Gson();
            String ingresarJson = gson.toJson(baseDatos_GC);
            escribir.write(ingresarJson);
        }catch (IOException e){
            System.out.println("Error json "+ e.getMessage());
        }
    }

    public boolean confirmarFecha(String fecha){
        Map<Boolean,String> dici = new HashMap<>();
        for(Map.Entry<Integer,Gestio_Clase> recorrer:baseDatos_GC.entrySet()){
            if(recorrer.getValue().getFechas().equals(fecha)){
                dici.put(false,"La fecha ya se encuntra registrada");
                return false;
            }
        }
        dici.put(true,"ok");
        return  true;
    }

    public boolean confirmarNumeroClase(int numero_clase){
        if (baseDatos_GC.containsKey(numero_clase)){
            return true;
        }else {
            return false;
        }
    }

    public String agregarClase(Gestio_Clase clase){
        baseDatos_GC.put(baseDatos_GC.size()+1,clase);
        this.escribirJson();
        return "Se agrego la clase para la fehca "+ clase.getFechas();
    }

    public String actualizarFecha(int numero_clase,String fecha){
        baseDatos_GC.get(numero_clase).setFechas(fecha);
        this.escribirJson();
        return "Se actualizo la fecha: "+fecha;
    }

    public String actualizarHora(int numero_clase, String horas){
        baseDatos_GC.get(numero_clase).setHorarios(horas);
        this.escribirJson();
        return "Se actualizo la hora: "+horas;
    }

    public String actualizarDescripcion(int numero_clase, String descripcion){
        baseDatos_GC.get(numero_clase).setDescricionClase(descripcion);
        this.escribirJson();
        return "Se actualizo la descripcion: "+descripcion;
    }

    public String actualizarPrecio(int numero_clase, float precio){
        baseDatos_GC.get(numero_clase).setPrecio(precio);
        this.escribirJson();
        return "Se actualizo el precio: "+precio;
    }

    public String actualizarPendiente(int numero_clase, boolean pendiente){
        baseDatos_GC.get(numero_clase).setClasePendiente(pendiente);
        this.escribirJson();
        if(pendiente){
            return "La clase para el dia "+baseDatos_GC.get(numero_clase).getFechas()+" se activo";
        }else {
            return "La clase para el dia "+baseDatos_GC.get(numero_clase).getFechas()+" se desactivo";
        }
    }

    public String actualizrClase(int numero_clase,Gestio_Clase clase){
        baseDatos_GC.put(numero_clase,clase);
        this.escribirJson();
        return "Se actualizo toda la informacion de la clase numero "+numero_clase;
    }

    public boolean confimarElimnarClase(String confirmar){
        confirmar.toLowerCase();
        if(confirmar.equals("si")){
            return  true;
        }else {
            return false;
        }
    }

    public String eliminarClase(int numero_clase){
        baseDatos_GC.remove(numero_clase);
        this.escribirJson();
        return "Se elemino exitosamente la clase";
    }






}


