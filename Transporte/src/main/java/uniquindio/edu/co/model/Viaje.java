package uniquindio.edu.co.model;

public class Viaje {
    //Atributos de la clase Viaje
    private int codigoViaje;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Ruta ruta;

    /**
     * Metodo onstructor de la clase Viaje
     * @param codigoViaje del viaje
     * @param conductor del viaje
     * @param vehiculo del viaje
     * @param ruta del viaje
     */
    public Viaje(int codigoViaje, Conductor conductor, Vehiculo vehiculo, Ruta ruta){
        this.codigoViaje = codigoViaje;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.ruta = ruta;
    }

    public int getCodigoViaje() {
        return codigoViaje;
    }

    public void setCodigoViaje(int codigoViaje) {
        this.codigoViaje = codigoViaje;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "codigoViaje=" + codigoViaje +
                ", conductor=" + (conductor != null ? conductor.getNombre() : "N/A") +
                ", vehiculo=" + (vehiculo != null ? vehiculo.getPlaca() : "N/A") +
                ", ruta=" + (ruta != null ? ruta.getCodigo() : "N/A") +
                '}';
    }
}
