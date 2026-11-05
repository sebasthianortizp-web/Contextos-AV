package uniquindio.edu.co.model;

public class Producto {
    //Atributos de la clase Producto
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidadDisponible;
    private Categoria categoria;

    /**
     * Metodo constructor de la clase Producto
     * @param codigo del producto
     * @param nombre del producto
     * @param precio del producto
     * @param cantidadDisponible del producto
     * @param categoria del producto
     */
    public Producto(int codigo, String nombre, double precio, int cantidadDisponible, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                ", categoria=" + categoria +
                '}';
    }
}
