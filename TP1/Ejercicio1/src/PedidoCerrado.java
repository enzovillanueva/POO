import exceptions.EntregaPedidoException;
import exceptions.NoIngresoArticuloException;
import exceptions.PedidoCerradoException;

public class PedidoCerrado implements EstadoPedido {
    @Override
    public void cerrar(Pedido pedido) throws PedidoCerradoException{
        throw new PedidoCerradoException("El pedido está cerrado.");
    }

    @Override
    public void agregarRemito(Pedido pedido, Remito remito) {
        pedido.addRemito(remito);

    }

    @Override
    public void agregarArticulo(Pedido pedido, ArticuloPedido articuloPedido) throws NoIngresoArticuloException{
        throw new NoIngresoArticuloException("No se puede agregar el articulo.");
    }

    @Override
    public void entregar(Pedido pedido) throws EntregaPedidoException {
        pedido.setEstado(new PedidoEntregado());
    }

    @Override
    public void reabrir(Pedido pedido) {
        pedido.setEstado(new PedidoAbierto());
        
    }

    
    
}
