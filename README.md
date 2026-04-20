# Restaurante El Buen Sabor

Sistema básico de gestión de restaurante desarrollado en Java, enfocado en programación orientada a objetos y refactorización de código.

El sistema permite gestionar pedidos, mesas y facturación con cálculos automáticos de subtotal, IVA, descuento y propina.

---

## Funcionalidades

- Visualización de la carta de productos
- Agregar productos a un pedido
- Gestión de pedidos por mesa
- Cálculo automático de:
  - Subtotal
  - IVA (19%)
  - Descuento (según regla de negocio)
  - Propina (según consumo mínimo)
- Generación de factura con número consecutivo
- Reinicio de mesa para nuevo pedido
- Validaciones básicas de entradas

---

## Estructura del proyecto

El proyecto está organizado en dos paquetes principales:

- **model** → Clases del sistema:
  - Producto
  - Pedido
  - ItemPedido
  - Mesa
  - Factura
  - MenuRestaurante
 

- **view** → Interfaz por consola:
  - Menu
  - FacturaImpresor
  - Imprimir
   
-**  restauranteelbuenasabor → Main:
  - RestauranteElBuenSabor

---

## Tecnologías utilizadas

- Java
- NetBeans IDE
- Programación Orientada a Objetos (POO)
- Colecciones (ArrayList)
- Consola (Scanner)

---

## Ejecución del proyecto

Ejecutar la clase principal: RestauranteElBuenSabor.java
