package uniquindio.edu.co.model;

public class ExamenEscrito implements Evaluacion {
    //Atributos de la clase evaluaciones
    private int numeroPreguntas;

    /**
     * Metodo constructor de la clase ExamenEscrito
     * @param numeroPreguntas del examen escrito
     */
    public ExamenEscrito(int numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }
    @Override
    public Calificacion calcularCalificacion(double notaBAse, String observaciones) {
        return new Calificacion(notaBAse, "2026-06-06", observaciones);
    }

    @Override
    public String generarRetroalimentacion(Calificacion calificacion) {
        return "Retroalimentación Examen Escrito: La nota final obtenida según la revisión de las " + numeroPreguntas+ " preguntas es: " + calificacion.valorNumerico();
    }

    @Override
    public String toString() {
        return "ExamenEscrito{" +
                "numeroPreguntas=" + numeroPreguntas +
                '}';
    }
}
