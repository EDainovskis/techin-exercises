import java.util.ArrayList;
import java.util.Scanner;

public class Items {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Item> itemsList = new ArrayList<>();

        while (true) {
            System.out.print("Name: ");
            String itemName = scanner.nextLine();

            if (itemName.isEmpty()) {
                break;
            }

            Item newItem = new Item(itemName);
            itemsList.add(newItem);
        }


        for (Item item : itemsList) {
            System.out.println(item);
        }
    }
}