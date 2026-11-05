package uniquindio.edu.co.model;

public class TransferenciaBancaria implements MedioPago{
    //Atributos de la clase TransferenciaBancaria
    private String banco;
    private String cuentaBancaria;

    /**
     * Metodo constructor de la clase TransferenciaBancaria
     * @param banco de la transferencia
     * @param cuentaBancaria de la transferencia
     */
    public TransferenciaBancaria(String banco, String cuentaBancaria){
        this.banco = banco;
        this.cuentaBancaria = cuentaBancaria;
    }
    @Override
    public Transaccion processarTransaccion(double valorTotal) {
        return new Transaccion(102, "2026-06-06", "AUT-TB-7766");
    }

    @Override
    public boolean consultarResultadoTransaccion(Transaccion transaccion) {
        return transaccion != null && transaccion.codigoAutorizacion() != null;
    }

    @Override
    public String toString() {
        return "TransferenciaBancaria{" +
                "banco='" + banco + '\'' +
                ", cuentaBancaria='" + cuentaBancaria + '\'' +
                '}';
    }
}
