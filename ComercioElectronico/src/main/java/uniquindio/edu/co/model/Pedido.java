package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //Atributos de la clase Pedido
    private int codigoPedido;
    private String fecha;
    private EstadoPedido estado;
    private double valorTotal;
    // Relacionaes de la clase Pedido
    private List<DetallePedido> listDetallesPedido;
    private Cliente cliente;
    private Transaccion transaccion;

    /**
     * Metodo constructor de la clase Pedido
     * @param codigoPedido del pedido
     * @param fecha del pedido
     * @param cliente del pedido
     */
    public Pedido(int codigoPedido, String fecha, Cliente cliente){
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.estado = EstadoPedido.PENDIENTE;
        this.cliente = cliente;
        this.valorTotal = 0.0;
        this.listDetallesPedido = new ArrayList<>();
    }

    /**
     * Metodo que nos permite calcular el valor total del pedido
     */
    public void calcularValorTotal(){
        double total = 0.0;
        for(DetallePedido detalle : listDetallesPedido){
            total += detalle.calcularSubtotal();
        }
        this.valorTotal = total;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<DetallePedido> getListDetallesPedido() {
        return listDetallesPedido;
    }

    public void setListDetallesPedido(List<DetallePedido> listDetallesPedido) {
        this.listDetallesPedido = listDetallesPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                ", valorTotal=" + valorTotal +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "N/A") +
                '}';
    }
}
