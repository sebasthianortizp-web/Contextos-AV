package uniquindio.edu.co.model;

public class Telefono extends Producto {
    //Atributos de la clase telefono
    private int almacenamientoGb;
    private int megapixelesCamara;

    /**
     * Metodo constructor de la clase Telefono
     * @param codigo del telefono
     * @param nombre del telefono
     * @param precio del telefono
     * @param cantidadDisponible del telefono
     * @param categoria del telefono
     * @param almacenamientoGb del telefono
     * @param megapixelesCamara del telefono
     */
    public Telefono(int codigo, String nombre, double precio, int cantidadDisponible, Categoria categoria, int almacenamientoGb, int megapixelesCamara) {
        super(codigo, nombre, precio, cantidadDisponible, categoria);
        this.almacenamientoGb = almacenamientoGb;
        this.megapixelesCamara = megapixelesCamara;
    }

    public int getAlmacenamientoGb() {
        return almacenamientoGb;
    }

    public void setAlmacenamientoGb(int almacenamientoGb) {
        this.almacenamientoGb = almacenamientoGb;
    }

    public int getMegapixelesCamara() {
        return megapixelesCamara;
    }

    public void setMegapixelesCamara(int megapixelesCamara) {
        this.megapixelesCamara = megapixelesCamara;
    }
    @Override
    public String toString() {
        return "Telefono{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", cantidadDisponible=" + getCantidadDisponible() + '\'' +
                ", categoria=" + getCategoria() +
                ", almacenamientoGb='" + almacenamientoGb + '\'' +
                ", megapixelesCamara=" + megapixelesCamara +
                '}';
    }
}
