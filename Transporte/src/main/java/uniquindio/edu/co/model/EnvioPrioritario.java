package uniquindio.edu.co.model;

public class EnvioPrioritario implements ModalidadEnvio{
    @Override
    public double calcularCostoEnvio(double peso, double distanciaKm) {
        return ((peso * 2500) + (distanciaKm * 1200)) * 1.50; //Recargo prioritario
    }

    @Override
    public String estimarTiempoEntrega(double distanciaKm) {
        return "Mismo día o día siguiente";
    }
}
