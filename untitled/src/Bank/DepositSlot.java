package Bank;

public class DepositSlot {
	private double amountDepositedTotal;
	private double amountDepositedByClient;
	
    public boolean acceptEnvelope() {
        return true;
    }
    
	public void setAmountDepositedByClient(double amount) {
		if(amount <= 0.0) {
			System.out.println("Debe ingresar el dinero a depositar");
		}else {
			this.amountDepositedByClient = amount;
		}
		
	}
	
	
	public double getAmountDepositedTotal() {
		return amountDepositedTotal;
	}

	public void addAmountDepositedTotal(double amountDepositedTotal) {
		this.amountDepositedTotal += amountDepositedTotal;
	}

	public double getAmountDepositedByClient() {
		double auxAmountClient = this.amountDepositedByClient;
		this.setAmountDepositedByClient(0);
		this.addAmountDepositedTotal(auxAmountClient);
		return auxAmountClient;
	}
    
    
}
