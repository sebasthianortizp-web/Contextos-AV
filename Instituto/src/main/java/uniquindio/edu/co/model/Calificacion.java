package uniquindio.edu.co.model;

public record Calificacion(double valorNumerico, String fechaRegistro, String obsAcademca) {
    @Override
    public String toString() {
        return "Calificacion{" +
                "valorNumerico=" + valorNumerico +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", obsAcademca='" + obsAcademca + '\'' +
                '}';
    }
}
