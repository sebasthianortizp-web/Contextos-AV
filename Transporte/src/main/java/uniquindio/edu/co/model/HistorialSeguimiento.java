package uniquindio.edu.co.model;

public record HistorialSeguimiento(String ubicacionActual, String fecha, String hora, String observaciones) {
    @Override
    public String toString() {
        return "HistorialSeguimiento{" +
                "ubicacionActual='" + ubicacionActual + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
