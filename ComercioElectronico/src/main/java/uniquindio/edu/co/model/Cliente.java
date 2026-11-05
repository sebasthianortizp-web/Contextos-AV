package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    //Relaciones de la clase Cliente
    private List<Pedido> listClientePedidos;

    /**
     * Metodo constructor de la clase Cliente
     * @param documento del cliente
     * @param nombre del cliente
     * @param correoElectronico del cliente
     * @param telefono del cliente
     */
    public Cliente(int documento, String nombre, String correoElectronico, int telefono) {
        super(documento, nombre, correoElectronico, telefono);
        this.listClientePedidos = new ArrayList<>();
    }

    public List<Pedido> getListClientePedidos() {
        return listClientePedidos;
    }

    public void setListClientePedidos(List<Pedido> listClientePedidos) {
        this.listClientePedidos = listClientePedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + getDocumento() +
                ", nombre='"+ getNombre() + '\'' +
                ", correoelectronico='"+ getCorreoElectronico() + '\'' +
                "' telefono='" + getTelefono() + '\'' +
                '}';
    }
}
