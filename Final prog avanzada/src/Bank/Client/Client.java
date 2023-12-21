package Bank.Client;

import Bank.Account.Account;

public class Client {
    private int numberAccount;
    private String NIP;
    private Account account;

    public Client(int numberAccount, String NIP, Account account) {
        this.numberAccount = numberAccount;
        this.NIP = NIP;
        this.account = account;
    }
    public Account getAccount() {
        return this.account;
    }
    public int getNumberAccount() {
        return numberAccount;
    }

    public boolean verifyNIP(String NIP) {
        return this.NIP.equals(NIP);
    }
}
