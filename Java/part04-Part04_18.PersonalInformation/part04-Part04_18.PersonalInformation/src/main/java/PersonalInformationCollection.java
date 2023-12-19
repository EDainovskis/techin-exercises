import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PersonalInformation> persons = new ArrayList<>();

        while (true) {
            System.out.print("First name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            if (lastName.isEmpty()) {
                break;
            }

            System.out.print("Identification Number: ");
            String identificationNumber = scanner.nextLine();
            if (identificationNumber.isEmpty()) {
                break;
            }

            persons.add(new PersonalInformation(name, lastName, identificationNumber));
        }

        System.out.println();

        for (PersonalInformation person : persons) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}