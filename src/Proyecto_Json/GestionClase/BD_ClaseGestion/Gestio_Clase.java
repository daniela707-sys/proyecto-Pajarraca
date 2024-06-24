package GestionClase.BD_ClaseGestion;

public class Gestio_Clase {
    public String fechas;
    public String horarios;
    public String descricionClase;
    public float precio;
    public boolean clasePendiente;

    public Gestio_Clase(){

    }

    public Gestio_Clase(String fechas, String horarios, String descricionClase, float precio, boolean clasePendiente) {
        this.fechas = fechas;
        this.horarios = horarios;
        this.descricionClase = descricionClase;
        this.precio = precio;
        this.clasePendiente = clasePendiente;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getDescricionClase() {
        return descricionClase;
    }

    public void setDescricionClase(String descricionClase) {
        this.descricionClase = descricionClase;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean getClasePendiente() {
        return clasePendiente;
    }

    public void setClasePendiente(boolean clasePendiente) {
        this.clasePendiente = clasePendiente;
    }

    @Override
    public String toString() {
        return "\nDescricion: " + descricionClase +
                "\nFecha: " + fechas +
                "\nHorario: " + horarios +
                "\nPrecio: " + precio +"$"+
                '\n';
    }


}
