/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refactorizacion.model;

/**
 *
 * @author Lenovo
 */
public class Mesa {
    private final int numero;
    private Pedido pedidoActual;

    public Mesa(int numero) {
        this.numero = numero;
        this.pedidoActual = new Pedido();
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    
    public void nuevaOrden() {
        this.pedidoActual = new Pedido();
    }

    // Agregar producto directamente a la mesa
    public void agregarProducto(Producto producto, int cantidad) {
        pedidoActual.agregarItem(producto, cantidad);
    }

    public boolean tienePedido() {
        return pedidoActual.tieneProductos();
    }
}
