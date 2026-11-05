package uniquindio.edu.co.model;

public class EnvioExpres implements ModalidadEnvio {
    @Override
    public double calcularCostoEnvio(double peso, double distanciaKm) {
        return ((peso * 1500) + (distanciaKm * 800)) * 1.20; //Recargo expres
    }

    @Override
    public String estimarTiempoEntrega(double distanciaKm) {
        return "24 a 48 horas";
    }
}
