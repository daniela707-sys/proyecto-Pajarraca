package Proyecto_Json.DatosUsuario.Controlador;

import DatosUsuario.BD_DatosUsuario.BdDatosUsuario;
import DatosUsuario.Modelo.Modelo_DatosUsuario;
import Proyecto_Json.DatosUsuario.Vista_DatosUsuario.VistaDatosUsuario;
import Proyecto_Json.GestionClase.Main_GestionClase;
import GestionClase.Vista.Vista_GC;
import java.util.HashMap;
import java.util.Map;
import vista.vista;
public class Controlador_DatosUsuario extends Vista_GC  {

    public Modelo_DatosUsuario modeloDatosUsuario;
    public BdDatosUsuario bdDatosUsuario;
    public VistaDatosUsuario vistaDatosUsuario;

    public vista vista;
    public Controlador_DatosUsuario(Modelo_DatosUsuario modeloDatosUsuario, BdDatosUsuario bdDatosUsuario, VistaDatosUsuario vistaDatosUsuario) {
        this.modeloDatosUsuario = modeloDatosUsuario;
        this.bdDatosUsuario = bdDatosUsuario;
        this.vistaDatosUsuario = vistaDatosUsuario;
    }
    public  Controlador_DatosUsuario(){

    }

    public String nombre;
    public String correo;
    public String numero_telefonico;
    public String contraseña;



    BdDatosUsuario bd = new BdDatosUsuario();
    Modelo_DatosUsuario md = new Modelo_DatosUsuario();
    VistaDatosUsuario v = new VistaDatosUsuario();

    public void Control(){
        int opcion = 0;
        while (opcion != 3){
            opcion = v.menuInicio();
            switch (opcion){
                case(1):
                    nombre = v.capturarNombre();
                    contraseña = v.capturarPassword();
                    if(bd.iniciarSesion(nombre,contraseña)){
                        if(bd.verificarPermisos()){
                            opcion = 0;
                            while (opcion != 8){
                                opcion = v.menuAdministrador();
                                switch (opcion){
                                    case (1):
                                        v.mostrarMensaje(bd.mostrarInformacion());
                                        break;
                                    case (2):
                                        v.mostrarMensaje(bd.mostrarCuenta());
                                        break;
                                    case (3):
                                        nombre= v.capturarNombre();
                                        Map<Boolean,String> datos = new HashMap<>();
                                        datos = bd.consultarUsuario(nombre);
                                        if(datos.containsKey(true)){
                                            v.mostrarMensaje(datos.get(true));
                                        }else {
                                            v.mostrarError(datos.get(false));
                                        }
                                        break;
                                    case (4):
                                        opcion = v.menuPermisosAdministrador();
                                        switch (opcion){
                                            case (1):
                                                nombre = v.capturarNombre();
                                                if(bd.permisosAdministrador(nombre)){
                                                    v.mostrarMensaje("Se dio el admin al usuario exitosamente");
                                                }else {
                                                    v.mostrarError("No se encontro el usuario");
                                                }
                                                break;
                                            case (2):
                                                nombre = v.capturarNombre();
                                                if(bd.quitarPermisos(nombre)){
                                                    v.mostrarMensaje("Se quito el admin al usuario exitosamente");
                                                }else {
                                                    v.mostrarError("No se encontro el usuario");
                                                }
                                                break;
                                        }
                                        break;
                                    case (5):
                                        opcion = v.menuActualizar();
                                        switch (opcion){
                                            case (1):
                                                nombre= v.capturarNombre();
                                                v.mostrarMensaje(bd.actualizarNombre(nombre));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case (2):
                                                correo = v.capturarCorreo();
                                                v.mostrarMensaje(bd.actualizarCorreo(correo));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(3):
                                                numero_telefonico = v.capturarNumeroTelefonico();
                                                v.mostrarMensaje(bd.actualizarNumeroTelefonico(numero_telefonico));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(4):
                                                contraseña= v.capturarPassword();
                                                v.mostrarMensaje(bd.actualizarPassword(contraseña));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(5):
                                                nombre = v.capturarNombre();
                                                correo = v.capturarCorreo();
                                                numero_telefonico = v.capturarNumeroTelefonico();
                                                contraseña = v.capturarPassword();
                                                v.mostrarMensaje(bd.actualizarCuenta(new Modelo_DatosUsuario(nombre,correo,numero_telefonico,contraseña,bd.cuenta.getAdministrador())));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                        }
                                        break;
                                    case (6):
                                        Boolean eligir = v.eliminar();
                                        if(eligir){
                                            v.mostrarMensaje(bd.eliminarCuenta());
                                            opcion = 7;
                                        }else {
                                            v.mostrarMensaje("Se cancelo la eliminacion de la cuenta");
                                        }
                                        break;
                                    case (7):
                                        super.Control();
                                        break;
                                    case (8):
                                        super.conectarProductosYProyectos();
                                        break;
                                }
                            }
                        }else {
                            opcion = 0;
                            while (opcion !=  4){
                                opcion = v.menuUsuario();
                                switch (opcion){
                                    case (1):
                                        v.mostrarMensaje(bd.mostrarCuenta());
                                        break;
                                    case (2):
                                        opcion = v.menuActualizar();
                                        switch (opcion){
                                            case (1):
                                                nombre= v.capturarNombre();
                                                v.mostrarMensaje(bd.actualizarNombre(nombre));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case (2):
                                                correo = v.capturarCorreo();
                                                v.mostrarMensaje(bd.actualizarCorreo(correo));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(3):
                                                numero_telefonico = v.capturarNumeroTelefonico();
                                                v.mostrarMensaje(bd.actualizarNumeroTelefonico(numero_telefonico));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(4):
                                                contraseña= v.capturarPassword();
                                                v.mostrarMensaje(bd.actualizarPassword(contraseña));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                            case(5):
                                                nombre = v.capturarNombre();
                                                correo = v.capturarCorreo();
                                                numero_telefonico = v.capturarNumeroTelefonico();
                                                contraseña = v.capturarPassword();
                                                v.mostrarMensaje(bd.actualizarCuenta(new Modelo_DatosUsuario(nombre,correo,numero_telefonico,contraseña,bd.cuenta.getAdministrador())));
                                                v.mostrarMensaje(bd.mostrarCuenta());
                                                break;
                                        }
                                        break;
                                    case (3):
                                        Boolean eligir = v.eliminar();
                                        if(eligir){
                                            v.mostrarMensaje(bd.eliminarCuenta());
                                        }else {
                                            v.mostrarMensaje("Se cancelo la eliminacion de la cuenta");
                                        }
                                        break;
                                }
                            }
                        }
                    }else {
                        v.mostrarError("El nombre o contraseña son incorrectos");
                    }
                    break;
                case (2):
                    nombre = v.capturarNombre();
                    correo = v.capturarCorreo();
                    numero_telefonico = v.capturarNumeroTelefonico();
                    contraseña = v.capturarPassword();
                    Map<Boolean,String> datos = new HashMap<>();
                    datos = bd.insertarDatos(new Modelo_DatosUsuario(nombre,correo,numero_telefonico,contraseña,false));
                    if(datos.containsKey(true)){
                        v.mostrarMensaje(datos.get(true));
                    } else if (datos.containsKey(false)) {
                        v.mostrarError(datos.get(false));
                    }
                    break;
            }

        }

    }

}
