package uniquindio.edu.co.model;
//Metodo constructor de la clase Transaccion
public record Transaccion(int identificador, String fecha, String codigoAutorizacion) {
    @Override
    public String toString() {
        return "Transaccion{" +
                "identificador=" + identificador +
                ", fecha='" + fecha + '\'' +
                ", codigoAutorizacion='" + codigoAutorizacion + '\'' +
                '}';
    }
}
