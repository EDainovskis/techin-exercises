import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();


        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }

            System.out.print("Pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            System.out.print("Publication year: ");
            int publicationYear = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, pages, publicationYear));
        }


        System.out.print("What information will be printed? ");
        String printOption = scanner.nextLine();


        System.out.println();
        for (Book book : books) {
            if (printOption.equals("everything")) {
                System.out.println(book.getTitle() + ", " + book.getPages() + " pages, " + book.getPublicationYear());
            } else if (printOption.equals("name")) {
                System.out.println(book.getTitle());
            }
        }


        scanner.close();
    }
}