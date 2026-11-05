package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Envio {
    //Atributos de la classe Envio
    private int codigo;
    private String descripcion;
    private double pesoKg;
    private Ubicacion origen;
    private Ubicacion destino;
    private EstadoEnvio estado;
    private double costoTotal;
    private String tiempoEstimado;
    //Relaciones de la clase Envio
    private ModalidadEnvio modalidadEnvio;
    private List<HistorialSeguimiento> listEnvioHistorialSeguimiento;

    /**
     * Metodo constructor de la clase Envio
     * @param codigo del envio
     * @param descripcion del envio
     * @param pesoKg del envio
     * @param origen del envio
     * @param destino del envio
     * @param modalidadEnvio del envio
     */
    public Envio(int codigo, String descripcion, double pesoKg, Ubicacion origen, Ubicacion destino, ModalidadEnvio modalidadEnvio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
        this.origen = origen;
        this.destino = destino;
        this.estado = EstadoEnvio.REGISTRADO;
        this.modalidadEnvio = modalidadEnvio;
        this.listEnvioHistorialSeguimiento = new ArrayList<>();
    }

    /**
     * Metodo que permite calcular el tiempo y la tarifa de entrega
     * @param distanciaKm de la entrega
     */
    public void calcularTarifaTiempo(double distanciaKm){
        if(modalidadEnvio != null){
            this.costoTotal = modalidadEnvio.calcularCostoEnvio(pesoKg, distanciaKm);
            this.tiempoEstimado = modalidadEnvio.estimarTiempoEntrega(distanciaKm);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Ubicacion getOrigen() {
        return origen;
    }

    public void setOrigen(Ubicacion origen) {
        this.origen = origen;
    }

    public Ubicacion getDestino() {
        return destino;
    }

    public void setDestino(Ubicacion destino) {
        this.destino = destino;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public ModalidadEnvio getModalidadEnvio() {
        return modalidadEnvio;
    }

    public void setModalidadEnvio(ModalidadEnvio modalidadEnvio) {
        this.modalidadEnvio = modalidadEnvio;
    }

    public List<HistorialSeguimiento> getListEnvioHistorialSeguimiento() {
        return listEnvioHistorialSeguimiento;
    }

    public void setListEnvioHistorialSeguimiento(List<HistorialSeguimiento> listEnvioHistorialSeguimiento) {
        this.listEnvioHistorialSeguimiento = listEnvioHistorialSeguimiento;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", pesoKg=" + pesoKg +
                ", estado=" + estado +
                ", costoTotal=" + costoTotal +
                ", tiempoEstimado='" + tiempoEstimado + '\'' +
                '}';
    }
}
