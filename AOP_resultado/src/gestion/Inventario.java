package gestion;

// Vamos a manejarlo con el TDA Mapas
import java.util.HashMap;
import java.util.Map;
import modelo.Producto;

/**
 * Controla el stock de la tienda.
 * Patron Singleton: existe una sola instancia compartida por toda la tienda.
 */
public class Inventario {
    // 1. Atributo static que guarda la unica instancia
    private static Inventario instancia;

    private Map<String, Integer> stock = new HashMap<>();

    // 2. Constructor privado: nadie fuera de esta clase puede hacer "new Inventario()"
    private Inventario() {
        System.out.println("   (Se creo un objeto Inventario)");
    }

    // 3. Punto de acceso global: la primera vez crea el objeto, despues siempre devuelve el mismo
    public static synchronized Inventario getInstance() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
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