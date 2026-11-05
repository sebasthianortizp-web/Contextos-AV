package uniquindio.edu.co.model;

public class EnvioEstandar implements ModalidadEnvio {
    @Override
    public double calcularCostoEnvio(double peso, double distanciaKm) {
        return (peso * 1000) + (distanciaKm * 500);
    }

    @Override
    public String estimarTiempoEntrega(double distanciaKm) {
        return "3 a 5 días hábiles";
    }
}
