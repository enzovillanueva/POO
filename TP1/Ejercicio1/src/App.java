import java.util.Date;

import exceptions.NoIngresoArticuloException;
import exceptions.NoIngresoRemitoException;

public class App {
    public static void main(String[] args) throws Exception {
        Pedido pedido = new Pedido(1, new Date(), new Cliente("enzo", "villanueva"));
        ArticuloPedido articuloPedido_1 = new ArticuloPedido("notebook", 2, 1500);
        ArticuloPedido articuloPedido_2 = new ArticuloPedido("mouse", 4, 50);
        ArticuloPedido articuloPedido_3 = new ArticuloPedido("teclado", 3, 80);
        ArticuloPedido articuloPedido_4 = new ArticuloPedido("auriculares", 2, 110);
        ArticuloPedido articuloPedido_5 = new ArticuloPedido("tarjeta gráfica", 1, 1280);

        // Pedidos y remitos agregados
        pedido.agregarArticulo(articuloPedido_1);
        pedido.agregarArticulo(articuloPedido_2);
        pedido.agregarArticulo(articuloPedido_3);
        
        // Error de ingreso de articulos.
        try {
            pedido.cerrarPedido();
            pedido.agregarArticulo(articuloPedido_4);
            // pedido.reabrir();
            System.out.println("No hubo errores ");
        } catch (NoIngresoArticuloException e) {
            System.out.println("Error en la entrega: " + e);
        }

        Remito remito_1 = new Remito();
        Remito remito_2 = new Remito();

        remito_1.setArticuloPedido(articuloPedido_4);
        remito_2.setArticuloPedido(articuloPedido_5);

        pedido.agregarRemito(remito_1);

        // Error de ingreso de remitos.
        try {
            pedido.entregarPedido();
            pedido.agregarRemito(remito_2);
        } catch (NoIngresoRemitoException e) {
            System.out.println("Error de remito: " + e);
        }



    }
}
