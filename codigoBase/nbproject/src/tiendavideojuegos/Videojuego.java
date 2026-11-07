package tiendavideojuegos;

public class Videojuego implements Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private String plataforma;

    public Videojuego(String codigo, String nombre, double precio, String plataforma) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.plataforma = plataforma;
    }

    @Override
    public String getCodigo() { return codigo; }

    @Override
    public String getNombre() { return nombre + " (" + plataforma + ")"; }

    @Override
    public double getPrecio() { return precio; }
}
