public class Main {
    public static void main(String[] args) {
        Agent bond = new Agent("James", "Bond");

        bond.toString(); // This prints nothing explicitly
        System.out.println(bond); // This will implicitly call toString()

        Agent ionic = new Agent("Ionic", "Bond");
        System.out.println(ionic);
    } }