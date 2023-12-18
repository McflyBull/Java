package Bank;

public class Main {

	public static void main(String[] args) {

		// Configuración inicial, como agregar cuentas al banco

		Banco.agregarCuenta(new Cuenta(12345, "1234", 1000.0));

		// Interacción del usuario simulada

		int numeroCuenta = 12345; // Número de cuenta obtenido de la interfaz de usuario
		double cantidad = 200.0; // Cantidad ingresada por el usuario

		System.out.println("Test Case 1: Cliente retira $200, con saldo de $1000");
		// Buscar cuenta y realizar una extracción
		double dineroDisponibleAtmInicio = Atm.getInstance().getCashDispenser().getCashAvailable();
		Cuenta cuenta = Banco.buscarCuenta(numeroCuenta);
		System.out.println("Saldo antes de retiro: " + cuenta.getSaldo());
		TransactionStrategy strategy = new WithdrawalStrategy(cuenta, cantidad, Atm.getInstance().getCashDispenser());
		Atm.getInstance().realizarTransaccion(strategy);
		System.out.println("Saldo después del retiro: " + cuenta.getSaldo());
		
		System.out.println("Test Case 2: Dinero disponible ATM");
		System.out.println("Antes del retiro: " + dineroDisponibleAtmInicio);
		System.out.println("Después del retiro: " + Atm.getInstance().getCashDispenser().getCashAvailable());
		
		
		System.out.println("Test Case 3: Cliente retira $20000, con saldo de $2000");
		Banco.agregarCuenta(new Cuenta(10000, "1000", 2000.0));
		// Interacción del usuario simulada
		int numeroCuenta2 = 10000; // Número de cuenta obtenido de la interfaz de usuario
		double cantidad2 = 20000.0; // Cantidad ingresada por el usuario
		// Pruebas
		Cuenta cuenta2 = Banco.buscarCuenta(numeroCuenta2);
		TransactionStrategy strategy2 = new WithdrawalStrategy(cuenta2, cantidad2, Atm.getInstance().getCashDispenser());
		Atm.getInstance().realizarTransaccion(strategy2);
		
		System.out.println("Test Case 4: Cliente con cuenta 12345, deposita $50000");
		// Interacción del usuario simulada
		int numeroCuenta3 = 12345; // Número de cuenta obtenido de la interfaz de usuario
		double cantidad3 = 50000.0; // Cantidad ingresada por el usuario
		// Pruebas
		Cuenta cuenta3 = Banco.buscarCuenta(numeroCuenta3);
		double saldoAntesDeposito = cuenta3.getSaldo();
		double dineroEnAtmAntesDeposito = Atm.getInstance().getDepositSlot().getAmountDepositedTotal();
		System.out.println("Saldo en cuenta antes de depósito " + saldoAntesDeposito);
		TransactionStrategy strategy3 = new DepositStrategy(cuenta3, cantidad3, Atm.getInstance().getDepositSlot());
		Atm.getInstance().realizarTransaccion(strategy3);
		System.out.println("Saldo en cuenta después de depósito " + cuenta3.getSaldo());
		
		System.out.println("Test Case 5: Total de dinero depositado en ATM");
		System.out.println("Dinero ATM antes depósito: " + dineroEnAtmAntesDeposito);
		System.out.println("Dinero ATM después depósito: " + Atm.getInstance().getDepositSlot().getAmountDepositedTotal());
	}
}
