public class HealthStation {

    private int counter;


    public int weigh(Person person) {
        int weight = person.getWeight();
        counter++;
        return weight;
    }


    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        return counter;
    }
}