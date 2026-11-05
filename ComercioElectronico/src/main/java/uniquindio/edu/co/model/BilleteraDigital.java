package uniquindio.edu.co.model;

public class BilleteraDigital implements MedioPago{
    //Atributos de la clase BilleteraDigital
    private String proveedor;
    private String telefonoCelular;

    /**
     * Metodo constructor de la clase BilleteraDigital
     * @param proveedor de la Billetera Digital
     * @param telefonoCelular de la Billetera Digital
     */
    public BilleteraDigital(String proveedor, String telefonoCelular) {
        this.proveedor = proveedor;
        this.telefonoCelular = telefonoCelular;
    }
    @Override
    public Transaccion processarTransaccion(double valorTotal) {
        return new Transaccion(103, "2026-06-06", "AUT-BD-5544");
    }

    @Override
    public boolean consultarResultadoTransaccion(Transaccion transaccion) {
        return transaccion != null && transaccion.codigoAutorizacion() != null;
    }

    @Override
    public String toString() {
        return "BilleteraDigital{" +
                "proveedor='" + proveedor + '\'' +
                ", telefonoCelular='" + telefonoCelular + '\'' +
                '}';
    }
}
