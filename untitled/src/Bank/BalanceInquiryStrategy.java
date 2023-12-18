package Bank;

public class BalanceInquiryStrategy implements TransactionStrategy {
    private Account account;

    public BalanceInquiryStrategy(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        // Lógica para la consulta de saldo
    }
}