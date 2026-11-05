package uniquindio.edu.co.model;

public class Accesorios extends Producto{
    //Atributos de la clase Accesorios
    private String tipoConexion;

    /**
     * Metodo constructor de la clase Accesorios
     * @param codigo del accesorio
     * @param nombre del accesorio
     * @param precio del accesorio
     * @param cantidadDisponible del accesorio
     * @param categoria del accesorio
     * @param tipoConexion del accesorio
     */
    public Accesorios(int codigo, String nombre, double precio, int cantidadDisponible, Categoria categoria, String tipoConexion) {
        super(codigo, nombre, precio, cantidadDisponible, categoria);
        this.tipoConexion = tipoConexion;
    }

    public String getTipoConexion() {
        return tipoConexion;
    }

    public void setTipoConexion(String tipoConexion) {
        this.tipoConexion = tipoConexion;
    }
    @Override
    public String toString() {
        return "Accesorios{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", cantidadDisponible=" + getCantidadDisponible() + '\'' +
                ", categoria=" + getCategoria() +
                ", tipoConexion=" + tipoConexion +
                '}';
    }
}
