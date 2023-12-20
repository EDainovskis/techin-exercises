public class MainProgram {
    public static void main(String[] args) {

        Pet lucy = new Pet("Lucy", "golden retriever");
        Person leo = new Person("Leo", lucy);
        System.out.println(leo);


        Person john = new Person("John");
        System.out.println(john);


        Person defaultPerson = new Person();
        System.out.println(defaultPerson);
    }
}