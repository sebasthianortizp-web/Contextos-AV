package uniquindio.edu.co.model;

public class Computador extends Producto{
    //Atributos de la clase Computador
    private String procesador;
    private int memoriaRamGb;

    /**
     * Metodo contructor de la clase Computador
     * @param codigo del computador
     * @param nombre del computador
     * @param precio del computador
     * @param cantidadDisponible del computador
     * @param categoria del computador
     * @param procesador del computador
     * @param memoriaRamGb del computador
     */
    public Computador(int codigo, String nombre, double precio, int cantidadDisponible, Categoria categoria, String procesador, int memoriaRamGb) {
        super(codigo, nombre, precio, cantidadDisponible, categoria);
        this.procesador = procesador;
        this.memoriaRamGb = memoriaRamGb;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getMemoriaRamGb() {
        return memoriaRamGb;
    }

    public void setMemoriaRamGb(int memoriaRamGb) {
        this.memoriaRamGb = memoriaRamGb;
    }
    @Override
    public String toString() {
        return "Computador{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", cantidadDisponible=" + getCantidadDisponible() + '\'' +
                ", categoria=" + getCategoria() +
                ", procesador='" + procesador + '\'' +
                ", memoriaRamGb=" + memoriaRamGb +
                '}';
    }
}
