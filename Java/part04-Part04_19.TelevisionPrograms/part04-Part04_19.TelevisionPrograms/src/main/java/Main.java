import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TelevisionProgram> programs = new ArrayList<>();


        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Duration: ");
            int duration = Integer.parseInt(scanner.nextLine());

            programs.add(new TelevisionProgram(name, duration));
        }


        System.out.print("Program's maximum duration? ");
        int maxDuration = Integer.parseInt(scanner.nextLine());


        System.out.println();
        for (TelevisionProgram program : programs) {
            if (program.getDuration() <= maxDuration) {
                System.out.print(program.isAwesome() ? "[Awesome] " : "");
                System.out.println(program);
            }
        }


        scanner.close();
    }
}