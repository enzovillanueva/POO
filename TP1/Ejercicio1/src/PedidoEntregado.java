import exceptions.EntregaPedidoException;
import exceptions.NoIngresoArticuloException;
import exceptions.NoIngresoRemitoException;
import exceptions.NoReAbrirException;
import exceptions.PedidoCerradoException;

public class PedidoEntregado implements EstadoPedido {

    @Override
    public void agregarRemito(Pedido pedido, Remito remito) throws NoIngresoRemitoException{
        throw new NoIngresoRemitoException("No se puede agregar remito del pedido.");
    }

    @Override
    public void agregarArticulo(Pedido pedido, ArticuloPedido articuloPedido) throws NoIngresoArticuloException{
        throw new NoIngresoArticuloException("No se puede agregar articulo del pedido.");
    }

    @Override
    public void entregar(Pedido pedido) throws EntregaPedidoException{
        throw new EntregaPedidoException("El pedido ya está entregado.");
    }

    @Override
    public void cerrar(Pedido pedido) throws PedidoCerradoException {
        throw new PedidoCerradoException("No se puede cerrar un pedido entregado.");
        
    }

    @Override
    public void reabrir(Pedido pedido) throws NoReAbrirException {
        throw new NoReAbrirException("No se puede abrir un pedido entregado.");
        
    }

    
}
