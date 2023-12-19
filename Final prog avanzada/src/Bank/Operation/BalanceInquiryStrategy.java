package Bank.Operation;

import Bank.Account.Account;
import Bank.Interface.TransactionStrategy;

public class BalanceInquiryStrategy implements TransactionStrategy {
    private Account account;

    public BalanceInquiryStrategy(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        double balance = account.getBalance();
        System.out.println("El saldo de su cuenta es: $" + balance);
    }
}
