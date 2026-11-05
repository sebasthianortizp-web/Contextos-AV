package uniquindio.edu.co.model;

public class Persona {
    // Atributos de la clas persona
    private int documento;
    private String nombre;
    private String correoElectronico;
    private int telefono;

    /**
     * Metodo constructor de la clase persona
     * @param documento de la persona
     * @param nombre de la persona
     * @param correoElectronico de la persona
     * @param telefono de la persona
     */
    public Persona( int documento, String nombre, String correoElectronico, int telefono){
        this.documento = documento;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
