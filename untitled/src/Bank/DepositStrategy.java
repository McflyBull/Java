package Bank;

public class DepositStrategy implements TransactionStrategy {
    private Cuenta cuenta;
    private double cantidad;
    private DepositSlot depositSlot;

    public DepositStrategy(Cuenta cuenta, double cantidad, DepositSlot depositSlot) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.depositSlot = depositSlot;
    }

    @Override
    public void execute() {
        // Lógica para realizar un depósito
    }
}