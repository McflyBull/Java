package Bank;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static List<Cuenta> cuentas = new ArrayList<>();

    private Banco() {
    }

    // Buscar una cuenta
    public static Cuenta buscarCuenta(int numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta() == numeroCuenta)
                .findFirst()
                .orElse(null);
    }

    public static void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

}