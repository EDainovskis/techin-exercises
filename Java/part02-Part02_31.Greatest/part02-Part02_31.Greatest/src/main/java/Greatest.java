
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int max = number1;

        if (max <= number2)
            max = number2;

        if (max <= number3)
            max = number3;
           return max;
    }

    public static void main(String[] args) {
        int answer = greatest(2, 7, 3);
        System.out.println("Greatest: " + answer);
    }
}
