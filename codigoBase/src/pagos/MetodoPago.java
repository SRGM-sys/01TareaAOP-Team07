package pagos;

/**
 * Forma de pago que acepta la caja de la tienda.
 */

public interface MetodoPago {
    boolean pagar(double monto);
    String getNombre();
}
