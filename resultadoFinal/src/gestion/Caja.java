package gestion;

import externo.GamerPayService;
import modelo.Producto;
import pagos.MetodoPago;

/**
 * Atiende las ventas de la tienda.
 */

public class Caja {
    private Inventario inventario = new Inventario();

    public void vender(Producto p, MetodoPago metodo) {
        System.out.println("Venta de " + p.getNombre() + " con " + metodo.getNombre());
        if (!inventario.hayStock(p)) {
            System.out.println("   No hay stock disponible.");
            return;
        }
        if (metodo.pagar(p.getPrecio())) {
            inventario.descontar(p);
            System.out.println("   Venta registrada.");
        }
    }

    // GamerPay no implementa MetodoPago, asi que necesita su propio metodo de venta
    public void venderConGamerPay(Producto p, GamerPayService gamerPay, String gamerTag) {
        System.out.println("Venta de " + p.getNombre() + " con GamerPay");
        if (!inventario.hayStock(p)) {
            System.out.println("   No hay stock disponible.");
            return;
        }

        long centavos = Math.round(p.getPrecio() * 100);
        int estado = gamerPay.procesarTransaccion(gamerTag, centavos);

        if (estado == 200) {
            inventario.descontar(p);
            System.out.println("   Venta registrada.");
        } else {
            System.out.println("   GamerPay rechazo el pago (codigo " + estado + ").");
        }
    }
}
