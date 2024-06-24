package Proyecto_Json.DatosUsuario.Vista_DatosUsuario;

import Proyecto_Json.DatosUsuario.Controlador.Controlador_DatosUsuario;

import javax.swing.*;

public class VistaDatosUsuario {

    public String leer_datos;
    public int opcion;

    public VistaDatosUsuario(){

    }

    public int menuInicio(){
        opcion= Integer.parseInt(JOptionPane.showInputDialog("=========================\n1-Iniciar Sesion\n2-Crear Cuenta\n3-Salir\n========================="));
        while (opcion <= 0 || opcion > 3){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se ecuentra en el sistema","ERROR",JOptionPane.ERROR_MESSAGE);
            opcion= Integer.parseInt(JOptionPane.showInputDialog("=========================\n1-Iniciar Sesion\n2-Crear Cuenta\n3-Salir\n========================="));
        }
        return opcion;
    }

    public int menuAdministrador(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1-Mostrar Informacion\n2-Mostrar Usuarios\n3-Consultar Usuario\n4-Permisos De Administrador\n5-Actualizar Informacion\n6-Eliminar Cuenta\n\n7-Gestion de Clases\n8.gestion de inventario y productos\n9-Salir"));
        while (opcion <=0 || opcion>8){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se ecuentra en el sistema","ERROR",JOptionPane.ERROR_MESSAGE);
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1-Mostrar Informacion\n2-Mostrar Usuarios\n3-Consultar Usuario\n4-Permisos De Administrador\n5-Actualizar Informacion\n6-Eliminar Cuenta\n7-Salir"));

        }
        return opcion;
    }

    public int menuPermisosAdministrador(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Dar Permisos De Administrador\n2-Quitar Permisos de Administrador\n3-Salir"));
        while (opcion<=0 || opcion > 3){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se ecuentra en el sistema","ERROR",JOptionPane.ERROR_MESSAGE);
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Dar Permisos De Administrador\n2-Quitar Permisos de Administrador\n3-Salir"));
        }
        return opcion;
    }

    public int menuUsuario(){
        opcion  = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Mostrar Usuario\n2-Actualizar Informacion\n3-Eliminar Cuenta\n4-Salir"));
        while (opcion <= 0 || opcion > 4){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se ecuentra en el sistema","ERROR",JOptionPane.ERROR_MESSAGE);
            opcion  = Integer.parseInt(JOptionPane.showInputDialog(null,"1-Mostrar Usuario\n2-Actualizar Informacion\n3-Eliminar Cuenta\n4-Salir"));
        }
        return opcion;
    }

    public int menuActualizar(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"DATOS QUE DESEE ACTUALIZAR\n1-Nombre\n2-Correo Electronico\n3-Numero Telefonico\n4-Contraseña\n5-Todos los datos\n6-Salir"));
        while (opcion <= 0 || opcion >6){
            JOptionPane.showMessageDialog(null,"La opcion elegida no se ecuentra en el sistema","ERROR",JOptionPane.ERROR_MESSAGE);
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"DATOS QUE DESEE ACTUALIZAR\n1-Nombre\n2-Correo Electronico\n3-Numero Telefonico\n4-Contraseña\n5-Todos los datos\n6-Salir"));
        }
        return opcion;
    }




    public boolean eliminar(){
        boolean eliminar;
        leer_datos = (JOptionPane.showInputDialog(null,"¿Estas seguro de eliminar la cuenta?"));
        while (!leer_datos.equals("s") && !leer_datos.equals("n")){
            JOptionPane.showMessageDialog(null,"Solo puedes eligis 's' o 'n'","ERROR",JOptionPane.ERROR_MESSAGE);
            leer_datos = (JOptionPane.showInputDialog(null,"¿Estas seguro de eliminar la cuenta?"));
        }
        if (leer_datos.equals("s")){
            eliminar = true;
        }else {
            eliminar = false;
        }
        return eliminar;

    }

    public String capturarNombre(){
        leer_datos = JOptionPane.showInputDialog("Ingrese el nombre");
        while (leer_datos.equals("")){
            JOptionPane.showMessageDialog(null,"Rellene los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
            leer_datos = JOptionPane.showInputDialog("Ingrese el nombre");
        }
        return leer_datos;
    }

    public String capturarCorreo(){
        leer_datos = JOptionPane.showInputDialog("Ingrese el correo electronico");
        while (leer_datos.equals("")){
            JOptionPane.showMessageDialog(null,"Rellene los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
            leer_datos = JOptionPane.showInputDialog("Ingrese el correo electronico");
        }
        return leer_datos;
    }

    public String capturarNumeroTelefonico(){
        leer_datos = JOptionPane.showInputDialog("Ingrese el numero telefonico");
        while (leer_datos.equals("")){
            JOptionPane.showMessageDialog(null,"Rellene los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
            leer_datos = JOptionPane.showInputDialog("Ingrese el numero telefonico");
        }
        return leer_datos;
    }

    public String capturarPassword(){
        leer_datos = JOptionPane.showInputDialog("Ingrese la contraseña");
        while (leer_datos.equals("")){
            JOptionPane.showMessageDialog(null,"Rellene los datos solicitados","Error",JOptionPane.ERROR_MESSAGE);
            leer_datos = JOptionPane.showInputDialog("Ingrese la contraseña");
        }
        return leer_datos;
    }

    public void imprimir(String datos){
        JOptionPane.showInputDialog(datos);
    }

    public void mostrarMensaje(String datos){
        JOptionPane.showMessageDialog(null, datos, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarError(String datos){
        JOptionPane.showMessageDialog(null, datos, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void Control(){
        Controlador_DatosUsuario c = new Controlador_DatosUsuario();
        c.Control();
    }

}
