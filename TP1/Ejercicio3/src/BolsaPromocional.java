import java.util.ArrayList;
import java.util.List;

public class BolsaPromocional implements Producto {
    private List<Producto> productos;

    public BolsaPromocional() {
        this.productos = new ArrayList<>();
    }

    public void addProductos(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProductos(Producto producto) {
        this.productos.remove(producto);
    }

    @Override
    public String nombreProducto() {
        return "Bolsa Promocional";
    }

    @Override
    public double precio() {
        return productos.stream()
            .mapToDouble(Producto::precio)
            .sum();
    }

}
