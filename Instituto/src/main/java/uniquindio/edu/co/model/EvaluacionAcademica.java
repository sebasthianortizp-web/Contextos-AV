package uniquindio.edu.co.model;

public class EvaluacionAcademica {
    //Atributos de la clase EvaluacionAcademica
    private int codigo;
    private String nombre;
    private double porcentaje;
    private String fechaRealizacion;
    private EstadoEvaluacion estado;
    private Evaluacion mecanismoEvaluacion;
    private Calificacion calificacion;

    /**
     * Metodo constructor de la clase EvaluacionAcademica
     * @param codigo de la evaluacion
     * @param nombre de la evaluacion
     * @param porcentaje de la evaluacion
     * @param fechaRealizacion de la evaluacion
     * @param mecanismoEvaluacion de la evaluacion
     */
    public EvaluacionAcademica(int codigo, String nombre, double porcentaje, String fechaRealizacion, Evaluacion mecanismoEvaluacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.fechaRealizacion = fechaRealizacion;
        this.estado = EstadoEvaluacion.PROGRAMADA;
        this.mecanismoEvaluacion = mecanismoEvaluacion;
    }

    /**
     * Metodo que permite calificar una ealuacion
     * @param notaBase de la evaluacion
     * @param observaciones de la evaluacion
     */
    public void claificar(double notaBase, String observaciones){
        if(mecanismoEvaluacion != null){
            this.calificacion = mecanismoEvaluacion.calcularCalificacion(notaBase, observaciones);
            this.estado = EstadoEvaluacion.CALIFICADA;
        }
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

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public EstadoEvaluacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvaluacion estado) {
        this.estado = estado;
    }

    public Evaluacion getMecanismoEvaluacion() {
        return mecanismoEvaluacion;
    }

    public void setMecanismoEvaluacion(Evaluacion mecanismoEvaluacion) {
        this.mecanismoEvaluacion = mecanismoEvaluacion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "EvaluacionAcademica{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", porcentaje=" + porcentaje +
                ", estado=" + estado +
                ", calificacion=" + (calificacion != null ? calificacion.valorNumerico() : "Sin calificar") +
                '}';
    }
}
