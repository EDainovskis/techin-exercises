public class HealthStation {

    private int counter;


    public int weigh(Person person) {
        return person.getWeight() + counter++;
    }


    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        return counter;
    }
}