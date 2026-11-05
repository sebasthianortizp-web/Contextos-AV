package uniquindio.edu.co.model;

public interface MedioPago {
    Transaccion processarTransaccion(double valorTotal);
    boolean consultarResultadoTransaccion(Transaccion transaccion);
}
