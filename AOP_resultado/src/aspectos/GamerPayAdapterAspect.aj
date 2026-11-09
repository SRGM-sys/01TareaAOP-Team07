package aspectos;

import externo.GamerPayService;
import pagos.MetodoPago;

/**
 * Sección B - Patrón Adapter implementado con AOP (Inter-Type Declarations).
 * Adapta directamente GamerPayService (Adaptee) a la interfaz MetodoPago (Target)
 * sin necesidad de una clase envoltorio (GamerPayAdapter).
 */
public aspect GamerPayAdapterAspect {

    // 1. Declaración inter-tipo: GamerPayService ahora implementa MetodoPago
    declare parents: GamerPayService implements MetodoPago;

    // 2. Inyección del atributo necesario para identificar al usuario en GamerPay
    private String GamerPayService.gamerTag = "UsuarioGenerico";

    // 3. Inyección de constructor sobrecargado para inicializar el gamerTag directamente
    public GamerPayService.new(String gamerTag) {
        this();
        this.gamerTag = gamerTag;
    }

    // 4. Inyección del método pagar(double) exigido por la interfaz MetodoPago (Target)
    public boolean GamerPayService.pagar(double monto) {
        long centavos = Math.round(monto * 100);

        int estado = this.procesarTransaccion(this.gamerTag, centavos);

        if (estado == 200) {
            return true;
        }
        System.out.println("  GamerPay rechazo el pago (codigo " + estado + ").");
        return false;
    }

    // 5. Inyección del método getNombre() exigido por MetodoPago
    public String GamerPayService.getNombre() {
        return "GamerPay";
    }
}