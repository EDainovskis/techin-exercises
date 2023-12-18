public class MainProgram {
    public static void main(String[] args) {
        PaymentCard paulsCard = new PaymentCard(20);
        PaymentCard mattsCard = new PaymentCard(30);

        paulsCard.eatHeartily();
        mattsCard.eatAffordably();
        printCardBalance("Paul", paulsCard);
        printCardBalance("Matt", mattsCard);

        paulsCard.addMoney(20);
        mattsCard.eatHeartily();
        printCardBalance("Paul", paulsCard);
        printCardBalance("Matt", mattsCard);

        paulsCard.eatAffordably();
        paulsCard.eatAffordably();
        mattsCard.addMoney(50);
        printCardBalance("Paul", paulsCard);
        printCardBalance("Matt", mattsCard);
    }

    private static void printCardBalance(String name, PaymentCard card) {
        System.out.println(name + ": " + card);
    }
}