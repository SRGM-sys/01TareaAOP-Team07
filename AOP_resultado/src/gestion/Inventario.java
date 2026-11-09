package gestion;

// Vamos a manejarlo con el TDA Mapas
import java.util.HashMap;
import java.util.Map;
import modelo.Producto;

/**
 * Controla el stock de la tienda.
 * Con AOP, la clase desconoce que es un Singleton (principio de obliviousness).
 */
public class Inventario {
    private Map<String, Integer> stock = new HashMap<>();

    // Constructor público normal: el aspecto interceptará sus llamadas
    public Inventario() {
        System.out.println("  (Se creo un objeto Inventario)");
    }

    public void agregarStock(Producto p, int cantidad) {
        int actual = consultarStock(p);
        stock.put(p.getCodigo(), actual + cantidad);
    }

    public boolean hayStock(Producto p) {
        return consultarStock(p) > 0;
    }

    public void descontar(Producto p) {
        if (hayStock(p)) {
            stock.put(p.getCodigo(), consultarStock(p) - 1);
        }
    }

    public int consultarStock(Producto p) {
        return stock.getOrDefault(p.getCodigo(), 0);
    }
}