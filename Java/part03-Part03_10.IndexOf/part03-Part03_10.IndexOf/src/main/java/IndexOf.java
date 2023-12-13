
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }

            numbers.add(input);
        }

        System.out.print("Search for? ");
        int searchValue = scanner.nextInt();


        System.out.print(searchValue + " is at index");
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == searchValue) {
                System.out.print(" " + i);

            }
        }

    }
}
