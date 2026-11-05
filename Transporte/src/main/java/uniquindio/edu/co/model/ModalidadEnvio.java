package uniquindio.edu.co.model;

public interface ModalidadEnvio {
    double calcularCostoEnvio(double peso, double distanciaKm);
    String estimarTiempoEntrega(double distanciaKm);
}
