import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.EntregaPedidoException;
import exceptions.NoIngresoArticuloException;
import exceptions.NoIngresoRemitoException;
import exceptions.NoReAbrirException;
import exceptions.PedidoCerradoException;

public class Pedido {
    private int numero;
    private Date fecha_entrega;
    private Cliente cliente;
    private List<ArticuloPedido> articulos;
    private List<Remito> remitos;
    private EstadoPedido estado;
    
    public Pedido(int numero, Date fecha_entrega, Cliente cliente) {
        this.numero = numero;
        this.fecha_entrega = fecha_entrega;
        this.cliente = cliente;
        this.articulos = new ArrayList<>();
        this.remitos = new ArrayList<>();
        this.estado = new PedidoAbierto();
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void reabrir() throws NoReAbrirException{
        estado.reabrir(this);
    }

    public void cerrarPedido() throws PedidoCerradoException{
        estado.cerrar(this);
    }

    public void entregarPedido() throws EntregaPedidoException{
        estado.entregar(this);
    }

    public void agregarArticulo(ArticuloPedido articuloPedido) throws NoIngresoArticuloException{
        estado.agregarArticulo(this, articuloPedido);
    }

    public void agregarRemito(Remito remito) throws NoIngresoRemitoException{
        estado.agregarRemito(this, remito);
    }

    public void addArticulo(ArticuloPedido articulo) {
        this.articulos.add(articulo);
    }

    public void addRemito(Remito remito){
        this.remitos.add(remito);
    }

    public void removeArticulo(ArticuloPedido articulo) {
        this.articulos.remove(articulo);
    }

    public void removeRemito(Remito remito){
        this.remitos.remove(numero);
    }
    // Getters y Setters.
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ArticuloPedido> getArticulos() {
        return articulos;
    }



}
