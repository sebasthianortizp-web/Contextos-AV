package uniquindio.edu.co.model;

public class Camion extends Vehiculo{
    //Atributos de la clase Camion
    private int numeroEjes;

    /**
     * Metodo constructor de la clase Camion
     * @param placa del camion
     * @param marca del camion
     * @param modelo del camion
     * @param capacidadCargaKg del camion
     * @param estado del camion
     * @param numeroEjes del camion
     */
    public Camion(String placa, String marca, String modelo, double capacidadCargaKg, EstadoVehiculo estado, int numeroEjes) {
        super(placa, marca, modelo, capacidadCargaKg, estado);
        this.numeroEjes = numeroEjes;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "numeroEjes=" + numeroEjes +
                '}';
    }
}
