package tiendavideojuegos;

import java.util.HashMap;
import java.util.Map;

/**
 * Controla el stock de productos de la tienda.
 */
public class Inventario {
    private Map<String, Integer> stock = new HashMap<>();

    public Inventario() {
        System.out.println("   (Se creó un objeto Inventario)");
    }

    public void agregarStock(Producto p, int cantidad) {
        int actual = stock.getOrDefault(p.getCodigo(), 0);
        stock.put(p.getCodigo(), actual + cantidad);
    }

    public boolean hayStock(Producto p) {
        return stock.getOrDefault(p.getCodigo(), 0) > 0;
    }

    public void descontar(Producto p) {
        int actual = stock.getOrDefault(p.getCodigo(), 0);
        stock.put(p.getCodigo(), actual - 1);
    }

    public int consultarStock(Producto p) {
        return stock.getOrDefault(p.getCodigo(), 0);
    }
}
