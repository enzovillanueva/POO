import java.util.HashMap;
import java.util.Map;

import exceptions.ImpresoraNoEncontradaException;

public class PoolImpresora {
    private static PoolImpresora instance;
    private Map<String, Impresora> impresoras;

    private PoolImpresora() {
        this.impresoras = new HashMap<>();
        impresoras.put("HP_123", new Impresora("HP_123"));
        impresoras.put("Canon_456", new Impresora("Canon_456"));
        impresoras.put("HP_Smart_515", new Impresora("HP_Smart_515"));
    }
    public static PoolImpresora getInstance() {
        if (instance == null) {
            instance = new PoolImpresora();
        }
        return instance;
    }

    public synchronized Impresora obtenerImpresora(String nombre) throws ImpresoraNoEncontradaException {
        Impresora impresora = impresoras.get(nombre);
        if (impresora == null) {
            throw new ImpresoraNoEncontradaException("No se encontró el impresora " + nombre);
        }
        this.impresoras.put(nombre, impresora);
        return impresora;
    }

    public synchronized void liberarImpresora(Impresora impresora) throws ImpresoraNoEncontradaException {
        this.impresoras.put(impresora.getNombre(), impresora);
    }

    public static void setInstance(PoolImpresora instance) {
        PoolImpresora.instance = instance;
    }

    public Map<String, Impresora> getImpresoras() {
        return impresoras;
    }

    public void setImpresoras(Map<String, Impresora> impresoras) {
        this.impresoras = impresoras;
    }
}
