package GestionClase.Vista;

import GestionClase.Controlador_ClaseGestion.Controlador_GC;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Vista_GC {
    public int opcion;
    public String datos;
    public float precio;
    public boolean pendiente;

    public int menuAdministrador(){
        JOptionPane.showMessageDialog(null,"GESTION DE CLASE","Mensjae",JOptionPane.INFORMATION_MESSAGE);
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Agregar Clase\n2-Actualizar Clase\n3-Eliminar Clase\n4-Mostrar Clase\n5-Salir"));
        while (opcion <=0 || opcion >5){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se encuentra en las opciones","Error",JOptionPane.ERROR_MESSAGE);
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Agregar Clase\n2-Actualizar Clase\n3-Eliminar Clase\n4-Mostrar Clase\n5-Salir"));
        }
        return opcion;
    }
    public int menuActualizar(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Elegi la opcion que desea ejecurar\n1-Actualizar Fecha\n2-Actualizar Hora\n3-Actualizar Descripciono\n4-Actualizar Precio\n5-Actualizar Clase Pendiente\n6-Salir","Opcion"));
        while ( opcion <= 0|| opcion>6){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se encuentra en las opciones","Error",JOptionPane.ERROR_MESSAGE);
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Elegi la opcion que desea ejecurar\n1-Actualizar Fecha\n2-Actualizar Hora\n3-Actualizar Descripciono\n4-Actualizar Precio\n5-Actualizar Clase Pendiente\n6-Salir","Opcion"));
        }
        return opcion;
    }


    public String capturarFechas(){
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String elegir_meses = (String) JOptionPane.showInputDialog(null,"Elegir el mes","MES",JOptionPane.PLAIN_MESSAGE,null,meses,meses[0]);
        if (elegir_meses != null){
            String[] dias = new String[31];
            for (int i = 0; i < 31; i++) {
                dias[i] = String.valueOf(i + 1);
            }
            String elegir_dias = (String) JOptionPane.showInputDialog(null,"Elegir el dia","DIAS",JOptionPane.PLAIN_MESSAGE,null,dias,dias[0]);
            if(elegir_dias !=null){
                datos = elegir_dias+"/"+elegir_meses+"/2024";
                return datos;
            }else {
                return datos;
            }
        }else{
            return datos;
        }
    }

    public String capturarHora(){
        LocalTime tiempo = null;
        try {
            String input = JOptionPane.showInputDialog(null, "Ingrese la hora (HH:mm:ss):");
            tiempo = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm:ss"));
            int horas = tiempo.getHour();
            int minutos = tiempo.getMinute();
            int segundos = tiempo.getSecond();
            datos = "Hora ingresada: " + horas + ":" + minutos + ":" + segundos;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de hora incorrecto. Ingrese en formato HH:mm:ss.");
            datos = null;
        }
        return datos;
    }

    public String capturarDescripcion(){
        datos = JOptionPane.showInputDialog(null,"Digite la descripcion de la clase");
        return datos;
    }

    public int captuarNumeroClase(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Elige el numero de la clase "));
        return opcion;
    }

    public float capturarPrecio(){
        precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Digite el precio de la clase"));
        return  precio;
    }

    public int capturarClasePendiente(){
        opcion = JOptionPane.showConfirmDialog(null,"Digite si la clase esta pendiente?");
        return opcion;
    }

    public String capturarConfirmarEliminacion(){
        datos = JOptionPane.showInputDialog(null,"¿Quieres Eliminar La Clase? 'Si' o 'No'");
        datos.toLowerCase();
        while (datos == "si" || datos == "no"){
            JOptionPane.showMessageDialog(null,"La opcion a elegir no puede ser diferente de 'Si' o 'No' ");
            datos = JOptionPane.showInputDialog(null,"¿Quieres Eliminar La Clase? 'Si' o 'No'");
        }
        return datos;
    }

    public void errorMensjae(String datos){
        JOptionPane.showMessageDialog(null,datos,"Error",JOptionPane.ERROR_MESSAGE);
    }
    public void informarMensjae(String datos){
        JOptionPane.showMessageDialog(null,datos,"Informar",JOptionPane.INFORMATION_MESSAGE);
    }

    public void Control(){
        Controlador_GC c = new Controlador_GC();
        c.Control();
    }
}
