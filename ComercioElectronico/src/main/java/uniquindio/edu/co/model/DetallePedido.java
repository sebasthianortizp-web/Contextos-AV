package uniquindio.edu.co.model;

//Atributos de la clase record DetallePedido
public record DetallePedido(Producto producto, int cantidad, double precioUnitario) {
    public double calcularSubtotal(){
        return cantidad*precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "producto=" + (producto != null ? producto.getNombre() : "M/A") +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                "' subtotal=" + calcularSubtotal() +
                '}';
    }
}
