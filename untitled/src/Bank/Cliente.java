package Bank;

public class Cliente {
    private int numeroCuenta;
    private String NIP;

    public Cliente(int numeroCuenta, String NIP) {
        this.numeroCuenta = numeroCuenta;
        this.NIP = NIP;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public boolean verificarNIP(String NIP) {
        return this.NIP.equals(NIP);
    }
}
