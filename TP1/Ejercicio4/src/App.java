public class App {
    public static void main(String[] args) throws Exception {
        // Pago mediante transferencia bancaria
        FormaPago pagoTransferencia = new PagoTransferencia("1234567890123456789012");
        Pago pago1 = new Pago(1500.0, pagoTransferencia);
        pago1.realizarPago();

        // Pago mediante PayPal
        FormaPago pagoPayPal = new PagoPayPal("user@paypal.com");
        Pago pago2 = new Pago(750.0, pagoPayPal);
        pago2.realizarPago();

        // Pago mediante tarjeta de crédito
        FormaPago pagoTarjeta = new PagoTarjeta("Visa", "4111111111111111", "123");
        Pago pago3 = new Pago(1200.0, pagoTarjeta);
        pago3.realizarPago();
    }
}
