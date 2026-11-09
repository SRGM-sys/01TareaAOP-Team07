package gestion;

import modelo.Producto;

/**
 * Recibe la mercaderia de los proveedores y la registra en el inventario.
 */

public class Bodega {
    // Usa la unica instancia del inventario (Singleton)
    private Inventario inventario = Inventario.getInstance();

    public void recibirMercaderia(Producto p, int cantidad) {
        inventario.agregarStock(p, cantidad);
        System.out.println("   Bodega recibio " + cantidad + " x " + p.getNombre());
    }

    public void reporteStock(Producto p) {
        System.out.println("   Stock de " + p.getNombre() + ": " + inventario.consultarStock(p));
    }
}