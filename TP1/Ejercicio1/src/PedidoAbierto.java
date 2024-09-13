import exceptions.EntregaPedidoException;
import exceptions.NoIngresoRemitoException;
import exceptions.NoReAbrirException;

public class PedidoAbierto implements EstadoPedido {

    @Override
    public void agregarRemito(Pedido pedido, Remito remito) throws NoIngresoRemitoException{
        throw new NoIngresoRemitoException("No se puede agregar remito");
    }

    @Override
    public void agregarArticulo(Pedido pedido, ArticuloPedido articuloPedido) {
        pedido.addArticulo(articuloPedido);
    }

    @Override
    public void cerrar(Pedido pedido){
        pedido.setEstado(new PedidoCerrado());
    }

    @Override
    public void entregar(Pedido pedido) throws EntregaPedidoException {
        throw new EntregaPedidoException("No se puede entregar un pedido abierto.");
        
    }

    @Override
    public void reabrir(Pedido pedido) throws NoReAbrirException {
        throw new NoReAbrirException("El pedido está abierto");
        
    }

    

    
}
