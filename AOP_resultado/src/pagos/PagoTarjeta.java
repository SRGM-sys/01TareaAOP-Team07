package pagos;

public class PagoTarjeta implements MetodoPago{
    private String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean pagar(double monto) {
        String ultimos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        System.out.printf("   Cobro de $%.2f a la tarjeta terminada en %s%n", monto, ultimos);
        return true;
    }

    @Override
    public String getNombre() { return "Tarjeta"; }
}
