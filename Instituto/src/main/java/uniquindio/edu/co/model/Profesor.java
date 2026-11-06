package uniquindio.edu.co.model;

public class Profesor extends Persona{
    //Atributos de la clase Profesor
    private String categoria;
    private String areaFormacion;

    /**
     * Metodo constructor de la classe Profesor
     *
     * @param identificacion      del profesor
     * @param nombre              del profesor
     * @param correoElectronico   del profesor
     * @param telefono            del profesor
     * @param codigoInstitucional del profesor
     * @param categoria           del profesor
     */
    public Profesor(int identificacion, String nombre, String correoElectronico, int telefono, String codigoInstitucional, String categoria) {
        super(identificacion, nombre, correoElectronico, telefono);
        this.categoria = categoria;
        this.areaFormacion = areaFormacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaFormacion() {
        return areaFormacion;
    }

    public void setAreaFormacion(String areaFormacion) {
        this.areaFormacion = areaFormacion;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "identificacion='" + getIdentificacion() +
                ", nombre='" + getNombre() + '\'' +
                ", categoria='" + categoria + '\'' +
                ", areaFormacion='" + areaFormacion + '\'' +
                '}';
    }
}
