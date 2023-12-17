package Bank;

public class Cuenta {
    private int numeroCuenta;
    private String NIP;
    private double saldo;

    public Cuenta(int numeroCuenta, String NIP, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.NIP = NIP;
        this.saldo = saldoInicial;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        saldo -= cantidad;
    }

    public boolean verificarNIP(String NIP) {
        return this.NIP.equals(NIP);
    }
}
