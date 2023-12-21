package Bank;

import Bank.Account.Account;
import Bank.Atm.Atm;
import Bank.Client.Client;
import Bank.Interface.TransactionStrategy;
import Bank.Operation.BalanceInquiryStrategy;
import Bank.Operation.DepositStrategy;
import Bank.Operation.WithdrawalStrategy;

public class Main {

    public static void main(String[] args) {


        Account account1 = new Account(12345, "1234", 1000.0);
        Client client1 = new Client(12345, "1234", account1);
        Bank.addAccount(account1);

        Account account2 = new Account(10000, "1000", 2000.0);
        Client client2 = new Client(10000, "1000", account2);
        Bank.addAccount(account2);



        System.out.println("\n-------------------------------------------------");
        // Test case 1: Cliente retira $200, con saldo de $1000
        System.out.println("Test Case 1: Cliente retira $200, con saldo de $1000");
        double amountWanted = 200.0; // Cantidad solicitada por el usuario
        if (client1.verifyNIP("1234")) {
            Atm atm = Atm.getInstance();
            TransactionStrategy balanceInquiry = new BalanceInquiryStrategy(account1);
            TransactionStrategy withdrawal = new WithdrawalStrategy(account1, amountWanted, atm.getCashDispenser());

            atm.executeTransaction(balanceInquiry);
            atm.executeTransaction(withdrawal);
            atm.executeTransaction(balanceInquiry);
        } else {
            System.out.println("Autenticación fallida para el cliente 1.");
        }



        System.out.println("\n-------------------------------------------------");
        // Test case 2: Dinero disponible ATM
        System.out.println("Test Case 2: Dinero disponible ATM"); // Anteriormente retire 200 deberia dar 10k menos 200
        System.out.println("Dinero: " + Atm.getInstance().getCashDispenser().getCashAvailable());



        System.out.println("\n-------------------------------------------------");
        // Test case 3: Cliente intenta retirar más de su saldo
        System.out.println("Test Case 3: Cliente intenta retirar $20000(veinte mil), con saldo de $2000 (dos mil)");
        double amount2 = 20000.0;
        if (client2.verifyNIP("1000")) {
            TransactionStrategy withdrawal2 = new WithdrawalStrategy(account2, amount2, Atm.getInstance().getCashDispenser());
            Atm.getInstance().executeTransaction(withdrawal2);
        } else {
            System.out.println("Autenticación fallida para el cliente 2.");
        }


        System.out.println("\n-------------------------------------------------");
        // Test case 4: Cliente con cuenta 12345, deposita $50000
        System.out.println("Test Case 4: Cliente con cuenta 12345, deposita $50000");
        double amount3 = 50000.0; // Cantidad ingresada por el usuario
        if (client1.verifyNIP("1234")) {
            System.out.print("Antes del depósito. ");
            Atm.getInstance().executeTransaction(new BalanceInquiryStrategy(account1));
            double atmMoneyBeforeDeposit = Atm.getInstance().getDepositSlot().getAmountDepositedTotal();
            TransactionStrategy deposit = new DepositStrategy(account1, amount3, Atm.getInstance().getDepositSlot());
            Atm.getInstance().executeTransaction(deposit);
            System.out.print("Después del depósito. ");
            Atm.getInstance().executeTransaction(new BalanceInquiryStrategy(account1));
            System.out.println("Total de dinero depositado en ATM antes de la operación: " + atmMoneyBeforeDeposit);
            System.out.println("Total de dinero depositado en ATM después de la operación: " + Atm.getInstance().getDepositSlot().getAmountDepositedTotal());
        } else {
            System.out.println("Autenticación fallida para el cliente 1.");
        }
    }
}
