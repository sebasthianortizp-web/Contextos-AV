package uniquindio.edu.co.model;

public class Ruta {
    //Atributos de la clase Ruta
    private int codigo;
    private String puntoOrigen;
    private String destino;
    private double distanciaEstimadaKm;

    /**
     * Metodo constructor de la clase Ruta
     * @param codigo de la ruta
     * @param puntoOrigen de la ruta
     * @param destino de la ruta
     * @param distanciaEstimadaKm de la ruta
     */
    public Ruta(int codigo,  String puntoOrigen, String destino, double distanciaEstimadaKm) {
        this.codigo = codigo;
        this.puntoOrigen = puntoOrigen;
        this.destino = destino;
        this.distanciaEstimadaKm = distanciaEstimadaKm;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPuntoOrigen() {
        return puntoOrigen;
    }

    public void setPuntoOrigen(String puntoOrigen) {
        this.puntoOrigen = puntoOrigen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistanciaEstimadaKm() {
        return distanciaEstimadaKm;
    }

    public void setDistanciaEstimadaKm(double distanciaEstimadaKm) {
        this.distanciaEstimadaKm = distanciaEstimadaKm;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "codigo=" + codigo +
                ", puntoOrigen='" + puntoOrigen + '\'' +
                ", destino='" + destino + '\'' +
                ", distanciaEstimadaKm=" + distanciaEstimadaKm +
                '}';
    }
}
