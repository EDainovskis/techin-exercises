public class NullPointerExceptionProgram {

    public static void main(String[] args) {
        Person garry;
        garry = new Person("Garry");
        System.out.println(garry);

        garry = null;


        garry.growOlder();
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void growOlder() {
        System.out.println(name);
    }

}
