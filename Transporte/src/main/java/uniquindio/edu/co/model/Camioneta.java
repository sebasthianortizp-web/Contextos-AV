package uniquindio.edu.co.model;

public class Camioneta extends Vehiculo{
    //Atributos de la calse Camioneta
    private boolean tienePlanchon;

    /**
     * Metodo constructor de la clase Camioneta
     * @param placa de la camioneta
     * @param marca de la camioneta
     * @param modelo de la camioneta
     * @param capacidadCargaKg de la camioneta
     * @param estado de la camioneta
     * @param tienePlanchon de la camioneta
     */
    public Camioneta(String placa, String marca, String modelo, double capacidadCargaKg, EstadoVehiculo estado, boolean tienePlanchon) {
        super(placa, marca, modelo, capacidadCargaKg, estado);
        this.tienePlanchon = tienePlanchon;
    }

    public boolean isTienePlanchon() {
        return tienePlanchon;
    }

    public void setTienePlanchon(boolean tienePlanchon) {
        this.tienePlanchon = tienePlanchon;
    }

    @Override
    public String toString() {
        return "Camioneta{" +
                "tienePlanchon=" + tienePlanchon +
                '}';
    }
}
