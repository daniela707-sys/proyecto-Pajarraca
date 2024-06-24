package DatosUsuario.BD_DatosUsuario;

import DatosUsuario.Modelo.Modelo_DatosUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class BdDatosUsuario {
    public HashMap<Integer, Modelo_DatosUsuario> baseDatos = new HashMap<>();
    public Modelo_DatosUsuario cuenta;
    public int clave;

    public Gson gson=new GsonBuilder().setPrettyPrinting().create();
    public String nombre_achirvo = ".idea/Datos de Usuario.json";


    public BdDatosUsuario(){
        this.leerJson();
    }

    public void leerJson(){
        try (FileReader reader = new FileReader(nombre_achirvo)) {
            Type type = new TypeToken<Map<Integer,Modelo_DatosUsuario>>() {}.getType();
            baseDatos = gson.fromJson(reader,type);
        }catch (IOException e){
            System.out.printf("Datos" + e.getMessage());
        }
    }

    public void escribirJson(){
        String json_escribir =gson.toJson(baseDatos);
        try (FileWriter escribir = new FileWriter(nombre_achirvo) ){
            escribir.write(json_escribir);
        }catch (IOException e){
            System.out.printf("Datos" + e.getMessage());
        }
    }

    public String mostrarInformacion(){
        return baseDatos.toString();
    }

    public String mostrarCuenta(){
        return cuenta.toString();
    }

    public Map<Boolean,String> consultarUsuario(String nombre_correo){
        Map<Boolean,String> datos = new HashMap<>();
        for(Map.Entry<Integer,Modelo_DatosUsuario> recorrer:baseDatos.entrySet()){
            if(recorrer.getValue().getNombre().equals(nombre_correo) || recorrer.getValue().getCorreo().equals(nombre_correo)){
                datos.put(true,recorrer.toString());
                return datos;
            }
        }
        datos.put(false,"No se encontro el usuario");
        return datos;
    }

    public Boolean permisosAdministrador(String nombre_correo){
        Map<Boolean,String> datos = new HashMap<>();
        for(Map.Entry<Integer,Modelo_DatosUsuario> recorrer: baseDatos.entrySet()){
            if(recorrer.getValue().getNombre().equals(nombre_correo) || recorrer.getValue().getCorreo().equals(nombre_correo)){
                recorrer.getValue().setAdministrador(true);
                this.escribirJson();
                return true;
            }
        }
        return false;
    }

    public Boolean quitarPermisos(String nombre_correo){
        Map<Boolean,String> datos = new HashMap<>();
        for(Map.Entry<Integer,Modelo_DatosUsuario> recorrer: baseDatos.entrySet()){
            if(recorrer.getValue().getNombre().equals(nombre_correo) || recorrer.getValue().getCorreo().equals(nombre_correo)){
                recorrer.getValue().setAdministrador(false);
                this.escribirJson();
                return true;
            }
        }
        return false;
    }

    public String actualizarNombre(String nombre){
        cuenta.setNombre(nombre);
        baseDatos.get(clave).setNombre(nombre);
        this.escribirJson();
        return "Se actualizo el nombre exitosamente";
    }

    public String actualizarCorreo(String correo){
        cuenta.setCorreo(correo);
        baseDatos.get(clave).setCorreo(correo);
        this.escribirJson();
        return "Se actualizo el correo exitosamente";
    }

    public String actualizarNumeroTelefonico(String numero){
        cuenta.setNumero_telefonico(numero);
        baseDatos.get(clave).setNumero_telefonico(numero);
        this.escribirJson();
        return "Se actualizo el numero exitosamnete exitosamente";
    }

    public String actualizarPassword(String password){
        cuenta.setContrasena(password);
        baseDatos.get(clave).setContrasena(password);
        this.escribirJson();
        return "Se actualizo la contraseña exitosamente";
    }

    public String actualizarCuenta(Modelo_DatosUsuario usuario){
        cuenta = usuario;
        baseDatos.put(clave,cuenta);
        this.escribirJson();
        return "Se actualizo toda la informacion de la cuenta exitosamente";
    }


    public String eliminarCuenta(){
        baseDatos.remove(clave);
        this.escribirJson();
        return "Se elimino exitosamnete";
    }

    public Map<Boolean,String> insertarDatos(Modelo_DatosUsuario usuario){
        Map<Boolean,String> devolver = new HashMap<>();
        for(Map.Entry<Integer,Modelo_DatosUsuario> recorrer : baseDatos.entrySet()){
            if(recorrer.getValue().getCorreo().equals(usuario.getCorreo())){
                devolver.put(false,"El correo electronico ya se encuentra registrado");
                return devolver;
            } else if (recorrer.getValue().getNumero_telefonico().equals(usuario.getNumero_telefonico())){
                devolver.put(false,"El numero telefonico ya se encuentra registrado");
                return devolver;
            } else if (recorrer.getValue().getContrasena().equals(usuario.getContrasena())){
                devolver.put(false,"La contraseña ya se encuentra registrado");
                return devolver;
            }
        }
        devolver.put(true,"Se agrego exitosamnete");
        baseDatos.put(baseDatos.size()+1,usuario);
        this.escribirJson();
        return devolver;
    }

    public boolean iniciarSesion(String nombre_correo,String password){
        System.out.println(baseDatos);
        for(Map.Entry<Integer,Modelo_DatosUsuario> recorrer: baseDatos.entrySet()){
            if((recorrer.getValue().getNombre().equals(nombre_correo) || recorrer.getValue().getCorreo().equals(nombre_correo)) && recorrer.getValue().getContrasena().equals(password)){
                cuenta = recorrer.getValue();
                clave = recorrer.getKey();
                return true;
            }
        }
        return false;
    }

    public boolean verificarPermisos(){
        return cuenta.getAdministrador();
    }


}
