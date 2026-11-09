package gestion;

import modelo.Producto;
import pagos.MetodoPago;

/**
 * Atiende las ventas de la tienda.
 * Gracias al Adapter, un solo metodo vender() sirve para TODOS los metodos de pago,
 * incluido GamerPay.
 */

public class Caja {
    // Instanciación estándar: SingletonInventarioAspect devolverá la misma instancia que usa Bodega
    private Inventario inventario = new Inventario();

    public void vender(Producto p, MetodoPago metodo) {
        System.out.println("Venta de " + p.getNombre() + " con " + metodo.getNombre());
        if (!inventario.hayStock(p)) {
            System.out.println("  No hay stock disponible.");
            return;
        }
        if (metodo.pagar(p.getPrecio())) {
            inventario.descontar(p);
            System.out.println("  Venta registrada.");
        }
    }
}