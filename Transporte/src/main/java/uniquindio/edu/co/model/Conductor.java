package uniquindio.edu.co.model;

public class Conductor {
    //Atributos de la clase Conductor
    private int identificacion;
    private String nombre;
    private String licencia;
    private String telefono;

    /**
     * Metodo constructor de la clase Conductor
     * @param identificacion del conductor
     * @param nombre del conductor
     * @param licencia del conductor
     * @param telefono del conductor
     */
    public Conductor(int identificacion, String nombre, String licencia, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.licencia = licencia;
        this.telefono = telefono;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", licencia='" + licencia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
