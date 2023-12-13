
import java.util.Scanner;
import java.util.ArrayList;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();


        while (true) {
            int input = scanner.nextInt();
            if (input == 9999) {
                break;
            }

            numbers.add(input);
        }


        int smallestNumber = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < smallestNumber) {
                smallestNumber = number;
            }
        }

        System.out.println("Smallest number: " + smallestNumber);

        System.out.print("Found at index:");
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == smallestNumber) {
                System.out.print(" " + i);
            }
        }
    }
}