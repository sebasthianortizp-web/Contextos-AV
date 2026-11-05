package uniquindio.edu.co.model;

public class TarjetaCredito implements MedioPago{
    //Atributos de la clase TarjetaCredito
    private String numeroTarjeta;
    private String titular;
    private String cvv;

    public TarjetaCredito(String numeroTarjeta, String titular, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.cvv = cvv;
    }

    @Override
    public Transaccion processarTransaccion(double valorTotal) {
        return new Transaccion(101, "2026-06-06", "AUT-TC-9988");
    }

    @Override
    public boolean consultarResultadoTransaccion(Transaccion transaccion) {
        return transaccion != null && transaccion.codigoAutorizacion() != null;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", titular='" + titular + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
