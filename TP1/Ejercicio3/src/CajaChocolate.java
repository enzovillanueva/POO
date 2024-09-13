public class CajaChocolate implements Producto{
    private String nombre;
    private double precioUnitario;

    public CajaChocolate(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String nombreProducto() {
        return this.nombre;
    }

    @Override
    public double precio() {
        return this.precioUnitario;
    }
    
    
}
