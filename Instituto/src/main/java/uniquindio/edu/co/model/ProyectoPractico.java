package uniquindio.edu.co.model;

public class ProyectoPractico implements Evaluacion {
    //Atributos de la clase
    private String repositorioUrl;

    /**
     * Metodo COntructor de la clase ProyetoPractico
     * @param repositorioUrl del proyecto
     */
    public ProyectoPractico(String repositorioUrl) {
        this.repositorioUrl = repositorioUrl;
    }

    @Override
    public Calificacion calcularCalificacion(double notaBAse, String observaciones) {
        return new Calificacion(notaBAse, "2026-06-06", observaciones);
    }

    @Override
    public String generarRetroalimentacion(Calificacion calificacion) {
        return "Retroalimentacion Proyecto Práctico: Evaluación del repositorio ("+repositorioUrl+") completada con la nota: "+calificacion.valorNumerico();
    }
}
