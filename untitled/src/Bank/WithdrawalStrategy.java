package Bank;

public class WithdrawalStrategy implements TransactionStrategy {
    private Cuenta cuenta;
    private double cantidad;
    private CashDispenser cashDispenser;

    public WithdrawalStrategy(Cuenta cuenta, double cantidad, CashDispenser cashDispenser) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.cashDispenser = cashDispenser;
    }
    
    private boolean validacion(Cuenta cuenta, double cantidad) {
		double saldo = this.cuenta.getSaldo();
		if(cantidad > saldo) {
			return false;
		}  	
    	return true;
    	
    }

    @Override
    public void execute() {
        // Lógica para realizar un retiro
    	if(validacion(cuenta, cantidad)) {
    		if(this.cashDispenser.isSufficientCashAvailable(cantidad)) {
    			System.out.println("-> Este cajero no cuenta con dinero suficiente");
    		}else {
    			this.cashDispenser.dispenseCash(cantidad);
    			cuenta.retirar(cantidad);
    		}
    	}else {
    		System.out.println("-> La cuenta no tiene fondos suficientes para realizar el retiro");
    	}
    }
}