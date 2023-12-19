package Bank.Operation;

import Bank.Account.Account;
import Bank.Atm.DepositSlot;
import Bank.Interface.TransactionStrategy;

public class DepositStrategy implements TransactionStrategy {
    private Account account;
    private double amount;
    private DepositSlot depositSlot;

    public DepositStrategy(Account account, double amount, DepositSlot depositSlot) {
        this.account = account;
        this.amount = amount;
        this.depositSlot = depositSlot;
    }

    @Override
    public void execute() {
        // Lógica para realizar un depósito
        this.depositSlot.setAmountDepositedByClient(amount);
        double amountToDeposit = this.depositSlot.getAmountDepositedByClient();
        this.account.deposit(amountToDeposit);
    }
}