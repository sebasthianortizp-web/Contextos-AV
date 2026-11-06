package uniquindio.edu.co.model;

public class Asignatura {
    //Atributos de la clase Asignatura
    private int codigo;
    private String nombre;
    private int numeroCreditos;

    /**
     * Metodo Constructor de la clase Asignatura
     * @param codigo de la asignatura
     * @param nombre de la asignatura
     * @param numeroCreditos de la asignatura
     */
    public Asignatura(int codigo, String nombre, int numeroCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroCreditos = numeroCreditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", numeroCreditos=" + numeroCreditos +
                '}';
    }
}
