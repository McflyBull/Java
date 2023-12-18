package Bank;

public class CashDispenser {
    private double cashAvailable;

    public CashDispenser() {
        this.cashAvailable = 10000.0; // Suponiendo que inicia con 500 billetes de $20
    }

    public void dispenseCash(double amount) {
        	cashAvailable -= amount;
    }

    public boolean isSufficientCashAvailable(double amount) {
        return amount > cashAvailable;
    }

	public double getCashAvailable() {
		return cashAvailable;
	}
    
}
