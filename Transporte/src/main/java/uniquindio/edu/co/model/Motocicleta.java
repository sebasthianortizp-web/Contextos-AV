package uniquindio.edu.co.model;

public class Motocicleta extends Vehiculo{
    //Atributos de la calse Motocicleta
    private int cilindraje;

    /**
     * Metodo constructor de la lase Motocicleta
     * @param placa de la motocicleta
     * @param marca de la motocicleta
     * @param modelo de la motocicleta
     * @param capacidadCargaKg de la motocicleta
     * @param estado de la motocicleta
     * @param cilindraje de la motocicleta
     */
    public Motocicleta(String placa, String marca, String modelo, double capacidadCargaKg, EstadoVehiculo estado, int cilindraje) {
        super(placa, marca, modelo, capacidadCargaKg, estado);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "cilindraje=" + cilindraje +
                '}';
    }
}
