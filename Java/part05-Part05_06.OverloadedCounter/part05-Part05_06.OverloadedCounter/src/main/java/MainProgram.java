public class MainProgram {

    public static void main(String[] args) {
        // Test the Counter class
        Counter counter1 = new Counter(5);
        System.out.println("Counter 1 value: " + counter1.value());  // Output: 5
        counter1.increase();
        System.out.println("Increased Counter 1 value: " + counter1.value());  // Output: 6
        counter1.decrease();
        System.out.println("Decreased Counter 1 value: " + counter1.value());  // Output: 5

        Counter counter2 = new Counter();
        System.out.println("Counter 2 value: " + counter2.value());  // Output: 0
        counter2.increase(3);
        System.out.println("Increased Counter 2 value: " + counter2.value());  // Output: 3
        counter2.decrease(2);
        System.out.println("Decreased Counter 2 value: " + counter2.value());  // Output: 1
    }
}