package GestionClase.Controlador_ClaseGestion;

import GestionClase.BD_ClaseGestion.BD_GC;
import GestionClase.BD_ClaseGestion.Gestio_Clase;
import GestionClase.Vista.Vista_GC;

import javax.swing.*;

public class Controlador_GC {
    public Vista_GC vistaGc;
    public Gestio_Clase gestioClase;
    public BD_GC bdGc;


    public Controlador_GC(Vista_GC vistaGc, Gestio_Clase gestioClase, BD_GC bdGc) {
        this.vistaGc = vistaGc;
        this.gestioClase = gestioClase;
        this.bdGc = bdGc;
    }

    public Controlador_GC() {
    }


    Vista_GC v =new Vista_GC();
    BD_GC bd = new BD_GC();
    Gestio_Clase gc = new Gestio_Clase();


    public void Control(){
        int opcion = 0;
        while(opcion != 5){
            opcion = v.menuAdministrador();
            switch (opcion){
                case (1):
                    String fecha,hora,descripcion;
                    float precio;
                    boolean pendiente;
                    int datoPendiente;
                    fecha = v.capturarFechas();
                    if(bd.confirmarFecha(fecha)){
                        if (fecha == null){
                            v.informarMensjae("Se cancelo el programa");
                            break;
                        }
                        if ((hora=v.capturarHora()) == null){
                            v.informarMensjae("Se cancelo el programa");
                            break;
                        }
                        if ((descripcion = v.capturarDescripcion()) == null){
                            v.informarMensjae("Se cancelo el programa");
                            break;
                        }
                        precio = v.capturarPrecio();
                        datoPendiente = v.capturarClasePendiente();
                        if(datoPendiente == JOptionPane.YES_OPTION){
                            pendiente = true;
                            v.informarMensjae(bd.agregarClase(new Gestio_Clase(fecha,hora,descripcion,precio,pendiente)));
                        } else if (datoPendiente == JOptionPane.NO_OPTION) {
                            pendiente = false;
                            v.informarMensjae(bd.agregarClase(new Gestio_Clase(fecha,hora,descripcion,precio,pendiente)));
                        } else if (datoPendiente == JOptionPane.CANCEL_OPTION || datoPendiente == JOptionPane.CLOSED_OPTION) {
                            v.informarMensjae("El usuario cancelo el programa");
                        }
                    }else {
                        v.errorMensjae("La fecha ya se encunetra registrada para otra clase");
                    }
                    break;
                case (2):
                    int numero_clase = v.captuarNumeroClase();
                    if(bd.confirmarNumeroClase(numero_clase)){
                        int opcion_actualizar = 0;
                        while (opcion_actualizar !=6){
                            opcion_actualizar = v.menuActualizar();
                            switch (opcion_actualizar){
                                case (1):
                                    fecha = v.capturarFechas();
                                    if(fecha != null){
                                        v.informarMensjae(bd.actualizarFecha(numero_clase,fecha));
                                    }else {
                                        v.informarMensjae("Se cancelo el programa");
                                    }
                                    break;
                                case(2):
                                    hora = v.capturarHora();
                                    if(hora != null){
                                        v.informarMensjae(bd.actualizarHora(numero_clase,hora));
                                    }else {
                                        v.informarMensjae("Se cancelo el programa");
                                    }
                                    break;
                                case (3):
                                    descripcion= v.capturarDescripcion();
                                    if (descripcion !=null){
                                        v.informarMensjae(bd.actualizarDescripcion(numero_clase,descripcion));
                                    }else {
                                        v.informarMensjae("Se cancelo el programa");
                                    }
                                    break;
                                case(4):
                                    precio = v.capturarPrecio();
                                    v.informarMensjae(bd.actualizarPrecio(numero_clase,precio));
                                    break;
                                case (5):
                                    datoPendiente = v.capturarClasePendiente();
                                    if (datoPendiente == JOptionPane.YES_OPTION){
                                        pendiente = true;
                                        v.informarMensjae(bd.actualizarPendiente(numero_clase,pendiente));
                                    } else if (datoPendiente == JOptionPane.NO_OPTION) {
                                        pendiente = false;
                                        v.informarMensjae(bd.actualizarPendiente(numero_clase,pendiente));
                                    } else if (datoPendiente == JOptionPane.CANCEL_OPTION) {
                                        v.informarMensjae("Se cancelo el programa");
                                    }
                                    break;
                            }
                        }
                    }else {
                        v.errorMensjae("El numero de la clase no se encuentra registrado en el programa");
                    }
                    break;
                case(3):
                    numero_clase = v.captuarNumeroClase();
                    if (bd.confirmarNumeroClase(numero_clase)) {
                        if (bd.confimarElimnarClase(v.capturarConfirmarEliminacion())) {
                            v.informarMensjae(bd.eliminarClase(numero_clase));
                        }else {
                            v.informarMensjae("Se cancelo el proceso");
                        }
                    }else {
                        v.errorMensjae("El numero de la clase no se encuentra registrado en el programa");
                    }
                    break;
                case(4):
                    v.informarMensjae(bd.baseDatos_GC.toString());
                    break;
            }
        }
    }

}
