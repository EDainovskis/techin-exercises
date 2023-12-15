
public class YourFirstAccount {

    public static void main(String[] args) {

        Account artosAccount = new Account("Arto's account", 100.0);

        System.out.println("Initial state");
        System.out.println(artosAccount);

        artosAccount.withdrawal(20);
        System.out.println("The balance of Arto's account is now: " + artosAccount.saldo());
        artosAccount.deposit(20.0);


        System.out.println("End state");
        System.out.println(artosAccount);


        // Do not touch the code in Account.java
        // Write your program here
    }
}
