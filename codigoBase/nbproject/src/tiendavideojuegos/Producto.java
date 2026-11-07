package tiendavideojuegos;

/**
 * Cualquier artículo que se vende en la tienda.
 */
public interface Producto {
    String getCodigo();
    String getNombre();
    double getPrecio();
}
