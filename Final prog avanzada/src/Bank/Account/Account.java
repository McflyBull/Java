package Bank.Account;


public class Account {
    private int numberAccount;
    private String NIP;
    private double balance;

    public Account(int numberAccount, String NIP, double initialBalance) {
        this.numberAccount = numberAccount;
        this.NIP = NIP;
        this.balance = initialBalance;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount <= 0.0) {
            throw new IllegalArgumentException("La cantidad debe ser >= 0.0");
        }
        balance += amount;
        return;
    }

    public void withdraw(double cantidad) {
        if(balance < cantidad) {
            throw new IllegalArgumentException("La cantidad excede el saldo de la cuenta para retirar");
        }
        balance -= cantidad;
    }

    public boolean verifyNIP(String NIP) {
        return this.NIP.equals(NIP);
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numberAccount + ", NIP=" + NIP + ", saldo=" + balance + "]";
    }
}

