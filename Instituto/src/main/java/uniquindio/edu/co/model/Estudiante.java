package uniquindio.edu.co.model;

public class Estudiante extends Persona{
    //Atributo de las clase Estudiante
    private String codigoInstitucional;
    private String programaAcademico;

    /**
     * Metodo constructor de la clase Estudiante
     * @param identificacion del estudiante
     * @param nombre del estudiante
     * @param correoElectronico del estudiante
     * @param telefono del estudiante
     * @param codigoInstitucional del estudiante
     * @param programaAcademico del estudiante
     */
    public Estudiante(int identificacion, String nombre, String correoElectronico, int telefono, String codigoInstitucional, String programaAcademico) {
        super(identificacion, nombre, correoElectronico, telefono);
        this.codigoInstitucional = codigoInstitucional;
        this.programaAcademico = programaAcademico;
    }

    public String getCodigoInstitucional() {
        return codigoInstitucional;
    }

    public void setCodigoInstitucional(String codigoInstitucional) {
        this.codigoInstitucional = codigoInstitucional;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "identificacion='" + getIdentificacion() +
                ", nombre='" + getNombre() + '\'' +
                ", codigoInstitucional='" + codigoInstitucional + '\'' +
                ", programaAcademico='" + programaAcademico + '\'' +
                '}';
    }
}
