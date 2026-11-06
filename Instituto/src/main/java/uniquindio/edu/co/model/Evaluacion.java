package uniquindio.edu.co.model;

public interface Evaluacion {
    Calificacion calcularCalificacion(double notaBAse, String observaciones);
    String generarRetroalimentacion(Calificacion calificacion);
}
