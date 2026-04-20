/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refactorizacion.view;

import java.util.Scanner;
import refactorizacion.model.Factura;
import refactorizacion.model.MenuRestaurante;
import refactorizacion.model.Mesa;
import refactorizacion.view.FacturaImpresor;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private MenuRestaurante menu = new MenuRestaurante();
    private Mesa mesa = new Mesa(1);
    private int mesaActual = 0;
    private int intentosInvalidos = 0;
    private int numeroFactura = 1;

    public void iniciar() {

        int op;

        do {

            Imprimir.imprimirEncabezado();

            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver pedido");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    intentosInvalidos = 0;
                    FacturaImpresor.mostrarCarta(menu);
                    break;

                case 2:
                    intentosInvalidos = 0;
                    System.out.println("--- AGREGAR PRODUCTO ---");

                    System.out.print("Producto: ");
                    int producto = sc.nextInt();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    if (producto <= 0 || producto > menu.getProductos().size()) {
                        System.out.println("Producto no existe. La carta tiene " + menu.getCantidaActualProductos() + " productos");
                        break;
                    }

                    if (cantidad <= 0) {
                        System.out.println("Cantidad invalida, porfavor digite un numero mayor a 0");
                        break;
                    }

                    if (mesaActual == 0) {
                        System.out.print("Mesa: ");
                        int mesa = sc.nextInt();

                        if (mesa <= 0) {
                            mesaActual = 1;
                        } else {
                            mesaActual = mesa;
                        }
                    }

                    mesa.agregarProducto(menu.obtener(producto), cantidad);

                    System.out.println("Producto agregado");
                    break;

                case 3:
                    intentosInvalidos = 0;
                    if (mesa.tienePedido()) {
                        FacturaImpresor.mostrarPedido(mesa.getPedidoActual());
                    } else {
                        System.out.println("No hay pedido en progreso");
                    }
                    break;

                case 4:
                    intentosInvalidos = 0;
                    if (mesa.tienePedido()) {

                        Factura factura = new Factura(mesa.getPedidoActual(), numeroFactura);
                        FacturaImpresor.imprimirFactura(factura);

                        numeroFactura++;

                        mesa.nuevaOrden();
                        mesaActual = 0;
                    } else {
                        System.out.println("No hay productos en el pedido, use porfavor la opcion 2 primero para agregar productos.");
                    }
                    break;

                case 5:
                    intentosInvalidos = 0;
                    mesa.nuevaOrden();
                    mesaActual = 0;
                    System.out.println("Mesa reiniciada");
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    manejarError();
                    break;
            }

        } while (op != 0);
    }

    private void manejarError() {

        intentosInvalidos++;

        System.out.println("Opcion invalida");

        if (intentosInvalidos > 3) {

            System.out.println("Demasiados intentos invalidos");
            System.out.println("Presione ENTER para continuar");

            sc.nextLine(); 
            sc.nextLine(); 

            intentosInvalidos = 0;
        }
    }

}
