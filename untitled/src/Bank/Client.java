package Bank;

public class Client {
    private int numberAccount;
    private String NIP;

    public Client(int numberAccount, String NIP) {
        this.numberAccount = numberAccount;
        this.NIP = NIP;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public boolean verifyNIP(String NIP) {
        return this.NIP.equals(NIP);
    }
}
