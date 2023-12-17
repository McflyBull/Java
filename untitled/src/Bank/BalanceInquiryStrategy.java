package Bank;

public class BalanceInquiryStrategy implements TransactionStrategy {
    private Cuenta cuenta;

    public BalanceInquiryStrategy(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void execute() {
        // Lógica para la consulta de saldo
    }
}