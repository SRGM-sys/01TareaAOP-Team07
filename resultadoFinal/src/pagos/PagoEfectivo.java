package pagos;

public class PagoEfectivo implements MetodoPago{
    private double efectivoRecibido;

    public PagoEfectivo(double efectivoRecibido) {
        this.efectivoRecibido = efectivoRecibido;
    }

    @Override
    public boolean pagar(double monto) {
        if (efectivoRecibido < monto) {
            System.out.println("   Efectivo insuficiente.");
            return false;
        }
        System.out.printf("   Pago en efectivo. Cambio: $%.2f%n", efectivoRecibido - monto);
        return true;
    }

    @Override
    public String getNombre() { return "Efectivo"; }
}
