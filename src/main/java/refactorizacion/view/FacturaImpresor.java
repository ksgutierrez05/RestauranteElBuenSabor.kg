/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refactorizacion.view;

import refactorizacion.model.Factura;
import refactorizacion.model.ItemPedido;
import refactorizacion.model.MenuRestaurante;
import refactorizacion.model.Pedido;
import refactorizacion.model.Producto;


public class FacturaImpresor {

    public static void mostrarCarta(MenuRestaurante menu) {

        Imprimir.imprimirEncabezado();

        int i = 1;
        for (Producto p : menu.getProductos()) {
            System.out.println(i + ". " + p.getNombre() + " $" + p.getPrecio());
            i++;
        }
    }


    public static void mostrarPedido(Pedido pedido) {

        System.out.println("--- PEDIDO ACTUAL ---");

        for (ItemPedido i : pedido.getItems()) {
            System.out.println(
                    i.getProducto().getNombre()
                    + " x" + i.getCantidad()
                    + " = " + i.subtotal()
            );
        }

        System.out.println("Subtotal: " + pedido.calcularSubtotal());
    }

    public static void imprimirFactura(Factura f) {

        Imprimir.imprimirEncabezado();

        System.out.println("----------------------------------------");

        System.out.println("====================================");
        System.out.printf("FACTURA No. %03d%n", f.getNumero());
        System.out.println("====================================");

        for (ItemPedido i : f.getPedido().getItems()) {
            System.out.println(
                    i.getProducto().getNombre()
                    + " x" + i.getCantidad()
                    + " = " + i.subtotal()
            );
        }

        System.out.println("------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", f.subtotal());
        System.out.printf("%-27s $%,.0f%n", "Descuento: ", f.calcularDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", f.calcularIVA());
        System.out.printf("%-27s $%,.0f%n", "Propina (10%):", f.calcularPropina());

        System.out.println("------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL: ", f.total());
        System.out.println("====================================");
    }
}

