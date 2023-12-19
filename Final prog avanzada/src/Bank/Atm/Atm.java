package Bank.Atm;

import Bank.Interface.TransactionStrategy;

public class Atm {
    private static Atm instance = new Atm();
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCashDispenser(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    public DepositSlot getDepositSlot() {
        return depositSlot;
    }

    public void setDepositSlot(DepositSlot depositSlot) {
        this.depositSlot = depositSlot;
    }

    private Atm() {
        this.cashDispenser = new CashDispenser();
        this.depositSlot = new DepositSlot();
    }

    public static Atm getInstance() {
        return instance;
    }

    public void executeTransaction(TransactionStrategy strategy) {
        strategy.execute();
    }
}
