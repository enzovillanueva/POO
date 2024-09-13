public class PagoPayPal implements FormaPago{
    private String nombreUsuario;

    public PagoPayPal(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    @Override
    public void pagar(double importe) {
        PayPal.cobrar(this.getNombreUsuario(), importe);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
