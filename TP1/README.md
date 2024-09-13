# Trabajo Práctico N°1 - POO 2024

* **Ejercicio 1**:
Se solicita modelar un sistema de gestión de pedidos que incluye clientes, artículos, remitos y diferentes estados del pedido como abierto, cerrado o entregado. También se considera la posibilidad de reabrir un pedido cerrado.
**Patrón utilizado**: **State Pattern** para manejar los estados del pedido.

* **Ejercicio 2**: 
Implementación de un Pool de Impresoras, asegurando que solo exista una instancia del mismo en todo el sistema. El pool debe administrar la asignación y liberación de impresoras.
**Patrón utilizado**: **Singleton** para garantizar que solo exista una instancia del Pool de Impresoras.

* **Ejercicio 3**:
Modelado de un software para la venta de chocolates, donde se manejan cajas de productos y bolsas promocionales que ofrecen un descuento en el precio total.
**Patrón utilizado**: **Composite** para manejar tanto las cajas individuales como las bolsas de productos, que son composiciones de cajas.

* **Ejercicio 4**:
Modelado de diferentes formas de pago (transferencia bancaria, PayPal y tarjeta de crédito) dentro de un sistema de ventas, cada una con su propio procedimiento de cobro.
**Patrón utilizado**: **Strategy** para encapsular los diferentes comportamientos de pago dentro de la venta.