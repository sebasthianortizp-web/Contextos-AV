package uniquindio.edu.co.model;

public class ExposicionOral implements Evaluacion{
    //Atributos de la clase ExposicionOral
    private int duracionMinutos;

    /**
     * Metodo constructor de la clase ExposicionOral
     * @param duracionMinutos de la explosicion
     */
    public ExposicionOral(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public Calificacion calcularCalificacion(double notaBAse, String observaciones) {
        return new Calificacion(notaBAse, "2026-06-06", observaciones);
    }

    @Override
    public String generarRetroalimentacion(Calificacion calificacion) {
        return "Retroalimentacion Exposición Oral: Desempeño en los "+duracionMinutos+" minutos de presentación evaluado en: "+calificacion.valorNumerico();
    }
}
