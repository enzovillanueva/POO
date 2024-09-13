public class Pago {
    private double importe;
    private FormaPago formaPago;

    public Pago(double importe, FormaPago formaPago) {
        this.importe = importe;
        this.formaPago = formaPago;
    }

    public void realizarPago() {
        formaPago.pagar(importe);
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
}
