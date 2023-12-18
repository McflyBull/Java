package Bank;

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
        // Lógica para realizar un retiro
    	if(validation(account, amount)) {
    		if(this.cashDispenser.isSufficientCashAvailable(amount)) {
    			System.out.println("-> Este cajero no cuenta con dinero suficiente");
    		}else {
    			this.cashDispenser.dispenseCash(amount);
    			account.withdraw(amount);
    		}
    	}else {
    		System.out.println("-> La cuenta no tiene fondos suficientes para realizar el retiro");
    	}
    }
}