package app;

import externo.GamerPayService;
import gestion.*;
import modelo.*;
import pagos.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TIENDA DE VIDEOJUEGOS \"LEVEL UP\" ===\n");

        Producto zelda = new Videojuego("VJ-001", "Zelda: Tears of the Kingdom", 69.99, "Switch");
        Producto ps5 = new Consola("CO-001", "PlayStation 5", 499.99, 825);

        System.out.println("-- Abriendo la tienda --");
        Bodega bodega = new Bodega();
        Caja caja = new Caja();

        System.out.println("\n-- Llega mercaderia --");
        bodega.recibirMercaderia(zelda, 5);
        bodega.recibirMercaderia(ps5, 2);

        System.out.println("\n-- Clientes comprando --");
        caja.vender(zelda, new PagoEfectivo(100.00));
        caja.vender(ps5, new PagoTarjeta("4111222233334444"));

        // Adapter: GamerPay ahora entra por el mismo metodo vender() que los demas pagos
        MetodoPago gamerPay = new GamerPayAdapter(new GamerPayService(), "NaoGamer");
        caja.vender(zelda, gamerPay);

        System.out.println("\n-- Reporte de bodega --");
        bodega.reporteStock(zelda);
        bodega.reporteStock(ps5);

        // Singleton: comprobamos que todos usan el mismo objeto
        System.out.println("\n-- Comprobacion Singleton --");
        Inventario inv1 = Inventario.getInstance();
        Inventario inv2 = Inventario.getInstance();
        System.out.println("   inv1 == inv2 ? " + (inv1 == inv2));
    }
}