package uniquindio.edu.co.model;

public record Ubicacion(String ciudad, String direccion, String codigoPostal) {
    @Override
    public String toString() {
        return "Ubicacion{" +
                "ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigoPOstal='" + codigoPostal + '\'' +
                '}';
    }
}
