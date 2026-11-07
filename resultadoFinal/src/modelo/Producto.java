package modelo;

/**
 * Cualquier articulo que se vende en la tienda.
 */

public interface Producto {
    String getCodigo();
    String getNombre();
    double getPrecio();
}
