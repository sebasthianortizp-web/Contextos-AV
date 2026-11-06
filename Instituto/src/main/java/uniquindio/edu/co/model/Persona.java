package uniquindio.edu.co.model;

public class Persona {
    //Atributos de la clase Persona
    private int identificacion;
    private String nombre;
    private String correoElectronico;
    private int telefono;

    /**
     * Metodo constructor de la clase Persona
     * @param identificacion de la persona
     * @param nombre de la persona
     * @param correoElectronico de la persona
     * @param telefono de la persona
     */
    public Persona(int identificacion, String nombre, String correoElectronico, int telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
