package Bank;

public class Main {

    public static void main(String[] args) {
        // Configuración inicial, como agregar cuentas al banco
        Banco.agregarCuenta(new Cuenta(12345, "1234", 1000.0));

        // Interacción del usuario simulada
        int numeroCuenta = 12345; // Número de cuenta obtenido de la interfaz de usuario
        double cantidad = 200.0;  // Cantidad ingresada por el usuario

        // Buscar cuenta y realizar transacción
        Cuenta cuenta = Banco.buscarCuenta(numeroCuenta);
        TransactionStrategy strategy = new WithdrawalStrategy(cuenta, cantidad, Atm.getInstance().getCashDispenser());
        Atm.getInstance().realizarTransaccion(strategy);
    }
}



