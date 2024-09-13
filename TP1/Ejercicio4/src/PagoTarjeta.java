public class PagoTarjeta implements FormaPago{
    private String numeroTarjeta;
    private String nombreTarjeta;
    private String digitoTarjeta;

    public PagoTarjeta(String numeroTarjeta, String nombreTarjeta, String digitoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.digitoTarjeta = digitoTarjeta;
    }

    @Override
    public void pagar(double importe) {
        Tarjeta.cobrar(this.getNombreTarjeta(), this.getNumeroTarjeta(), this.getDigitoTarjeta(), importe);
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getDigitoTarjeta() {
        return digitoTarjeta;
    }

    public void setDigitoTarjeta(String digitoTarjeta) {
        this.digitoTarjeta = digitoTarjeta;
    }
}
