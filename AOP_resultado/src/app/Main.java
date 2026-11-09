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

        // Adapter con AOP: GamerPayService ES un MetodoPago gracias al aspecto GamerPayAdapterAspect
        MetodoPago gamerPay = new GamerPayService("NaoGamer");
        caja.vender(zelda, gamerPay);

        System.out.println("\n-- Reporte de bodega --");
        bodega.reporteStock(zelda);
        bodega.reporteStock(ps5);

        // Singleton con AOP: aunque hacemos "new Inventario()", el aspecto retorna la misma instancia.
        System.out.println("\n-- Comprobacion Singleton --");
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        System.out.println("   inv1 == inv2 ? " + (inv1 == inv2));
    }
}