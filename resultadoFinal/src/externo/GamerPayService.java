package externo;

/**
 * Servicio de pagos de una empresa externa ("GamerPay").
 * La tienda lo recibio como una libreria ya compilada:
 * NO se puede modificar esta clase.
 */

public class GamerPayService {
    /**
     * @param usuarioGamerTag el usuario del cliente en GamerPay
     * @param montoEnCentavos el monto en centavos (ej. $10.50 = 1050)
     * @return un codigo de estado: 200 = aprobado, 402 = fondos insuficientes
     */
    public int procesarTransaccion(String usuarioGamerTag, long montoEnCentavos) {
        System.out.println("   [GamerPay] Cobrando " + montoEnCentavos
                + " centavos al usuario @" + usuarioGamerTag);

        if (montoEnCentavos > 100000) {
            return 402;
        }
        return 200;
    }
}
