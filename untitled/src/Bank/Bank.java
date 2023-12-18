package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static List<Account> accounts = new ArrayList<>();

    private Bank() {}

    // Buscar una cuenta
    public static Account findAccount(int numberAccount) {
        return accounts.stream()
                .filter(account -> account.getNumberAccount() == numberAccount)
                .findFirst()
                .orElse(null);
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    
    
}