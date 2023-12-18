package Bank;

public class Main {

	public static void main(String[] args) {

		// Configuración inicial, como agregar cuentas al banco

		Bank.addAccount(new Account(12345, "1234", 1000.0));

		// Interacción del usuario simulada

		int accountNumber = 12345; // Número de cuenta obtenido de la interfaz de usuario
		double amount = 200.0; // Cantidad ingresada por el usuario

		System.out.println("Test Case 1: Cliente retira $200, con saldo de $1000");
		// Buscar cuenta y realizar una extracción
		double moneyAvailableAtmInit = Atm.getInstance().getCashDispenser().getCashAvailable();
		Account account = Bank.findAccount(accountNumber);
		System.out.println("Saldo antes de retiro: " + account.getBalance());
		TransactionStrategy strategy = new WithdrawalStrategy(account, amount, Atm.getInstance().getCashDispenser());
		Atm.getInstance().executeTransaction(strategy);
		System.out.println("Saldo después del retiro: " + account.getBalance());
		
		System.out.println("Test Case 2: Dinero disponible ATM");
		System.out.println("Antes del retiro: " + moneyAvailableAtmInit);
		System.out.println("Después del retiro: " + Atm.getInstance().getCashDispenser().getCashAvailable());
		
		
		System.out.println("Test Case 3: Cliente retira $20000, con saldo de $2000");
		Bank.addAccount(new Account(10000, "1000", 2000.0));
		// Interacción del usuario simulada
		int numberAccount2 = 10000; // Número de cuenta obtenido de la interfaz de usuario
		double amount2 = 20000.0; // Cantidad ingresada por el usuario
		// Pruebas
		Account account2 = Bank.findAccount(numberAccount2);
		TransactionStrategy strategy2 = new WithdrawalStrategy(account2, amount2, Atm.getInstance().getCashDispenser());
		Atm.getInstance().executeTransaction(strategy2);
		
		System.out.println("Test Case 4: Cliente con cuenta 12345, deposita $50000");
		// Interacción del usuario simulada
		int numberAccount3 = 12345; // Número de cuenta obtenido de la interfaz de usuario
		double amount3 = 50000.0; // Cantidad ingresada por el usuario
		// Pruebas
		Account account3 = Bank.findAccount(numberAccount3);
		double balanceBeforeDeposit = account3.getBalance();
		double atmMoneyBeforeDeposit = Atm.getInstance().getDepositSlot().getAmountDepositedTotal();
		System.out.println("Saldo en cuenta antes sde depósito " + balanceBeforeDeposit);
		TransactionStrategy strategy3 = new DepositStrategy(account3, amount3, Atm.getInstance().getDepositSlot());
		Atm.getInstance().executeTransaction(strategy3);
		System.out.println("Saldo en cuenta después de depósito " + account3.getBalance());
		
		System.out.println("Test Case 5: Total de dinero depositado en ATM");
		System.out.println("Dinero ATM antes depósito: " + atmMoneyBeforeDeposit);
		System.out.println("Dinero ATM después depósito: " + Atm.getInstance().getDepositSlot().getAmountDepositedTotal());
	}
}
