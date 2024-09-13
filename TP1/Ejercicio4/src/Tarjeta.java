public class Tarjeta {
    public static void cobrar(String nombreTarjera, String numeroTarjeta, String digitoTarjeta, double importe) {
        System.out.println("Cobro realizado a la tarjeta " + nombreTarjera + " " +
                "(Numero: " + numeroTarjeta + ", CVV: " + digitoTarjeta + " de un importe de: $" + importe);
    }

}
