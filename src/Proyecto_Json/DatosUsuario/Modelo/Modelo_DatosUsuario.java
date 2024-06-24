package DatosUsuario.Modelo;

public class Modelo_DatosUsuario {
    public String nombre;
    public String correo;
    public String numero_telefonico;
    public String contrasena;
    public boolean rol;

    public Modelo_DatosUsuario(){

    }

    public Modelo_DatosUsuario(String nombre, String correo, String numero_telefonico, String contrasena, boolean rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.numero_telefonico = numero_telefonico;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public void permisoUsuario(){
        setAdministrador(false);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getAdministrador() {
        return rol;
    }

    public void setAdministrador(boolean rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "\nNombre = " + nombre +
                "\nCorreo = " + correo +
                "\nNumero_telefonico = " + numero_telefonico +
                "\nContrasena = " + contrasena +
                "\nPermisos = " + rol +
                '\n';
    }
}
