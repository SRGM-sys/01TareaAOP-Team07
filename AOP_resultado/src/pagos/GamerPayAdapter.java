package pagos;

import externo.GamerPayService;

/**
 * Patron Adapter: permite usar GamerPayService (clase externa que NO se puede modificar)
 * como si fuera un MetodoPago mas de la tienda.
 *
 * Target  -> MetodoPago
 * Adaptee -> GamerPayService
 * Adapter -> GamerPayAdapter
 * Client  -> Caja
 */
public class GamerPayAdapter implements MetodoPago {
    private GamerPayService gamerPay;   // el objeto adaptado (Adaptee)
    private String gamerTag;

    public GamerPayAdapter(GamerPayService gamerPay, String gamerTag) {
        this.gamerPay = gamerPay;
        this.gamerTag = gamerTag;
    }

    @Override
    public boolean pagar(double monto) {
        // Traduccion 1: dolares (double) -> centavos (long)
        long centavos = Math.round(monto * 100);

        // Delegamos el cobro al servicio externo
        int estado = gamerPay.procesarTransaccion(gamerTag, centavos);

        // Traduccion 2: codigo de estado (int) -> resultado (boolean)
        if (estado == 200) {
            return true;
        }
        System.out.println("   GamerPay rechazo el pago (codigo " + estado + ").");
        return false;
    }

    @Override
    public String getNombre() { return "GamerPay"; }
}