import exceptions.EntregaPedidoException;
import exceptions.NoIngresoArticuloException;
import exceptions.NoIngresoRemitoException;
import exceptions.NoReAbrirException;
import exceptions.PedidoCerradoException;

public interface EstadoPedido {
    public void agregarRemito(Pedido pedido, Remito remito) throws NoIngresoRemitoException;
    public void agregarArticulo(Pedido pedido, ArticuloPedido articuloPedido) throws NoIngresoArticuloException;
    public void cerrar(Pedido pedido) throws PedidoCerradoException;
    public void entregar(Pedido pedido) throws EntregaPedidoException;
    public void reabrir(Pedido pedido) throws NoReAbrirException;
}
