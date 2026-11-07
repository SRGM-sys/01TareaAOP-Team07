package tiendavideojuegos;

public class Consola implements Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int almacenamientoGB;

    public Consola(String codigo, String nombre, double precio, int almacenamientoGB) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.almacenamientoGB = almacenamientoGB;
    }

    @Override
    public String getCodigo() { return codigo; }

    @Override
    public String getNombre() { return nombre + " " + almacenamientoGB + "GB"; }

    @Override
    public double getPrecio() { return precio; }
}
