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
        if(cantidad >= 0.0) {
        	saldo += cantidad;
        }else {
        	throw new IllegalArgumentException("La cantidad debe ser >= 0.0");
        }
    }

    public void retirar(double cantidad) {
        if(saldo < cantidad) {
        	throw new IllegalArgumentException("La cantidad excede el saldo de la cuenta para retirar");
        }else {
        	saldo -= cantidad;
        }
        
    }

    public boolean verificarNIP(String NIP) {
        return this.NIP.equals(NIP);
    }

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", NIP=" + NIP + ", saldo=" + saldo + "]";
	}
    
}
