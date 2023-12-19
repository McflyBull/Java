package Bank.Operation;

import Bank.Account.Account;
import Bank.Atm.CashDispenser;
import Bank.Interface.TransactionStrategy;

public class WithdrawalStrategy implements TransactionStrategy {
    private Account account;
    private double amount;
    private CashDispenser cashDispenser;

    public WithdrawalStrategy(Account account, double amount, CashDispenser cashDispenser) {
        this.account = account;
        this.amount = amount;
        this.cashDispenser = cashDispenser;
    }

    private boolean validation(Account account, double amount) {
        double balance = this.account.getBalance();
        if(amount > balance) {
            return false;
        }
        return true;
    }

    @Override
    public void execute() {
        // Comprobar si la cuenta tiene suficientes fondos
        if (!validation(account, amount)) {
            System.out.println("-> La cuenta no tiene fondos suficientes para realizar el retiro");
            return;
        }

        // Comprobar si el cajero tiene suficiente efectivo
        if (!this.cashDispenser.isSufficientCashAvailable(amount)) {
            System.out.println("-> Este cajero no cuenta con dinero suficiente");
            return;
        }

        // Lógica para realizar un retiro
        this.cashDispenser.dispenseCash(amount);
        account.withdraw(amount);
    }
}