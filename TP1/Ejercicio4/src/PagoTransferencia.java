public class PagoTransferencia implements FormaPago{
    private String cbu;

    public PagoTransferencia(String cbu){
        this.cbu = cbu;
    }

    @Override
    public void pagar(double importe) {
        Banco.transferir(this.cbu, importe);
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
}
