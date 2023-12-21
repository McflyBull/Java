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

    private boolean isMultipleOf20(double amount) {
        return amount % 20 == 0;
    }

    private boolean hasSufficientFunds(Account account, double amount) {
        return account.getBalance() >= amount;
    }

    @Override
    public void execute() {
        // Verificar si el monto es múltiplo de 20
        if (!isMultipleOf20(amount)) {
            System.out.println("-> La cantidad debe ser un múltiplo de 20");
            return;
        }

        // Verificar si la cuenta tiene suficientes fondos
        if (!hasSufficientFunds(account, amount)) {
            System.out.println("-> La cuenta no tiene fondos suficientes para realizar el retiro");
            return;
        }

        // Verificar si el cajero tiene suficiente efectivo
        if (!this.cashDispenser.isSufficientCashAvailable(amount)) {
            System.out.println("-> Este cajero no cuenta con dinero suficiente");
            return;
        }

        // Lógica para realizar un retiro
        this.cashDispenser.dispenseCash(amount);
        account.withdraw(amount);
    }
}