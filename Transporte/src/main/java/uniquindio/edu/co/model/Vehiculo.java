package uniquindio.edu.co.model;

public class Vehiculo {
    //Atributos de la clase Vehiculo
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCargaKg;
    private EstadoVehiculo estado;

    /**
     * Metodo Constructor de la clase Vehiculo
     * @param placa del vehiculo
     * @param marca del vehiculo
     * @param modelo del vehiculo
     * @param capacidadCargaKg del vehiculo
     * @param estado del vehiculo
     */
    public Vehiculo(String placa, String marca, String modelo, double capacidadCargaKg, EstadoVehiculo estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCargaKg = capacidadCargaKg;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadCargaKg=" + capacidadCargaKg +
                ", estado=" + estado +
                '}';
    }
}
