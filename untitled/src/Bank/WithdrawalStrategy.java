package Bank;

public class WithdrawalStrategy implements TransactionStrategy {
    private Cuenta cuenta;
    private double cantidad;
    private CashDispenser cashDispenser;

    public WithdrawalStrategy(Cuenta cuenta, double cantidad, CashDispenser cashDispenser) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        // Lógica para realizar un retiro
    }
}