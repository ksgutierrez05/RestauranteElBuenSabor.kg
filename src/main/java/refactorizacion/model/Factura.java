/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refactorizacion.model;

public class Factura {

    private final Pedido pedido;
    private final int numero;

    public static final double IVA = 0.19;
    public static final double DESCUENTO = 0.05;
    public static final double PROPINA = 0.10;
    public static final double UMBRAL_PROPINA = 50000;
    public static int numeroFactura = 1;
    private static final int MIN_ITEMS_DESCUENTO = 3;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public double subtotal() {
        return pedido.calcularSubtotal();
    }
    
    // El IVA se aplica después del descuento para evitar sobrecálculo del impuesto
    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > MIN_ITEMS_DESCUENTO) {
            return subtotal() * DESCUENTO;
        }
        return 0;
    }

    // El IVA se calcula sobre el subtotal ya descontado, segun DIAN 2024
    public double calcularIVA() {
        return (subtotal() - DESCUENTO) * IVA;
    }
    // La propina solo se activa cuando el consumo supera un umbral mínimo de compra

    public double calcularPropina() {
        double base = subtotal() - DESCUENTO + calcularIVA();
        return base > UMBRAL_PROPINA ? base * PROPINA : 0;
    }

    public double total() {
        return subtotal() - DESCUENTO + calcularIVA() + calcularPropina();
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
