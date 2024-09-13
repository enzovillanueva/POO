import exceptions.ImpresoraNoEncontradaException;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener la instancia única del Pool de Impresoras
        PoolImpresora pool = PoolImpresora.getInstance();

        // Solicitar una impresora del pool
        try {
            Impresora impresora1 = pool.obtenerImpresora("HP_123");
            System.out.println("Impresora " + impresora1 +" en uso...");
            pool.liberarImpresora(impresora1);
        } catch (ImpresoraNoEncontradaException e) {
            System.out.println(e);
        }

        // Error
        try {
            Impresora impresora1 = pool.obtenerImpresora("HP_568");
            System.out.println("Impresora " + impresora1 +" en uso...");
            pool.liberarImpresora(impresora1);
        } catch (ImpresoraNoEncontradaException e) {
            System.out.println(e);
        }

    }
}
