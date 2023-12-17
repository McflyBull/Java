package Bank;

public class CashDispenser {
    private int cashAvailable;

    public CashDispenser() {
        this.cashAvailable = 10000; // Suponiendo que inicia con 500 billetes de $20
    }

    public void dispenseCash(int amount) {
        cashAvailable -= amount;
    }

    public boolean isSufficientCashAvailable(int amount) {
        return amount <= cashAvailable;
    }
}
