package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    //Atributos de la clase Plataforma
    private String nombreComercial;
    private String nit;
    //Relaciones de la clase Plataforma
    private List<Producto> listPlataformaProductos;
    private List<Cliente> listPlataformaClientes;
    private List<Pedido> listPlataformaPedidos;

    /**
     * Metodo constructor de la clase PlataformaComercial
     * @param nombreComercial de la empresa
     * @param nit de la empresa
     */
    public Plataforma(String nombreComercial, String nit) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.listPlataformaProductos = new ArrayList<>();
        this.listPlataformaClientes = new ArrayList<>();
        this.listPlataformaPedidos = new ArrayList<>();
    }

    /**
     * Metodo que me permite registrar un producto
     * @param producto
     * @return
     */
    public boolean registrarProducto(Producto producto){
        boolean resultado = false;
        if(buscarProducto(producto.getCodigo()) == null){
            listPlataformaProductos.add(producto);
            resultado = true;
        }
        return resultado;
    }

    /**
     * Metodo que permite buscar un producto
     * @param codigo del producto
     * @return
     */
    public Producto buscarProducto(int codigo){
        for(Producto produc : listPlataformaProductos){
            if(produc.getCodigo() == codigo){
                return produc;
            }
        }
        return null;
    }

    /**
     * Metodo que me permite registrar un cliente
     * @param documento del cliente
     * @param nombre del cliente
     * @param correo del cliente
     * @param telefono del cliente
     * @return
     */
    public boolean registrarCliente(int documento, String nombre, String correo, int telefono){
        boolean resul = false;
        if(buscarCliente(documento) == null){
            Cliente cliente = new Cliente(documento, nombre, correo, telefono);
            listPlataformaClientes.add(cliente);
            resul = true;
        }
        return resul;
    }

    /**
     * Metodo que me permite buscar un cliente
     * @param documento del cliente
     * @return
     */
    public Cliente buscarCliente(int documento){
        for(Cliente clien : listPlataformaClientes){
            if(clien.getDocumento() == documento){
                return clien;
            }
        }
        return null;
    }

    /**
     * Metodo que permite registrar un pedido
     * @param codigoPedido del pedido
     * @param fecha del pedido
     * @param documentoCliente del pedido
     * @param detallePedido del pedido
     * @return
     */
    public boolean registrarPedido(int codigoPedido, String fecha, int documentoCliente, List<DetallePedido> detallePedido){
        Cliente cliente = buscarCliente(documentoCliente);
        if(cliente != null && buscarPedido(codigoPedido) == null){
            Pedido pedido = new Pedido(codigoPedido, fecha, cliente);
            for(DetallePedido detalle : detallePedido){
                pedido.getListDetallesPedido().add(detalle);
            }
            pedido.calcularValorTotal();
            listPlataformaPedidos.add(pedido);
            cliente.getListClientePedidos().add(pedido);
            return true;
        }
        return false;
    }

    /**
     * Metodo que me permite buscar un pedido
     * @param codigoPedido
     * @return
     */
    public Pedido buscarPedido(int codigoPedido){
        for(Pedido ped : listPlataformaPedidos){
            if(ped.getCodigoPedido() == codigoPedido){
                return ped;
            }
        }
        return null;
    }

    /**
     * Metodo que permite pagar un pedido
     * @param codigoPedido para pagar
     * @param medioPago para pagar
     * @return
     */
    public boolean pagarPedido(int codigoPedido, MedioPago medioPago){
        Pedido pedido = buscarPedido(codigoPedido);
        if(pedido != null && pedido.getEstado() == EstadoPedido.PENDIENTE){
            Transaccion transaccion = medioPago.processarTransaccion(pedido.getValorTotal());
            if(medioPago.consultarResultadoTransaccion(transaccion)){
                pedido.setTransaccion(transaccion);
                pedido.setEstado(EstadoPedido.PAGADO);
                return true;
            }
        }
        return false;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Producto> getListPlataformaProductos() {
        return listPlataformaProductos;
    }

    public void setListPlataformaProductos(List<Producto> listPlataformaProductos) {
        this.listPlataformaProductos = listPlataformaProductos;
    }

    public List<Cliente> getListPlataformaClientes() {
        return listPlataformaClientes;
    }

    public void setListPlataformaClientes(List<Cliente> listPlataformaClientes) {
        this.listPlataformaClientes = listPlataformaClientes;
    }

    public List<Pedido> getListPlataformaPedidos() {
        return listPlataformaPedidos;
    }

    public void setListPlataformaPedidos(List<Pedido> listPlataformaPedidos) {
        this.listPlataformaPedidos = listPlataformaPedidos;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", listPlataformaProductos=" + listPlataformaProductos +
                ", listPlataformaClientes=" + listPlataformaClientes +
                ", listPlataformaPedidos=" + listPlataformaPedidos +
                '}';
    }
}
